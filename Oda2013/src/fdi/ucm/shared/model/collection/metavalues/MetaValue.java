package fdi.ucm.shared.model.collection.metavalues;

import java.io.Serializable;
import java.util.ArrayList;

import com.google.gwt.user.client.rpc.IsSerializable;

import fdi.ucm.shared.model.collection.Attributable;
import fdi.ucm.shared.model.collection.meta.Meta;
import fdi.ucm.shared.model.collection.meta.show.Show;



/**
 * Clase base que para la definicion de los atributos de las section values, poseen un tipo dentro del esquema de atributos.  
 * @author Joaquin Gayoso-Cabada
 *
 */

public class MetaValue implements Serializable,IsSerializable {


	private Attributable attributableFather;
	
	private static final long serialVersionUID = 1L;
	protected Meta hastype;
	protected ArrayList<Integer> Ambitos;
	protected ArrayList<Show> Shows;  

	
	/**
	 * Constructor por defecto.
	 */
	public MetaValue() {
		Ambitos=new ArrayList<Integer>();
		Shows=new ArrayList<Show>();
	}
	
	/**
	 * Constructor con parametro de entrada de el nodo al que pertenece dentro del esquema.
	 * @param hastype
	 */
	public MetaValue(Meta hastype) {
		this.hastype = hastype;
		Ambitos=new ArrayList<Integer>();
		Shows=new ArrayList<Show>();
	}

	/**
	 * @return the hastype
	 */
	public Meta getHastype() {
		return hastype;
		
	}

	/**
	 * @param hastype the hastype to set
	 */
	public void setHastype(Meta hastype) {
		this.hastype = hastype;
	}

	/**
	 * @return the ambitos
	 */
	public ArrayList<Integer> getAmbitos() {
		return Ambitos;
	}

	/**
	 * @param ambitos the ambitos to set
	 */
	public void setAmbitos(ArrayList<Integer> ambitos) {
		Ambitos = ambitos;
	}


	/**
	 * @return the attributableFather
	 */
	public Attributable getAttributableFather() {
		return attributableFather;
	}

	/**
	 * @param attributableFather the attributableFather to set
	 */
	public void setAttributableFather(Attributable attributableFather) {
		this.attributableFather = attributableFather;
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
	
	
	
	
}
