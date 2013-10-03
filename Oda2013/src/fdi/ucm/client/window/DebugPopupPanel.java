package fdi.ucm.client.window;

import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextArea;

/**
 * Pantalla de debug, saca por pantalla en un popupautocerrable un tecto
 * @author Joaquin Gayoso-Cabada
 *
 */
public class DebugPopupPanel extends PopupPanel {
	private TextArea TextText;

	/**
	 * Constructor por defecto
	 * @param Texto Texto que se quiere mostrar.
	 */
	public DebugPopupPanel(String Texto) {
		setAnimationEnabled(true);
		setAutoHideEnabled(true);
		
		TextText = new TextArea();
		TextText.setText(Texto);
		setWidget(TextText);
		TextText.setSize("1042px", "511px");
		setGlassEnabled(true);
	}

	
	
}
