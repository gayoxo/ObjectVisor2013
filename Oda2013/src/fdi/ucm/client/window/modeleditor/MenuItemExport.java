/**
 * 
 */
package fdi.ucm.client.window.modeleditor;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.MenuItem;

import fdi.ucm.client.ConstantsError;
import fdi.ucm.client.ConstantsInformation;
import fdi.ucm.client.service.SaveService;
import fdi.ucm.client.service.SaveServiceAsync;
import fdi.ucm.client.window.LoadingPopupPanel;
import fdi.ucm.shared.model.CollectionExport;
import fdi.ucm.shared.model.ImportExportPair;
import fdi.ucm.shared.model.exceptions.ImportRuntimeException;

/**
 * Elemento de menu item que sirve para exportar elementos a un nuevo sistema
 * @author Joaquin Gayoso-Cabada
 *
 */
public class MenuItemExport extends MenuItem {

	private static SaveServiceAsync exportservice = GWT.create(SaveService.class);
	
	private CollectionExport Colecciones;
	
	public MenuItemExport(CollectionExport colleciones) {
		super(colleciones.getName(),true,(Command)null);
		Colecciones=colleciones;
		
		Command C=new Command() {
			
			private ServerRequestDataPopUpPanel SRD;
	
			public void execute() {
				
				if (EditorMainWindowEditor.getColeccionActual()!=null){
				
					LoadingPopupPanel.getInstance().setLabelTexto(ConstantsInformation.LOADINGEXPORTCONFIG);
					LoadingPopupPanel.getInstance().center();
				exportservice.getCollectionConfig(Colecciones, new AsyncCallback<ArrayList<ImportExportPair>>() {
					
					@Override
					public void onSuccess(ArrayList<ImportExportPair> result) {
						LoadingPopupPanel.getInstance().hide();
						SRD=new ServerRequestDataPopUpPanel(result, new ClickHandler() {
							
							private ArrayList<String> EntradaDatos;

							@Override
							public void onClick(ClickEvent event) {
								if (SRD.isComplete())
								{
									EntradaDatos=SRD.getResultado();
									LoadingPopupPanel.getInstance().setLabelTexto(ConstantsInformation.SAVING);
									LoadingPopupPanel.getInstance().center();
									exportservice.SaveCollection(Colecciones, EntradaDatos, EditorMainWindowEditor.getColeccionActual(), new AsyncCallback<Void>() {
											
											@Override
											public void onSuccess(Void result) {
												SRD.hide();
												LoadingPopupPanel.getInstance().hide();
												Window.alert(ConstantsInformation.SAVECOMPLETE);
												
																											
											}
											
											@Override
											public void onFailure(Throwable caught) {
												LoadingPopupPanel.getInstance().hide();
												if (caught instanceof ImportRuntimeException)
													Window.alert(caught.getMessage());
												else Window.alert(ConstantsError.FATAL_ERROR);
											}
											});
									
									
								
								}
								else 
									Window.alert(ConstantsError.ERROREMPRTYPARAMETRES);
								
							}
						});
						
						SRD.center();
						
					}
					
					@Override
					public void onFailure(Throwable caught) {
						LoadingPopupPanel.getInstance().hide();
						Window.alert(ConstantsError.ERROR_LOADING_CONFIG_DATA);
						
					}
					
				});
					
				
				}
			}
	};
	
	super.setScheduledCommand(C);
}
		
		
		

}
