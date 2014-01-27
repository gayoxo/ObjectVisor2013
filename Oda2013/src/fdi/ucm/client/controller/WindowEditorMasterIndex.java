/**
 * 
 */
package fdi.ucm.client.controller;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

import fdi.ucm.client.service.Oda3Service;
import fdi.ucm.client.service.Oda3ServiceAsync;
import fdi.ucm.shared.model.userserver.CollectionAndFilePath;

/**
 * Define la construccion de un index que lleva al login en caso de ser una URLBasica y carga la coleccion si es publica y ademas coincide el nombre
 * @author Joaquin Gayoso-Cabada
 *
 */
public class WindowEditorMasterIndex implements WindowEditorInterface {

	private static Oda3ServiceAsync serviceOda = GWT.create(Oda3Service.class);
	
	/* (non-Javadoc)
	 * @see fdi.ucm.client.window.WindowEditor#showWindow()
	 */
	@Override
	public void showWindow() {
		
		String IdentificadorPublico = com.google.gwt.user.client.Window.Location.getParameter("name");
		if (IdentificadorPublico==null||IdentificadorPublico.isEmpty())
			processGeneral2();		
		else {
				PopupPanelLoading.getInstance().setLabelTexto(Oda2013StaticNames.LOADING + IdentificadorPublico);
				PopupPanelLoading.getInstance().center();
				serviceOda.LoadPublicCollection(IdentificadorPublico, new AsyncCallback<CollectionAndFilePath>() {
					
					@Override
					public void onSuccess(CollectionAndFilePath result) {
						PopupPanelLoading.getInstance().hide();
						if (result.getColeccion()!=null)
							EntryPointControlador.ToPublicCollectionVisualiceWindowEditor(result.getColeccion(), result.getDescription());
						else processGeneral2();
					}
					
					@Override
					public void onFailure(Throwable caught) {
						PopupPanelLoading.getInstance().hide();
						processGeneral();
					}
				});
		}

	}

	protected void processGeneral2() {
		Window.alert(Oda2013ConstantsError.ERROR_LOADING_COLLECTION_PUBLIC2);
		Window.open("http://a-note.fdi.ucm.es/ModelEditor2013/", "", "");
		
	}

	private void processGeneral() {
		Window.alert(Oda2013ConstantsError.ERROR_LOADING_COLLECTION_PUBLIC);
		
	}

}
