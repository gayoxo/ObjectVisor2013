/**
 * 
 */
package fdi.ucm.shared.model.collection.document;

import java.io.Serializable;
import com.google.gwt.user.client.rpc.IsSerializable;

import fdi.ucm.shared.model.collection.grammar.OperationalValueType;

/**
 * Clase que define un valor para la vista
 * @author Joaquin Gayoso-Cabada
 *
 */
public class OperationalValue implements Serializable,IsSerializable{



	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1058491057386424065L;
	private OperationalValueType type;
	private String Value;

	public OperationalValue() {
		super();
		Value=null;
		type=null;
	}

	
	/**
	 * @param valor
	 */
	public OperationalValue(OperationalValueType type,String valor) {
		super();
		Value=valor;
		this.type=type;
	}


	/**
	 * @return the type
	 */
	public OperationalValueType getType() {
		return type;
	}


	/**
	 * @param type the type to set
	 */
	public void setType(OperationalValueType type) {
		this.type = type;
	}


	/**
	 * @return the value
	 */
	public String getValue() {
		return Value;
	}


	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		Value = value;
	}


	
}
