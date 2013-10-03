/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fdi.ucm.client.service;





import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import fdi.ucm.shared.model.collection.Collection;
import fdi.ucm.shared.model.exceptions.Oda3RuntimeException;
import fdi.ucm.shared.model.userserver.CollectionAndFilePath;
import fdi.ucm.shared.model.userserver.CollectionPropias;
import fdi.ucm.shared.model.userserver.UserAndCollection;
import fdi.ucm.shared.model.userserver.UserServer;


/**
 * Clase que define las funciones asincronas al servidor
 * @author Joaquin Gayoso-Cabada
 *
 */
@RemoteServiceRelativePath("service/oda3")
public interface Oda3Service extends RemoteService {

	/**
	 * Borra todos los usuarios y en consecuencia la base de datos
	 */
	void CleanDB();
	
	
	/**
	 * Salva un usuario, no se salvan sus catalogos asociados, mantendra los que tenia o si no tenia salvara con lista vacia
	 * @param userin usuario a salvar
	 * @return Nuevo usuario o Actuializado
	 * @throws Oda3RuntimeException excepciones de duplicidad y errores varios.
	 */
	UserServer SaveUser(UserServer userin) throws Oda3RuntimeException;

	/**
	 * 
	 * * Salva un catalogo si este ya existe o lo añade al usuario si no existia
	 * @param collectionentrada Catalogo a añadir
	 * @param userin usuario de salvado
	 * @return El catalogo nuevo o actualizado
	 * @throws Oda3RuntimeException  excepciones de duplicidad y errores varios.
	 */
	UserAndCollection SaveCollection(Collection collectionentrada,String FilePath,UserServer userin) throws Oda3RuntimeException;

	
	
	/**
	 * Borrar Coleccion, igual a RemoveCollectionToUser(UserServer, Collection)
	 * @param collectionentrada
	 * @param usuario
	 * @return Usuario con la coleccion borrada
	 */
	UserServer DeleteCollection(Collection collectionentrada,UserServer usuario);
	
	/**
	 * Borra un usuario y como consecuencia todas sus colecciones
	 * @param userin
	 */
	void DeleteUser(UserServer userin);
	
	
	/**
	 * Carga un usuario en base al email y la contraseña
	 * @param User
	 * @param Password
	 * @return the user
	 */
	UserServer LoadUserByUserByPassword(String User,String Password);
	
	/**
	 * Carga un usuario en funcion de su identificador
	 * @param id 
	 * @return the user
	 */
	UserServer LoadUserById(Long id);
	


	
	

	/**
	 * Carga una coleccion dado la coleccion minima
	 * @param collecionCarga
	 * @return la Coleccion.
	 */
	Collection LoadCollection(CollectionPropias collecionCarga);
	
	/**
	 * Funcion que devuelve si el nombre es seleccionable o no
	 * @param collecionaPublicar
	 * @return Si el nombre esta libre.
	 */
	Boolean CheckNameAvariable(String collecionaPublicar);

	/**
	 * Publica una coleccion.
	 * @param User
	 * @param Description
	 * @param PublicName
	 * @return Devuelve el usuario con los nuevos datos
	 */
	UserServer PublishCollection(UserServer User,Collection NewCollection,String Description,String PublicName);
	
	/**
	 * Despublica una coleccion.
	 * @param User
	 * @param NewCollection
	 * @return  Devuelve el usuario con los nuevos datos
	 */
	UserServer UnPublishCollection(UserServer User,Collection NewCollection);
	
	
	/**
	 * Carga una coleccion publica desde su nombre publico
	 * @param PublicName
	 * @return coleccio y Path de la coleccion
	 */
	CollectionAndFilePath LoadPublicCollection(String PublicName);
}
