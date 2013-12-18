package fdi.ucm.client.publiccolletions;

import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.PopupPanel;

import fdi.ucm.shared.model.collection.document.LinkElement;
import fdi.ucm.shared.model.collection.grammar.Structure;

/**
 * Clase que implementa un Boton de tivo metavalue para uso de las Relacions
 * @author Joaquin Gayoso
 *
 */
public class ButtonLinkElement extends Button {

	private LinkElement MetaRelationValue;
	private List<Structure> ColeccionSons;

	public ButtonLinkElement(LinkElement metaValueD,List<Structure> coleccionSons2) {
		super();
		MetaRelationValue=metaValueD;
		ColeccionSons=coleccionSons2;
		setHTML(metaValueD.getHastype().getName());
		addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				PopupPanel RPUP=null;

					RPUP=new PopupPanelConstructDescriptor(MetaRelationValue.getValue(),ColeccionSons);
					SplitLayoutPanelPublicCollection.getPila_de_cerrado().add(RPUP);
					RPUP.center();


				
			}
		});
	}

}
