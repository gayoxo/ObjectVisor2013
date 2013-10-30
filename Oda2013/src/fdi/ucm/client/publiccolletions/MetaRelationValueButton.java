package fdi.ucm.client.publiccolletions;

import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.PopupPanel;

import fdi.ucm.shared.model.collection.CollectionAttribute;
import fdi.ucm.shared.model.collection.metavalues.MetaRelationValue;
import fdi.ucm.shared.model.collection.resources.Construct;
import fdi.ucm.shared.model.collection.resources.Resources;

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
				if (MetaRelationValue.getValue() instanceof Construct)
				{
					RPUP=new ReferencePopUpPanel((Construct)MetaRelationValue.getValue(),ColeccionSons);
					SplitLayoutPanelPropio.getPila_de_cerrado().add(RPUP);
					RPUP.center();
				}
				else if (MetaRelationValue.getValue() instanceof Resources)
				{
					RPUP=new ReferencePopUpPanel2((Resources)MetaRelationValue.getValue(),ColeccionSons);
					SplitLayoutPanelPropio.getPila_de_cerrado().add(RPUP);
					RPUP.center();
				}
				
			}
		});
	}

}
