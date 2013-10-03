package fdi.ucm.shared.model.exceptions;

/**
 * Excepciones de Oda
 * @author Joaquin Gayoso-Cabada
 *
 */
public class ImportRuntimeException extends RuntimeException {

	//1 Error de creacion por falta de Meta Objeto virtual.
	//2 Descripcion no encontrada en la entrada al objeto virtual.
	//3 Los Identificadores no son numeros.
	//4 Existe una categoria que esta en los atributos y no en el modelo.
	//5 Existe error en el parseado de las iteraciones.
	//6 Un Own Files es otra cosa en lugar de un File
	//7 El file no tiene visibiliadad
	
	private static final long serialVersionUID = 1L;
	
	private static final String GENERIC_ERROR_STATIC = "Try again please, if persist contact with administrator of the system";
	private String GENERIC_ERROR;
	
	
	public ImportRuntimeException() {
		super(GENERIC_ERROR_STATIC);
		GENERIC_ERROR=GENERIC_ERROR_STATIC;
	}
	
	/**
	 * Construtor por defecto
	 * @param i tipo de error
	 */
	public ImportRuntimeException(String i) {
		
		GENERIC_ERROR=i;
		
	}

@Override
public String getLocalizedMessage() {
	return GENERIC_ERROR;
}

	@Override
	public String getMessage() {
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
