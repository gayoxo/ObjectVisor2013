/**
 * 
 */
package fdi.ucm.client.window;

import java.util.Date;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.DoubleClickEvent;
import com.google.gwt.event.dom.client.DoubleClickHandler;
import com.google.gwt.user.client.ui.Button;

import fdi.ucm.client.ConstantsError;
import fdi.ucm.client.ConstantsInformation;
import fdi.ucm.client.controller.ControladorEntryPoint;
import fdi.ucm.client.service.Oda3Service;
import fdi.ucm.client.service.Oda3ServiceAsync;
import fdi.ucm.shared.model.userserver.UserServer;


/**
 * Sistema de entrada al modelo, con creaccion de cokies y login
 * @author Joaquin Gayoso-Cabada
 *
 */
public class LoginWindowEditor implements WindowEditor {

	private static Oda3ServiceAsync serviceOda = GWT.create(Oda3Service.class);
	
	private static final String WELLCOME = "Digital Collections Model Editor 2013";
	private static final String LOGO_UCM = "Logos/logo_ucm.jpg";
	protected static final String URL_UCM = "http://www.ucm.es";
	private static final String ILSA_LOGO = "Logos/ILSA.jpg";
	protected static final String URL_FDI = "http://ilsa.fdi.ucm.es/";
	private static final String BOTON_ACCEDER = "Log in";
	protected static final String YOU_ARE_NO_AUTORIZED = "Not authorized to access the application";
	private static final String ABOUT = "About";
	private static final String USER = "User";
	private static final String PASSWORD = "Password";
	private TextBox User;
	private PasswordTextBox password;
	private MenuItem BotonAbout;

	
	
	@Override
	public void showWindow() {
		
		
		String UserCookie = Cookies.getCookie(ControladorEntryPoint.COOKIE_NAME);
		if (UserCookie != null) {
			Long L = (Long.parseLong(UserCookie) / (ControladorEntryPoint.SemillaPrimo_2 * ControladorEntryPoint.SemillaPrimo));
			serviceOda.LoadUserById(L, new AsyncCallback<UserServer>() {
				
				@Override
				public void onSuccess(UserServer result) {
					ControladorEntryPoint.ActualUSer=result;
					enter();
					
				}
				
				@Override
				public void onFailure(Throwable caught) {
					Cookies.removeCookie(ControladorEntryPoint.COOKIE_NAME);
					startBaseWindow();
				}
			});

			
		}else
		startBaseWindow();
		

	}

	/**
	 * Clase que genera la ventana en caso de no haber cookie.
	 * @wbp.parser.entryPoint
	 */
	private void startBaseWindow() {
		RootPanel rootPanel=RootPanel.get();
		DockLayoutPanel dockLayoutPanel = new DockLayoutPanel(Unit.PX);
		rootPanel.add(dockLayoutPanel,0,0);
		dockLayoutPanel.setSize("100%", "100%");
		
		MenuBar menuBar = new MenuBar(false);
		dockLayoutPanel.addNorth(menuBar, 30.1);
		
		BotonAbout = new MenuItem(ABOUT, false, new Command() {
			
			@Override
			public void execute() {
				AboutPopupPanel PP=new AboutPopupPanel(true);
				PP.showRelativeTo(BotonAbout);
				
			}
		});
		menuBar.addItem(BotonAbout);
		
		VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		verticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		dockLayoutPanel.add(verticalPanel);
		verticalPanel.setSize("100%", "100%");
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setSpacing(5);
		horizontalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		horizontalPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		verticalPanel.add(horizontalPanel);
		
		VerticalPanel verticalPanel_1 = new VerticalPanel();
		verticalPanel_1.setSpacing(3);
		verticalPanel_1.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		verticalPanel_1.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		horizontalPanel.add(verticalPanel_1);
		
		Label lblNewLabel = new Label(WELLCOME);
		lblNewLabel.setStyleName("gwt-LabelTOP");
		verticalPanel_1.add(lblNewLabel);
		
		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		horizontalPanel_1.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel_1.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		horizontalPanel_1.setSpacing(3);
		verticalPanel_1.add(horizontalPanel_1);
		
		Image UCMlogo = new Image(LOGO_UCM);
		UCMlogo.addDoubleClickHandler(new DoubleClickHandler() {
			
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				Window.open(URL_UCM, "_blank", null);
				
			}
		});
		
