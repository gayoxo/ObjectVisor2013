package fdi.ucm.shared.model.collection.document;

import java.util.Date;

import fdi.ucm.shared.model.collection.grammar.MetaDate;


/**
 * Clase que genera la implementacion de un valor de tipo fecha para un Meta
 * @author Joaquin Gayoso-Cabada
 *
 */

public class MetaDateValue extends Element {


	private static final long serialVersionUID = 1L;
	
	protected Date DValue;
	
	/**
	 * Constructor por defecto
	 */
	public MetaDateValue() {
		super();
		DValue=null;
	}

	/**
	 * Constructor por parametrps de la clase
	 * @param hastype clase padre
	 */
	public MetaDateValue(MetaDate hastype) {
		super(hastype);
		DValue=null;
	}

	/**
	 * Constructor por parametrps de la clase.
	 * @param hastype clase padre.
	 * @param Value valor de la fecha.
	 */
	public MetaDateValue(MetaDate hastype, Date Valuein) {
		super(hastype);
		DValue=Valuein;
	}

	/**
	 * @return the value
	 */
	public Date getValue() {
		return DValue;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(Date value) {
		DValue = value;
	}
	
	
}

