/**
 * 
 */
package fdi.ucm.shared.model.collection.meta.show;

import java.io.Serializable;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * Clase que define un valor para la vista
 * @author Joaquin Gayoso-Cabada
 *
 */
public class ShowValuesInstance extends ShowValues implements Serializable,IsSerializable{


	private static final long serialVersionUID = 2611988084685026790L;

	
	public ShowValuesInstance() {
		super();
	}

	
	/**
	 * @param valor
	 */
	public ShowValuesInstance(String valor) {
		super(valor);
	}
	
	
	
}
