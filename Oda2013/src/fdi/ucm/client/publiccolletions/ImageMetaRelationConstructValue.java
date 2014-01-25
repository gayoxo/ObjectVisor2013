/**
 * 
 */
package fdi.ucm.client.publiccolletions;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Image;

import fdi.ucm.shared.model.collection.document.Documents;

/**
 * Clase que genera una imagen cliqueable para el caso de las imagenes
 * @author Joaquin Gayoso-Cabada
 *
 */
public class ImageMetaRelationConstructValue extends Image {

	
	private Documents RecursoAsociado;
	protected static final int MaxWidth = 50;

	public ImageMetaRelationConstructValue(Documents imagen,String imagenAsociada) {
		super();
		setUrl(imagenAsociada);
		RecursoAsociado=imagen;
		addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				
				
				PopupPanelDocumentDescriptor RPUP=new PopupPanelDocumentDescriptor(RecursoAsociado);
				SplitLayoutPanelPublicCollection.getPila_de_cerrado().add(RPUP);
				RPUP.center();
				
			}
		});
	}
	
	@Override
	protected void onLoad() {
		super.onLoad();

		float porcent=getWidth()/MaxWidth;
		float Height = getHeight()/porcent;
		int height=Math.round(Height);
		String PX="px";
			setHeight(height+PX);
			setWidth(MaxWidth+PX);

	}
}
