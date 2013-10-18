/**
 * 
 */
package fdi.ucm.shared.model.collection.meta.show;

import java.io.Serializable;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * Clase que define una vista para un Meta
 * @author Joaquin Gayoso-Cabada
 *
 */
public abstract class Show implements Serializable,IsSerializable{

	
	private static final long serialVersionUID = -5553181915585551551L;
	protected String name;
	
	
	public Show() {
	}

	public Show(String value)
	{
		name=value;
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
