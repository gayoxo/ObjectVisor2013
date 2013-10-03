package fdi.ucm.client.window.modeleditor.model;

import com.google.gwt.event.dom.client.DoubleClickEvent;
import com.google.gwt.event.dom.client.DoubleClickHandler;
import com.google.gwt.user.client.ui.Button;

import fdi.ucm.client.window.modeleditor.EditorMainWindowEditor;
import fdi.ucm.shared.model.collection.CollectionAttribute;

/**
 * Clase que implementa in boton con el elemento en el arbol dentro de el
 * @author Joaquin Gayoso
 *
 */
public class AtributoModeloButton extends Button {
	
	
	private  CompositeModeloBotonComposite elementoEnArbol;

	/**
	 * Constructor por parametros de la clase
	 * @param elementoEnArbolin elemento en el arbol al que representa el boton
	 */
	public AtributoModeloButton(CompositeModeloBotonComposite elementoEnArbolin) {
		super(EditorMainWindowEditor.pathFather(elementoEnArbolin.getElementoBoton()));
		elementoEnArbol=elementoEnArbolin;
		addDoubleClickHandler(new DoubleClickHandler() {
			
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				AtributoModeloButton B=(AtributoModeloButton)event.getSource();
				B.removeFromParent();
			}
		});
	}
	


	/**
	 * Retorn el atributo que simboliza el boton
	 * @return the atributo que simboliza el boton
	 */
	public CollectionAttribute getAttribute() {
		return elementoEnArbol.getElementoBoton();
	}
	
/**
 * Retorna el objeto visual que representa al elemento en el arbol.
 * @return the objeto visual que representa al elemento en el arbol.
 */
	public CompositeModeloBotonComposite getElementoEnArbol() {
		return elementoEnArbol;
	}
	
	
}
