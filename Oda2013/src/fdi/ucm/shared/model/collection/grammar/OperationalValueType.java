/**
 * 
 */
package fdi.ucm.shared.model.collection.grammar;

import java.io.Serializable;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * Clase que define un valor para la vista
 * @author Joaquin Gayoso-Cabada
 *
 */
public class OperationalValueType implements Serializable,IsSerializable{


	private static final long serialVersionUID = 2611988084685026790L;
	protected String Default;
	protected String Name;
	protected OperationalView View;

	
	public OperationalValueType() {
		super();
		Default=null;
		Name=null;
	}

	
	/**
	 * 
	 * @param Name
	 * @param defaultV
	 */
	public OperationalValueType(String Name,String defaultV,OperationalView padre) {
		super();
		Default=defaultV;
		this.Name=Name;
		View=padre;
	}


	/**
	 * @return the default
	 */
	public String getDefault() {
		return Default;
	}


	/**
	 * @param default1 the default to set
	 */
	public void setDefault(String default1) {
		Default = default1;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return Name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		Name = name;
	}


	/**
	 * @return the view
	 */
	public OperationalView getView() {
		return View;
	}


	/**
	 * @param view the view to set
	 */
	public void setView(OperationalView view) {
		View = view;
	}
	
	
	
}
