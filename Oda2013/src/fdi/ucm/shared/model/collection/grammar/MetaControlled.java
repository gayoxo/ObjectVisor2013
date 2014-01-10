/**
 * 
 */
package fdi.ucm.shared.model.collection.grammar;

import fdi.ucm.shared.model.collection.grammar.controlled.Vocabulary;



/**
 * Clase que define el atributo Meta para un elemento de Controlado.
 * @author Joaquin Gayoso-Cabada
 *
 */
public class MetaControlled extends ElementType {

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
	 * @param father
	 */
	public MetaControlled(String name,Structure father) {
		super(name,father);
		vocabulary=new Vocabulary();
	}



	/**
	 * @param name
	 * @param father
	 */
	public MetaControlled(String name,Grammar GramaticaPadre) {
		super(name,GramaticaPadre);
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
