/**
 * 
 */
package fdi.ucm.shared.model.collection.document;

/**
 * Constructor de la clase URL
 * @author Joaquin Gayoso-Cabada
 *
 */
public class URL extends Resources {


	private static final long serialVersionUID = 1L;
	private String Src;
	
	public URL() {
		super();
		Src="";
	}
	
	public URL(String src) {
		super();
		Src=src;
	}

	/**
	 * @return the src
	 */
	public String getSrc() {
		return Src;
	}

	/**
	 * @param src the src to set
	 */
	public void setSrc(String src) {
		Src = src;
	}

	
	
}
