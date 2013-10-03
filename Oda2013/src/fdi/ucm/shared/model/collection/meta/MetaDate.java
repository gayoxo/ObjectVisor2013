package fdi.ucm.shared.model.collection.meta;

import fdi.ucm.shared.model.collection.CollectionAttribute;

/**
 * Clase que define el atributo Meta para un elemento de fecha.
 * @author Joaquin Gayoso-Cabada
 *
 */
public class MetaDate extends Meta {


	private static final long serialVersionUID = -5648236153802918973L;

	/**
	 * Constructor por defecto
	 */
	public MetaDate() {
		super();
	}

	/**
	 * @param name
	 * @param browseable
	 * @param father
	 * @param summary
	 * @param visible
	 */
	public MetaDate(String name, Boolean browseable,
			CollectionAttribute father, Boolean summary) {
		super(name, browseable, father, summary);
	}

	

	
	
	

}
