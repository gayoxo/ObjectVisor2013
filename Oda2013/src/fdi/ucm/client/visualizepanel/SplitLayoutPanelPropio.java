/**
 * 
 */
package fdi.ucm.client.visualizepanel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.event.logical.shared.OpenEvent;
import com.google.gwt.event.logical.shared.OpenHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.SplitLayoutPanel;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.VerticalPanel;

import fdi.ucm.client.window.modeleditor.EditorMainWindowEditor;
import fdi.ucm.shared.model.collection.Collection;
import fdi.ucm.shared.model.collection.CollectionAttribute;
import fdi.ucm.shared.model.collection.meta.Meta;
import fdi.ucm.shared.model.collection.meta.MetaControlled;
import fdi.ucm.shared.model.collection.meta.MetaText;
import fdi.ucm.shared.model.collection.meta.controlled.Term;
import fdi.ucm.shared.model.collection.meta.controlled.Vocabulary;
import fdi.ucm.shared.model.collection.metavalues.MetaControlledValue;
import fdi.ucm.shared.model.collection.metavalues.MetaTextValue;
import fdi.ucm.shared.model.collection.metavalues.MetaValue;
import fdi.ucm.shared.model.collection.resources.Resources;

/**
 * Clase que mantiene y genera el panel de vision general para el modelo.
 * @author Coca-COla
 *
 */
public class SplitLayoutPanelPropio extends SplitLayoutPanel {

