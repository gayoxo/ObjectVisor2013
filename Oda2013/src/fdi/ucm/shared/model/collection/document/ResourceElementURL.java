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

public class ResourceElementURL extends ResourceElement {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String URL;
	
	/**
	 * COnstructor por defecto.
	 * 
	 */
	public ResourceElementURL() {
		super();
		URL=null;
	}

	/**
	 * Constructor con parametros con el hasttype correspondiente.
	 * @param hastype tipo al que pertenece.
	 */
	public ResourceElementURL(ResourceElementType hastype) {
		super(hastype);
		URL=null;
	}

	/**
	 * Constructor con todos los parametros.
	 * @param hastype Elemento al que pertenece.
	 * @param value valor de la referencia.
	 */
	public ResourceElementURL(ResourceElementType hastype, String value) {
		super(hastype);
		URL = value;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return URL;
	}

	
	
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		URL = value;
	}

	/**
	 * Limpia el valor
	 */
	public void removeValue() {
		URL = null;
		
	}


	

	

}
