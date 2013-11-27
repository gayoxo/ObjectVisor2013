/**
 * 
 */
package fdi.ucm.shared.model.collection.metavalues;

import fdi.ucm.shared.model.collection.meta.MetaRelation;



/**
 * Clase que define un Ration value.
 * @author Joaquin Gayoso
 *
 */

public abstract class MetaRelationValue extends MetaValue {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * COnstructor por defecto.
	 * 
	 */
	public MetaRelationValue() {
		super();
	}

	/**
	 * Constructor con parametros con el hasttype correspondiente.
	 * @param hastype tipo al que pertenece.
	 */
	public MetaRelationValue(MetaRelation hastype) {
		super(hastype);
	}

	/**
	 * Set Value of retalion to null
	 */
	public abstract void removeValue();

}
