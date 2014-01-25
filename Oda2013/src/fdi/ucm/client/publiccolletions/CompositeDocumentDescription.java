/**
 * 
 */
package fdi.ucm.client.publiccolletions;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.ui.Composite;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.LoadEvent;
import com.google.gwt.event.dom.client.LoadHandler;
import com.google.gwt.user.client.ui.Frame;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Image;

import fdi.ucm.client.controller.Oda2013OperatinoalViewStaticFunctions;
import fdi.ucm.shared.model.collection.document.Documents;
import fdi.ucm.shared.model.collection.grammar.ElementType;
import fdi.ucm.shared.model.collection.grammar.Structure;

/**
 * Clase que implemeneta un elemento recurso de tipo composite para mostrar el elemento.
 * @author Joaquin Gayoso-Cabada
 *
 */
public class CompositeDocumentDescription extends Composite {

	private static final String SHOWMORE = "Show More";
	protected static final int MaxWidth = 50;
	private static final String PX = "PX";
//	private HashMap<ElementType, VerticalPanel> Pestanas;
	private SimplePanel PanelDecorador;
//	private HashMap<Element,CompositeTabElement> Procesados;
	private Documents Recurso;
//	private ArrayList<Element> vaciosCreados;
//	private ArrayList<ElementType> MetaOrden;
	private Image Icono;
	private String Destino;
	private String ImagenAsociada;
	private VerticalPanel PanelA;
	private SimplePanel PanelDelIcono;
	private DecoratorPanel decoratorPanel;
	private HorizontalPanel PanelGeneral;
	private VerticalPanel PanelGeneral2;

	public CompositeDocumentDescription(Documents recurso) {
		super();
//		Pestanas=new HashMap<ElementType, VerticalPanel>();
//		Procesados=new HashMap<Element,CompositeTabElement>();	
		Recurso=recurso;
//		vaciosCreados=new ArrayList<Element>();
//		MetaOrden=new ArrayList<ElementType>();
//		MetaPestanaATab=new HashMap<Meta, TabElement>();
		
		
		decoratorPanel = new DecoratorPanel();
		initWidget(decoratorPanel);
		decoratorPanel.setSize("100%", "100%");
		
		PanelGeneral2 = new VerticalPanel();
		decoratorPanel.setWidget(PanelGeneral2);
		PanelGeneral2.setSize("100%", "100%");
		
		PanelGeneral = new HorizontalPanel();
		PanelGeneral2.add(PanelGeneral);
		PanelGeneral.setSize("", "100%");
		
		PanelDelIcono = new SimplePanel();
		PanelGeneral.add(PanelDelIcono);
		//PanelDelIcono.setSize("", "");
		PanelGeneral.setCellVerticalAlignment(PanelDelIcono, HasVerticalAlignment.ALIGN_MIDDLE);
		
		String elementoIcono = Oda2013OperatinoalViewStaticFunctions.getIcon(recurso);
		
		
		Destino=Oda2013OperatinoalViewStaticFunctions.calculaDestino(elementoIcono);
		ImagenAsociada=Oda2013OperatinoalViewStaticFunctions.calculaImagenAsociada(elementoIcono);
		
		
		
		Icono = new Image(ImagenAsociada);
		PanelDelIcono.setWidget(Icono);
		Icono.setSize("100%", "100%");
		Icono.addLoadHandler(new LoadHandler() {
			
			@Override
			public void onLoad(LoadEvent event) {
				
				float porcent=Icono.getWidth()/MaxWidth;
				float Height = Icono.getHeight()/porcent;
				int height=Math.round(Height);
				String PX="px";
				Icono.setHeight(height+PX);
				Icono.setWidth(MaxWidth+PX);

				PanelDelIcono.setWidth(MaxWidth+PX);
				
				
				
				
			}
		});
		
		
		
		
		if (Destino!=null)
			Icono.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					PopupPanelCentrado P = new PopupPanelCentrado(true);
					Frame F = new Frame(Destino);
					P.add(F,Destino);
					P.center();
					
					
				}
			});
		
		
		SimplePanel PanelAmpliador = new SimplePanel();
		PanelGeneral.add(PanelAmpliador);
		PanelAmpliador.setSize("100%", "100%");
		
		
		VerticalPanel PanelContenedorDecoyBoton=new VerticalPanel();
		PanelAmpliador.add(PanelContenedorDecoyBoton);
		PanelContenedorDecoyBoton.setWidth("100%");

		
		PanelDecorador = new SimplePanel();
		PanelContenedorDecoyBoton.add(PanelDecorador);
		PanelDecorador.setSize("100%", "100%");
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		PanelContenedorDecoyBoton.add(horizontalPanel);
		
		SimplePanel Glue = new SimplePanel();
		horizontalPanel.add(Glue);
		Glue.setWidth("25px");
		
		Button OpenElement = new Button(SHOWMORE);
		horizontalPanel.add(OpenElement);
		OpenElement.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				PopupPanelDocumentDescriptor RPUP=new PopupPanelDocumentDescriptor(Recurso);
				SplitLayoutPanelPublicCollection.getPila_de_cerrado().add(RPUP);
				RPUP.center();
			}
		});
		

	
		Refresh();
		
	
		
