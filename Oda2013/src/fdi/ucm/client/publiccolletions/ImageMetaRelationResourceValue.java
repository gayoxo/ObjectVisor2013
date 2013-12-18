/**
 * 
 */
package fdi.ucm.client.publiccolletions;

import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Image;

import fdi.ucm.shared.model.collection.document.Resources;
import fdi.ucm.shared.model.collection.grammar.Structure;

/**
 * Clase que genera una imagen cliqueable para el caso de las imagenes
 * @author Joaquin Gayoso-Cabada
 *
 */
public class ImageMetaRelationResourceValue extends Image {

	
	private List<Structure> ColeccionSons;
	private Resources RecursoAsociado;
	protected static final int MaxWidth = 50;

	public ImageMetaRelationResourceValue(Resources imagen, List<Structure> coleccionSons, String imagenAsociada) {
		super();
		setUrl(imagenAsociada);
		ColeccionSons=coleccionSons;
		RecursoAsociado=imagen;
		addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				
				
				PopupPanelReferenceDescriptor RPUP=new PopupPanelReferenceDescriptor(RecursoAsociado,ColeccionSons);
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
