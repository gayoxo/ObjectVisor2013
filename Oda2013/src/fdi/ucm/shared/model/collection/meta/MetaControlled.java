/**
 * 
 */
package fdi.ucm.shared.model.collection.meta;

import fdi.ucm.shared.model.collection.CollectionAttribute;
import fdi.ucm.shared.model.collection.meta.controlled.Vocabulary;



/**
 * Clase que define el atributo Meta para un elemento de Controlado.
 * @author Joaquin Gayoso-Cabada
 *
 */
public class MetaControlled extends Meta {

	private static final long serialVersionUID = 3682420925857572152L;
	
	protected Vocabulary vocabulary;
	
	/**
	 * Constructor por defecto
	 */
	public MetaControlled() {
		super();
		vocabulary=new Vocabulary();
	}

	
	
	

	/**
	 * @param name
	 * @param browseable
	 * @param father
	 * @param summary
	 * @param visible
	 */
	public MetaControlled(String name,CollectionAttribute father, Boolean summary) {
		super(name,father, summary);
		vocabulary=new Vocabulary();
	}





	/**
	 * @return the vocabulary
	 */
	public Vocabulary getVocabulary() {
		return vocabulary;
	}

	/**
	 * @param vocabulary the vocabulary to set
	 */
	public void setVocabulary(Vocabulary vocabulary) {
		this.vocabulary = vocabulary;
	}

	


}
