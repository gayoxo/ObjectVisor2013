/**
 * 
 */
package fdi.ucm.client.publiccolletions;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.PopupPanel;

import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Frame;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.LoadEvent;
import com.google.gwt.event.dom.client.LoadHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Image;

import fdi.ucm.client.controller.Oda2013OperatinoalViewStaticFunctions;
import fdi.ucm.shared.model.collection.document.File;

/**
 * Panel PopUp que muestra el objeto en funcion del valor de referencia,
 * @author Joaquin Gayoso-Cabada
 *
 */
public class PopupPanelReferenceDescriptor extends PopupPanel implements PoupPanelInterfaceCerrableGrupo{

	
	private static final String X = "X";
	private File Recurso;
	private boolean AllClose;
	private String Destino;
	private String ImagenAsociada;
	private Image Icono;
	private Label LabelVariable;
	protected static final int MaxHeight = 200;
	private static final String FILE_PATH = "File Path : ";

	
	public PopupPanelReferenceDescriptor(File value) {
		setAutoHideEnabled(true);
		setModal(true);
		AllClose=true;
		AbsolutePanel General=new AbsolutePanel();
		setAnimationEnabled(true);
		setGlassEnabled(true);
		int Width = Window.getClientWidth();
		int Heigh = Window.getClientHeight();
		
		if (Width>200)
			Width=Width-100;
		if (Heigh>200)
			Heigh=Heigh-100;
		
		setSize(Width+"px", Heigh+"px");

		Recurso=value;


		Destino=Oda2013OperatinoalViewStaticFunctions.calculaDestino(Recurso);
		ImagenAsociada=Oda2013OperatinoalViewStaticFunctions.calculaImagenAsociada(Recurso);
		
		setWidget(General);
		
		HorizontalPanel PanelGeneral = new HorizontalPanel();
		PanelGeneral.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		General.add(PanelGeneral);
		PanelGeneral.setSize("100%", "100%");
		
		HorizontalPanel horizontalPanel_2 = new HorizontalPanel();
		horizontalPanel_2.setSpacing(10);
		horizontalPanel_2.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel_2.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		PanelGeneral.add(horizontalPanel_2);
		
		Icono = new Image(ImagenAsociada);
		horizontalPanel_2.add(Icono);
		
		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		horizontalPanel_2.add(horizontalPanel_1);
		
		Image IconFlecha = new Image("Iconos/Keyicon.png");
		horizontalPanel_1.add(IconFlecha);
		IconFlecha.setSize("25px", "22px");
		
		LabelVariable = new Label("New label");
		horizontalPanel_1.add(LabelVariable);
		
		Icono.addLoadHandler(new LoadHandler() {
			
			@Override
			public void onLoad(LoadEvent event) {
				float porcent=Icono.getHeight()/MaxHeight;
				float Width = Icono.getWidth()/porcent;
				int width=Math.round(Width);
				String PX="px";
				Icono.setHeight(MaxHeight+PX);
				Icono.setWidth(width+PX);
				
			}
		});
		


		
		if (Destino!=null)
			Icono.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					PopupPanelCentrado P = new PopupPanelCentrado(true);
					Frame F = new Frame(Destino);
					P.add(F,Destino);
					P.center();
					
					
				}
			});
		

		if (Recurso instanceof File)
			LabelVariable.setText(FILE_PATH + ((File)Recurso).getPath());
		
		
		
		
		

		
		SimplePanel horizontalPanel = new SimplePanel();
		General.add(horizontalPanel,Width-60,0);
		
		Button btnNewButton = new Button(X);
		btnNewButton.setStyleName("gwt-Button2");
		btnNewButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				AllClose=false;
				hide();
			}
		});
		horizontalPanel.setWidget(btnNewButton);
		btnNewButton.setWidth("50px");
		
		
		
	}
	
	
	@Override
	public void hide(boolean autoClosed) {
		super.hide(autoClosed);
		if (AllClose)
			while (!SplitLayoutPanelPublicCollection.getPila_de_cerrado().isEmpty())
			{
				PoupPanelInterfaceCerrableGrupo RPP=(PoupPanelInterfaceCerrableGrupo) SplitLayoutPanelPublicCollection.getPila_de_cerrado().pop();
				RPP.setAllClose(false);
				((PopupPanel)RPP).hide();
			}
	}
	/**
	 * @return the allClose
	 */
	@Override
	public boolean isAllClose() {
		return AllClose;
	}

	/**
	 * @param allClose the allClose to set
	 */
	@Override
	public void setAllClose(boolean allClose) {
		AllClose = allClose;
	}
	


}
