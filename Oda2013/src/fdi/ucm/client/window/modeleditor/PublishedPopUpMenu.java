/**
 * 
 */
package fdi.ucm.client.window.modeleditor;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

import fdi.ucm.client.ConstantsError;
import fdi.ucm.client.ConstantsInformation;
import fdi.ucm.client.controller.ControladorEntryPoint;
import fdi.ucm.client.service.Oda3Service;
import fdi.ucm.client.service.Oda3ServiceAsync;
import fdi.ucm.client.window.LoadingPopupPanel;
import fdi.ucm.shared.model.userserver.UserServer;

/**
 * Define los parametros de publicacion de una coleccion
 * @author Joaquin Gayoso-Cabada
 *
 */
public class PublishedPopUpMenu extends PopupPanel{
	
	private static final String SHORT_DESCRIPTION_140_CHARACTERS = "Short Description (140 characters Max. Optional)";
	private static final String INFORMATIONTEXT = "Insert extend collection information for complete the publish process";
	private static final String PUBLICNAME = "Public name for collection (40 characters Max.)";
	private static final String PUBLICNAMEEMPTY= "Public name should not be empty";
	private static final String SELECTED_NAME_IN_USE_SELECT_ANOTHER_ONE="Selected public name is in use, chose another, please";
	private static final String OK = "Ok";
	private static final String CANCEL = "Cancel";
	private static Oda3ServiceAsync serviceOda = GWT.create(Oda3Service.class);
	private TextBox Description;
	private TextBox PublicName;
	private EditorMainWindowEditor EditorPadre;

	public PublishedPopUpMenu(EditorMainWindowEditor EditorPadrein) {
		setModal(true);
		setGlassEnabled(true);
		setAnimationEnabled(true);
		EditorPadre=EditorPadrein;
		VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setSpacing(3);
		verticalPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		setWidget(verticalPanel);
		verticalPanel.setSize("100%", "100%");
		
		Label Information = new Label(INFORMATIONTEXT);
		verticalPanel.add(Information);
		
		VerticalPanel verticalPanel_1 = new VerticalPanel();
		verticalPanel_1.setSpacing(3);
		verticalPanel.add(verticalPanel_1);
		verticalPanel_1.setWidth("100%");
		
		VerticalPanel verticalPanel_2 = new VerticalPanel();
		verticalPanel_1.add(verticalPanel_2);
		verticalPanel_2.setWidth("100%");
		
		Label PublicLabel = new Label(PUBLICNAME);
		verticalPanel_2.add(PublicLabel);
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		verticalPanel_2.add(horizontalPanel);
		
		SimplePanel Glue1 = new SimplePanel();
		horizontalPanel.add(Glue1);
		Glue1.setWidth("35px");
		
		PublicName = new TextBox();
		horizontalPanel.add(PublicName);
		PublicName.setMaxLength(40);
		
		VerticalPanel verticalPanel_3 = new VerticalPanel();
		verticalPanel_1.add(verticalPanel_3);
		
		Label DescriptionLabel = new Label(SHORT_DESCRIPTION_140_CHARACTERS);
		verticalPanel_3.add(DescriptionLabel);
		
		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		horizontalPanel_1.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		verticalPanel_3.add(horizontalPanel_1);
		
		SimplePanel Glue2 = new SimplePanel();
		horizontalPanel_1.add(Glue2);
		Glue2.setWidth("35px");
		
		Description = new TextBox();
		Description.setMaxLength(140);
		horizontalPanel_1.add(Description);
		
		VerticalPanel verticalPanel_4 = new VerticalPanel();
		verticalPanel_4.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel.add(verticalPanel_4);
		verticalPanel_4.setWidth("100%");
		
		HorizontalPanel horizontalPanel_2 = new HorizontalPanel();
		verticalPanel_4.add(horizontalPanel_2);
		horizontalPanel_2.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel_2.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		horizontalPanel_2.setSpacing(5);
		horizontalPanel_2.setWidth("");
		
		Button Ok = new Button(OK);
		Ok.addClickHandler(new ClickHandler() {


			public void onClick(ClickEvent event) {
					if (!PublicName.getText().trim().isEmpty()){
						
						LoadingPopupPanel.getInstance().setLabelTexto(
								ConstantsInformation.CHEKING_NAME);
						LoadingPopupPanel.getInstance().center();
						serviceOda.CheckNameAvariable(PublicName.getText().trim(), new AsyncCallback<Boolean>() {

							@Override
							public void onFailure(Throwable caught) {
								LoadingPopupPanel.getInstance().hide();
								Window.alert(ConstantsError.ERROR_CHECKING_NAME_AVALIABLITY_TRY_AGAIN);
								
							}

							@Override
							public void onSuccess(Boolean result) {
								LoadingPopupPanel.getInstance().hide();
								if (result)
								{
									LoadingPopupPanel.getInstance().setLabelTexto(
											ConstantsInformation.PUBLISHING);
									LoadingPopupPanel.getInstance().center();
									serviceOda.PublishCollection(ControladorEntryPoint.ActualUSer, EditorMainWindowEditor.getColeccionActual(), Description.getText().trim(), PublicName.getText().trim(),  new AsyncCallback<UserServer>(){

										@Override
										public void onFailure(Throwable caught) {
											LoadingPopupPanel.getInstance().hide();
											Window.alert(ConstantsError.ERROR_PUBLISHING_COLLECTION);	
										}

										@Override
										public void onSuccess(UserServer result) {
											LoadingPopupPanel.getInstance().hide();
											ControladorEntryPoint.ActualUSer=result;
											EditorPadre.Reinicioinicio(EditorMainWindowEditor.getColeccionActual());
											hide();
											
										}});
								}
								else 
									Window.alert(SELECTED_NAME_IN_USE_SELECT_ANOTHER_ONE);
								
							}
						});
					}
					else Window.alert(PUBLICNAMEEMPTY);
			}
		});
		horizontalPanel_2.add(Ok);
		
		Button Cancel = new Button(CANCEL);
		Cancel.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				hide();
			}
		});
		horizontalPanel_2.add(Cancel);
	}

}
