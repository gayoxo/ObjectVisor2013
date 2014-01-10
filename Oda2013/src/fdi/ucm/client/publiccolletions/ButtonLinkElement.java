package fdi.ucm.client.publiccolletions;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.PopupPanel;

import fdi.ucm.shared.model.collection.document.LinkElement;

/**
 * Clase que implementa un Boton de tivo metavalue para uso de las Relacions
 * @author Joaquin Gayoso
 *
 */
public class ButtonLinkElement extends Button {

	private LinkElement MetaRelationValue;


	public ButtonLinkElement(LinkElement metaValueD) {
		super();
		MetaRelationValue=metaValueD;
		setHTML(metaValueD.getHastype().getName());
		addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				PopupPanel RPUP=null;

					RPUP=new PopupPanelConstructDescriptor(MetaRelationValue.getValue());
					SplitLayoutPanelPublicCollection.getPila_de_cerrado().add(RPUP);
					RPUP.center();


				
			}
		});
	}

}
