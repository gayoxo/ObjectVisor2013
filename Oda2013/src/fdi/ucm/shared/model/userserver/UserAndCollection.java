/**
 * 
 */
package fdi.ucm.shared.model.userserver;

import java.io.Serializable;

import com.google.gwt.user.client.rpc.IsSerializable;

import fdi.ucm.shared.model.collection.Collection;


/**
 * Usuario y coleccion utilizados para transicionar al actualizar ambos en la addicion de elementos a un usuario.
 * @author Joaquin Gayoso-Cabada
 *
 */
public class UserAndCollection implements Serializable,IsSerializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 312496879771167275L;
	private UserServer Usuario;
	private Collection Coleccion;
	
	
	public UserAndCollection() {
		Usuario=null;
		Coleccion=null;
	}
	
	/**
	 * @param usuario
	 * @param coleccion
	 */
	public UserAndCollection(UserServer usuario, Collection coleccion) {
		super();
		Usuario = usuario;
		Coleccion = coleccion;
	}
	/**
	 * @return the usuario
	 */
	public UserServer getUsuario() {
		return Usuario;
	}
	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(UserServer usuario) {
		Usuario = usuario;
	}
	/**
	 * @return the coleccion
	 */
	public Collection getColeccion() {
		return Coleccion;
	}
	/**
	 * @param coleccion the coleccion to set
	 */
	public void setColeccion(Collection coleccion) {
		Coleccion = coleccion;
	}
	
	
	
}
