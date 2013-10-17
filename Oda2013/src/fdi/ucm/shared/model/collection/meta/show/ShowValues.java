package fdi.ucm.shared.model.collection.meta.show;

import java.io.Serializable;
import java.util.ArrayList;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * Clase que define el Show Value General que se encuentran en los Show
 * @author Joaquin Gayoso-Cabada
 *
 */
public abstract class ShowValues implements Serializable,IsSerializable{

	private static final long serialVersionUID = -97254894124910878L;
	protected ArrayList<ShowValoresResult> Resultado;
	protected String Valor;
	
	
	public ShowValues() {
		Resultado=new ArrayList<ShowValoresResult>();
		Valor="";
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
