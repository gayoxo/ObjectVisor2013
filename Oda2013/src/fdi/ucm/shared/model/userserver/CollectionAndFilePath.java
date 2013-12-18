/**
 * 
 */
package fdi.ucm.shared.model.userserver;

import java.io.Serializable;

import com.google.gwt.user.client.rpc.IsSerializable;

import fdi.ucm.shared.model.collection.Collection;

/**
 * Clase de intercambio para cargar una coleccion y su path
 * @author Joaquin Gayoso-Cabada
 *
 */
public class CollectionAndFilePath implements Serializable,IsSerializable{

	
	private static final long serialVersionUID = 6592631257848928894L;
	private Collection Coleccion;
	private String Description;
	
	
	public CollectionAndFilePath() {
		super();
		Coleccion = null;
		Description="";
	}
	
	/**
	 * @param coleccion
	 * @param filePath
	 */
	public CollectionAndFilePath(Collection coleccion, String description) {
		super();
		Coleccion = coleccion;
		Description= description;
	}

	/**
	 * @return the coleccion
	 */
	public Collection getColeccion() {
		return Coleccion;
	}

	/**
	 * @param coleccion the coleccion to set
	 */
	public void setColeccion(Collection coleccion) {
		Coleccion = coleccion;
	}


	/**
	 * @return the description
	 */
	public String getDescription() {
		return Description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		Description = description;
	}
	
	
	
	
}
