package fdi.ucm.client.visualizepanel;

import java.util.ArrayList;

import fdi.ucm.shared.model.collection.meta.Meta;
import fdi.ucm.shared.model.collection.meta.controlled.Term;

/**
 * Clase que implementa un hijo del arbol de tipo controlado.
 * @author Joaquin Gayoso-Cabada
 *
 */
public class MetaVisualizeTreeItemTerm extends MetaVisualizeTreeItem {

	private Term Termino;
	
	public MetaVisualizeTreeItemTerm(Meta atributo1,Term Terminoin, ArrayList<Term> arrayList, ArrayList<String> filtroTextoin) {
		super();
		Termino=Terminoin;
		
		asignaciones(atributo1, arrayList, filtroTextoin);
		
		filtro.add(Terminoin);
		
		HijosRecurso=SplitLayoutPanelPropio.FindResources(ListEntrada, atributo1,filtro,filtroTexto);
		
		if (HijosRecurso.size()>0)
			setHTML("<i> " +Terminoin.getTerm() +" </i>"+"("+HijosRecurso.size()+")");
		else 
			setHTML("<i> " +Terminoin.getTerm() +" </i>");
		
		Boolean A = SplitLayoutPanelPropio.getFlagsDeAperturaTerm().get(Terminoin);
		if (A!=null&&A)
			setState(true, true);
		
	}

	/**
	 * @return the termino
	 */
	public Term getTermino() {
		return Termino;
	}

	/**
	 * @param termino the termino to set
	 */
	public void setTermino(Term termino) {
		Termino = termino;
	}

	

}
