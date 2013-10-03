/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fdi.ucm.client.service;


import com.google.gwt.user.client.rpc.AsyncCallback;

import fdi.ucm.shared.model.collection.Collection;
import fdi.ucm.shared.model.exceptions.Oda3RuntimeException;
import fdi.ucm.shared.model.userserver.CollectionAndFilePath;
import fdi.ucm.shared.model.userserver.CollectionPropias;
import fdi.ucm.shared.model.userserver.UserAndCollection;
import fdi.ucm.shared.model.userserver.UserServer;


/**
 * Clase que define las funciones asincronas
 * @author Joaquin Gayoso-Cabada
 *
 */
public interface Oda3ServiceAsync {



	/**
	 *  Borra todos los usuarios y en consecuencia la base de datos
	 * @param callback
	 */
	void CleanDB(AsyncCallback<Void> callback);
	
	/**
	 *  Salva un catalogo si este ya existe o lo añade al usuario si no existia
	 * @param collectionen
	 * @param callback
	 * @param userin
	 * @throws Oda3RuntimeException
	 */
	void SaveCollection(Collection collectionen,String FilePath,UserServer userin,
			AsyncCallback<UserAndCollection> callback) throws Oda3RuntimeException;

	/**
	 * Salva un usuario, no se salvan sus catalogos asociados, mantendra los que tenia o si no tenia salvara con lista vacia
	 * @param userin
	 * @param callback
	 * @throws Oda3RuntimeException
	 */
	void SaveUser(UserServer userin, AsyncCallback<UserServer> callback) throws Oda3RuntimeException;

	
/**
 * Borrar Coleccion, igual a RemoveCollectionToUser(UserServer, Collection)
 * @param collectionentrada
 * @param usuario
 * @param callback
 */
	void DeleteCollection(Collection collectionentrada,UserServer usuario,
			AsyncCallback<UserServer> callback);
/**
 * Borra un usuario y como consecuencia todas sus colecciones
 * @param userin
 * @param callback
 */
	void DeleteUser(UserServer userin, AsyncCallback<Void> callback);

	
	/**
	 *  Carga un usuario en base al email y la contraseña
	 * @param User
	 * @param Password
	 * @param callback
	 */
	void LoadUserByUserByPassword(String User, String Password,
			AsyncCallback<UserServer> callback);
	
	/**
	 * Carga un usuario en funcion de su identificador
	 * @param id
	 * @param callback
	 */
	void LoadUserById(Long id, AsyncCallback<UserServer> callback);

	
	

	/**
	 * Carga una coleccion dado la coleccion minima
	 * @param collecionCarga
	 * @param callback
	 */
void LoadCollection(CollectionPropias collecionCarga,
		AsyncCallback<Collection> callback);


	/**
	 * Funcion que devuelve si el nombre es seleccionable o no
	 * @param collecionCarga
	 * @param Si el nombre esta libre.
	 */
	void CheckNameAvariable(String collecionaPublicar,
			AsyncCallback<Boolean> callback);

	/**
	 * 
	 * Publica una coleccion.
	 * @param User
	 * @param Description
	 * @param PublicName
	 * @param callback el usuario actualizado
	 */
	void PublishCollection(UserServer User, Collection NewCollection,
			String Description, String PublicName,
			AsyncCallback<UserServer> callback);

	/**
	  * Despublica una coleccion.
	 * @param User
	 * @param NewCollection
	 * @param callback  el usuario actualizado
	 */
	void UnPublishCollection(UserServer User, Collection NewCollection,
			AsyncCallback<UserServer> callback);

	
	/**
	 * Carga una coleccion publica desde su nombre publico
	 * @param PublicName
	 * @param coleccio y Path de la coleccion
	 */
	void LoadPublicCollection(String PublicName,
			AsyncCallback<CollectionAndFilePath> callback);


	



	

	


}
