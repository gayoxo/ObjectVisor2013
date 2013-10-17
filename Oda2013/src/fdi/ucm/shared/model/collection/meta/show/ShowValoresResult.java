/**
 * 
 */
package fdi.ucm.shared.model.collection.meta.show;

import java.io.Serializable;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * Resultado valores
 * @author Joaquin Gayoso-Cabada
 *
 */
public class ShowValoresResult implements Serializable,IsSerializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7439173902466318134L;
	protected String resultado;
	
	
	public ShowValoresResult() {
		resultado="";
		
	}

	/**
	 * @param resultado
	 */
	public ShowValoresResult(String resultado) {
		super();
		this.resultado = resultado;
	}

	/**
	 * @return the resultado
	 */
	public String getResultado() {
		return resultado;
	}

	/**
	 * @param resultado the resultado to set
	 */
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	
	
}
