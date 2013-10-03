/**
 * 
 */
package fdi.ucm.client.visualizepanel;

import java.util.ArrayList;

import fdi.ucm.shared.model.collection.meta.Meta;
import fdi.ucm.shared.model.collection.meta.controlled.Term;

/**
 * clase que define la implementacion de un treeItem para la creacion de un elemento de texto
 * @author Joaquin Gayoso-Cabada
 *
 */
public class MetaVisualizeTreeItemString extends MetaVisualizeTreeItem {

	private String TextoPropio;
	
	public MetaVisualizeTreeItemString(Meta atributo1, String textopropio,
			ArrayList<Term> arrayList, ArrayList<String> filtroTextoin) {
		super();
		TextoPropio=textopropio;
		
		asignaciones(atributo1, arrayList, filtroTextoin);
		
		filtroTexto.add(atributo1.getName()+TextoPropio);
		
		HijosRecurso=SplitLayoutPanelPropio.FindResources(ListEntrada, atributo1,filtro,filtroTexto);

		if (HijosRecurso.size()>0)
			setHTML("<i> " +TextoPropio +" </i>"+"("+HijosRecurso.size()+")");
		else 
			setHTML("<i> " +TextoPropio +" </i>");
		
		Boolean A = SplitLayoutPanelPropio.getFlagsDeAperturaString().get(TextoPropio);
		if (A!=null&&A)
			setState(true, true);
	}

	/**
	 * @return the textoPropio
	 */
	public String getTextoPropio() {
		return TextoPropio;
	}

	/**
	 * @param textoPropio the textoPropio to set
	 */
	public void setTextoPropio(String textoPropio) {
		TextoPropio = textoPropio;
	}

	
	
}
