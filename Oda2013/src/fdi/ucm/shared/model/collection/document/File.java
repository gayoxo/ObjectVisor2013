/**
 * 
 */
package fdi.ucm.shared.model.collection.document;

import java.io.Serializable;

import fdi.ucm.shared.model.collection.Collection;

/**
 * Clase que implementa un sectionValue file
 * @author Joaquin Gayoso-Cabada
 *
 */
public class File implements Serializable{


	private static final long serialVersionUID = 7786350162913651910L;
	private String Path;
	private Collection collectionFather;
	
	public File() {
		super();
		this.Path="";
	}
	
	/**
	 * Constructor por defecto
	 */
	public File(String Path) {
		super();
		this.Path=Path;
	}
	/**
	 * @return the path
	 */
	public String getPath() {
		return Path;
	}
	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		Path = path;
	}
	
	public Collection getCollectionFather() {
		return collectionFather;
	}



	public void setCollectionFather(Collection collectionFather) {
		this.collectionFather=collectionFather;
		
	}
}
