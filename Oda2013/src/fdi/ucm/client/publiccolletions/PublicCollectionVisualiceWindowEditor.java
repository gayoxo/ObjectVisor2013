/**
 * 
 */
package fdi.ucm.client.publiccolletions;

import com.google.gwt.user.client.ui.RootPanel;

import fdi.ucm.client.visualizepanel.SplitLayoutPanelPropio;
import fdi.ucm.client.window.WindowEditor;

import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.SplitLayoutPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;

/**
 * Clazse que implementa la creacion de un visor de colecciones publicas en base a su modelo.
 * @author Joaquin Gayoso-Cabada
 *
 */
public class PublicCollectionVisualiceWindowEditor implements WindowEditor {


	private Label LabelInformativa;

	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public void showWindow() {
		
		RootPanel rootPanel=RootPanel.get();
		DockLayoutPanel PanelGeneral = new DockLayoutPanel(Unit.PX);
		rootPanel.add(PanelGeneral,0,0);
		PanelGeneral.setSize("100%", "100%");
		
		VerticalPanel PanelNorte = new VerticalPanel();
		PanelGeneral.addNorth(PanelNorte, 154.0);
		PanelNorte.setSize("100%", "100%");
		
		VerticalPanel PanelCentradoImagen = new VerticalPanel();
		PanelNorte.add(PanelCentradoImagen);
		PanelCentradoImagen.setSize("100%", "100%");
		PanelCentradoImagen.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		PanelCentradoImagen.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		
		Image LogoAplicacion = new Image("Logos/LogoME2013.png");
		PanelCentradoImagen.add(LogoAplicacion);
		LogoAplicacion.setSize("699px", "100px");
		
		VerticalPanel PanelLabel = new VerticalPanel();
		PanelNorte.add(PanelLabel);
		PanelLabel.setWidth("");
		
		LabelInformativa = new Label("");
		PanelLabel.add(LabelInformativa);
		LabelInformativa.setDirectionEstimator(false);
		
		MenuBar BarraDeMenu = new MenuBar(false);
		PanelNorte.add(BarraDeMenu);
		BarraDeMenu.setHeight("30px");
		
		SplitLayoutPanel PanelVisor = new SplitLayoutPanelPropio();
		PanelGeneral.add(PanelVisor);
		PanelVisor.setSize("100%", "100%");

		
	}

	/**
	 * @return the labelInformativa
	 */
	public Label getLabelInformativa() {
		return LabelInformativa;
	}

	/**
	 * @param labelInformativa the labelInformativa to set
	 */
	public void setLabelInformativa(Label labelInformativa) {
		LabelInformativa = labelInformativa;
	}

	/**
	 * @param labelInformativa the labelInformativa to set
	 */
	public void setLabelInformativa(String labelInformativa) {
		if (!labelInformativa.isEmpty())
			LabelInformativa.setText(labelInformativa);
		else 
			LabelInformativa.setText("");
	}
	
	
	

	

	
	
	
}
