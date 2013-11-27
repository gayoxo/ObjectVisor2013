/**
 * 
 */
package fdi.ucm.shared.model.collection.metavalues;

import fdi.ucm.shared.model.collection.meta.MetaRelation;
import fdi.ucm.shared.model.collection.meta.MetaRelationConstruct;
import fdi.ucm.shared.model.collection.resources.Construct;



/**
 * Clase que define un Ration value.
 * @author Joaquin Gayoso
 *
 */

public class MetaRelationConstructValue extends MetaRelationValue {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Construct RValue;
	
	/**
	 * COnstructor por defecto.
	 * 
	 */
	public MetaRelationConstructValue() {
		super();
		RValue=null;
	}

	/**
	 * Constructor con parametros con el hasttype correspondiente.
	 * @param hastype tipo al que pertenece.
	 */
	public MetaRelationConstructValue(MetaRelation hastype) {
		super(hastype);
		RValue=null;
	}

	/**
	 * Constructor con todos los parametros.
	 * @param hastype Elemento al que pertenece.
	 * @param value valor de la referencia.
	 */
	public MetaRelationConstructValue(MetaRelationConstruct hastype, Construct value) {
		super(hastype);
		RValue = value;
	}

	/**
	 * @return the value
	 */
	public Construct getValue() {
		return RValue;
	}

	
	
	/**
	 * @param value the value to set
	 */
	public void setValue(Construct value) {
		RValue = value;
	}

	@Override
	public void removeValue() {
		RValue= null;
		
	}
	
	
	
	

}
