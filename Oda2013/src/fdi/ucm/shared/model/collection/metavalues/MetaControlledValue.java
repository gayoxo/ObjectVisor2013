/**
 * 
 */
package fdi.ucm.shared.model.collection.metavalues;

import fdi.ucm.shared.model.collection.meta.MetaControlled;
import fdi.ucm.shared.model.collection.meta.controlled.Term;

/**
 * Clase que genera la implementacion de un valor de tipo texto para un Meta
 * @author Joaquin Gayoso-Cabada
 *
 */

public class MetaControlledValue extends MetaValue {


	private static final long serialVersionUID = 1L;
	protected Term CValue;
	
	/**
	 * Constructor por defecto
	 */
	public MetaControlledValue() {
		super();
		CValue=null;
	}

	/**
	 * Constructor por parametrps de la clase
	 * @param hastype clase padre
	 */
	public MetaControlledValue(MetaControlled hastype) {
		super(hastype);
		CValue=null;
	}

	/**
	 * Constructor por parametrps de la clase.
	 * @param hastype clase padre.
	 * @param Value valor del Texto.
	 */
	public MetaControlledValue(MetaControlled hastype, Term Valuein) {
		super(hastype);
		CValue=Valuein;
	}

	/**
	 * @return the value
	 */
	public Term getValue() {
		return CValue;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(Term value) {
		CValue = value;
	}
	
	
}

