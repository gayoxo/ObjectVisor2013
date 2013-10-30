/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fdi.ucm.client.service;


import com.google.gwt.user.client.rpc.AsyncCallback;

import fdi.ucm.shared.model.userserver.CollectionAndFilePath;


/**
 * Clase que define las funciones asincronas
 * @author Joaquin Gayoso-Cabada
 *
 */
public interface Oda3ServiceAsync {



	/**
	 * Carga una coleccion publica desde su nombre publico
	 * @param PublicName
	 * @param coleccio y Path de la coleccion
	 */
	void LoadPublicCollection(String PublicName,
			AsyncCallback<CollectionAndFilePath> callback);


	



	

	


}