	protected static final String MORE_BUTTON = "More";
	protected static final String LESS_BUTTON = "Back";
	private static HashMap<Meta, Boolean> FlagsDeApertura;
	private static HashMap<Term, Boolean> FlagsDeAperturaTerm;
	private static HashMap<String, Boolean> FlagsDeAperturaString;
	private ScrollPanel scrollElementos;
	private static Stack<PopupPanel> Pila_de_cerrado;
	private int LastElement;
	private Label Path;
	private VerticalPanel PanelRecursosActuales;
	private Label PageLabel;
	private static Collection coleccion;
	private static String BasePath;
	
	
	public SplitLayoutPanelPropio() {
		
		if (FlagsDeApertura==null)
			FlagsDeApertura=new HashMap<Meta, Boolean>();
		
		if (FlagsDeAperturaTerm==null)
			FlagsDeAperturaTerm=new HashMap<Term, Boolean>();
		
		if (FlagsDeAperturaString==null)
			FlagsDeAperturaString=new HashMap<String, Boolean>();
		
		ScrollPanel scrollPanel = new ScrollPanel();
		addWest(scrollPanel, 200.0);
		scrollPanel.setSize("100%", "100%");
		
		SimplePanel ZonaArboles = new SimplePanel();
		scrollPanel.setWidget(ZonaArboles);
		ZonaArboles.setSize("100%", "100%");
		

		
		
		Tree ArbolAGenerar = new Tree();
		ArbolAGenerar.addSelectionHandler(new SelectionHandler<TreeItem>() {
			private Button Mas;
			private ArrayList<Resources> Lista;
			private Button Menos;

			public void onSelection(SelectionEvent<TreeItem> event) {
				if (event.getSelectedItem() instanceof MetaVisualizeTreeItem)  
					{
					Pila_de_cerrado=new Stack<PopupPanel>();
					Meta Element = ((MetaVisualizeTreeItem)event.getSelectedItem()).getAttribute();
					Lista = ((MetaVisualizeTreeItem)event.getSelectedItem()).getHijosRecurso();
					Path.setText(EditorMainWindowEditor.pathFather(Element));
					PanelRecursosActuales.clear();
					LastElement=0;
					showNextLista();
					setPageLabel();
					Mas=new Button(MORE_BUTTON);
					Mas.addClickHandler(new ClickHandler() {
						
						@Override
						public void onClick(ClickEvent event) {
								PanelRecursosActuales.clear();
								PanelRecursosActuales.add(Menos);
								showNextLista();
								if (LastElement<Lista.size())
									PanelRecursosActuales.add(Mas);
								scrollElementos.setVerticalScrollPosition(0);

						}
					});
					if (LastElement>=9)
						PanelRecursosActuales.add(Mas);
					Mas.setWidth("100%");
					Menos=new Button(LESS_BUTTON);
					Menos.addClickHandler(new ClickHandler() {
						
						@Override
						public void onClick(ClickEvent event) {
								PanelRecursosActuales.clear();
								int calMenos=LastElement-1;
								int div=(calMenos/10);
								LastElement=div*10;		
								LastElement=LastElement-20;
								if (LastElement>0)
									PanelRecursosActuales.add(Menos);
								if (LastElement<0)
									LastElement=0;
								showNextLista();
									PanelRecursosActuales.add(Mas);
									scrollElementos.setVerticalScrollPosition(0);

						}
					});
					Menos.setWidth("100%");
					}
			}

			private void setPageLabel() {
				int Menos=(LastElement-9);
				if (Menos<1)
					if (LastElement>0)
						Menos=1;
					else
						Menos=0;
				PageLabel.setText((Menos)+"/"+(LastElement));
				
			}

			private void showNextLista() {
				int actual = 0;
				for (int i = 0; i<10 && (LastElement+i) < Lista.size(); i++) {
					Resources recurso =Lista.get(LastElement+i);
					PanelRecursosActuales.add(new RecursoDescriptionComposite(recurso,coleccion.getMetamodelSchemas()));
					actual++;
				}
				LastElement=LastElement+actual;
				setPageLabel();
				
				
			}
		});
		ArbolAGenerar.addOpenHandler(new OpenHandler<TreeItem>() {
			public void onOpen(OpenEvent<TreeItem> event) {
				if (event.getTarget() instanceof MetaVisualizeTreeItemTerm)  
					{
					FlagsDeAperturaTerm.put(((MetaVisualizeTreeItemTerm)event.getTarget()).getTermino(),true);
					((MetaVisualizeTreeItemTerm)event.getTarget()).OpenSons();
					}
				else 
					if (event.getTarget() instanceof MetaVisualizeTreeItem)
					{	
						FlagsDeApertura.put(((MetaVisualizeTreeItem)event.getTarget()).getAttribute(),true);	
					((MetaVisualizeTreeItem)event.getTarget()).OpenSons();
					}
					else if (event.getTarget() instanceof MetaVisualizeTreeItemString)
					{	
						FlagsDeAperturaString.put(((MetaVisualizeTreeItemString)event.getTarget()).getTextoPropio(),true);	
					((MetaVisualizeTreeItemString)event.getTarget()).OpenSons();
					}
			}
		});
		
		ArbolAGenerar.addCloseHandler(new CloseHandler<TreeItem>() {
			
			@Override
			public void onClose(CloseEvent<TreeItem> event) {
				if (event.getTarget() instanceof MetaVisualizeTreeItemTerm)  
				FlagsDeAperturaTerm.put(((MetaVisualizeTreeItemTerm)event.getTarget()).getTermino(),false);

			else 
				if (event.getTarget() instanceof MetaVisualizeTreeItem)
					FlagsDeApertura.put(((MetaVisualizeTreeItem)event.getTarget()).getAttribute(),false);	
				else 
					if (event.getTarget() instanceof MetaVisualizeTreeItemString)
						FlagsDeAperturaString.put(((MetaVisualizeTreeItemString)event.getTarget()).getTextoPropio(),false);	
				
			}
		});
		ZonaArboles.setWidget(ArbolAGenerar);
		ArbolAGenerar.setSize("100%", "100%");
		
		MetaVisualizeTreeItem.setListEntrada(coleccion.getSectionValues());
		TabElement.setBasePath(BasePath);
		RecursoDescriptionComposite.setBasePath(BasePath);
		
		if (coleccion!=null)
			processCollection(coleccion.getMetamodelSchemas(), ArbolAGenerar);
		
		
		
		DockLayoutPanel ZonaElementosActual = new DockLayoutPanel(Unit.PX);
		add(ZonaElementosActual);
		ZonaElementosActual.setSize("100%", "100%");
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		ZonaElementosActual.addNorth(horizontalPanel, 40.0);
		horizontalPanel.setSize("100%", "100%");
		
		ScrollPanel scrollPanel_2 = new ScrollPanel();
		horizontalPanel.add(scrollPanel_2);
		scrollPanel_2.setSize("100%", "100%");
		
		Path = new Label();
		scrollPanel_2.setWidget(Path);
		Path.setHeight("100%");
		
		PageLabel = new Label();
		PageLabel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		horizontalPanel.add(PageLabel);
		PageLabel.setSize("100%", "100%");
		
		scrollElementos = new ScrollPanel();
		ZonaElementosActual.add(scrollElementos);
		scrollElementos.setSize("100%", "100%");
		
		PanelRecursosActuales = new VerticalPanel();
		scrollElementos.setWidget(PanelRecursosActuales);
		PanelRecursosActuales.setSize("100%", "100%");

	}
	
