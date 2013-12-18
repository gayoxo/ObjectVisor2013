/**
 * 
 */
package fdi.ucm.shared.model.collection.document;

import javax.persistence.Column;

import fdi.ucm.shared.model.collection.grammar.TextElementType;


/**
 * Clase que genera la implementacion de un valor de tipo texto para un Meta
 * @author Joaquin Gayoso-Cabada
 *
 */
public class TextElement extends Element {


	private static final long serialVersionUID = 1L;
	@Column(columnDefinition = "LONGTEXT")
	protected String TValue;
	
	/**
	 * Constructor por defecto
	 */
	public TextElement() {
		super();
		TValue=null;
	}

	/**
	 * Constructor por parametrps de la clase
	 * @param hastype clase padre
	 */
	public TextElement(TextElementType hastype) {
		super(hastype);
		TValue=null;
	}

	/**
	 * Constructor por parametrps de la clase.
	 * @param hastype clase padre.
	 * @param Value valor del Texto.
	 */
	public TextElement(TextElementType hastype, String Valuein) {
		super(hastype);
		TValue=Valuein;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return TValue;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		TValue = value;
	}
	
	
}
