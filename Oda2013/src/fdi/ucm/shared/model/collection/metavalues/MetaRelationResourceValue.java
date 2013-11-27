/**
 * 
 */
package fdi.ucm.shared.model.collection.metavalues;


import fdi.ucm.shared.model.collection.meta.MetaRelation;
import fdi.ucm.shared.model.collection.meta.MetaRelationResource;
import fdi.ucm.shared.model.collection.resources.Resources;



/**
 * Clase que define un Ration value.
 * @author Joaquin Gayoso
 *
 */

public class MetaRelationResourceValue extends MetaRelationValue {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Resources RValue;
	
	/**
	 * COnstructor por defecto.
	 * 
	 */
	public MetaRelationResourceValue() {
		super();
		RValue=null;
	}

	/**
	 * Constructor con parametros con el hasttype correspondiente.
	 * @param hastype tipo al que pertenece.
	 */
	public MetaRelationResourceValue(MetaRelation hastype) {
		super(hastype);
		RValue=null;
	}

	/**
	 * Constructor con todos los parametros.
	 * @param hastype Elemento al que pertenece.
	 * @param value valor de la referencia.
	 */
	public MetaRelationResourceValue(MetaRelationResource hastype, Resources value) {
		super(hastype);
		RValue = value;
	}

	/**
	 * @return the value
	 */
	public Resources getValue() {
		return RValue;
	}

	
	
	/**
	 * @param value the value to set
	 */
	public void setValue(Resources value) {
		RValue = value;
	}
	
	
	@Override
	public void removeValue() {
		RValue= null;
		
	}
	

}
