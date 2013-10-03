/**
 * 
 */
package fdi.ucm.shared.model.collection.meta;

import fdi.ucm.shared.model.collection.CollectionAttribute;

/**
 * Clase que define el atributo Meta para un elemento de texto.
 * @author Joaquin Gayoso-Cabada
 *
 */
public class MetaText extends Meta {

	private static final long serialVersionUID = -3295083410485450541L;

	/**
	 * Constructor por defecto
	 */
	public MetaText() {
		super();
	}

	/**
	 * @param name
	 * @param browseable
	 * @param father
	 * @param summary
	 * @param visible
	 */
	public MetaText(String name, Boolean browseable,
			CollectionAttribute father, Boolean summary) {
		super(name, browseable, father, summary);
	}

	
	

}