	/**
	 * Procesa la lista de elementos sobre la base
	 * @param list
	 * @param arbolAGenerar 
	 */
	private void processCollection(
			List<CollectionAttribute> list, Tree arbolAGenerar) {
		for (CollectionAttribute atributo1 : list) {
			
			MetaVisualizeTreeItem trtmNewItem;
			if ((atributo1 instanceof Meta)
					&&(((Meta)atributo1).getBrowseable())
					)
				{
				trtmNewItem = new MetaVisualizeTreeItem((Meta)atributo1,new ArrayList<Term>(),new ArrayList<String>());
				arbolAGenerar.addItem(trtmNewItem);
					if (atributo1 instanceof MetaControlled)
						processCollectionControlled(((MetaControlled) atributo1).getVocabulary(), trtmNewItem,trtmNewItem.getHijos());
						else
							if (atributo1 instanceof MetaText)
								//{
								processCollectionText((MetaText) trtmNewItem.getAttribute(), trtmNewItem,trtmNewItem.getHijos());
								//processCollection(atributo1.getSons(), arbolAGenerar);
								//}
								else
									processCollection(trtmNewItem.getAttribute().getSons(), trtmNewItem,trtmNewItem.getHijos());
					}
				else 	
					processCollection(atributo1.getSons(), arbolAGenerar);
			
			
		
		}
		
	}
	
	/**
	 * @return the coleccion
	 */
	public static Collection getColeccion() {
		return coleccion;
	}

	
	/**
	 * @return the basePath
	 */
	public static String getBasePath() {
		return BasePath;
	}

	/**
	 * @param coleccion the coleccion to set
	 * @param basePath the basePath to set
	 */
	public static void setColeccionAndBasePath(Collection coleccion,String basePath) {
		SplitLayoutPanelPropio.coleccion = coleccion;
		SplitLayoutPanelPropio.BasePath=basePath;
	}

	/**
	 * @return the pila_de_cerrado
	 */
	public static Stack<PopupPanel> getPila_de_cerrado() {
		return Pila_de_cerrado;
	}

	/**
	 * @param pila_de_cerrado the pila_de_cerrado to set
	 */
	public static void setPila_de_cerrado(Stack<PopupPanel> pila_de_cerrado) {
		Pila_de_cerrado = pila_de_cerrado;
	}

	/**
	 * @return the flagsDeApertura
	 */
	public static HashMap<Meta, Boolean> getFlagsDeApertura() {
		return FlagsDeApertura;
	}

	/**
	 * @param flagsDeApertura the flagsDeApertura to set
	 */
	public static void setFlagsDeApertura(HashMap<Meta, Boolean> flagsDeApertura) {
		FlagsDeApertura = flagsDeApertura;
	}

	/**
	 * @return the flagsDeAperturaTerm
	 */
	public static HashMap<Term, Boolean> getFlagsDeAperturaTerm() {
		return FlagsDeAperturaTerm;
	}

