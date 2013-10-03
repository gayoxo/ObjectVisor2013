/**
 * 
 */
package fdi.ucm.client.window.modeleditor;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.MenuItem;

import fdi.ucm.client.ConstantsError;
import fdi.ucm.client.ConstantsInformation;
import fdi.ucm.client.service.Oda3Service;
import fdi.ucm.client.service.Oda3ServiceAsync;
import fdi.ucm.client.window.LoadingPopupPanel;
import fdi.ucm.shared.model.collection.Collection;
import fdi.ucm.shared.model.userserver.CollectionPropias;

/**
 * Genera los menuItem para los elementos.
 * @author Joaquin Gayoso-Cabada
 *
 */


public class MenuItemUserCollections extends MenuItem {

	
	private static Oda3ServiceAsync serviceOda = GWT.create(Oda3Service.class);
	private CollectionPropias NameElement;
	private EditorMainWindowEditor RefreshedElement;
	
	public MenuItemUserCollections(CollectionPropias nombre, boolean b,EditorMainWindowEditor RefreshedElementin) {
		super(nombre.getName(),b,(Command)null);
		super.setScheduledCommand(new ScheduledCommand() {
			
			@Override
			public void execute() {
				LoadingPopupPanel.getInstance().setLabelTexto(
						ConstantsInformation.LOADINGCOLLECTION);
				LoadingPopupPanel.getInstance().center();
				serviceOda.LoadCollection(NameElement, new AsyncCallback<Collection>() {
					
					@Override
					public void onSuccess(Collection result) {
						LoadingPopupPanel.getInstance()
						.hide();
						RefreshedElement.Reinicioinicio(result);
						EditorMainWindowEditor.setColeccionActualPath(NameElement.getFilePath());
						
					}
					
					@Override
					public void onFailure(Throwable caught) {
						LoadingPopupPanel.getInstance()
						.hide();
				Window.alert(ConstantsError.ERROR_LOADING_COLLECTION);
						
					}
				});
				
							
			}
		});
		NameElement=nombre;
		RefreshedElement=RefreshedElementin;
	}

}
