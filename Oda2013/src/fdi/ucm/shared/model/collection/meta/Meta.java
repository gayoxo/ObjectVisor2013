package fdi.ucm.shared.model.collection.meta;

import java.io.Serializable;
import java.util.ArrayList;

import com.google.gwt.user.client.rpc.IsSerializable;

import fdi.ucm.shared.model.collection.CollectionAttribute;
import fdi.ucm.shared.model.collection.meta.show.ShowSchema;





/**
 * Clase base del esquema de atributos
 * @author Joaquin Gayoso-Cabada
 *
 */
public class Meta extends CollectionAttribute implements Serializable,IsSerializable{


	private static final long serialVersionUID = 5151085195953705390L;
	protected String Name;
	protected ArrayList<ShowSchema> Shows;  


	
	
	/**
	 * Constructor por defecto
	 */
	public Meta() {
		super();
	Father=null;
	Name="unknown";
	Shows=new ArrayList<ShowSchema>();
	}




	/** Constructor con todos los parametros
	 * @param father Padre del attibuto.
	 * @param name Nombre del atributo.
	 * @param browseable Define si es navegable
	 */
		public Meta(String name, CollectionAttribute father) {
			super();
			Name = name;
			Father = father;
			Shows=new ArrayList<ShowSchema>();
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
	public ArrayList<ShowSchema> getShows() {
		return Shows;
	}




	/**
	 * @param shows the shows to set
	 */
	public void setShows(ArrayList<ShowSchema> shows) {
		Shows = shows;
	}




	
}