	/**
	 * @param flagsDeAperturaTerm the flagsDeAperturaTerm to set
	 */
	public static void setFlagsDeAperturaTerm(
			HashMap<Term, Boolean> flagsDeAperturaTerm) {
		FlagsDeAperturaTerm = flagsDeAperturaTerm;
	}

	/**
	 * @return the flagsDeAperturaString
	 */
	public static HashMap<String, Boolean> getFlagsDeAperturaString() {
		return FlagsDeAperturaString;
	}

	/**
	 * @param flagsDeAperturaString the flagsDeAperturaString to set
	 */
	public static void setFlagsDeAperturaString(
			HashMap<String, Boolean> flagsDeAperturaString) {
		FlagsDeAperturaString = flagsDeAperturaString;
	}

	/**
	 * procesa una coleccion para un atributo controlado.
	 * @param vocabulary
	 * @param padre
	 * @param hijosDelPadre
	 */
	public static void processCollectionControlled(Vocabulary vocabulary,
			MetaVisualizeTreeItem padre,
			ArrayList<MetaVisualizeTreeItem> hijosDelPadre) {
		for (Term Terminos : vocabulary.getList()) {
			MetaVisualizeTreeItem trtmNewItem = new MetaVisualizeTreeItemTerm(padre.getAttribute(),Terminos,padre.getFiltro(),padre.getFiltroTexto());
			if (trtmNewItem.getHijosRecurso().size()!=0)
				{
				padre.addItem(trtmNewItem);
				hijosDelPadre.add(trtmNewItem);
				}
		}
		
		
		Boolean A=null;
		if (padre instanceof MetaVisualizeTreeItemTerm)  
			A = getFlagsDeAperturaTerm().get(((MetaVisualizeTreeItemTerm)padre).getTermino());
			
		else 
			if (padre instanceof MetaVisualizeTreeItem)
				A = getFlagsDeApertura().get(padre.getAttribute());
			else 
				if (padre instanceof MetaVisualizeTreeItemString)
					A = getFlagsDeAperturaString().get(((MetaVisualizeTreeItemString) padre).getTextoPropio());

		if (A!=null&&A)
		{
		padre.setState(true, true);
		}
	}

	/**
	 * Procesa lista cuando viene de un nodo hijo
	 * @param list
	 * @param padre
	 * @param hijosDelPadre
	 */
	public static void processCollection(List<CollectionAttribute> list,
			MetaVisualizeTreeItem padre,
			ArrayList<MetaVisualizeTreeItem> hijosDelPadre) {
		for (CollectionAttribute atributoHijo : list) {
			
			MetaVisualizeTreeItem trtmNewItem;
			if ((atributoHijo instanceof Meta)
					&&(((Meta)atributoHijo).getBrowseable())
					)
				{
				trtmNewItem = new MetaVisualizeTreeItem((Meta)atributoHijo,padre.getFiltro(),padre.getFiltroTexto());
				padre.addItem(trtmNewItem);
				hijosDelPadre.add(trtmNewItem);
				}
			else 

				processCollection(atributoHijo.getSons(), padre,hijosDelPadre);	

		}
		
		Boolean A=null;
		if (padre instanceof MetaVisualizeTreeItemTerm)  
			A = getFlagsDeAperturaTerm().get(((MetaVisualizeTreeItemTerm)padre).getTermino());
			
		else 
			if (padre instanceof MetaVisualizeTreeItem)
				A = getFlagsDeApertura().get(padre.getAttribute());
			else 
				if (padre instanceof MetaVisualizeTreeItemString)
					A = getFlagsDeAperturaString().get(((MetaVisualizeTreeItemString) padre).getTextoPropio());

		if (A!=null&&A)
		{
		padre.setState(true, true);
		}
		
		
	}

