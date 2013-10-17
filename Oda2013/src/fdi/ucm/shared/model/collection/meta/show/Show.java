/**
 * 
 */
package fdi.ucm.shared.model.collection.meta.show;

import java.io.Serializable;
import java.util.ArrayList;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * Clase que define una vista para un Meta
 * @author Joaquin Gayoso-Cabada
 *
 */
public class Show implements Serializable,IsSerializable{

	
	private static final long serialVersionUID = -5553181915585551551L;
	protected ArrayList<ShowValues> Values;
	protected String name;
	
	
	public Show() {
		Values=new ArrayList<ShowValues>();
	}

	public Show(String value)
	{
		Values=new ArrayList<ShowValues>();
		name=value;
	}
	/**
	 * @return the values
	 */
	public ArrayList<ShowValues> getValues() {
		return Values;
	}

	/**
	 * @param values the values to set
	 */
	public void setValues(ArrayList<ShowValues> values) {
		Values = values;
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
	
	
}