//		PanelA = new VerticalPanel();
//		PanelA.setSize("100%", "100%");
//		
//		PanelDecorador.add(PanelA);
//		
//		Composite Descripcion=new CompositeDocumentDescriptionDescriptionTab(Recurso.getDescriptionText());
//		PanelA.add(Descripcion);
//		
//		
//		for (Structure MetaElem : Recurso.getDocument().getSons()) {
//				
//			if (MetaElem instanceof ElementType)
//				{
//				
//				Pestanas.put((ElementType) MetaElem, PanelA);
//				MetaOrden.add((ElementType) MetaElem);
//				}
//			else 
//				{
//				 procesaEstrella((Iterator)MetaElem);
//				}
//			
//
//		}
//		
//		
//	
//		
//		for (Element MetaValueD : recurso.getDescription()) {
//			if (!Procesados.containsKey(MetaValueD)&&(Oda2013OperatinoalViewStaticFunctions.isSummary(MetaValueD)))
//					procesa(MetaValueD);
//		}
//		
		

	}





	/**
	 * Refresca los datos.
	 */
	private void Refresh() {


		PanelDecorador.clear();
		

		PanelA = new VerticalPanel();
		PanelA.setSize("100%", "100%");
		
		PanelDecorador.add(PanelA);
		
		Composite Descripcion=new CompositeDocumentDescriptionDescriptionTab(Recurso.getDescriptionText());
		PanelA.add(Descripcion);
		
		processSons(Recurso.getDocument().getSons(),PanelA);
		
		

		
	}





	/**
	 * Procesa los hijos a tratar sobre el panel que se incorporaran
	 * @param list
	 * @param panelA2
	 */
	private void processSons(List<Structure> list, VerticalPanel panelA2) {
		for (Structure elementoHijo : list) {
			
			if (elementoHijo instanceof ElementType && Oda2013OperatinoalViewStaticFunctions.isSummary((ElementType)elementoHijo))
			{
				CompositeDocumentDescriptionTabStructureSummary T=new CompositeDocumentDescriptionTabStructureSummary((ElementType)elementoHijo,Recurso,new ArrayList<Integer>());
				panelA2.add(T);
				processSons(elementoHijo.getSons(), T.getPanelHijos());
			} 
			else  processSons(elementoHijo.getSons(), panelA2);
			
		}
		
	}




