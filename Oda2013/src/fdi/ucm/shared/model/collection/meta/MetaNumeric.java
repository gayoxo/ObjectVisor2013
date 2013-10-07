/**
 * 
 */
package fdi.ucm.shared.model.collection.meta;

import fdi.ucm.shared.model.collection.CollectionAttribute;

/**
 * Clase que redefine el atributo meta para el nodo de tipo numerico. 
 * @author Joaquin Gayoso-Cabada
 *
 */
public class MetaNumeric extends Meta {

	private static final long serialVersionUID = 4151697778650120145L;

	/**
	 * Constructor por defecto
	 */
	public MetaNumeric() {
		super();
	}

	/**
	 * @param name
	 * @param father
	 * @param summary
	 */
	public MetaNumeric(String name,	CollectionAttribute father, Boolean summary) {
		super(name, father, summary);
	}

	


	
	

}
