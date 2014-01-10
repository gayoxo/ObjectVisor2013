/**
 * 
 */
package fdi.ucm.shared.model.collection.grammar;



/**
 * Clase que define el atributo Meta para un elemento de iterador, sin valor.
 * @author Joaquin Gayoso-Cabada
 *
 */
public class Iterator extends Structure {

	private static final long serialVersionUID = -3295083410485450541L;
	
	private Integer AmbitoSTotales;

	/**
	 * Constructor por defecto
	 */
	public Iterator() {
		super();
		AmbitoSTotales=1;
	}

	
	/**
	 * Constructor con todos los parametros
 * @param father Padre del attibuto.
	 */
	public Iterator(Structure father) {
		super(father,null);
		AmbitoSTotales=1;
	}

	/**
	 * Constructor con todos los parametros
 * @param father Padre del attibuto.
	 */
	public Iterator(Grammar Padre) {
		super(null,Padre);
		AmbitoSTotales=1;
	}
	
	/**
	 * @return the ambitoSTotales
	 */
	public Integer getAmbitoSTotales() {
		return AmbitoSTotales;
	}


	/**
	 * @param ambitoSTotales the ambitoSTotales to set
	 */
	public void setAmbitoSTotales(Integer ambitoSTotales) {
		AmbitoSTotales = ambitoSTotales;
	}


	
	


	
	
	

}
