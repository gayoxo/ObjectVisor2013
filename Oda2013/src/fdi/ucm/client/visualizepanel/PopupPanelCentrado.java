package fdi.ucm.client.visualizepanel;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;

/**
 * Clase que desine el estado para un frame con el elemento de añadido centrado
 * @author Joaquin Gayoso-Cabada
 *
 */
public class PopupPanelCentrado extends PopupPanel {

	private static final String CLOSE = "Close";
	private static final String SHOWEXTERNAL = "Show in a external Window";
	private VerticalPanel verticalPanel;
	private String URL;
	private DockLayoutPanel dockLayoutPanel;


	public PopupPanelCentrado(boolean b) {
		super(b);
		setModal(true);
		setGlassEnabled(true);
		setAnimationEnabled(true);
		dockLayoutPanel = new DockLayoutPanel(Unit.PX);
		setWidget(dockLayoutPanel);
		String PX="px";
		dockLayoutPanel.setSize((Window.getClientWidth()-100)+PX,(Window.getClientHeight()-100)+PX);
		
		MenuBar menuBar = new MenuBar(false);
		dockLayoutPanel.addNorth(menuBar, 31.0);
		
		MenuItem CloseItem = new MenuItem(CLOSE, true, new Command() {
			public void execute() {
				hide();
			}
		});
		menuBar.addItem(CloseItem);
		
		MenuItem ShowExternal = new MenuItem(SHOWEXTERNAL, true, new Command() {
			public void execute() {
				if (URL!=null)
					{
					Window.open(URL, "_blank", null);
					hide();
					}
				
			}
		});
		menuBar.addItem(ShowExternal);

		verticalPanel = new VerticalPanel();
		verticalPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		verticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel.setSize("100%", "100%");
		dockLayoutPanel.add(verticalPanel);
	}
	
	
public void add(Widget w,String uRL) {
	verticalPanel.add(w);
	w.setSize("100%", "100%");
	URL=uRL;
}

}
