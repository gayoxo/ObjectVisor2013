/**
 * 
 */
package fdi.ucm.shared.model;

import java.io.Serializable;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * Clase que implementa los datos para la exportacion e importacion de los elementos en un plugin. 
 * @author Joaquin Gayoso-Cabada
 *
 */
public class ImportExportPair implements Serializable,IsSerializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5865820843900140019L;
	private ImportExportDataEnum Tipo;
	private String Label;
	
	
	public ImportExportPair() {
		Tipo=null;
		Label=null;
	}
	
	/**
	 * @param tipo
	 * @param label
	 */
	public ImportExportPair(ImportExportDataEnum tipo, String label) {
		super();
		Tipo = tipo;
		Label = label;
	}
	/**
	 * @return the tipo
	 */
	public ImportExportDataEnum getTipo() {
		return Tipo;
	}
	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(ImportExportDataEnum tipo) {
		Tipo = tipo;
	}
	/**
	 * @return the label
	 */
	public String getLabel() {
		return Label;
	}
	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		Label = label;
	}
	
	
}
