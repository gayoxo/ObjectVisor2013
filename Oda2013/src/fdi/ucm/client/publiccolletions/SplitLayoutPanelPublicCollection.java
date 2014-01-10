/**
 * 
 */
package fdi.ucm.client.publiccolletions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.event.logical.shared.OpenEvent;
import com.google.gwt.event.logical.shared.OpenHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
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

import fdi.ucm.client.controller.Oda2013ConstantsInformation;
import fdi.ucm.client.controller.Oda2013OperatinoalViewStaticFunctions;
import fdi.ucm.shared.model.collection.Collection;
import fdi.ucm.shared.model.collection.document.Documents;
import fdi.ucm.shared.model.collection.document.Element;
import fdi.ucm.shared.model.collection.document.MetaControlledValue;
import fdi.ucm.shared.model.collection.document.TextElement;
import fdi.ucm.shared.model.collection.grammar.ElementType;
import fdi.ucm.shared.model.collection.grammar.Grammar;
import fdi.ucm.shared.model.collection.grammar.MetaControlled;
import fdi.ucm.shared.model.collection.grammar.Structure;
import fdi.ucm.shared.model.collection.grammar.TextElementType;
import fdi.ucm.shared.model.collection.grammar.controlled.Term;
import fdi.ucm.shared.model.collection.grammar.controlled.Vocabulary;

import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.kiouri.sliderbar.client.event.BarValueChangedEvent;
import com.kiouri.sliderbar.client.event.BarValueChangedHandler;
import com.kiouri.sliderbar.client.solution.simplehorizontal.SliderBarSimpleHorizontal;

/**
 * Clase que mantiene y genera el panel de vision general para el modelo.
 * @author Joaquin Gayoso-Cabada
 *
 */
public class SplitLayoutPanelPublicCollection extends SplitLayoutPanel {

//	protected static final String MORE_BUTTON = "More";
//	protected static final String LESS_BUTTON = "Back";
	private static HashMap<ElementType, Boolean> FlagsDeApertura;
	private static HashMap<Term, Boolean> FlagsDeAperturaTerm;
	private static HashMap<String, Boolean> FlagsDeAperturaString;
	private ScrollPanel scrollElementos;
	private static Stack<PopupPanel> Pila_de_cerrado;
	private int LastElement;
	private Label Path;
	private VerticalPanel PanelRecursosActuales;
	private Label PageLabel;
	private static Collection coleccion;
	private SliderBarSimpleHorizontal SB;
	private ArrayList<Documents> Lista;
	private SplitLayoutPanelPublicCollection OEThis;
	private SimplePanel PanelScrollBar;
	
