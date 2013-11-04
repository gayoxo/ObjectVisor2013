package fdi.ucm.shared.model.collection.resources;

import fdi.ucm.shared.model.collection.Attributable;
import fdi.ucm.shared.model.collection.Collection;
import fdi.ucm.shared.model.collection.meta.Meta;

/**
 * Clase que diseña las construciones basicas .
 * @author Joaquin Gayoso-Cabada
 *
 */
public class Construct extends Attributable implements RelationObject{

	private static final long serialVersionUID = 1L;
	private Collection collectionFather;
	private Meta Document;


	/**
	 * Constructior por defecto
	 */
	public Construct() {
		super();
	}



	/**
	 * @param document
	 */
	public Construct(Meta document) {
		super();
		Document = document;
	}



	public Collection getCollectionFather() {
		return collectionFather;
	}



	public void setCollectionFather(Collection collectionFather) {
		this.collectionFather=collectionFather;
		
	}



	/**
	 * @return the document
	 */
	public Meta getDocument() {
		return Document;
	}



	/**
	 * @param document the document to set
	 */
	public void setDocument(Meta document) {
		Document = document;
	}

	
	
}
