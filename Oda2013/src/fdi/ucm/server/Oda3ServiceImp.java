package fdi.ucm.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;



import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import fdi.ucm.client.service.Oda3Service;
import fdi.ucm.shared.model.collection.Attributable;
import fdi.ucm.shared.model.collection.Collection;
import fdi.ucm.shared.model.collection.CollectionAttribute;
import fdi.ucm.shared.model.collection.meta.MetaControlled;
import fdi.ucm.shared.model.collection.meta.controlled.Vocabulary;
import fdi.ucm.shared.model.exceptions.Oda3RuntimeException;
import fdi.ucm.shared.model.userserver.CollectionAndFilePath;
import fdi.ucm.shared.model.userserver.CollectionPropias;
import fdi.ucm.shared.model.userserver.UserAndCollection;
import fdi.ucm.shared.model.userserver.UserServer;


/**
 * Clase que implementa los servicios para el JPA de Oda3
 * @author Joaquin Gayoso-Cabada
 *
 */
public class Oda3ServiceImp extends RemoteServiceServlet implements Oda3Service{
	
	private static final long serialVersionUID = 1L;
	private static final String PERSISTENCE_UNIT_NAME = "ModelEditor2013JPA";
	private static final String USUARIODUPLICADO = "Duplicate user for registry, choose another name or log in for this user";
	private static final String CATALOGODUPLICADO = "The user had one collection with the same name previously, set another name for collection and try again";
	private static final String EMAILDUPLICADO = "Duplicate email for registry, choose another email or log in with the user associated to the email";
	private static EntityManagerFactory factory;
	  
