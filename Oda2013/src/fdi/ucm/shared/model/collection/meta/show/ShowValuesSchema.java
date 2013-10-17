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
public class ShowValuesSchema extends ShowValues implements Serializable,IsSerializable{



	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1058491057386424065L;


	public ShowValuesSchema() {
		super();
	}

	
	/**
	 * @param valor
	 */
	public ShowValuesSchema(String valor) {
		super(valor);
	}
	
	
	
}
