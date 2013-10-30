/**
 * 
 */
package fdi.ucm.shared.model.collection.metavalues;

import fdi.ucm.shared.model.collection.meta.MetaBoolean;


/**
 * Clase que genera la implementacion de un valor de tipo texto para un Meta
 * @author Joaquin Gayoso-Cabada
 *
 */

public class MetaBooleanValue extends MetaValue {


	private static final long serialVersionUID = 1L;
	protected Boolean BValue;
	
	/**
	 * Constructor por defecto
	 */
	public MetaBooleanValue() {
		super();
		BValue=null;
	}

	/**
	 * Constructor por parametrps de la clase
	 * @param hastype clase padre
	 */
	public MetaBooleanValue(MetaBoolean hastype) {
		super(hastype);
		BValue=null;
	}

	/**
	 * Constructor por parametrps de la clase.
	 * @param hastype clase padre.
	 * @param Value valor del Texto.
	 */
	public MetaBooleanValue(MetaBoolean hastype, Boolean Valuein) {
		super(hastype);
		BValue=Valuein;
	}

	/**
	 * @return the value
	 */
	public Boolean getValue() {
		return BValue;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(Boolean value) {
		BValue = value;
	}
	
	
}