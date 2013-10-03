/**
 * 
 */
package fdi.ucm.client.window.modeleditor;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.PopupPanel;

import fdi.ucm.client.ConstantsError;
import fdi.ucm.client.ConstantsInformation;
import fdi.ucm.client.controller.ControladorEntryPoint;
import fdi.ucm.client.service.Oda3Service;
import fdi.ucm.client.service.Oda3ServiceAsync;
import fdi.ucm.client.window.LoadingPopupPanel;
import fdi.ucm.shared.model.collection.Collection;
import fdi.ucm.shared.model.exceptions.Oda3RuntimeException;
import fdi.ucm.shared.model.userserver.CollectionPropias;
import fdi.ucm.shared.model.userserver.UserAndCollection;

import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

/**
 * Clase que define la seleccion de un nuevo nombre para la salvacion de la coleccion.
 * @author Joaquin Gayoso-Cabada
 *
 */
public class SalvadoPopUp extends PopupPanel {

	private static final String THE_NAME_FOR_THE_COLLECTION_CAN_NOT_BE_EMPTY = "The name for the collection can not be empty";
	private static final String CANCEL = "Cancel";
	private static final String OK = "Ok";
	private static final String INSERT_NAME_FOR_COLLECTION = "Insert name for Collection";
	private TextBox textBox;
	private Collection coleccionActual;
	private EditorMainWindowEditor EditorMainMenuRefresh;
	private static Oda3ServiceAsync serviceOda = GWT.create(Oda3Service.class);

	public SalvadoPopUp(Collection coleccionActualin,EditorMainWindowEditor EditorRefresh) {
		this.coleccionActual=coleccionActualin;
		setModal(true);
		EditorMainMenuRefresh=EditorRefresh;
		setGlassEnabled(true);
		setAnimationEnabled(true);
		
		VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setSpacing(14);
		verticalPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		verticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		setWidget(verticalPanel);
		verticalPanel.setSize("100%", "100%");
		
		Label lblNewLabel = new Label(INSERT_NAME_FOR_COLLECTION);
		verticalPanel.add(lblNewLabel);
		
		VerticalPanel verticalPanel_1 = new VerticalPanel();
		verticalPanel_1.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		verticalPanel_1.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel.add(verticalPanel_1);
		
		textBox = new TextBox();
		textBox.setMaxLength(255);
		verticalPanel_1.add(textBox);
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		horizontalPanel.setSpacing(10);
		verticalPanel.add(horizontalPanel);
		
		Button OkButton = new Button(OK);
		OkButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if (!textBox.getText().isEmpty())
				{
					coleccionActual.setName(textBox.getText());
					LoadingPopupPanel.getInstance().setLabelTexto(
							ConstantsInformation.SAVING);
					LoadingPopupPanel.getInstance().center();
					serviceOda.SaveCollection(coleccionActual, EditorMainWindowEditor.getColeccionActualPath(),ControladorEntryPoint.ActualUSer, new AsyncCallback<UserAndCollection>() {
						
						@Override
						public void onSuccess(UserAndCollection result) {
							LoadingPopupPanel.getInstance().hide();
							ControladorEntryPoint.ActualUSer=result.getUsuario();
							EditorMainMenuRefresh.Reinicioinicio(result.getColeccion());
							EditorMainMenuRefresh.RefreshListaCollections();
							CollectionPropias ColeccionAsociada=EditorMainWindowEditor.getCollectionInterbyCollection();
							if (ColeccionAsociada!=null)
								{
								EditorMainWindowEditor.setColeccionActualPath(ColeccionAsociada.getFilePath());
								}
							hide();
							
							
						}
						
						@Override
						public void onFailure(Throwable caught) {
							LoadingPopupPanel.getInstance().hide();
							if (caught instanceof Oda3RuntimeException) {
								Oda3RuntimeException new_name = (Oda3RuntimeException) caught;
								Window.alert(ConstantsError.ERRORPREV+ new_name.getGENERIC_ERROR());
							}
							else Window.alert(ConstantsError.ERRORPREV+ caught.getMessage());
							caught.printStackTrace();
							
						}
					});
				}
				else Window.alert(THE_NAME_FOR_THE_COLLECTION_CAN_NOT_BE_EMPTY);
			}
		});
		horizontalPanel.add(OkButton);
		
		Button CancelButton = new Button(CANCEL);
		CancelButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				hide();
			}
		});
		horizontalPanel.add(CancelButton);
		
	}

}
