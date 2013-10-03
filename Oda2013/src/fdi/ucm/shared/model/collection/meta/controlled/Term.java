package fdi.ucm.shared.model.collection.meta.controlled;

import java.io.Serializable;

import com.google.gwt.user.client.rpc.IsSerializable;

import fdi.ucm.shared.model.collection.Attributable;




/**
 * Clase que implementa un termino
 * @author Joaquin Gayoso-Cabada
 *
 */
public class Term extends Attributable implements Serializable,IsSerializable{

	private static final long serialVersionUID = 407850953777136626L;
	
	protected String term;
	
	private Vocabulary vocabularyFather;
	
	/**
	 * Contructor por defecto de un termino
	 */
	public Term() {
		super();
	}
	
	/**
	 * Constructor por parametros de un termino
	 * @param name nombre de termino
	 */
	public Term(String name) {
		term=name;
	}

	/**
	 * @return the term
	 */
	public String getTerm() {
		return term;
	}

	/**
	 * @param term the term to set
	 */
	public void setTerm(String term) {
		this.term = term;
	}

	/**
	 * @return the vocabularyFather
	 */
	public Vocabulary getVocabularyFather() {
		return vocabularyFather;
	}

	/**
	 * @param vocabularyFather the vocabularyFather to set
	 */
	public void setVocabularyFather(Vocabulary vocabularyFather) {
		this.vocabularyFather = vocabularyFather;
	}
	
	
	
}
