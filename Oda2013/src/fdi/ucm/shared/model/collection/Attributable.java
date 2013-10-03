package fdi.ucm.shared.model.collection;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.rpc.IsSerializable;

import fdi.ucm.shared.model.collection.metavalues.MetaValue;


/**
 * Clase que define que objetos pueden tener atributos
 * @author Joaquin Gayoso-Cabada
 *
 */
public abstract class Attributable implements Serializable,IsSerializable{

	private static final long serialVersionUID = 1L;
	
	protected List<MetaValue> Description;
	
	/**
	 * Constructor que permite generar attribuibles
	 */
	public Attributable() {
		Description=new ArrayList<MetaValue>();
	}
	
	/**
	 * @return the description
	 */
	public List<MetaValue> getDescription() {
		return Description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(ArrayList<MetaValue> description) {
		Description = description;
	}

	

}
