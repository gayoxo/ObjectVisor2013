/**
 * 
 */
package fdi.ucm.client.window.visualize;

import com.google.gwt.user.client.ui.RootPanel;

import fdi.ucm.client.controller.ControladorEntryPoint;
import fdi.ucm.client.visualizepanel.SplitLayoutPanelPropio;
import fdi.ucm.client.window.WindowEditor;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.SplitLayoutPanel;

/**
 * Clase que implementa la creacion de un visor de colecciones en base a su modelo.
 * @author Joaquin Gayoso-Cabada
 *
 */
public class VisualizeCollectionWindowEditor implements WindowEditor {

	private static final String BACKTOTHEEDITOR = "Back to the editor";

	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public void showWindow() {
		
		RootPanel rootPanel=RootPanel.get();
		DockLayoutPanel PanelGeneral = new DockLayoutPanel(Unit.PX);
		rootPanel.add(PanelGeneral,0,0);
		PanelGeneral.setSize("100%", "100%");
		
		MenuBar menuBar = new MenuBar(false);
		PanelGeneral.addNorth(menuBar, 33.0);
		
		MenuItem BotonBack = new MenuItem(BACKTOTHEEDITOR, false, new Command() {
			public void execute() {
				ControladorEntryPoint.ToEditorMainWindowEditor();
			}
		});
		BotonBack.setHTML(BACKTOTHEEDITOR);
		menuBar.addItem(BotonBack);
		
		SplitLayoutPanel PanelVisor = new SplitLayoutPanelPropio();
		PanelGeneral.add(PanelVisor);
		PanelVisor.setSize("100%", "100%");

		
	}

	
	
	
	

	

	
	
	
}