	/**
	 * Clase que implementa la busqueda de recursos en la lista de recursos de la coleccion
	 * @param listEntrada
	 * @param ElementoABuscar
	 * @param filtro 
	 * @return
	 */
	protected static ArrayList<Resources> FindResources(List<Resources> listEntrada,
			Meta ElementoABuscar, ArrayList<Term> filtro,ArrayList<String> filtroTexto) {
		ArrayList<Resources> Salida = new ArrayList<Resources>();
		for (Resources resources : listEntrada) {
			for (MetaValue valorDesc : resources.getDescription()) {
				if (valorDesc.getHastype()==ElementoABuscar)
					Salida.add(resources);
			}
		}
		
		HashSet<Resources> quitar=new HashSet<Resources>();
		for (Resources resources : Salida) {
			for (Term termino : filtro) {
				boolean encontrado=false;
				for (MetaValue valorDesc : resources.getDescription()) {
					if ((valorDesc instanceof MetaControlledValue)&&((MetaControlledValue)valorDesc).getValue()==termino)
						{
						encontrado=true;
						break;
						}
				}
				if (!encontrado)
					{
					quitar.add(resources);
					break;
					}
			}
		}
		
		for (Resources resourcesAQuitar : quitar) {
			Salida.remove(resourcesAQuitar);
		}
		
		
		HashSet<Resources> quitarTexto = new HashSet<Resources>();
		for (Resources resources : Salida) {
			for (String testofiltro : filtroTexto) {
				boolean encontrado = false;
				for (MetaValue valorDesc : resources.getDescription()) {
					if ((valorDesc instanceof MetaTextValue)
							&& (((((MetaTextValue) valorDesc).getHastype()
									.getName()) + (((MetaTextValue) valorDesc)
									.getValue())).equals(testofiltro))) {
						encontrado = true;
						break;
					}
				}
				if (!encontrado) {
					quitarTexto.add(resources);
					break;
				}
			}
		}
		
		for (Resources resourcesAQuitar : quitarTexto) {
			Salida.remove(resourcesAQuitar);
		}
		
		
		
		return Salida;
	}

	
	/**
	 * Procesa una coleccion de tipoTexto
	 * @param meta
	 * @param trtmNewItem
	 * @param hijos
	 */
	public static void processCollectionText(MetaText meta,
			MetaVisualizeTreeItem padre,
			ArrayList<MetaVisualizeTreeItem> hijos) {
		
		ArrayList<String> ResursorAptos=FindVocabularyText(meta);
		Collections.sort(ResursorAptos);
		for (String texto1 : ResursorAptos) {
			MetaVisualizeTreeItemString TreeItem= new MetaVisualizeTreeItemString(padre.getAttribute(),texto1,padre.getFiltro(),padre.getFiltroTexto());
			if (TreeItem.getHijosRecurso().size()!=0)
			{
			padre.addItem(TreeItem);
			hijos.add(TreeItem);
			}
		}
		
		
		Boolean A=null;
		if (padre instanceof MetaVisualizeTreeItemTerm)  
			A = getFlagsDeAperturaTerm().get(((MetaVisualizeTreeItemTerm)padre).getTermino());
			
		else 
			if (padre instanceof MetaVisualizeTreeItem)
				A = getFlagsDeApertura().get(padre.getAttribute());
			else 
				if (padre instanceof MetaVisualizeTreeItemString)
					A = getFlagsDeAperturaString().get(((MetaVisualizeTreeItemString) padre).getTextoPropio());

		if (A!=null&&A)
		{
		padre.setState(true, true);
		}
		
	}

	private static ArrayList<String> FindVocabularyText(MetaText meta) {
		
		HashSet<String> lista=new HashSet<String>();
		
		for (Resources recursopos : coleccion.getSectionValues()) {
			for (MetaValue metavalorpos : recursopos.getDescription()) {
				if ((metavalorpos instanceof MetaTextValue)&&(metavalorpos.getHastype()==meta))
					{
					String valor=((MetaTextValue)metavalorpos).getValue();
					valor=valor.trim();
					lista.add(valor);
					}
			}
		}
		ArrayList<String> salida=new ArrayList<String>();
		for (String string : lista) {
			salida.add(string);
		}
		return salida;
	}

	
}
