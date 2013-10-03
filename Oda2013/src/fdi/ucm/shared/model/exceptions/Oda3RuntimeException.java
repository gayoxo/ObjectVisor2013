/**
 * 
 */
package fdi.ucm.shared.model.exceptions;

/**
 * @author Coca-COla
 *
 */
public class Oda3RuntimeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private static final String GENERIC_ERROR_STATIC = "Try again please, if persist contact with administrator of the system";
	private String GENERIC_ERROR = "Try again please, if persist contact with administrator of the system";
	
	
public Oda3RuntimeException() {
	super(GENERIC_ERROR_STATIC);
}


	

	@Override
	public String getMessage() {
		return GENERIC_ERROR;
	}
	
	public String getMessageString() {
		return GENERIC_ERROR;
	}


	/**
	 * @return the genericError
	 */
	public String getGenericError() {
		return GENERIC_ERROR;
	}




	/**
	 * @return the gENERIC_ERROR
	 */
	public String getGENERIC_ERROR() {
		return GENERIC_ERROR;
	}




	/**
	 * @param gENERIC_ERROR the gENERIC_ERROR to set
	 */
	public void setGENERIC_ERROR(String gENERIC_ERROR) {
		GENERIC_ERROR = gENERIC_ERROR;
	}
	
	
	
}
