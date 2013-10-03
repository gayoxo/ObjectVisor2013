/**
 * 
 */
package fdi.ucm.client.controller;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

import fdi.ucm.client.ConstantsError;
import fdi.ucm.client.service.Oda3Service;
import fdi.ucm.client.service.Oda3ServiceAsync;
import fdi.ucm.client.window.WindowEditor;
import fdi.ucm.shared.model.userserver.CollectionAndFilePath;

/**
 * Define la construccion de un index que lleva al login en caso de ser una URLBasica y carga la coleccion si es publica y ademas coincide el nombre
 * @author Joaquin Gayoso-Cabada
 *
 */
public class MasterIndexWindowEditor implements WindowEditor {

	private static Oda3ServiceAsync serviceOda = GWT.create(Oda3Service.class);
	
	/* (non-Javadoc)
	 * @see fdi.ucm.client.window.WindowEditor#showWindow()
	 */
	@Override
	public void showWindow() {
		
		String IdentificadorPublico = com.google.gwt.user.client.Window.Location.getParameter("name");
		if (IdentificadorPublico==null||IdentificadorPublico.isEmpty())
			ControladorEntryPoint.ToLoginWindowEditor();
		else {
				serviceOda.LoadPublicCollection(IdentificadorPublico, new AsyncCallback<CollectionAndFilePath>() {
					
					@Override
					public void onSuccess(CollectionAndFilePath result) {
						if (result.getColeccion()!=null)
							ControladorEntryPoint.ToPublicCollectionVisualiceWindowEditor(result.getColeccion(), "http://"+Window.Location.getHost()+"/ME2013/Files/"+result.getFilePath(), result.getDescription());
						else ControladorEntryPoint.ToLoginWindowEditor();
					}
					
					@Override
					public void onFailure(Throwable caught) {
						Window.alert(ConstantsError.ERROR_LOADING_COLLECTION_PUBLIC);
						ControladorEntryPoint.ToLoginWindowEditor();
					}
				});
		}

	}

}
