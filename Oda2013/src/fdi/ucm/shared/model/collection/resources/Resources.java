package fdi.ucm.shared.model.collection.resources;

import java.io.Serializable;

import fdi.ucm.shared.model.collection.Collection;




/**
 * Clase base que define un valor dentro de la estructura de archivos.
 * @author Joaquin Gayoso-Cabada
 *
 */
public abstract class Resources implements Serializable,RelationObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7786350162913651910L;
	private Collection collectionFather;

	public Resources() {

	}
	

	public Collection getCollectionFather() {
		return collectionFather;
	}



	public void setCollectionFather(Collection collectionFather) {
		this.collectionFather=collectionFather;
		
	}
	
}
