/**
 * 
 */
package fdi.ucm.client.publiccolletions;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Image;

import fdi.ucm.shared.model.collection.document.File;

/**
 * Clase que genera una imagen cliqueable para el caso de las imagenes
 * @author Joaquin Gayoso-Cabada
 *
 */
public class ImageMetaRelationResourceValue extends Image {

	
	private File RecursoAsociado;
	private String RecursoAsociadoS;
	protected static final int MaxWidth = 50;

	public ImageMetaRelationResourceValue(File imagen,String imagenAsociada) {
		super();
		setUrl(imagenAsociada);
		RecursoAsociado=imagen;
		addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				
				
				PopupPanelReferenceFileDescriptor RPUP=new PopupPanelReferenceFileDescriptor(RecursoAsociado);
				SplitLayoutPanelPublicCollection.getPila_de_cerrado().add(RPUP);
				RPUP.center();
				
			}
		});
	}
	
	public ImageMetaRelationResourceValue(String imagen,String imagenAsociada) {
		super();
		setUrl(imagenAsociada);
		RecursoAsociadoS=imagen;
		addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				
				Window.open(RecursoAsociadoS, "_blank", "");
				
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