	public SplitLayoutPanelPublicCollection() {
		
		if (FlagsDeApertura==null)
			FlagsDeApertura=new HashMap<ElementType, Boolean>();
		
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
		
		OEThis=this;
		
		
		Tree ArbolAGenerar = new Tree();
		ArbolAGenerar.addSelectionHandler(new SelectionHandler<TreeItem>() {


			public void onSelection(SelectionEvent<TreeItem> event) {
				if (event.getSelectedItem() instanceof TreeItemMetaVisualize)  
					{
					Pila_de_cerrado=new Stack<PopupPanel>();
					ElementType Element = ((TreeItemMetaVisualize)event.getSelectedItem()).getAttribute();
					Lista = ((TreeItemMetaVisualize)event.getSelectedItem()).getHijosRecurso();
					Path.setText(pathFather(Element));
					PanelRecursosActuales.clear();
					SB.setMaxValue(Lista.size()-1);
					SB.setValue(0);
					LastElement=0;
					showNextLista();
					setPageLabel(LastElement);
					PanelScrollBar.setWidget(SB);

					}
			}

		
		});
		ArbolAGenerar.addOpenHandler(new OpenHandler<TreeItem>() {
			public void onOpen(OpenEvent<TreeItem> event) {
				if (event.getTarget() instanceof TreeItemMetaControlledTermMetaVisualize)  
					{
					FlagsDeAperturaTerm.put(((TreeItemMetaControlledTermMetaVisualize)event.getTarget()).getTermino(),true);
					((TreeItemMetaControlledTermMetaVisualize)event.getTarget()).OpenSons();
					}
				else 
					if (event.getTarget() instanceof TreeItemMetaVisualize)
					{	
						FlagsDeApertura.put(((TreeItemMetaVisualize)event.getTarget()).getAttribute(),true);	
					((TreeItemMetaVisualize)event.getTarget()).OpenSons();
					}
					else if (event.getTarget() instanceof TreeItemMetaTextMetaVisualize)
					{	
						FlagsDeAperturaString.put(((TreeItemMetaTextMetaVisualize)event.getTarget()).getTextoPropio(),true);	
					((TreeItemMetaTextMetaVisualize)event.getTarget()).OpenSons();
					}
			}
		});
		
		ArbolAGenerar.addCloseHandler(new CloseHandler<TreeItem>() {
			
			@Override
			public void onClose(CloseEvent<TreeItem> event) {
				if (event.getTarget() instanceof TreeItemMetaControlledTermMetaVisualize)  
				FlagsDeAperturaTerm.put(((TreeItemMetaControlledTermMetaVisualize)event.getTarget()).getTermino(),false);

			else 
				if (event.getTarget() instanceof TreeItemMetaVisualize)
					FlagsDeApertura.put(((TreeItemMetaVisualize)event.getTarget()).getAttribute(),false);	
				else 
					if (event.getTarget() instanceof TreeItemMetaTextMetaVisualize)
						FlagsDeAperturaString.put(((TreeItemMetaTextMetaVisualize)event.getTarget()).getTextoPropio(),false);	
				
			}
		});
		ZonaArboles.setWidget(ArbolAGenerar);
		ArbolAGenerar.setSize("100%", "100%");
		
		TreeItemMetaVisualize.setListEntrada(coleccion.getEstructuras());
		
		if (coleccion!=null)
			processCollectionG(coleccion.getMetamodelGrammar(), ArbolAGenerar);
		
		
		
		DockLayoutPanel ZonaElementosActual = new DockLayoutPanel(Unit.PX);
		add(ZonaElementosActual);
		ZonaElementosActual.setSize("100%", "100%");
		
		VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		verticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		ZonaElementosActual.addNorth(verticalPanel, 48.0);
		verticalPanel.setSize("100%", "100%");
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		verticalPanel.add(horizontalPanel);
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
		
		PanelScrollBar = new SimplePanel();
		verticalPanel.add(PanelScrollBar);
		verticalPanel.setCellVerticalAlignment(PanelScrollBar, HasVerticalAlignment.ALIGN_MIDDLE);
		verticalPanel.setCellHorizontalAlignment(PanelScrollBar, HasHorizontalAlignment.ALIGN_CENTER);
		PanelScrollBar.setSize("100%", "100%");
		
		scrollElementos = new ScrollPanel();
		ZonaElementosActual.add(scrollElementos);
		scrollElementos.setSize("100%", "100%");
		
		PanelRecursosActuales = new VerticalPanel();
		scrollElementos.setWidget(PanelRecursosActuales);
		PanelRecursosActuales.setSize("100%", "100%");
		
		LastElement=0;
		SB=new SliderBarSimpleHorizontal(0, "100%", true);
		SB.setVisible(true);
		SB.setMinMarkStep(10);
		SB.addBarValueChangedHandler(new BarValueChangedHandler() {
			


			@Override
			public void onBarValueChanged(BarValueChangedEvent event) {
				if (PanelRecursosActuales!=null&&Lista!=null)
				{
				PanelRecursosActuales.clear();
				LastElement=event.getValue();
				OEThis.showNextLista();
				}
			}
		});

	}
	
