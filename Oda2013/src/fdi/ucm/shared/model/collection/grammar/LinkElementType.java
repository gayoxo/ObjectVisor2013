package fdi.ucm.shared.model.collection.grammar;


/**
 * Clase que genera una relacion entre secciones
 * @author Joaquin Gayoso
 *
 */
public class LinkElementType extends ElementType{

	private static final long serialVersionUID = 1L;
	
	
	public LinkElementType() {
		super();
	}


	/**
	 * @param name
	 * @param father
	 * @param summary
	 */
	public LinkElementType(String name, Structure father) {
		super(name,father);
	}
	

}
