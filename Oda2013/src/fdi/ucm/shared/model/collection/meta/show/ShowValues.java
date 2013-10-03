/**
 * 
 */
package fdi.ucm.shared.model.collection.meta.show;

import java.io.Serializable;
import java.util.ArrayList;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * Clase que define un valor para la vista
 * @author Joaquin Gayoso-Cabada
 *
 */
public class ShowValues implements Serializable,IsSerializable{


	private static final long serialVersionUID = 2611988084685026790L;
	protected String Valor;
	protected ArrayList<ShowValoresResult> Resultado;
	
	public ShowValues() {
		Valor="";
		Resultado=new ArrayList<ShowValoresResult>();
	}

	/**
	 * @param valor
	 */
	public ShowValues(String valor) {
		super();
		Valor = valor;
		Resultado=new ArrayList<ShowValoresResult>();
	}

	/**
	 * @return the valor
	 */
	public String getValor() {
		return Valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(String valor) {
		Valor = valor;
	}

	/**
	 * @return the resultado
	 */
	public ArrayList<ShowValoresResult> getResultado() {
		return Resultado;
	}

	/**
	 * @param resultado the resultado to set
	 */
	public void setResultado(ArrayList<ShowValoresResult> resultado) {
		Resultado = resultado;
	}
	
	
	
}
