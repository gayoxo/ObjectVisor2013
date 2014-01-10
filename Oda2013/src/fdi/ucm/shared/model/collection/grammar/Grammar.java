/**
 * 
 */
package fdi.ucm.shared.model.collection.grammar;

import java.io.Serializable;
import java.util.ArrayList;

import com.google.gwt.user.client.rpc.IsSerializable;

import fdi.ucm.shared.model.collection.Collection;

/**
 * Clase que define una gramatica
 * @author Joaquin Gayoso-Cabada
 *
 */
public class Grammar implements Serializable,IsSerializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1669968409568391810L;
	private ArrayList<Structure> Sons;
	private String Nombre;
	private String Description;
	private ArrayList<OperationalView> Views;
	private Collection Coleccion;
	
	
	public Grammar() {
		Sons=new ArrayList<Structure>();
		Nombre=null;
		Description=null;
		Views=new ArrayList<OperationalView>();
	}


	/**
	 * @param nombre
	 * @param description
	 */
	public Grammar(String nombre, String description,Collection coleccion) {
		super();
		Nombre = nombre;
		Description = description;
		Sons=new ArrayList<Structure>();
		Views=new ArrayList<OperationalView>();
		Coleccion=coleccion;
		
	}


	/**
	 * @return the sons
	 */
	public ArrayList<Structure> getSons() {
		return Sons;
	}


	/**
	 * @param sons the sons to set
	 */
	public void setSons(ArrayList<Structure> sons) {
		Sons = sons;
	}


	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return Nombre;
	}


	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		Nombre = nombre;
	}


	/**
	 * @return the description
	 */
	public String getDescription() {
		return Description;
	}


	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		Description = description;
	}


	/**
	 * @return the views
	 */
	public ArrayList<OperationalView> getViews() {
		return Views;
	}


	/**
	 * @param views the views to set
	 */
	public void setViews(ArrayList<OperationalView> views) {
		Views = views;
	}


	/**
	 * @return the coleccion
	 */
	public Collection getColeccion() {
		return Coleccion;
	}


	/**
	 * @param coleccion the coleccion to set
	 */
	public void setColeccion(Collection coleccion) {
		Coleccion = coleccion;
	}
	
	
}
