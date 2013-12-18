package fdi.ucm.server;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;



import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import fdi.ucm.client.service.Oda3Service;
import fdi.ucm.shared.model.collection.Collection;
import fdi.ucm.shared.model.exceptions.Oda3RuntimeException;
import fdi.ucm.shared.model.userserver.CollectionAndFilePath;
import fdi.ucm.shared.model.userserver.CollectionPropias;


/**
 * Clase que implementa los servicios para el JPA de Oda3
 * @author Joaquin Gayoso-Cabada
 *
 */
public class Oda3ServiceImp extends RemoteServiceServlet implements Oda3Service{
	
	private static final long serialVersionUID = 1L;
	private static final String PERSISTENCE_UNIT_NAME = "ModelEditor2013JPA";
	private static EntityManagerFactory factory;
	  


	    
		




	@Override
	public CollectionAndFilePath LoadPublicCollection(String PublicName) {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	    EntityManager em = factory.createEntityManager();
	    
	    TypedQuery<CollectionPropias> query =
	    	      em.createQuery("SELECT c FROM CollectionPropias c WHERE c.Publicname='"+PublicName+"' AND c.Publica='"+true+"'" , CollectionPropias.class);
	    	  List<CollectionPropias> results = query.getResultList();
	    	  
	    	if (!results.isEmpty())  
	    		{
	    		Collection SalidaC=LoadCollection(results.get(0));
	    		String descString=results.get(0).getDescription();
	    		return new CollectionAndFilePath(SalidaC, descString);
	    		}
	
	    em.close();
		return new CollectionAndFilePath();
	}
    

	
	private Collection LoadCollection(CollectionPropias collecionCarga) {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		try {		
			CollectionPropias collecionSalida = em.find(CollectionPropias.class, collecionCarga.getId());
			em.close();
			return LoadCollection(collecionSalida.getSavePath());
		} catch (Exception e) {
			em.close();
			if (e instanceof NullPointerException)
			{
				Oda3RuntimeException C=new Oda3RuntimeException();
				C.setGENERIC_ERROR("La colecccion :" +collecionCarga.getId()+" no existe");
				throw C;
			}
			else 
			{	
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}

	/**
	 * Carga la coleccion desde un path
	 * @param path
	 * @return
	 * @throws Exception 
	 */
	private Collection LoadCollection(String path) throws Exception {
		 try {
	            ObjectInputStream file = new ObjectInputStream(new FileInputStream( path ));
	            Collection clase = (Collection) file.readObject();
	            file.close();
	          return clase;
	          
	        } catch (Exception e)
	        {
	        	throw e;
	        }
	}
}
