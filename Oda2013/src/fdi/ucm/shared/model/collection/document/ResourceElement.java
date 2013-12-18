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

public class ResourceElement extends Element {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Resources RValue;
	
	/**
	 * COnstructor por defecto.
	 * 
	 */
	public ResourceElement() {
		super();
		RValue=null;
	}

	/**
	 * Constructor con parametros con el hasttype correspondiente.
	 * @param hastype tipo al que pertenece.
	 */
	public ResourceElement(ResourceElementType hastype) {
		super(hastype);
		RValue=null;
	}

	/**
	 * Constructor con todos los parametros.
	 * @param hastype Elemento al que pertenece.
	 * @param value valor de la referencia.
	 */
	public ResourceElement(ResourceElementType hastype, Resources value) {
		super(hastype);
		RValue = value;
	}

	/**
	 * @return the value
	 */
	public Resources getValue() {
		return RValue;
	}

	
	
	/**
	 * @param value the value to set
	 */
	public void setValue(Resources value) {
		RValue = value;
	}

	/**
	 * Limpia el valor
	 */
	public void removeValue() {
		RValue = null;
		
	}


	

	

}
