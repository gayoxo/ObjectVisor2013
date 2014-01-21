package fdi.ucm.shared.model.collection.document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.rpc.IsSerializable;

import fdi.ucm.shared.model.collection.Collection;
import fdi.ucm.shared.model.collection.grammar.Grammar;

/**
 * Clase que diseña las construciones basicas .
 * @author Joaquin Gayoso-Cabada
 *
 */
public class Documents implements Serializable,IsSerializable{

	private static final long serialVersionUID = 1L;
	private Collection collectionFather;
	private Grammar Grammar;
	protected List<Element> Description;
	private ArrayList<OperationalValue> ViewsValues;
	private String DescriptionText;
	private String Icon;


	/**
	 * Constructior por defecto
	 */
	public Documents() {
		super();
		Description=new ArrayList<Element>();
		setViewsValues(new ArrayList<OperationalValue>());
		DescriptionText="";
		Icon ="";
	}



	/**
	 * @param document
	 */
	public Documents(Grammar document) {
		Grammar = document;
		Description=new ArrayList<Element>();
		setViewsValues(new ArrayList<OperationalValue>());
		DescriptionText="";
		Icon ="";
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
	public Grammar getDocument() {
		return Grammar;
	}



	/**
	 * @param document the document to set
	 */
	public void setDocument(Grammar document) {
		Grammar = document;
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



	/**
	 * @return the viewsValues
	 */
	public ArrayList<OperationalValue> getViewsValues() {
		return ViewsValues;
	}



	/**
	 * @param viewsValues the viewsValues to set
	 */
	public void setViewsValues(ArrayList<OperationalValue> viewsValues) {
		ViewsValues = viewsValues;
	}



	/**
	 * @return the descriptionText
	 */
	public String getDescriptionText() {
		return DescriptionText;
	}



	/**
	 * @param descriptionText the descriptionText to set
	 */
	public void setDescriptionText(String descriptionText) {
		DescriptionText = descriptionText;
	}



	/**
	 * @return the icon
	 */
	public String getIcon() {
		return Icon;
	}



	/**
	 * @param icon the icon to set
	 */
	public void setIcon(String icon) {
		Icon = icon;
	}
	
}