	private static final String DATA_DIRECTORY = "ME2013";
	private static final String BACK = ".bak";
    private static final String DATA_DIRECTORY2="Files";
//	private static final int MAX_MEMORY_SIZE = 10240 * 1024 * 2;
//	private static final int MAX_REQUEST_SIZE = 10240 * 1024;
	
    
    @Override
	public void CleanDB() {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	    EntityManager em = factory.createEntityManager();
	    try {
	    	em.getTransaction().begin();
		    
		    TypedQuery<UserServer> query =
		    	      em.createQuery("SELECT c FROM UserServer c", UserServer.class);
		    	  List<UserServer> results = query.getResultList();
		    	  
		    	for (UserServer userServer : results) {
		    		em.remove(userServer);
				}  
		    	
		    em.getTransaction().commit();
		    em.close();
		} catch (Exception e) {
			em.getTransaction().rollback();
			em.close();
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	    
		
	
	
	
	}

	@Override
	public UserAndCollection SaveCollection(Collection collectionentrada,String FilePath, UserServer userin) throws Oda3RuntimeException{
		if (collectionentrada.getId()!=null)
		{
			
			collectionentrada=StabilizeCollectionAndCleanids(collectionentrada);
			factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
			EntityManager em = factory.createEntityManager();
			
			
			try{
			CollectionPropias coleccionSalida = em.find(CollectionPropias.class, collectionentrada.getId());
			UserServer UserSalida=em.find(UserServer.class, userin.getId());
			em.close();
			if (!UserSalida.getColecciones().contains(coleccionSalida))
				return AddCollectionToUser(UserSalida,FilePath, collectionentrada);
			else 
				{
					
				try {
					backupCollection(coleccionSalida.getSavePath());
					saveCollection(collectionentrada,coleccionSalida.getSavePath());
					deleteBackupCollection(coleccionSalida.getSavePath());
					return new UserAndCollection(UserSalida, collectionentrada);
				} catch (Exception e) {
					restoreBackCollection(coleccionSalida.getSavePath());
					throw e;
				}
				
				
				
				}
			 
			
			} catch (Exception e) {
				em.getTransaction().rollback();
				em.close();
				e.printStackTrace();
				throw new RuntimeException(e);
			}
			
			
		}
		else{
			return AddCollectionToUser(userin,FilePath, collectionentrada);
		}
	}



	

	@Override
	public UserServer SaveUser(UserServer userin) throws Oda3RuntimeException{
	
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		if (userin.getId()!=null)
			{
			UserServer UserServerSalida = em.find(UserServer.class, userin.getId());
			userin.setColecciones(UserServerSalida.getColecciones());
			if (!userin.getUser().equals(UserServerSalida.getUser()))
				if (UsuarioRepetido_(userin.getUser(),em))
					{
					Oda3RuntimeException E = new Oda3RuntimeException();
					E.setGENERIC_ERROR(USUARIODUPLICADO);
					throw E;
					}
			if (!userin.getEmail().equals(UserServerSalida.getEmail()))
				if (emailRepetido_(userin.getEmail(),em))
					{
					Oda3RuntimeException E = new Oda3RuntimeException();
					E.setGENERIC_ERROR(EMAILDUPLICADO);
					throw E;
					}

			}
		else 
			{
			userin.setColecciones(new ArrayList<CollectionPropias>());
				if (UsuarioRepetido_(userin.getUser(),em))
					{
					Oda3RuntimeException E = new Oda3RuntimeException();
					E.setGENERIC_ERROR(USUARIODUPLICADO);
					throw E;
					}
				if (emailRepetido_(userin.getEmail(),em))
					{
					Oda3RuntimeException E = new Oda3RuntimeException();
					E.setGENERIC_ERROR(EMAILDUPLICADO);
					throw E;
					}
			
			}
		
		em.close();		
		
		try {
			UserServer Salida=(UserServer) PersistObject(userin);
			return Salida;
			
		} catch (Exception e) {
//			
//			if (e.getCause()!=null
//					&&e.getCause().getCause()!=null
//					&&e.getCause().getCause() instanceof MySQLIntegrityConstraintViolationException
//					&&((MySQLIntegrityConstraintViolationException)e.getCause().getCause()).getErrorCode()==1062)
//				{
//				Oda3RuntimeException E = new Oda3RuntimeException();
//				E.setGENERIC_ERROR(USUARIODUPLICADO);
//				throw E;
//				}
//			else
			em.getTransaction().rollback();
			em.close();
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		
		
	}

	
	
	
	
	
	

	@Override
	public UserServer DeleteCollection(Collection collectionentrada,UserServer usuario) {

		return RemoveCollectionToUser(usuario, collectionentrada);
		
	}
	


	@Override
	public void DeleteUser(UserServer userin) {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		
		try {
			UserServer UsuarioABorrar = em.find(UserServer.class, userin.getId());
			 
			em.getTransaction().begin();
			
			em.remove(UsuarioABorrar);
			
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		
	}


	
	
	
	

	@Override
	public UserServer LoadUserByUserByPassword(String User, String Password) {
		UserServer Salida=null;
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	    EntityManager em = factory.createEntityManager();
	    em.getTransaction().begin();
	    
	    TypedQuery<UserServer> query =
	    	      em.createQuery("SELECT c FROM UserServer c WHERE c.User='"+User+"' AND c.Password='"+Password+"'", UserServer.class);
	    	  List<UserServer> results = query.getResultList();
	    	  
	    	if (!results.isEmpty())  
	    		{
	    		Salida=results.get(0);
	    		}
	    	
	    em.close();
		return Salida;
	}


	
	
	@Override
	public UserServer LoadUserById(Long id) {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		try {		
			UserServer UserServerSalida = em.find(UserServer.class, id);
			em.close();
			return UserServerSalida;
		} catch (Exception e) {
			em.close();
			if (e instanceof NullPointerException)
			{
				Oda3RuntimeException C=new Oda3RuntimeException();
				C.setGENERIC_ERROR("Usuario "+ id+ " intento logearse y produjo error");
				throw C;
			}
			else 
			{	
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		
	}
	
	


	@Override
	public Collection LoadCollection(CollectionPropias collecionCarga) {
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

	
	
	
	
	
	

	





	@Override
	public Boolean CheckNameAvariable(String collecionaPublicar) {
		Boolean Salida=false;
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	    EntityManager em = factory.createEntityManager();
	    em.getTransaction().begin();
	    
	    TypedQuery<CollectionPropias> query =
	    	      em.createQuery("SELECT c FROM CollectionPropias c WHERE c.Publicname='"+collecionaPublicar+"'" , CollectionPropias.class);
	    	  List<CollectionPropias> results = query.getResultList();
	    	  
	    	if (!results.isEmpty())  
	    		{
	    		Salida=false;
	    		}
	    	else Salida=true;
	    	
	    em.close();
		return Salida;
	}

	@Override
	public UserServer PublishCollection(UserServer User,
			Collection NewCollection, String Description, String PublicName) {

		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		try {
			CollectionPropias coleccionSalida = em.find(
					CollectionPropias.class, NewCollection.getId());
			UserServer UserSalida = em.find(UserServer.class, User.getId());
			coleccionSalida.setDescription(Description);
			coleccionSalida.setPublicname(PublicName);
			coleccionSalida.setPublica(true);
			em.persist(coleccionSalida);
			em.getTransaction().commit();
			em.close();
			return UserSalida;

		} catch (Exception e) {
			em.getTransaction().rollback();
			em.close();
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public UserServer UnPublishCollection(UserServer User,
			Collection NewCollection) {
		
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		try {
			CollectionPropias coleccionSalida = em.find(
					CollectionPropias.class, NewCollection.getId());
			UserServer UserSalida = em.find(UserServer.class, User.getId());
			coleccionSalida.setPublicname(null);
			coleccionSalida.setPublica(false);
			em.persist(coleccionSalida);
			em.getTransaction().commit();
			em.close();
			return UserSalida;

		} catch (Exception e) {
			em.getTransaction().rollback();
			em.close();
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public CollectionAndFilePath LoadPublicCollection(String PublicName) {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	    EntityManager em = factory.createEntityManager();
//	    em.getTransaction().begin();
	    
	    TypedQuery<CollectionPropias> query =
	    	      em.createQuery("SELECT c FROM CollectionPropias c WHERE c.Publicname='"+PublicName+"' AND c.Publica='"+true+"'" , CollectionPropias.class);
	    	  List<CollectionPropias> results = query.getResultList();
	    	  
	    	if (!results.isEmpty())  
	    		{
	    		Collection SalidaC=LoadCollection(results.get(0));
	    		String filePath=results.get(0).getFilePath();
	    		String descString=results.get(0).getDescription();
	    		return new CollectionAndFilePath(SalidaC, filePath,descString);
	    		}
	
	    em.close();
		return new CollectionAndFilePath();
	}
    

    
    
	  /**
	   * Funcion que persiste un objeto en JPA
	   * @param entrada elemento de entrada
	   * @return elemento persistido
	   */
	private Object PersistObject(Object entrada) {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		try {
			em.getTransaction().begin();
			Object salida = em.merge(entrada);


			em.getTransaction().commit();
			em.close();
			return salida;
		} catch (Exception e) {
			em.getTransaction().rollback();
			em.close();
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	
	/**
	 * Devuelve si el email esta repetido
	 * @param email
	 * @param em
	 * @return
	 */
	private boolean emailRepetido_(String email, EntityManager em) {
		
	    
	    TypedQuery<UserServer> query =
	    	      em.createQuery("SELECT c FROM UserServer c WHERE c.Email='"+email+"'", UserServer.class);
	    	  List<UserServer> results = query.getResultList();
	    	  
	    	if (results.size()>0)
	    		return true;
	    	else return false;
	}

	/**
	 * Devuelve si el usuario esta repetido
	 * @param user
	 * @param em
	 * @return
	 */
	private boolean UsuarioRepetido_(String user, EntityManager em) {
		 TypedQuery<UserServer> query =
	    	      em.createQuery("SELECT c FROM UserServer c WHERE c.User='"+user+"'", UserServer.class);
	    	  List<UserServer> results = query.getResultList();
	    	  
	    	  if (results.size()>0)
		    		return true;
		    	else return false;
	}
	
	/**
	 * Estabiliza una coleccion
	 * @param collectionentrada
	 * @param borrarIds
	 * @return
	 */
	private Collection StabilizeCollectionAndCleanids(Collection collectionentrada) {
		for (int i = 0; i < collectionentrada.getMetamodelSchemas().size(); i++) {
//			collectionentrada.getMetamodelSchemas().get(i).setPositionInFather(i);
			collectionentrada.getMetamodelSchemas().get(i).setCollectionFather(collectionentrada);
			StabilizeCollectionAndCleanids(collectionentrada.getMetamodelSchemas().get(i));
		}
		for (int i = 0; i < collectionentrada.getSectionValues().size(); i++) {
			collectionentrada.getSectionValues().get(i).setCollectionFather(collectionentrada);
			StabilizeCollectionAndCleanids(collectionentrada.getSectionValues().get(i));
		}
		return collectionentrada;
	}
	
	
	/**
	 * Estabiliza una coleccion
	 * @param resources
	 * @param borrarIds
	 */
	private void StabilizeCollectionAndCleanids(Attributable resources) {
			for (int i = 0; i < resources.getDescription().size(); i++) {
				resources.getDescription().get(i).setAttributableFather(resources);
//				StabilizeCollectionAndCleanids(resources.getDescription().get(i));
			}

		
	}

	/**
	  * Estabiliza una coleccion
	 * @param collectionAttribute
	 * @param borrarIds
	 */
	private void StabilizeCollectionAndCleanids(
			CollectionAttribute collectionAttribute) {
			for (int i = 0; i < collectionAttribute.getSons().size(); i++) {
				//collectionAttribute.getSons().get(i).setPositionInFather(i);
				collectionAttribute.getSons().get(i).setFather(collectionAttribute);
				StabilizeCollectionAndCleanids(collectionAttribute.getSons().get(i));
				if (collectionAttribute.getSons().get(i) instanceof MetaControlled)
					StabilizeCollectionAndCleanids(((MetaControlled)collectionAttribute.getSons().get(i)).getVocabulary());
			}
		
	}

	/**
	  * Estabiliza una coleccion
	 * @param vocabulary
	 * @param borrarIds
	 */
	private void StabilizeCollectionAndCleanids(Vocabulary vocabulary) {
			for (int i = 0; i < vocabulary.getList().size(); i++) {
				vocabulary.getList().get(i).setVocabularyFather(vocabulary);
				StabilizeCollectionAndCleanids(vocabulary.getList().get(i));
			}
		
	}
	
	
	
	/**
	 * Salva la coleccion en el sistema
	 * @param coleccionSalida
	 * @param path
	 * @throws IOException 
	 */
	private void saveCollection(Collection coleccionSalida, String path) throws IOException {
		
        
        ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream( path ));
        file.writeObject(coleccionSalida);
        file.close();
		
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

	
	/**
	 * Salva una coleccion 
	 * @param newCollection
	 * @return path de la coleccion
	 * @throws IOException 
	 */
	private String saveCollectionNueva(Collection newCollection) throws IOException {
		String[] route = getServletContext().getRealPath("").split(Pattern.quote(File.separator));
        StringBuffer uploadFolderSb = new StringBuffer(); 
        //uploadFolderSb.append(File.separator);
        for (int i = 0; i < route.length - 2; i++) {
			uploadFolderSb.append(route[i]);
			uploadFolderSb.append(File.separator);
		}
        
        uploadFolderSb.append("docroot");
        uploadFolderSb.append(File.separator + DATA_DIRECTORY);
        String uploadFolder = uploadFolderSb.toString();
        
        java.io.File directorio = new File(uploadFolder);
        directorio.mkdirs();
        
      //  String uploadFolderRel = "\\" + DATA_DIRECTORY;
        uploadFolder=uploadFolder+File.separator+newCollection.getId()+".dat";
     //   uploadFolderRel=uploadFolderRel+"\\"+newCollection.getId()+".dat";
        saveCollection(newCollection, uploadFolder);
		return uploadFolder;
	}
	
	/**
	 * Restaura la copia de seguridad del fichero
	 * @param path
	 * @throws IOException
	 */
	private void restoreBackCollection(String path) throws IOException {
		File actFile=new File(path+BACK);
		File newFile=new File(path);
		
		FileInputStream in = new FileInputStream(actFile);
		FileOutputStream out = new FileOutputStream(newFile);
		
		int c;
		while( (c = in.read() ) != -1)
			out.write(c);

		in.close();
		out.close();
		
	}

	/**
	 * Restaura la copia de seguridad del fichero
	 * @param path
	 * @throws IOException
	 */
	private void backupCollection(String path) throws IOException {
		File actFile=new File(path);
		File newFile=new File(path+BACK);
		
		FileInputStream in = new FileInputStream(actFile);
		FileOutputStream out = new FileOutputStream(newFile);
		
		int c;
		while( (c = in.read() ) != -1)
			out.write(c);

		in.close();
		out.close();
	}
	
	
	/**
	 * Borra el backup
	 * @param path
	 */
	private void deleteBackupCollection(String path) {
		File newFile=new File(path+BACK);
		newFile.delete();
		
	}
	
	
	/** 
     * Copia un directorio con todo y su contendido 
     * @param srcDir 
     * @param dstDir 
     * @throws IOException 
     */ 
    private void copyDirectory(File srcDir, File dstDir) throws IOException { 
        if (srcDir.isDirectory()) { 
            if (!dstDir.exists()) { 
                dstDir.mkdir(); 
            } 
             
            String[] children = srcDir.list(); 
            for (int i=0; i<children.length; i++) { 
                copyDirectory(new File(srcDir, children[i]), 
                    new File(dstDir, children[i])); 
            } 
        } else { 
            copy(srcDir, dstDir); 
        } 
    } 
    
    /** 
     * Copia un solo archivo 
     * @param src 
     * @param dst 
     * @throws IOException 
     */ 
    private void copy(File src, File dst) throws IOException { 
        InputStream in = new FileInputStream(src); 
        OutputStream out = new FileOutputStream(dst); 
         
         
        byte[] buf = new byte[1024]; 
        int len; 
        while ((len = in.read(buf)) > 0) { 
            out.write(buf, 0, len); 
        } 
        in.close(); 
        out.close(); 
    } 
	
    /**
     * Borra un directorio
     * @param directorio
     */
    private void borrarDirectorio (File directorio){
        
    	if (directorio.isDirectory())
    	{
        File[] ficheros = directorio.listFiles();
        
        for (int x=0;x<ficheros.length;x++){
                if (ficheros[x].isDirectory()) {
                        borrarDirectorio(ficheros[x]);
                }
                ficheros[x].delete();
        }               
        }
        	directorio.delete();
}
    
    
    /**
	 * Añade una coleccion a un usuario
	 * @param User
	 * @param NewCollection
	 * @return la nuevo coleccion o la actualizacion
	 * @throws Oda3RuntimeException
	 */
	private UserAndCollection AddCollectionToUser(UserServer User,String FilePath, Collection NewCollection) throws Oda3RuntimeException {
		
			
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		
		 String[] route = getServletContext().getRealPath("").split(Pattern.quote(File.separator));
	        StringBuffer uploadFolderSb = new StringBuffer(); 
	        //uploadFolderSb.append(File.separator);
	        for (int i = 0; i < route.length - 2; i++) {
				uploadFolderSb.append(route[i]);
				uploadFolderSb.append(File.separator);
			}
	        
	        uploadFolderSb.append("docroot");
	        uploadFolderSb.append(File.separator + DATA_DIRECTORY+File.separator+DATA_DIRECTORY2);
	        
	       
		try {
		UserServer UserAAmpliar = em.find(UserServer.class, User.getId());
		
		NewCollection=StabilizeCollectionAndCleanids(NewCollection);
		
		NewCollection.setId(null);
		
		CollectionPropias CP=new CollectionPropias(NewCollection.getName(),"",FilePath);
		
		UserAAmpliar.getColecciones().add(CP);
	
		
		em.persist(UserAAmpliar);

		em.flush();
		
		em.refresh(UserAAmpliar);
		
		NewCollection.setId(CP.getId());
		
		String Path =saveCollectionNueva(NewCollection);
		
			String FilePathNew = "FC"+CP.getId();
		 File OldFile=new File(uploadFolderSb.toString()+File.separator+FilePath);
		 File NewFile=new File(uploadFolderSb.toString()+File.separator+FilePathNew);
	        
	        
	     copyDirectory(OldFile,NewFile);
	     borrarDirectorio(OldFile);
		
		CP.setSavePath(Path);
		CP.setFilePath(FilePathNew);
		
		em.merge(CP);
		
		em.getTransaction().commit();
		em.close();

		NewCollection.setId(CP.getId());
		return new UserAndCollection(UserAAmpliar,NewCollection);
		
		
		} catch (Exception e) {
			if (e.getCause()!=null
					&&e.getCause().getCause()!=null
					&&e.getCause().getCause() instanceof MySQLIntegrityConstraintViolationException
					&&((MySQLIntegrityConstraintViolationException)e.getCause().getCause()).getErrorCode()==1062)
				{	
				
				em.getTransaction().rollback();
				Oda3RuntimeException E = new Oda3RuntimeException();
				E.setGENERIC_ERROR(CATALOGODUPLICADO);
				throw E;
				}
			else {
				em.getTransaction().rollback();
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		
	}

	/**
	 * Borra un coleccion de la lista del usuario.
	 * @param User
	 * @param NewCollection
	 * @return Usuario con la coleccion borrada
	 */
	private UserServer RemoveCollectionToUser(UserServer User, Collection NewCollection) {

			factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			UserServer UserAReducir = em.find(UserServer.class, User.getId());
			CollectionPropias ColeccionABorrar= em.find(CollectionPropias.class, NewCollection.getId());
			
			UserAReducir.getColecciones().remove(ColeccionABorrar);
			
			
			em.persist(UserAReducir);


			em.getTransaction().commit();
			em.close();
			return UserAReducir;
		
		
	}
	
	
}
