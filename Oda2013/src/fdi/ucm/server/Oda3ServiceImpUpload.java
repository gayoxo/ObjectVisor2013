package fdi.ucm.server;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import fdi.ucm.server.utils.ZipUtils;
import fdi.ucm.shared.model.SharedConstants;

/**
 * Clase que implementa la subida de archivos alservidor dado un path que esta dentro de los parametros
 * @author Joaquin Gayoso-Cabada
 *
 */
public class Oda3ServiceImpUpload extends javax.servlet.http.HttpServlet implements
     javax.servlet.Servlet{
@Resource
	private static final long serialVersionUID = 2756014988983226250L;
    private static final String DATA_DIRECTORY1 = "ME2013";
    private static final String DATA_DIRECTORY2="Files";
    private static final int MAX_MEMORY_SIZE = 1024 * 1024 * 1024;
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 512;
    
	protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
    	
        // Check that we have a file upload request
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
 
        if (!isMultipart) {
            return;
        }
 
        // Create a factory for disk-based file items
        DiskFileItemFactory factory = new DiskFileItemFactory();
 
        // Sets the size threshold beyond which files are written directly to disk.
        factory.setSizeThreshold(MAX_MEMORY_SIZE);
 
        // Sets the directory used to temporarily store files that are larger
        // than the configured size threshold. We use temporary directory for java
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
        
        // constructs the folder where uploaded file will be stored
        String[] route = getServletContext().getRealPath("").split(Pattern.quote(File.separator));
        StringBuffer uploadFolderSb = new StringBuffer(); 
        //uploadFolderSb.append(File.separator);
        for (int i = 0; i < route.length - 2; i++) {
			uploadFolderSb.append(route[i]);
			uploadFolderSb.append(File.separator);
		}
        
        uploadFolderSb.append("docroot");
        uploadFolderSb.append(File.separator + DATA_DIRECTORY1+File.separator+DATA_DIRECTORY2);
        
 
        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);
 
        // Set overall request size constraint
        upload.setSizeMax(MAX_REQUEST_SIZE);

        try {
        	@SuppressWarnings("rawtypes")
			List items = upload.parseRequest(request);
            @SuppressWarnings("rawtypes")
			Iterator iter = items.iterator();
            List<FileItem> ListaFiles=new ArrayList<FileItem>();
            while (iter.hasNext()) {
                FileItem item = (FileItem) iter.next();
 
                if (!item.isFormField()) {
                	ListaFiles.add(item);
                    
                }
                else if(item.getFieldName().equals(SharedConstants.KeyFolderNumber))
                	uploadFolderSb.append(File.separator + item.getString());	
   
                }
            
            String uploadFolder = uploadFolderSb.toString();
            
            java.io.File directorio = new File(uploadFolder);
            directorio.mkdirs();
            
            for (FileItem fileItem : ListaFiles) {
            	String fileName = new File(fileItem.getName()).getName();
            	String filePath=uploadFolder + File.separator + fileName;
            	
                File uploadedFile = new File(filePath);
                
                // saves the file to upload directory
                fileItem.write(uploadedFile);
                
                ZipUtils.extract(uploadedFile, directorio);
                
			}

            // displays done.jsp page after upload finished
        //    getServletContext().getRequestDispatcher("/done.jsp").forward(request, response);
            return ;    
            
        } catch (FileUploadException ex) {
            throw new ServletException(ex);
        }catch (Exception ex) {
            throw new ServletException(ex);
        }       
    }
	
}
