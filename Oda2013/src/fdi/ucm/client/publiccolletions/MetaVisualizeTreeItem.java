/**
 * 
 */
package fdi.ucm.client.publiccolletions;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.ui.TreeItem;

import fdi.ucm.shared.model.collection.meta.Meta;
import fdi.ucm.shared.model.collection.meta.MetaControlled;
import fdi.ucm.shared.model.collection.meta.MetaText;
import fdi.ucm.shared.model.collection.meta.controlled.Term;
import fdi.ucm.shared.model.collection.resources.Resources;

/**
 * Clase que genera un elemento en un arbol y permite la creacion del resto de elementos en caso apertura.
 * @author Joaquin Gayoso-Cabada
 *
 */
public class MetaVisualizeTreeItem extends TreeItem {

	
	protected Meta attribute;
	protected ArrayList<MetaVisualizeTreeItem> Hijos;
	protected ArrayList<Resources> HijosRecurso;
	protected static List<Resources> ListEntrada;
	protected ArrayList<Term> filtro;
	protected ArrayList<String> filtroTexto;
	protected boolean open;
	
	public MetaVisualizeTreeItem(Meta atributo1, ArrayList<Term> arrayList,ArrayList<String> filtroTextoin) {
		super();
		asignaciones(atributo1,arrayList,filtroTextoin);
		
		HijosRecurso=SplitLayoutPanelPropio.FindResources(ListEntrada, atributo1,filtro,filtroTexto);
		
		if (HijosRecurso.size()>0)
			setHTML(atributo1.getName()+"("+HijosRecurso.size()+")");
		else 
			setHTML(atributo1.getName());
		
	}


	protected void asignaciones(Meta atributo1, ArrayList<Term> arrayList,
			ArrayList<String> filtroTextoin) {
		open=false;
		attribute=atributo1;
		Hijos=new ArrayList<MetaVisualizeTreeItem>();
		filtro=new ArrayList<Term>();
		for (Term term : arrayList) {
			filtro.add(term);
		}
		filtroTexto=new ArrayList<String>();
		for (String string : filtroTextoin) {
			filtroTexto.add(string);
		}
		
	}


	/**
	 * @return the filtro
	 */
	public ArrayList<Term> getFiltro() {
		return filtro;
	}


	/**
	 * @param filtro the filtro to set
	 */
	public void setFiltro(ArrayList<Term> filtro) {
		this.filtro = filtro;
	}


	public MetaVisualizeTreeItem() {
		super();
	}

	/**
	 * @return the hijosRecurso
	 */
	public ArrayList<Resources> getHijosRecurso() {
		return HijosRecurso;
	}

	/**
	 * @param hijosRecurso the hijosRecurso to set
	 */
	public void setHijosRecurso(ArrayList<Resources> hijosRecurso) {
		HijosRecurso = hijosRecurso;
	}

	/**
	 * @return the attribute
	 */
	public Meta getAttribute() {
		return attribute;
	}

	/**
	 * @param attribute the attribute to set
	 */
	public void setAttribute(Meta attribute) {
		this.attribute = attribute;
	}


		
	/**
	 * Abre los hijos si no se abrieron antes
	 */
	public void OpenSons() {
		if (!open)
			{
			for (MetaVisualizeTreeItem Hijo : Hijos) {
				if ((Hijo instanceof MetaVisualizeTreeItemTerm)||(Hijo instanceof MetaVisualizeTreeItemString))
					SplitLayoutPanelPropio.processCollection(Hijo.getAttribute().getSons(), Hijo,Hijo.getHijos());
				else
				{
				if (Hijo.getAttribute() instanceof MetaControlled)
					SplitLayoutPanelPropio.processCollectionControlled(((MetaControlled) Hijo.getAttribute()).getVocabulary(), Hijo,Hijo.getHijos());
				else
					if (Hijo.getAttribute() instanceof MetaText)
						SplitLayoutPanelPropio.processCollectionText((MetaText) Hijo.getAttribute(), Hijo,Hijo.getHijos());
						else 
							SplitLayoutPanelPropio.processCollection(Hijo.getAttribute().getSons(), Hijo,Hijo.getHijos());
				}
			}
			open=true;
			}
		
		
	}

	/**
	 * @return the hijos
	 */
	public ArrayList<MetaVisualizeTreeItem> getHijos() {
		return Hijos;
	}

	/**
	 * @param hijos the hijos to set
	 */
	public void setHijos(ArrayList<MetaVisualizeTreeItem> hijos) {
		Hijos = hijos;
	}

	/**
	 * @return the listEntrada
	 */
	public static List<Resources> getListEntrada() {
		return ListEntrada;
	}

	/**
	 * @param list the listEntrada to set
	 */
	public static void setListEntrada(List<Resources> list) {
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
