package fdi.ucm.shared.model.collection.document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.rpc.IsSerializable;

import fdi.ucm.shared.model.collection.Collection;
import fdi.ucm.shared.model.collection.grammar.ElementType;

/**
 * Clase que diseña las construciones basicas .
 * @author Joaquin Gayoso-Cabada
 *
 */
public class Documents implements Serializable,IsSerializable{

	private static final long serialVersionUID = 1L;
	private Collection collectionFather;
	private ElementType Document;
	protected List<Element> Description;


	/**
	 * Constructior por defecto
	 */
	public Documents() {
		super();
		Description=new ArrayList<Element>();
	}



	/**
	 * @param document
	 */
	public Documents(ElementType document) {
		Document = document;
		Description=new ArrayList<Element>();
	}



	public Collection getCollectionFather() {
		return collectionFather;
	}



	public void setCollectionFather(Collection collectionFather) {
		this.collectionFather=collectionFather;
		
	}



	/**
	 * @return the document
	 */
	public ElementType getDocument() {
		return Document;
	}



	/**
	 * @param document the document to set
	 */
	public void setDocument(ElementType document) {
		Document = document;
	}

	/**
	 * @return the description
	 */
	public List<Element> getDescription() {
		return Description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(ArrayList<Element> description) {
		Description = description;
	}
	
}
