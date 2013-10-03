package fdi.ucm.shared.model.collection.meta;

import java.io.Serializable;
import java.util.ArrayList;

import com.google.gwt.user.client.rpc.IsSerializable;

import fdi.ucm.shared.model.collection.CollectionAttribute;
import fdi.ucm.shared.model.collection.meta.show.Show;





/**
 * Clase base del esquema de atributos
 * @author Joaquin Gayoso-Cabada
 *
 */
public class Meta extends CollectionAttribute implements Serializable,IsSerializable{


	private static final long serialVersionUID = 5151085195953705390L;
	protected String Name;
	protected ArrayList<Show> Shows;   
	protected Boolean Browseable;
	protected Boolean Summary;


	
	
	/**
	 * Constructor por defecto
	 */
	public Meta() {
		super();
	Browseable=false;
	Father=null;
	Name="unknown";
	Summary=false;
	Shows=new ArrayList<Show>();
	}




	/** Constructor con todos los parametros
	 * @param father Padre del attibuto.
	 * @param name Nombre del atributo.
	 * @param browseable Define si es navegable
	 * @param summary si es sumario.
	 */
		public Meta(String name, Boolean browseable, CollectionAttribute father,Boolean summary) {
			super();
			Name = name;
			Browseable = browseable;
			Father = father;
			Summary=summary;
			Shows=new ArrayList<Show>();
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
	 * 
	 * @return the Browseable
	 */
	public Boolean getBrowseable() {
		return Browseable;
	}
	
	/**
	 * 
	 * @param browseable to browseable to set
	 */
	public void setBrowseable(Boolean browseable) {
		Browseable = browseable;
	}



	/**
	 * @return the summary
	 */
	public Boolean getSummary() {
		return Summary;
	}



	/**
	 * @param summary the summary to set
	 */
	public void setSummary(Boolean summary) {
		Summary = summary;
	}




	/**
	 * @return the shows
	 */
	public ArrayList<Show> getShows() {
		return Shows;
	}




	/**
	 * @param shows the shows to set
	 */
	public void setShows(ArrayList<Show> shows) {
		Shows = shows;
	}



//	@Override
//	public String pathFather() {
//		if (Father!=null)
//			return Father.pathFather()+"/" + Name ;
//		else return Name;
//	}
	
	
	
}
