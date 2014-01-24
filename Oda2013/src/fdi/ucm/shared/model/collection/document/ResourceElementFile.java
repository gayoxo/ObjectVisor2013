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

public class ResourceElementFile extends ResourceElement {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private File FilePath;
	
	/**
	 * COnstructor por defecto.
	 * 
	 */
	public ResourceElementFile() {
		super();
		FilePath=null;
	}

	/**
	 * Constructor con parametros con el hasttype correspondiente.
	 * @param hastype tipo al que pertenece.
	 */
	public ResourceElementFile(ResourceElementType hastype) {
		super(hastype);
		FilePath=null;
	}

	/**
	 * Constructor con todos los parametros.
	 * @param hastype Elemento al que pertenece.
	 * @param value valor de la referencia.
	 */
	public ResourceElementFile(ResourceElementType hastype, File value) {
		super(hastype);
		FilePath = value;
	}

	/**
	 * @return the value
	 */
	public File getValue() {
		return FilePath;
	}

	
	
	/**
	 * @param value the value to set
	 */
	public void setValue(File value) {
		FilePath = value;
	}

	/**
	 * Limpia el valor
	 */
	public void removeValue() {
		FilePath = null;
		
	}


	

	

}