	/**
	 * Procesa la lista de elementos sobre la base
	 * @param list
	 * @param arbolAGenerar 
	 */
	private void processCollection(
			List<Structure> list, Tree arbolAGenerar) {
		for (Structure atributo1 : list) {
			
			TreeItemMetaVisualize trtmNewItem;
			if ((atributo1 instanceof ElementType)
					&&(Oda2013OperatinoalViewStaticFunctions.isBrowseable(((ElementType)atributo1)))
					)
				{
				trtmNewItem = new TreeItemMetaVisualize((ElementType)atributo1,new ArrayList<Term>(),new ArrayList<String>());
				arbolAGenerar.addItem(trtmNewItem);
					if (atributo1 instanceof MetaControlled)
						processCollectionControlled(((MetaControlled) atributo1).getVocabulary(), trtmNewItem,trtmNewItem.getHijos());
						else
							if (atributo1 instanceof TextElementType)
								//{
								processCollectionText((TextElementType) trtmNewItem.getAttribute(), trtmNewItem,trtmNewItem.getHijos());
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
	 * Procesa la lista de elementos sobre la base
	 * @param list
	 * @param arbolAGenerar 
	 */
	private void processCollectionG(
			List<Grammar> list, Tree arbolAGenerar) {
		for (Grammar atributo1 : list) {
			
			TreeItemGrammarVisualize trtmNewItem;
			if (Oda2013OperatinoalViewStaticFunctions.isBrowseable(atributo1))
					
				{
				trtmNewItem = new TreeItemGrammarVisualize(atributo1);
				arbolAGenerar.addItem(trtmNewItem);
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
	 * @param coleccion the coleccion to set
	 * @param basePath the basePath to set
	 */
	public static void setColeccionAndBasePath(Collection coleccion) {
		SplitLayoutPanelPublicCollection.coleccion = coleccion;
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
	public static HashMap<ElementType, Boolean> getFlagsDeApertura() {
		return FlagsDeApertura;
	}

	/**
	 * @param flagsDeApertura the flagsDeApertura to set
	 */
	public static void setFlagsDeApertura(HashMap<ElementType, Boolean> flagsDeApertura) {
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
			TreeItemMetaVisualize padre,
			ArrayList<TreeItemMetaVisualize> hijosDelPadre) {
		for (Term Terminos : vocabulary.getList()) {
			TreeItemMetaVisualize trtmNewItem = new TreeItemMetaControlledTermMetaVisualize(padre.getAttribute(),Terminos,padre.getFiltro(),padre.getFiltroTexto());
			if (trtmNewItem.getHijosRecurso().size()!=0)
				{
				padre.addItem(trtmNewItem);
				hijosDelPadre.add(trtmNewItem);
				}
		}
		
		
		Boolean A=null;
		if (padre instanceof TreeItemMetaControlledTermMetaVisualize)  
			A = getFlagsDeAperturaTerm().get(((TreeItemMetaControlledTermMetaVisualize)padre).getTermino());
			
		else 
			if (padre instanceof TreeItemMetaVisualize)
				A = getFlagsDeApertura().get(padre.getAttribute());
			else 
				if (padre instanceof TreeItemMetaTextMetaVisualize)
					A = getFlagsDeAperturaString().get(((TreeItemMetaTextMetaVisualize) padre).getTextoPropio());

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
	public static void processCollection(List<Structure> list,
			TreeItemGrammarVisualize padre,
			ArrayList<TreeItemMetaVisualize> hijosDelPadre) {
		for (Structure atributoHijo : list) {
			
			TreeItemMetaVisualize trtmNewItem;
			if ((atributoHijo instanceof ElementType)
					&&(Oda2013OperatinoalViewStaticFunctions.isBrowseable((ElementType)atributoHijo))
					)
				{
				trtmNewItem = new TreeItemMetaVisualize((ElementType)atributoHijo,padre.getFiltro(),padre.getFiltroTexto());
				padre.addItem(trtmNewItem);
				hijosDelPadre.add(trtmNewItem);
				}
			else 

				processCollection(atributoHijo.getSons(), padre,hijosDelPadre);	

		}

		padre.setState(true, true);
		
		
	}
	
	
	/**
	 * Procesa lista cuando viene de un nodo hijo
	 * @param list
	 * @param padre
	 * @param hijosDelPadre
	 */
	public static void processCollection(List<Structure> list,
			TreeItemMetaVisualize padre,
			ArrayList<TreeItemMetaVisualize> hijosDelPadre) {
		for (Structure atributoHijo : list) {
			
			TreeItemMetaVisualize trtmNewItem;
			if ((atributoHijo instanceof ElementType)
					&&(Oda2013OperatinoalViewStaticFunctions.isBrowseable((ElementType)atributoHijo))
					)
				{
				trtmNewItem = new TreeItemMetaVisualize((ElementType)atributoHijo,padre.getFiltro(),padre.getFiltroTexto());
				padre.addItem(trtmNewItem);
				hijosDelPadre.add(trtmNewItem);
				}
			else 

				processCollection(atributoHijo.getSons(), padre,hijosDelPadre);	

		}
		
		Boolean A=null;
		if (padre instanceof TreeItemMetaControlledTermMetaVisualize)  
			A = getFlagsDeAperturaTerm().get(((TreeItemMetaControlledTermMetaVisualize)padre).getTermino());
			
		else 
			if (padre instanceof TreeItemMetaVisualize)
				A = getFlagsDeApertura().get(padre.getAttribute());
			else 
				if (padre instanceof TreeItemMetaTextMetaVisualize)
					A = getFlagsDeAperturaString().get(((TreeItemMetaTextMetaVisualize) padre).getTextoPropio());

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
	protected static ArrayList<Documents> FindResources(List<Documents> listEntrada,
			ElementType ElementoABuscar, ArrayList<Term> filtro,ArrayList<String> filtroTexto) {
		ArrayList<Documents> Salida = new ArrayList<Documents>();
		for (Documents resources : listEntrada) {
			for (Element valorDesc : resources.getDescription()) {
				if (valorDesc.getHastype()==ElementoABuscar)
					Salida.add(resources);
			}
		}
		
		HashSet<Documents> quitar=new HashSet<Documents>();
		for (Documents resources : Salida) {
			for (Term termino : filtro) {
				boolean encontrado=false;
				for (Element valorDesc : resources.getDescription()) {
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
		
		for (Documents resourcesAQuitar : quitar) {
			Salida.remove(resourcesAQuitar);
		}
		
		
		HashSet<Documents> quitarTexto = new HashSet<Documents>();
		for (Documents resources : Salida) {
			for (String testofiltro : filtroTexto) {
				boolean encontrado = false;
				for (Element valorDesc : resources.getDescription()) {
					if ((valorDesc instanceof TextElement)
							&& (((((TextElement) valorDesc).getHastype()
									.getName()) + (((TextElement) valorDesc)
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
		
		for (Documents resourcesAQuitar : quitarTexto) {
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
	public static void processCollectionText(TextElementType meta,
			TreeItemMetaVisualize padre,
			ArrayList<TreeItemMetaVisualize> hijos) {
		
		ArrayList<String> ResursorAptos=FindVocabularyText(meta);
		Collections.sort(ResursorAptos);
		for (String texto1 : ResursorAptos) {
			TreeItemMetaTextMetaVisualize TreeItem= new TreeItemMetaTextMetaVisualize(padre.getAttribute(),texto1,padre.getFiltro(),padre.getFiltroTexto());
			if (TreeItem.getHijosRecurso().size()!=0)
			{
			padre.addItem(TreeItem);
			hijos.add(TreeItem);
			}
		}
		
		
		Boolean A=null;
		if (padre instanceof TreeItemMetaControlledTermMetaVisualize)  
			A = getFlagsDeAperturaTerm().get(((TreeItemMetaControlledTermMetaVisualize)padre).getTermino());
			
		else 
			if (padre instanceof TreeItemMetaVisualize)
				A = getFlagsDeApertura().get(padre.getAttribute());
			else 
				if (padre instanceof TreeItemMetaTextMetaVisualize)
					A = getFlagsDeAperturaString().get(((TreeItemMetaTextMetaVisualize) padre).getTextoPropio());

		if (A!=null&&A)
		{
		padre.setState(true, true);
		}
		
	}

	private static ArrayList<String> FindVocabularyText(TextElementType meta) {
		
		HashSet<String> lista=new HashSet<String>();
		
		for (Documents recursopos : coleccion.getEstructuras()) {
			for (Element metavalorpos : recursopos.getDescription()) {
				if ((metavalorpos instanceof TextElement)&&(metavalorpos.getHastype()==meta))
					{
					String valor=((TextElement)metavalorpos).getValue();
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

	/**
	 *  Retorna el Texto que representa al path.
	 *  @return Texto cadena para el elemento
	 */
	private String pathFather(Structure entrada)
	{
		String DataShow;
		if (entrada instanceof ElementType)
			DataShow= ((ElementType) entrada).getName();
		else DataShow= Oda2013ConstantsInformation.ASTERISCO;
		
		if (entrada.getFather()!=null)
			return pathFather(entrada.getFather())+Oda2013ConstantsInformation.BARRAINVERTIDA+DataShow;
		else return DataShow;
	}
	
	private void showNextLista() {
		int actual = 0;
		int inicial=LastElement;
		for (int i = 0; i<10 && (LastElement+i) < Lista.size(); i++) {
			Documents recurso =Lista.get(LastElement+i);
			PanelRecursosActuales.add(new CompositeConstructDescription(recurso));
			actual++;
		}
		LastElement=LastElement+actual;
		setPageLabel(inicial);
	}
	
	private void setPageLabel(Integer inicio) {
		PageLabel.setText((inicio+1)+"/"+(LastElement));
		
	}

	
}
