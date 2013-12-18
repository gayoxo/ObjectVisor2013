/**
 * 
 */
package fdi.ucm.shared.model.collection.grammar;

import java.io.Serializable;
import java.util.ArrayList;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * Clase que define una vista para un Meta
 * @author Joaquin Gayoso-Cabada
 *
 */
public class OperationalView implements Serializable,IsSerializable{

	
	private static final long serialVersionUID = -5553181915585551551L;
	protected String name;
	protected ArrayList<OperationalValueType> Values;
	
	
	public OperationalView() {
		name="Error";
		Values=new ArrayList<OperationalValueType>();
	}

	public OperationalView(String value)
	{
		name=value;
		Values=new ArrayList<OperationalValueType>();
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the values
	 */
	public ArrayList<OperationalValueType> getValues() {
		return Values;
	}

	/**
	 * @param values the values to set
	 */
	public void setValues(ArrayList<OperationalValueType> values) {
		Values = values;
	}
}
