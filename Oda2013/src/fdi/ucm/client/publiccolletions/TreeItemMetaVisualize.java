/**
 * 
 */
package fdi.ucm.client.publiccolletions;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.ui.TreeItem;

import fdi.ucm.shared.model.collection.document.Documents;
import fdi.ucm.shared.model.collection.grammar.ElementType;
import fdi.ucm.shared.model.collection.grammar.TextElementType;

/**
 * Clase que genera un elemento en un arbol y permite la creacion del resto de elementos en caso apertura.
 * @author Joaquin Gayoso-Cabada
 *
 */
public class TreeItemMetaVisualize extends TreeItem {

	
	protected ElementType attribute;
	protected ArrayList<TreeItemMetaVisualize> Hijos;
	protected ArrayList<Documents> HijosRecurso;
	protected static List<Documents> ListEntrada;
	protected ArrayList<String> filtroTexto;
	protected boolean open;
	
	public TreeItemMetaVisualize(ElementType atributo1, ArrayList<String> filtroTextoin) {
		super();
		asignaciones(atributo1,filtroTextoin);
		
		HijosRecurso=SplitLayoutPanelPublicCollection.FindResources(ListEntrada, atributo1,filtroTexto);
		
		if (HijosRecurso.size()>0)
			setHTML(atributo1.getName()+"("+HijosRecurso.size()+")");
		else 
			setHTML(atributo1.getName());
		
	}


	protected void asignaciones(ElementType atributo1,
			ArrayList<String> filtroTextoin) {
		open=false;
		attribute=atributo1;
		Hijos=new ArrayList<TreeItemMetaVisualize>();
		filtroTexto=new ArrayList<String>();
		for (String string : filtroTextoin) {
			filtroTexto.add(string);
		}
		
	}





	public TreeItemMetaVisualize() {
		super();
	}

	/**
	 * @return the hijosRecurso
	 */
	public ArrayList<Documents> getHijosRecurso() {
		return HijosRecurso;
	}

	/**
	 * @param hijosRecurso the hijosRecurso to set
	 */
	public void setHijosRecurso(ArrayList<Documents> hijosRecurso) {
		HijosRecurso = hijosRecurso;
	}

	/**
	 * @return the attribute
	 */
	public ElementType getAttribute() {
		return attribute;
	}

	/**
	 * @param attribute the attribute to set
	 */
	public void setAttribute(ElementType attribute) {
		this.attribute = attribute;
	}


		
	/**
	 * Abre los hijos si no se abrieron antes
	 */
	public void OpenSons() {
		if (!open)
			{
			for (TreeItemMetaVisualize Hijo : Hijos) {
				if (Hijo.getAttribute() instanceof TextElementType)
						SplitLayoutPanelPublicCollection.processCollectionText((TextElementType) Hijo.getAttribute(), Hijo,Hijo.getHijos());
						else 
							SplitLayoutPanelPublicCollection.processCollection(Hijo.getAttribute().getSons(), Hijo,Hijo.getHijos());
			}
			open=true;
			}
		
		
	}

	/**
	 * @return the hijos
	 */
	public ArrayList<TreeItemMetaVisualize> getHijos() {
		return Hijos;
	}

	/**
	 * @param hijos the hijos to set
	 */
	public void setHijos(ArrayList<TreeItemMetaVisualize> hijos) {
		Hijos = hijos;
	}

	/**
	 * @return the listEntrada
	 */
	public static List<Documents> getListEntrada() {
		return ListEntrada;
	}

	/**
	 * @param list the listEntrada to set
	 */
	public static void setListEntrada(List<Documents> list) {
		ListEntrada = list;
	}


	/**
	 * @return the filtroTexto
	 */
	public ArrayList<String> getFiltroTexto() {
		return filtroTexto;
	}


	/**
	 * @param filtroTexto the filtroTexto to set
	 */
	public void setFiltroTexto(ArrayList<String> filtroTexto) {
		this.filtroTexto = filtroTexto;
	}
	
	

	
	
}
