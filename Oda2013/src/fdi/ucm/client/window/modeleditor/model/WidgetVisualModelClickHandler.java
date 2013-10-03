/**
 * 
 */
package fdi.ucm.client.window.modeleditor.model;

import java.util.ArrayList;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;

/**
 * Clase que genera un clicker para volver a poner visibles los elementos
 * @author Joaquin Gayoso-Cabada
 *
 */
public class WidgetVisualModelClickHandler implements ClickHandler {

	private ArrayList<CompositeModeloBotonComposite> ocultados;
	private Button MySelf;
	
	public WidgetVisualModelClickHandler(
			ArrayList<CompositeModeloBotonComposite> ocultar,Button MySelfin) {
		ocultados=ocultar;
		MySelf=MySelfin;
	}

	/* (non-Javadoc)
	 * @see com.google.gwt.event.dom.client.ClickHandler#onClick(com.google.gwt.event.dom.client.ClickEvent)
	 */
	@Override
	public void onClick(ClickEvent event) {
		for (CompositeModeloBotonComposite elemento : ocultados) {
			elemento.setVisible(true);
		}
		MySelf.removeFromParent();
	}

}
