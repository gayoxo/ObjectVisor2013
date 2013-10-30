/**
 * 
 */
package fdi.ucm.shared.model.collection.metavalues;

import fdi.ucm.shared.model.collection.meta.MetaNumeric;


/**
 * Clase que genera la implementacion de un valor de tipo texto para un Meta
 * @author Joaquin Gayoso-Cabada
 *
 */

public class MetaNumericValue extends MetaValue {


	private static final long serialVersionUID = 1L;
	protected Float NValue;
	
	/**
	 * Constructor por defecto
	 */
	public MetaNumericValue() {
		super();
		NValue=null;
	}

	/**
	 * Constructor por parametrps de la clase
	 * @param hastype clase padre
	 */
	public MetaNumericValue(MetaNumeric hastype) {
		super(hastype);
		NValue=null;
	}

	/**
	 * Constructor por parametrps de la clase.
	 * @param hastype clase padre.
	 * @param Value valor del Texto.
	 */
	public MetaNumericValue(MetaNumeric hastype, Float Valuein) {
		super(hastype);
		NValue=Valuein;
	}

	/**
	 * @return the value
	 */
	public Float getValue() {
		return NValue;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(Float value) {
		NValue = value;
	}
	
	
}
