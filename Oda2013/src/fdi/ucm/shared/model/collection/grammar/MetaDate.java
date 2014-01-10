package fdi.ucm.shared.model.collection.grammar;


/**
 * Clase que define el atributo Meta para un elemento de fecha.
 * @author Joaquin Gayoso-Cabada
 *
 */
public class MetaDate extends ElementType {


	private static final long serialVersionUID = -5648236153802918973L;

	/**
	 * Constructor por defecto
	 */
	public MetaDate() {
		super();
	}

	/**
	 * @param name
	 * @param father
	 * @param summary
	 */
	public MetaDate(String name,Structure father) {
		super(name, father);
	}

	
	/**
	 * @param name
	 * @param father
	 * @param summary
	 */
	public MetaDate(String name,Grammar GramaticaPadre) {
		super(name, GramaticaPadre);
	}

	
	
	
	

}
