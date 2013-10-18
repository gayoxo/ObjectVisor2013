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
public class ShowSchema extends Show implements Serializable,IsSerializable{

	
	private static final long serialVersionUID = -5553181915585551551L;
	protected ArrayList<ShowValues> Values;
	protected String name;
	
	
	public ShowSchema() {
		super();
		Values=new ArrayList<ShowValues>();
	}

	public ShowSchema(String value)
	{
		super(value);
		Values=new ArrayList<ShowValues>();
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


	
	
}
