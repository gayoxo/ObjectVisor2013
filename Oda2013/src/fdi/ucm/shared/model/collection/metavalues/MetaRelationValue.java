/**
 * 
 */
package fdi.ucm.shared.model.collection.metavalues;

import fdi.ucm.shared.model.collection.meta.MetaRelation;
import fdi.ucm.shared.model.collection.resources.RelationObject;
import fdi.ucm.shared.model.collection.resources.Resources;



/**
 * Clase que define un Ration value.
 * @author Joaquin Gayoso
 *
 */

public class MetaRelationValue extends MetaValue {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private RelationObject RValue;
	
	/**
	 * COnstructor por defecto.
	 * 
	 */
	public MetaRelationValue() {
		super();
		RValue=null;
	}

	/**
	 * Constructor con parametros con el hasttype correspondiente.
	 * @param hastype tipo al que pertenece.
	 */
	public MetaRelationValue(MetaRelation hastype) {
		super(hastype);
		RValue=null;
	}

	/**
	 * Constructor con todos los parametros.
	 * @param hastype Elemento al que pertenece.
	 * @param value valor de la referencia.
	 */
	public MetaRelationValue(MetaRelation hastype, RelationObject value) {
		super(hastype);
		RValue = value;
	}

	/**
	 * @return the value
	 */
	public RelationObject getValue() {
		return RValue;
	}

	
	
	/**
	 * @param value the value to set
	 */
	public void setValue(Resources value) {
		RValue = value;
	}
	
	
	
	

}
