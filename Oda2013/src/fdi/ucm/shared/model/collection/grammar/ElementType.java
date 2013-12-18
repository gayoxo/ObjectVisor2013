package fdi.ucm.shared.model.collection.grammar;

import java.io.Serializable;
import java.util.ArrayList;

import com.google.gwt.user.client.rpc.IsSerializable;






/**
 * Clase base del esquema de atributos
 * @author Joaquin Gayoso-Cabada
 *
 */
public class ElementType extends Structure implements Serializable,IsSerializable{


	private static final long serialVersionUID = 5151085195953705390L;
	protected String Name;
	protected ArrayList<OperationalView> Shows;  


	
	
	/**
	 * Constructor por defecto
	 */
	public ElementType() {
		super();
	Father=null;
	Name="unknown";
	Shows=new ArrayList<OperationalView>();
	}




	/** Constructor con todos los parametros
	 * @param father Padre del attibuto.
	 * @param name Nombre del atributo.
	 * @param browseable Define si es navegable
	 */
		public ElementType(String name, Structure father) {
			super();
			Name = name;
			Father = father;
			Shows=new ArrayList<OperationalView>();
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
	 * @return the shows
	 */
	public ArrayList<OperationalView> getShows() {
		return Shows;
	}




	/**
	 * @param shows the shows to set
	 */
	public void setShows(ArrayList<OperationalView> shows) {
		Shows = shows;
	}




	
}
