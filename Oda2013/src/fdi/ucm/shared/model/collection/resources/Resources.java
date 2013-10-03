package fdi.ucm.shared.model.collection.resources;

import fdi.ucm.shared.model.collection.Attributable;
import fdi.ucm.shared.model.collection.Collection;




/**
 * Clase base que define un valor dentro de la estructura de archivos.
 * @author Joaquin Gayoso-Cabada
 *
 */
public abstract class Resources extends Attributable{

	private static final long serialVersionUID = 1L;

	private Collection collectionFather;
	
	private Resources Icon;
	
	/**
	 * Constructor por defecto. 
	 */
	public Resources() {
		super();
	}

	/**
	 * @return the collectionFather
	 */
	public Collection getCollectionFather() {
		return collectionFather;
	}

	/**
	 * @param collectionFather the collectionFather to set
	 */
	public void setCollectionFather(Collection collectionFather) {
		this.collectionFather = collectionFather;
	}

	/**
	 * @return the icon
	 */
	public Resources getIcon() {
		return Icon;
	}

	/**
	 * @param icon the icon to set
	 */
	public void setIcon(Resources icon) {
		Icon = icon;
	}
	
	
	
}
