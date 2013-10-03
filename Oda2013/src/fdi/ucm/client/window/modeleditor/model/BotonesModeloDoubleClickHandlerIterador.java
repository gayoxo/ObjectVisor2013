package fdi.ucm.client.window.modeleditor.model;

import com.google.gwt.event.dom.client.DoubleClickEvent;
import com.google.gwt.event.dom.client.DoubleClickHandler;
import fdi.ucm.client.window.modeleditor.EditorMainWindowEditor;

/**
 * Clase que genera un cliqueador doble para un elemento iterador
 * @author Joaquin Gayoso-Cabada
 *
 */
public class BotonesModeloDoubleClickHandlerIterador implements
		DoubleClickHandler {

	
	private CompositeModeloBotonComposite elementoEnArbol;
	private EditorMainWindowEditor indexEntryPoint;
	
	/**
	 * Constructor de la clase que implementa el dobleclick para un elemento iterador
	 * @param indexEntryPointin
	 * @param ElementoAplicado
	 */
	public BotonesModeloDoubleClickHandlerIterador(EditorMainWindowEditor indexEntryPointin, CompositeModeloBotonComposite ElementoAplicado) {
		elementoEnArbol=ElementoAplicado;
		indexEntryPoint=indexEntryPointin;
	}
	
	@Override
	public void onDoubleClick(DoubleClickEvent event) {
		
	indexEntryPoint.borrarelementoIterador(elementoEnArbol,indexEntryPoint);	
		

	}

}
