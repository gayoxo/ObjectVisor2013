package fdi.ucm.shared.model.collection.resources;

import fdi.ucm.shared.model.collection.Attributable;
import fdi.ucm.shared.model.collection.Collection;

/**
 * Clase que diseña las construciones basicas .
 * @author Joaquin Gayoso-Cabada
 *
 */
public class Construct extends Attributable implements RelationObject{

	private static final long serialVersionUID = 1L;
	private Collection collectionFather;


	/**
	 * Constructior por defecto
	 */
	public Construct() {
		super();
	}



	public Collection getCollectionFather() {
		return collectionFather;
	}



	public void setCollectionFather(Collection collectionFather) {
		this.collectionFather=collectionFather;
		
	}

	
}
