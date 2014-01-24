/**
 * 
 */
package fdi.ucm.shared.model.collection.document;

import fdi.ucm.shared.model.collection.grammar.ResourceElementType;



/**
 * Clase que define un Ration value.
 * @author Joaquin Gayoso
 *
 */

public abstract class ResourceElement extends Element {

	/**
	 * 
	 */
	protected static final long serialVersionUID = 1L;
	
	/**
	 * COnstructor por defecto.
	 * @param hastype 
	 * 
	 */
	public ResourceElement(ResourceElementType hastype) {
		super(hastype);
	}

	public ResourceElement() {
		super();
	}


	

	

}
