/**
 * 
 */
package fdi.ucm.shared.model.collection.grammar;


/**
 * Clase que define el atributo Meta para un elemento de boleano.
 * @author Joaquin Gayoso-Cabada
 *
 */
public class MetaBoolean extends ElementType {

	private static final long serialVersionUID = -3295083410485450541L;

	/**
	 * Constructor por defecto
	 */
	public MetaBoolean() {
		super();
	}

	/**
	 * {@link ElementType constructor}
	 * @param name
	 * @param father
	 */
	public MetaBoolean(String name,Structure father) {
		super(name, father);
	}

	

	/**
	 * {@link ElementType constructor}
	 * @param name
	 * @param father
	 */
	public MetaBoolean(String name,Grammar GramaticaPadre) {
		super(name, GramaticaPadre);
	}
	
	

}
