/**
 * 
 */
package fdi.ucm.shared.model.collection.grammar;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.rpc.IsSerializable;

import fdi.ucm.shared.model.collection.Collection;

/**
 * Crea el objeto base que define un coleccion attribute
 * @author Joaquin Gayoso-Cabada
 *
 */
public abstract class Structure implements Serializable,IsSerializable{
	

	
	private Collection collectionFather;
	
	private static final long serialVersionUID = 1L;
	
	protected List<Structure> Sons=new ArrayList<Structure>();
	
	protected Structure Father;
//	private int PositionInFather=0;
	

	/**
	 * Consctructor por defecto
	 */
	public Structure() {
		Sons=new ArrayList<Structure>();	
		Father=null;
	//	PositionInFather=0;
	}
	
	
	/**
	 * Constructor con parametros
	 * @param father padre del objeto
	 */
	public Structure(Structure father) {
		super();
		Father = father;
		Sons=new ArrayList<Structure>();	
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
	public Structure getFather() {
		return Father;
	}



	/**
	 * @param father the father to set
	 */
	public void setFather(Structure father) {
		Father = father;
	}



	/**
	 * @return the sons
	 */
	public List<Structure> getSons() {
		return Sons;
	}

	/**
	 * @param sons the sons to set
	 */
	public void setSons(List<Structure> sons) {
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
