package fdi.ucm.client.publiccolletions;

import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.PopupPanel;

import fdi.ucm.shared.model.collection.CollectionAttribute;
import fdi.ucm.shared.model.collection.metavalues.MetaRelationConstructValue;
import fdi.ucm.shared.model.collection.metavalues.MetaRelationResourceValue;
import fdi.ucm.shared.model.collection.metavalues.MetaRelationValue;

/**
 * Clase que implementa un Boton de tivo metavalue para uso de las Relacions
 * @author Joaquin Gayoso
 *
 */
public class MetaRelationValueButton extends Button {

	private MetaRelationValue MetaRelationValue;
	private List<CollectionAttribute> ColeccionSons;

	public MetaRelationValueButton(MetaRelationValue metaValueD,List<CollectionAttribute> coleccionSons2) {
		super();
		MetaRelationValue=metaValueD;
		ColeccionSons=coleccionSons2;
		setHTML(metaValueD.getHastype().getName());
		addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				PopupPanel RPUP=null;
				if (MetaRelationValue instanceof MetaRelationConstructValue)
				{
					RPUP=new ConstructDescriptorPopUpPanel(((MetaRelationConstructValue)MetaRelationValue).getValue(),ColeccionSons);
					PublicCollectionSplitLayoutPanel.getPila_de_cerrado().add(RPUP);
					RPUP.center();
				}
				else if (MetaRelationValue instanceof MetaRelationResourceValue)
				{
					RPUP=new ReferenceDescriptorPopUpPanel(((MetaRelationResourceValue)MetaRelationValue).getValue(),ColeccionSons);
					PublicCollectionSplitLayoutPanel.getPila_de_cerrado().add(RPUP);
					RPUP.center();
				}
				
			}
		});
	}

}
