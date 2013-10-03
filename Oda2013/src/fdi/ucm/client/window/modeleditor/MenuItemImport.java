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
import fdi.ucm.client.controller.ControladorEntryPoint;
import fdi.ucm.client.service.LoadService;
import fdi.ucm.client.service.LoadServiceAsync;
import fdi.ucm.client.service.Oda3Service;
import fdi.ucm.client.service.Oda3ServiceAsync;
import fdi.ucm.client.window.LoadingPopupPanel;
import fdi.ucm.shared.model.CollectionImport;
import fdi.ucm.shared.model.ImportExportPair;
import fdi.ucm.shared.model.collection.Collection;
import fdi.ucm.shared.model.userserver.UserAndCollection;

/**
 * Clase que implementa el menuitem para una carga de ina coleccion en el sistema
 * @author Joaquin Gayoso-Cabada
 *
 */
public class MenuItemImport extends MenuItem {

	private CollectionImport ColeccionElement;
	private static Oda3ServiceAsync serviceOda = GWT.create(Oda3Service.class);
	private static LoadServiceAsync importservice = GWT.create(LoadService.class);
	private EditorMainWindowEditor Padre;

	public MenuItemImport(CollectionImport colleciones,EditorMainWindowEditor padre) {
		super(colleciones.getName(), true,(Command)null);
		
		Command C=new Command() {
//			private ServerRequestDataPopUpPanelOld SRDOld;
			private ServerRequestDataPopUpPanel SRD;
			public void execute() {
				
				
				if (EditorMainWindowEditor.getColeccionActual()!=null)
				{
					if (Window.confirm(ConstantsInformation.DO_YOU_WONT_TO_SAVE))
					{
						
						if (EditorMainWindowEditor.getColeccionActual()
								.getName().isEmpty()) {
							SalvadoPopUp PP = new SalvadoPopUp(
									EditorMainWindowEditor.getColeccionActual(),
									Padre);
							PP.center();
						} else {
							LoadingPopupPanel.getInstance().setLabelTexto(
									ConstantsInformation.SAVINGCOLLECTION);
							LoadingPopupPanel.getInstance().center();
							serviceOda
									.SaveCollection(
											EditorMainWindowEditor
													.getColeccionActual(),
											EditorMainWindowEditor
													.getColeccionActualPath(),
											ControladorEntryPoint.ActualUSer,
											new AsyncCallback<UserAndCollection>() {

												@Override
												public void onSuccess(
														UserAndCollection result) {

													ControladorEntryPoint.ActualUSer = result
															.getUsuario();
													LoadingPopupPanel
															.getInstance()
															.hide();
													LoadPanel();

												}

												@Override
												public void onFailure(
														Throwable caught) {
													LoadingPopupPanel
															.getInstance()
															.hide();
													Window.alert(ConstantsError.ERROR_SAVING_COLLECTION);

												}
											});
						}
					}
					else LoadPanel();
				}
				
				else LoadPanel();
				
				
				
			}
			
			/**
			 * Funcion que desprtiega el panel para cargar una nueva coleccion.
			 */
			private void LoadPanel() {
				
				LoadingPopupPanel.getInstance().setLabelTexto(ConstantsInformation.LOADINGIMPORTCONFIG);
				LoadingPopupPanel.getInstance().center();
				importservice.getCollectionConfig(ColeccionElement, new AsyncCallback<ArrayList<ImportExportPair>>() {
					
					@Override
					public void onSuccess(ArrayList<ImportExportPair> result) {
						LoadingPopupPanel.getInstance().hide();
						SRD=new ServerRequestDataPopUpPanel(result, new ClickHandler() {
							
							private String FilePathTemp;

							@Override
							public void onClick(ClickEvent event) {
								LoadingPopupPanel.getInstance().setLabelTexto(ConstantsInformation.LOADINGCOLLECTION);
								LoadingPopupPanel.getInstance().center();
								if (SRD.isComplete())
								{
									ArrayList<String> EntradaDatos=SRD.getResultado();
									FilePathTemp=SRD.getFolderKeyValue();
									importservice.LoadCollection(ColeccionElement,EntradaDatos,new AsyncCallback<Collection>() {
											
											@Override
											public void onSuccess(Collection result) {
												LoadingPopupPanel.getInstance().hide();
												Padre.Reinicioinicio(result);
												EditorMainWindowEditor.setColeccionActualPath(FilePathTemp);
												SRD.hide();
												
												
											}
											
											@Override
											public void onFailure(Throwable caught) {
												LoadingPopupPanel.getInstance().hide();
												Window.alert(ConstantsError.FATAL_ERROR);
												
											}
										});
								}
								else{
									LoadingPopupPanel.getInstance().hide();
									Window.alert(ConstantsError.ERROREMPRTYPARAMETRES);
								}
								
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
				
				
//				SRDOld=new ServerRequestDataPopUpPanelOld(new ClickHandler() {
//					
//					@Override
//					public void onClick(ClickEvent event) {
//
//						LoadingPopupPanel.getInstance().setLabelTexto(ConstantsInformation.LOADINGCOLLECTION);
//						LoadingPopupPanel.getInstance().center();
//						if (SRDOld.isComplete())
//						{
//							ArrayList<String> EntradaDatos=new ArrayList<String>();
//							EntradaDatos.add(SRDOld.getServerTextBox().getText());
//							EntradaDatos.add(SRDOld.getDatabaseTextBox().getText());
//							EntradaDatos.add(Integer.toString(SRDOld.getPortTextBox().getValue()));
//							EntradaDatos.add(SRDOld.getUserTextBox().getText());
//							EntradaDatos.add(SRDOld.getPassTextBox().getText());
//							chasquiservice.LoadCollection(ColeccionElement,EntradaDatos,new AsyncCallback<Collection>() {
//									
//									@Override
//									public void onSuccess(Collection result) {
//										Padre.Reinicioinicio(result);
//										
//										
//									}
//									
//									@Override
//									public void onFailure(Throwable caught) {
//										LoadingPopupPanel.getInstance().hide();
//										Window.alert(ConstantsError.FATAL_ERROR);
//										
//									}
//								});
//						}
//						else{
//							LoadingPopupPanel.getInstance().hide();
//							Window.alert(ConstantsError.ERROREMPRTYPARAMETRES);
//						}
//					}
//					});
//				SRDOld.center();
				
			}
		};
		
		super.setScheduledCommand(C);
		
		ColeccionElement=colleciones;
		Padre=padre;
		
		
		
//		setScheduledCommand((Command)null);
		
		
	}

}
