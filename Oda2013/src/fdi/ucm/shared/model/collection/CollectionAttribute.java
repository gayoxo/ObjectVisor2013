/**
 * 
 */
package fdi.ucm.shared.model.collection;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * Crea el objeto base que define un coleccion attribute
 * @author Joaquin Gayoso-Cabada
 *
 */
public abstract class CollectionAttribute implements Serializable,IsSerializable{
	

	
	private Collection collectionFather;
	
	private static final long serialVersionUID = 1L;
	
	protected List<CollectionAttribute> Sons=new ArrayList<CollectionAttribute>();
	
	protected CollectionAttribute Father;
//	private int PositionInFather=0;
	

	/**
	 * Consctructor por defecto
	 */
	public CollectionAttribute() {
		Sons=new ArrayList<CollectionAttribute>();	
		Father=null;
	//	PositionInFather=0;
	}
	
	
	/**
	 * Constructor con parametros
	 * @param father padre del objeto
	 */
	public CollectionAttribute(CollectionAttribute father) {
		super();
		Father = father;
		Sons=new ArrayList<CollectionAttribute>();	
	}




	/**
	 *  Retorna el Texto que representa al path.
	 *  @return Texto cadena para el elemento
	 */
	public String pathFather()
	{
		if (Father!=null)
			return Father.pathFather()+"/";
		else return "";
	}
	
	/**
	 * @return the father
	 */
	public CollectionAttribute getFather() {
		return Father;
	}



	/**
	 * @param father the father to set
	 */
	public void setFather(CollectionAttribute father) {
		Father = father;
	}



	/**
	 * @return the sons
	 */
	public List<CollectionAttribute> getSons() {
		return Sons;
	}

	/**
	 * @param sons the sons to set
	 */
	public void setSons(List<CollectionAttribute> sons) {
		Sons = sons;
	}



//	/**
//	 * @return the positionInFather
//	 */
//	public int getPositionInFather() {
//		return PositionInFather;
//	}
//
//
//	/**
//	 * @param positionInFather the positionInFather to set
//	 */
//	public void setPositionInFather(int positionInFather) {
//		PositionInFather = positionInFather;
//	}
//	


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

	
	
	
}
