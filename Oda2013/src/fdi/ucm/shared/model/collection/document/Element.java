package fdi.ucm.shared.model.collection.document;

import java.io.Serializable;
import java.util.ArrayList;

import com.google.gwt.user.client.rpc.IsSerializable;


import fdi.ucm.shared.model.collection.grammar.ElementType;



/**
 * Clase base que para la definicion de los atributos de las section values, poseen un tipo dentro del esquema de atributos.  
 * @author Joaquin Gayoso-Cabada
 *
 */

public class Element implements Serializable,IsSerializable {


	private Documents DocumentsFather;
	
	private static final long serialVersionUID = 1L;
	protected ElementType hastype;
	protected ArrayList<Integer> Ambitos;
	protected ArrayList<OperationalValue> Shows;  

	
	/**
	 * Constructor por defecto.
	 */
	public Element() {
		Ambitos=new ArrayList<Integer>();
		Shows=new ArrayList<OperationalValue>();
	}
	
	/**
	 * Constructor con parametro de entrada de el nodo al que pertenece dentro del esquema.
	 * @param hastype
	 */
	public Element(ElementType hastype) {
		this.hastype = hastype;
		Ambitos=new ArrayList<Integer>();
		Shows=new ArrayList<OperationalValue>();
	}

	/**
	 * @return the hastype
	 */
	public ElementType getHastype() {
		return hastype;
		
	}

	/**
	 * @param hastype the hastype to set
	 */
	public void setHastype(ElementType hastype) {
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
	 * @return the DocumentsFather
	 */
	public Documents getDocumentsFather() {
		return DocumentsFather;
	}

	/**
	 * @param DocumentsFather the DocumentsFather to set
	 */
	public void setDocumentsFather(Documents DocumentsFather) {
		this.DocumentsFather = DocumentsFather;
	}

	/**
	 * @return the shows
	 */
	public ArrayList<OperationalValue> getShows() {
		return Shows;
	}

	/**
	 * @param shows the shows to set
	 */
	public void setShows(ArrayList<OperationalValue> shows) {
		Shows = shows;
	}
	
	
	
	
}