//
//	/**
//	 * Funcion que procesa un recurso, creando el padre si este no existe.
//	 * @param metaValueD
//	 */
//	private CompositeTabElement procesa(Element metaValueD) {
//		
//		if (Pestanas.containsKey(metaValueD.getHastype()))
//		{
//			VerticalPanel A = Pestanas.get(metaValueD.getHastype());
//			CompositeTabElement nuevo= new CompositeTabElement(metaValueD);
//			A.add(nuevo);
//			Procesados.put(metaValueD, nuevo);
////			MetaPestanaATab.put(metaValueD.getHastype(), nuevo);
//			return nuevo;
//		}
//		else
//		{
//			ElementType Padre;
//			
//			Padre=FindPadreSummaryAscendente(metaValueD, metaValueD.getHastype());
//			
//			if (Pestanas.containsKey(Padre))
//				if (isSummaryMeta(Padre,metaValueD))
//					{
//					//Se retorno el padre por ser el padre
//						return procesosobremipadre(metaValueD,Padre);
//					}
//				else
//				{
//					Pestanas.put((ElementType) metaValueD.getHastype(), PanelA);
//					MetaOrden.add((ElementType) metaValueD.getHastype());
//					CompositeTabElement nuevo= new CompositeTabElement(metaValueD);
//					PanelA.add(nuevo);
//					Procesados.put(metaValueD, nuevo);
//					return nuevo;
//				}
//			else
//				{
//				return procesosobremipadre(metaValueD,Padre);
//				}
//			
//			
//			
//			}	
//		
//	}

//
//	/**
//	 * procesa si el padre es visible
//	 * @param padre
//	 * @param metaValueD 
//	 * @return
//	 */
//	private boolean isSummaryMeta(ElementType padre, Element metaValueD) {
//		Element PadreMV=findMetaValue(padre, metaValueD.getAmbitos());
//		if (PadreMV!=null)
//			return Oda2013OperatinoalViewStaticFunctions.isSummary(PadreMV);
//		else
//			return Oda2013OperatinoalViewStaticFunctions.isSummary(padre);
//				
//	}
//
//


