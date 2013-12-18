/**
 * 
 */
package fdi.ucm.shared.model.collection.document;

/**
 * Clase que implementa un sectionValue file
 * @author Joaquin Gayoso-Cabada
 *
 */
public class File extends Resources{


	private static final long serialVersionUID = 1L;
	private String Path;
	
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
	
	
}
