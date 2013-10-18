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
public class ShowInstance extends Show implements Serializable,IsSerializable{

	
	private static final long serialVersionUID = -5553181915585551551L;
	protected ArrayList<ShowValuesInstance> Values;
	
	
	public ShowInstance() {
		super();
		Values=new ArrayList<ShowValuesInstance>();
	}

	public ShowInstance(String value)
	{
		super(value);
		Values=new ArrayList<ShowValuesInstance>();
	}
	/**
	 * @return the values
	 */
	public ArrayList<ShowValuesInstance> getValues() {
		return Values;
	}

	/**
	 * @param values the values to set
	 */
	public void setValues(ArrayList<ShowValuesInstance> values) {
		Values = values;
	}

	
	
	
}
