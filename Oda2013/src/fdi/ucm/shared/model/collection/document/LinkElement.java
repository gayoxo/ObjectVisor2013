/**
 * 
 */
package fdi.ucm.shared.model.collection.document;

import fdi.ucm.shared.model.collection.grammar.LinkElementType;



/**
 * Clase que define un Ration value.
 * @author Joaquin Gayoso
 *
 */

public class LinkElement extends Element {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Documents RValue;
	
	/**
	 * COnstructor por defecto.
	 * 
	 */
	public LinkElement() {
		super();
		RValue=null;
	}

	/**
	 * Constructor con parametros con el hasttype correspondiente.
	 * @param hastype tipo al que pertenece.
	 */
	public LinkElement(LinkElementType hastype) {
		super(hastype);
		RValue=null;
	}

	/**
	 * Constructor con todos los parametros.
	 * @param hastype Elemento al que pertenece.
	 * @param value valor de la referencia.
	 */
	public LinkElement(LinkElementType hastype, Documents value) {
		super(hastype);
		RValue = value;
	}

	/**
	 * @return the value
	 */
	public Documents getValue() {
		return RValue;
	}

	
	
	/**
	 * @param value the value to set
	 */
	public void setValue(Documents value) {
		RValue = value;
	}

	/**
	 * Limpia el valor
	 */
	public void removeValue() {
		RValue = null;
		
	}


	
	

}
