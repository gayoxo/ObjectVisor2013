/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fdi.ucm.client.service;





import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import fdi.ucm.shared.model.userserver.CollectionAndFilePath;


/**
 * Clase que define las funciones asincronas al servidor
 * @author Joaquin Gayoso-Cabada
 *
 */
@RemoteServiceRelativePath("service/oda3")
public interface Oda3Service extends RemoteService {

	
	/**
	 * Carga una coleccion publica desde su nombre publico
	 * @param PublicName
	 * @return coleccio y Path de la coleccion
	 */
	CollectionAndFilePath LoadPublicCollection(String PublicName);
}