		horizontalPanel_1.add(UCMlogo);
		UCMlogo.setSize("287px", "290px");
		
		Image ILSAlogo = new Image(ILSA_LOGO);
		ILSAlogo.addDoubleClickHandler(new DoubleClickHandler() {
			
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				Window.open(URL_FDI, "_blank", null);
				
			}
		});
		
		horizontalPanel_1.add(ILSAlogo);
		ILSAlogo.setSize("556px", "172px");
		
		VerticalPanel verticalPanel_2 = new VerticalPanel();
		verticalPanel_1.add(verticalPanel_2);
		
		HorizontalPanel horizontalPanel_3 = new HorizontalPanel();
		verticalPanel_2.add(horizontalPanel_3);
		horizontalPanel_3.setSpacing(2);
		horizontalPanel_3.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel_3.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		
		Label UserLabel = new Label(USER);
		UserLabel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		horizontalPanel_3.add(UserLabel);
		UserLabel.setWidth("55px");
		
		User = new TextBox();
		horizontalPanel_3.add(User);
		
		HorizontalPanel horizontalPanel_4 = new HorizontalPanel();
		verticalPanel_2.add(horizontalPanel_4);
		horizontalPanel_4.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel_4.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		horizontalPanel_4.setSpacing(2);
		
		Label PasswordLabel = new Label(PASSWORD);
		horizontalPanel_4.add(PasswordLabel);
		
		password = new PasswordTextBox();
		horizontalPanel_4.add(password);
		password.setWidth("152px");
		
		Button Access = new Button(BOTON_ACCEDER);
		Access.setHTML(BOTON_ACCEDER);
		Access.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				LoadingPopupPanel.getInstance().setLabelTexto(
						ConstantsInformation.LOADING_USER);
				LoadingPopupPanel.getInstance().center();
				serviceOda.LoadUserByUserByPassword(User.getText(), password.getText(), new AsyncCallback<UserServer>() {
					
					@Override
					public void onSuccess(UserServer result) {
						LoadingPopupPanel.getInstance().hide();
						if (result!=null)
							{
							ControladorEntryPoint.ActualUSer=result;
							enter();
							}
						else Window.alert(ConstantsError.ERRORPREV +YOU_ARE_NO_AUTORIZED);
							
						
					}
					
					@Override
					public void onFailure(Throwable caught) {
						LoadingPopupPanel.getInstance().hide();
						Window.alert(ConstantsError.ERRORPREV + caught.getMessage());
						
					}
				});
//				if (User.getText().equals("admin")&&password.getText().equals("platano"))
//					{
//					enter();
//					}
//				else Window.alert(YOU_ARE_NO_AUTORIZED);
			}
		});
		verticalPanel_1.add(Access);
		
	}

	/**
	 * Metodo que entra en el sistema de entrada base
	 */
	private void enter() {
			
				Long Valor=ControladorEntryPoint.ActualUSer.getId();
				Cookies.removeCookie(ControladorEntryPoint.COOKIE_NAME);
				int caduca = 1000 * 60 * 60 * 24;
				Date expira = new Date(new Date().getTime()
						+ caduca);
				Cookies.setCookie(ControladorEntryPoint.COOKIE_NAME,
						Long.toString(Valor
								* ControladorEntryPoint.SemillaPrimo_2
								* ControladorEntryPoint.SemillaPrimo), expira);
				ControladorEntryPoint.ToEditorMainWindowEditor();
				
			}


}