//
//
//	/**
//	 * Procesa un elemto sobre su padre
//	 * @param metaValueD
//	 * @param padre
//	 * @return 
//	 */
//	private CompositeTabElement procesosobremipadre(Element metaValueD, ElementType padre) {
//		Element PadreValue=findMetaValue(padre,metaValueD.getAmbitos());
//		
//		CompositeTabElement PadreTab;
//		if (PadreValue==null)
//		{
//			
//			Element MV=getMetavalueVacio(padre,metaValueD.getAmbitos());
//			if (MV==null)
//			{
//				MV = new Element(padre);
//				for (Integer iterable_element :metaValueD.getAmbitos()) {
//					MV.getAmbitos().add(iterable_element.intValue());
//				}
//				vaciosCreados.add(MV);
//				PadreTab=procesa(MV);
//				
//			}
//			else
//			{
//				PadreTab=Procesados.get(MV);
//			}
//		
//		}
//		else{
//		
//		 PadreTab = Procesados.get(PadreValue);
//
//		 if (PadreTab==null)
//				{
//			 		PadreTab=procesa(PadreValue);
//				}
//		}
//		
//		VerticalPanel A = PadreTab.getPanelHijos();	
//		CompositeTabElement nuevo= new CompositeTabElement(metaValueD);
//		A.add(nuevo);
//		Procesados.put(metaValueD, nuevo);
//		return nuevo;
//		
//	}
//
//	/**
//	 * Busca al padre que ademas de se meta sea summary
//	 * @param metaValueD
//	 * @return
//	 */
//	private ElementType FindPadreSummaryAscendente(Element metaValueD,ElementType Metain) {
//		
//		ElementType Padre;
//		
//		if (Metain.getFather()==null)
//			return Metain;
//		
//		if (Metain.getFather() instanceof ElementType)
//			Padre=(ElementType) Metain.getFather();
//		else 
//			Padre=findMeta((Iterator) Metain.getFather());
//		
//		Element PadreMV=findMetaValue(Padre, metaValueD.getAmbitos());
//		
//		
//		
//		if (PadreMV!=null)
//			if (Oda2013OperatinoalViewStaticFunctions.isSummary(PadreMV))
//				return Padre;
//			else 
//				return FindPadreSummaryAscendente(PadreMV,PadreMV.getHastype());
//		else
//			if (Oda2013OperatinoalViewStaticFunctions.isSummary(Padre))
//				return Padre;
//			else 
//				return FindPadreSummaryAscendente(metaValueD,Padre);
//
//	}
//
//
//
//
//
//	private Element getMetavalueVacio(ElementType padre, ArrayList<Integer> ambitos) {
//		for (Element vaciosCandidato : vaciosCreados) {
//			if ((vaciosCandidato.getHastype()==padre)&&(checkAmbitos(vaciosCandidato.getAmbitos(),ambitos)))
//				return vaciosCandidato;
//		}
//		
//		return null;
//	}
//
//	/**
//	 * Busca un MetaValue en la lista de recursos
//	 * @param element
//	 * @param AmbitosElementoBase
//	 * @return
//	 */
//	private Element findMetaValue(ElementType element, ArrayList<Integer> AmbitosElementoBase) {
//		for (Element metaValuePro : Recurso.getDescription()) {
//			if ((metaValuePro.getHastype()==element)&&(checkAmbitos(metaValuePro.getAmbitos(),AmbitosElementoBase)))
//				return metaValuePro;
//		}
//		return null;
//	}
//
//	
//	/**
//	 * Chequea si las dos listas de ambitos coinciden, la segunda es la que ha de ser mayor ( mas profunda ) que la primera ( padre )
//	 * @param ambitos ambitos del padre a chequear
//	 * @param AmbitosElementoBase ambitos del hijo
//	 * @return
//	 */
//	private boolean checkAmbitos(ArrayList<Integer> ambitos,
//			ArrayList<Integer> AmbitosElementoBase) {
//		
//		if (ambitos.size()>AmbitosElementoBase.size())
//			return false;
//		
//		for (int i = 0; i < AmbitosElementoBase.size(); i++) {
//			
//			if ((ambitos.size()>i)&&(AmbitosElementoBase.get(i)!=null)&&(ambitos.get(i)!=null)&&(AmbitosElementoBase.get(i).intValue()!=ambitos.get(i).intValue()))
//				return false;
//		}
//		
//		return true;
//	}
//
//	/**
//	 * Busca el padre del elemento en Meta mas cercano hacia arriba en el arbol
//	 * @param IteradorProcesar
//	 * @return Meta mas cercano hacia arrriba en el arbol.
//	 */
//	private ElementType findMeta(Iterator IteradorProcesar) {
//		if (IteradorProcesar.getFather()==null)
//			return null;
//		if (IteradorProcesar.getFather() instanceof ElementType)
//			return (ElementType) IteradorProcesar.getFather();
//		else return findMeta((Iterator)IteradorProcesar.getFather());
//	}
//

//	/**
//	 * Mecanismo de proceso de un atributo estrella para la creacion de las pestañas
//	 * @param metaElem
//	 */
//	private void procesaEstrella(Iterator metaElem) {
//		for (Structure MetaElem : metaElem.getSons()) {
//			
//			if (MetaElem instanceof ElementType)
//				{
////				VerticalPanel PanelA = new VerticalPanel();
////				PanelA.setSize("100%", "100%");
//				Pestanas.put((ElementType) MetaElem, PanelA);
//				MetaOrden.add((ElementType) MetaElem);
//				}
//			else 
//				{
//				 procesaEstrella((Iterator)MetaElem);
//				}
//			
//
//		}
//		
//	}


	@Override
	protected void onLoad() {
		super.onLoad();
		if (decoratorPanel.getOffsetWidth()>0)
			PanelGeneral2.setWidth((decoratorPanel.getOffsetWidth()-MaxWidth-13)+PX);
		
	}
	

}
