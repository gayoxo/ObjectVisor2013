package fdi.ucm.shared.model.collection.grammar;


/**
 * Clase que genera una relacion entre secciones
 * @author Joaquin Gayoso
 *
 */
public class ResourceElementType extends ElementType{

	private static final long serialVersionUID = 1L;
	
	
	public ResourceElementType() {
		super();
	}


	/**
	 * @param name
	 * @param father
	 * @param summary
	 */
	public ResourceElementType(String name, Structure father) {
		super(name,father);
	}
	
	/**
	 * @param name
	 * @param father
	 * @param summary
	 */
	public ResourceElementType(String name, Grammar GramaticaPadre) {
		super(name,GramaticaPadre);
	}
	

}
