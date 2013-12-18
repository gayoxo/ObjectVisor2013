package fdi.ucm.shared.model.collection.grammar.controlled;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * Clase que implementa un vocabulario
 * @author Joaquin Gayoso-Cabada
 *
 */
public class Vocabulary implements Serializable,IsSerializable{


	
	private String Name;
	
	private static final long serialVersionUID = 3691846174757556535L;
	
	@OneToMany(cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH}, fetch = FetchType.EAGER,orphanRemoval=true, mappedBy="vocabularyFather")
	protected List<Term> list;
	
	private boolean afectado;
	
	/**
	 * Constructor por defecto de un vocabulario
	 */
	public Vocabulary() {
		list=new ArrayList<Term>();
		Name="Vocabulario";
		afectado=false;
	}

	/**
	 * @return the afectado
	 */
	public boolean isAfectado() {
		return afectado;
	}

	/**
	 * @param afectado the afectado to set
	 */
	public void setAfectado(boolean afectado) {
		this.afectado = afectado;
	}

	/**
	 * @return the list
	 */
	public List<Term> getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(ArrayList<Term> list) {
		this.list = list;
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


	
	
	
	
	
}
