/**
 * 
 */
package fdi.ucm.client.publiccolletions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.PopupPanel;

import fdi.ucm.client.controller.Oda2013OperatinoalViewStaticFunctions;
import fdi.ucm.shared.model.collection.document.Documents;
import fdi.ucm.shared.model.collection.document.Element;
import fdi.ucm.shared.model.collection.document.Resources;
import fdi.ucm.shared.model.collection.grammar.ElementType;
import fdi.ucm.shared.model.collection.grammar.Grammar;
import fdi.ucm.shared.model.collection.grammar.Iterator;
import fdi.ucm.shared.model.collection.grammar.Structure;

import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.DecoratedTabPanel;
import com.google.gwt.user.client.ui.Frame;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.LoadEvent;
import com.google.gwt.event.dom.client.LoadHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Image;

/**
 * Panel PopUp que muestra el objeto en funcion del valor de referencia,
 * @author Joaquin Gayoso-Cabada
 *
 */
public class PopupPanelConstructDescriptor extends PopupPanel implements PoupPanelInterfaceCerrableGrupo{

	
	private static final String X = "X";
	private HashMap<ElementType, VerticalPanel> Pestanas;
	private ArrayList<ElementType> MetaOrden;
	private DecoratedTabPanel PanelDecorador;
	private HashMap<Element,CompositeTabElement> Procesados;
	private Documents Recurso;
	private ArrayList<Element> vaciosCreados;
	private boolean AllClose;
	private  HashMap<ElementType, CompositeTabElement> MetaPestanaATab;
	private String Destino;
	private String ImagenAsociada;
	private Image Icono;
	protected static final int MaxHeight = 200;

	
	public PopupPanelConstructDescriptor(Documents value) {
		setAutoHideEnabled(true);
		setModal(true);
		AllClose=true;
		AbsolutePanel General=new AbsolutePanel();
		setAnimationEnabled(true);
		setGlassEnabled(true);
		int Width = Window.getClientWidth();
		int Heigh = Window.getClientHeight();
		
		if (Width>200)
			Width=Width-100;
		if (Heigh>200)
			Heigh=Heigh-100;
		
		setSize(Width+"px", Heigh+"px");
		Pestanas=new HashMap<ElementType, VerticalPanel>();
		MetaOrden= new ArrayList<ElementType>();
		Procesados=new HashMap<Element,CompositeTabElement>();	
		Recurso=value;
		vaciosCreados=new ArrayList<Element>();
		MetaPestanaATab=new HashMap<ElementType, CompositeTabElement>();
		setWidget(General);
		
		HorizontalPanel PanelGeneral = new HorizontalPanel();
		General.add(PanelGeneral);
		PanelGeneral.setSize("100%", "100%");
		
		SimplePanel simplePanel_1 = new SimplePanel();
		PanelGeneral.add(simplePanel_1);
		simplePanel_1.setSize("100%", "100%");
		
		PanelDecorador = new DecoratedTabPanel();
		simplePanel_1.setWidget(PanelDecorador);
		PanelDecorador.setSize("100%", "100%");
		
		SimplePanel simplePanel = new SimplePanel();
		PanelGeneral.add(simplePanel);
		PanelGeneral.setCellVerticalAlignment(simplePanel, HasVerticalAlignment.ALIGN_MIDDLE);
		PanelGeneral.setCellHorizontalAlignment(simplePanel, HasHorizontalAlignment.ALIGN_CENTER);
		
		VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		verticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		simplePanel.setWidget(verticalPanel);
		verticalPanel.setSize("100%", "100%");
		

		
		Resources elementoIcono = Oda2013OperatinoalViewStaticFunctions.getIcon(value);
		
		Destino=Oda2013OperatinoalViewStaticFunctions.calculaDestino(elementoIcono);
		ImagenAsociada=Oda2013OperatinoalViewStaticFunctions.calculaImagenAsociada(elementoIcono);
		
		Icono = new Image(ImagenAsociada);
		verticalPanel.add(Icono);
		Icono.addLoadHandler(new LoadHandler() {
			
			@Override
			public void onLoad(LoadEvent event) {
				float porcent=Icono.getHeight()/MaxHeight;
				float Width = Icono.getWidth()/porcent;
				int width=Math.round(Width);
				String PX="px";
				Icono.setHeight(MaxHeight+PX);
				Icono.setWidth(width+PX);
				
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
		
		
		
		SimplePanel horizontalPanel = new SimplePanel();
		General.add(horizontalPanel,Width-60,0);
		
		Button btnNewButton = new Button(X);
		btnNewButton.setStyleName("gwt-Button2");
		btnNewButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				AllClose=false;
				hide();
			}
		});
		horizontalPanel.setWidget(btnNewButton);
		btnNewButton.setWidth("50px");
		
		for (Grammar MetaElem : SplitLayoutPanelPublicCollection.getColeccion().getMetamodelGrammar()) {
			
			if (MetaElem instanceof ElementType)
				{
				VerticalPanel PanelA = new VerticalPanel();
				Pestanas.put((ElementType) MetaElem, PanelA);
				MetaOrden.add((ElementType) MetaElem);
				procesaHijosMeta(MetaElem.getSons());
				}
			else 
				{
				 procesaEstrella((Iterator)MetaElem);
				}
			

		}
		
		
		for (Element MetaValueD : Recurso.getDescription()) {
			if (!Procesados.containsKey(MetaValueD)&&(Oda2013OperatinoalViewStaticFunctions.isVisible(MetaValueD)))
					procesa(MetaValueD);
		}
		
		
		
		
		for (ElementType MetaActual : MetaOrden) {
			VerticalPanel res=Pestanas.get(MetaActual);
			if (res.getWidgetCount()>0)
				{
				ScrollPanel panelScrollVertical = new ScrollPanel();
//				int WidthScroll = Width-10;
				int HeighScroll = Heigh-37;
//				panelScrollVertical.setSize(WidthScroll+"px", HeighScroll+"px");
				panelScrollVertical.setSize("100%", HeighScroll+"px");
				PanelDecorador.add(panelScrollVertical, MetaActual.getName(), true);
				if (Oda2013OperatinoalViewStaticFunctions.NotBasic(MetaActual))
					panelScrollVertical.add(res);
				else
					{
					CompositeTabElement T=MetaPestanaATab.get(MetaActual);
					panelScrollVertical.add(T.getPanelHijos());
					}
				
				}
		}
		
//		for (Entry<Meta, VerticalPanel> PanelPestanas : Pestanas.entrySet()) {
//			if (PanelPestanas.getValue().getWidgetCount()>0)
//				{
//				ScrollPanel panelScrollVertical = new ScrollPanel();
//				panelScrollVertical.setSize("914px", "451px");
//				PanelDecorador.add(panelScrollVertical, PanelPestanas.getKey().getName(), true);
//				panelScrollVertical.add(PanelPestanas.getValue());
//				}
//		}
		
		if (PanelDecorador.getWidgetCount()>0)
			PanelDecorador.selectTab(0);
		
		
	}
	
	

	/**
	 * Funcion que procesa un recurso, creando el padre si este no existe.
	 * @param metaValueD
	 */
	private CompositeTabElement procesa(Element metaValueD) {
		
		if (Pestanas.containsKey(metaValueD.getHastype()))
		{
			
			VerticalPanel A = Pestanas.get(metaValueD.getHastype());
			CompositeTabElement nuevo= new CompositeTabElement(metaValueD);
			A.add(nuevo);
			Procesados.put(metaValueD, nuevo);
			MetaPestanaATab.put(metaValueD.getHastype(), nuevo);
			return nuevo;
		}
		else
		{
			ElementType Padre;
			
			
			Padre=FindPadreVisibleAscendente(metaValueD,metaValueD.getHastype());
			
			if (Pestanas.containsKey(Padre))
				if (isVisibleMeta(Padre,metaValueD))
					{
					//Se retorno el padre por ser el padre
						return procesosobremipadre(metaValueD,Padre);
					}
				else
				{
					VerticalPanel PanelA = new VerticalPanel();
					Pestanas.put((ElementType) metaValueD.getHastype(), PanelA);
					MetaOrden.add((ElementType) metaValueD.getHastype());
					CompositeTabElement nuevo= new CompositeTabElement(metaValueD);
					PanelA.add(nuevo);
					Procesados.put(metaValueD, nuevo);
					return nuevo;
				}
			else
				{
				return procesosobremipadre(metaValueD,Padre);
				}
			
			
			
			
			}	
		
	}
	
	
	/**
	 * procesa si el padre es visible
	 * @param padre
	 * @param metaValueD 
	 * @return
	 */
	private boolean isVisibleMeta(ElementType padre, Element metaValueD) {
		Element PadreMV=findMetaValue(padre, metaValueD.getAmbitos());
		if (PadreMV!=null)
			return Oda2013OperatinoalViewStaticFunctions.isVisible(PadreMV);
		else
			return Oda2013OperatinoalViewStaticFunctions.isVisible(padre);
				
	}


	/**
	 * Procesa un elemto sobre su padre
	 * @param metaValueD
	 * @param padre
	 * @return 
	 */
	private CompositeTabElement procesosobremipadre(Element metaValueD, ElementType padre) {
		
		Element PadreValue=findMetaValue(padre,metaValueD.getAmbitos());
		CompositeTabElement PadreTab;
		if (PadreValue==null)
		{
			
			Element MV=getMetavalueVacio(padre,metaValueD.getAmbitos());
			if (MV==null)
			{
				MV = new Element(padre);
				for (Integer iterable_element :metaValueD.getAmbitos()) {
					MV.getAmbitos().add(iterable_element.intValue());
				}
				vaciosCreados.add(MV);
				PadreTab=procesa(MV);
				
			}
			else
			{
				PadreTab=Procesados.get(MV);
			}
		
		}
		else{
		
		 PadreTab = Procesados.get(PadreValue);

		 if (PadreTab==null)
				{
			 		PadreTab=procesa(PadreValue);
				}
		}
		
		VerticalPanel A = PadreTab.getPanelHijos();	
		CompositeTabElement nuevo= new CompositeTabElement(metaValueD);
		A.add(nuevo);
		Procesados.put(metaValueD, nuevo);
		return nuevo;
		
	}

	/**
	 * Busca al padre que ademas de se meta sea summary
	 * @param metaValueD
	 * @return
	 */
	private ElementType FindPadreVisibleAscendente(Element metaValueD,ElementType Metain) {
		
		ElementType Padre;
		
		if (Metain.getFather()==null)
			return Metain;
		
		if (Metain.getFather() instanceof ElementType)
			Padre=(ElementType) Metain.getFather();
		else 
			Padre=findMeta((Iterator) Metain.getFather());
		
		Element PadreMV=findMetaValue(Padre, metaValueD.getAmbitos());
		
		
		
		if (PadreMV!=null)
			if (Oda2013OperatinoalViewStaticFunctions.isVisible(PadreMV))
				return Padre;
			else 
				return FindPadreVisibleAscendente(PadreMV,PadreMV.getHastype());
		else
			if (Oda2013OperatinoalViewStaticFunctions.isVisible(Padre))
				return Padre;
			else 
				return FindPadreVisibleAscendente(metaValueD,Padre);

	}

	/**
	 * Genera Metavalue vacio
	 * @param padre
	 * @param ambitos
	 * @return
	 */
	private Element getMetavalueVacio(ElementType padre, ArrayList<Integer> ambitos) {
		for (Element vaciosCandidato : vaciosCreados) {
			if ((vaciosCandidato.getHastype()==padre)&&(checkAmbitos(vaciosCandidato.getAmbitos(),ambitos)))
				return vaciosCandidato;
		}
		
		return null;
	}

	/**
	 * Busca un MetaValue en la lista de recursos
	 * @param element
	 * @param AmbitosElementoBase
	 * @return
	 */
	private Element findMetaValue(ElementType element, ArrayList<Integer> AmbitosElementoBase) {
		for (Element metaValuePro : Recurso.getDescription()) {
			if ((metaValuePro.getHastype()==element)&&(checkAmbitos(metaValuePro.getAmbitos(),AmbitosElementoBase)))
				return metaValuePro;
		}
		return null;
	}

	
	/**
	 * Chequea si las dos listas de ambitos coinciden, la segunda es la que ha de ser mayor ( mas profunda ) que la primera ( padre )
	 * @param ambitos ambitos del padre a chequear
	 * @param AmbitosElementoBase ambitos del hijo
	 * @return
	 */
	private boolean checkAmbitos(ArrayList<Integer> ambitos,
			ArrayList<Integer> AmbitosElementoBase) {
		
		if (ambitos.size()>AmbitosElementoBase.size())
			return false;
		
		for (int i = 0; i < AmbitosElementoBase.size(); i++) {
			if ((ambitos.size()>i)&&(AmbitosElementoBase.get(i)!=null)&&(ambitos.get(i)!=null)&&(AmbitosElementoBase.get(i).intValue()!=ambitos.get(i).intValue()))
				return false;
		}
		
		return true;
	}

	/**
	 * Busca el padre del elemento en Meta mas cercano hacia arriba en el arbol
	 * @param IteradorProcesar
	 * @return Meta mas cercano hacia arrriba en el arbol.
	 */
	private ElementType findMeta(Iterator IteradorProcesar) {
		if (IteradorProcesar.getFather() instanceof ElementType)
			return (ElementType) IteradorProcesar.getFather();
		else return findMeta((Iterator)IteradorProcesar.getFather());
	}


	/**
	 * Mecanismo de proceso de un atributo estrella para la creacion de las pestañas
	 * @param metaElem
	 */
	private void procesaEstrella(Iterator metaElem) {
		for (Structure MetaElem : metaElem.getSons()) {
			
			if (MetaElem instanceof ElementType)
				{
				VerticalPanel PanelA = new VerticalPanel();
				PanelA.setSize("100%", "100%");
				Pestanas.put((ElementType) MetaElem, PanelA);
				MetaOrden.add((ElementType) MetaElem);
				procesaHijosMeta(MetaElem.getSons());
				}
			else 
				{
				 procesaEstrella((Iterator)MetaElem);
				}
			

		}
		
	}
	
	/**
	 * Procesa los hijos meta para hacer pestañas
	 * @param sons
	 */
	private void procesaHijosMeta(List<Structure> sons) {
		for (Structure MetaElem : sons) {
			
			if (MetaElem instanceof ElementType && !Oda2013OperatinoalViewStaticFunctions.NotBasic((ElementType) MetaElem))
				{
				VerticalPanel PanelA = new VerticalPanel();
				Pestanas.put((ElementType) MetaElem, PanelA);
				MetaOrden.add((ElementType) MetaElem);
				}
			else if (MetaElem instanceof Iterator)
				{
				 procesaHijosMetaEstrella((Iterator)MetaElem);
				}
			

		}
		
	}





	/**
	 * Procesa los hijos estrella de manera unitaria
	 * @param metaElem
	 */
	private void procesaHijosMetaEstrella(Iterator metaElem) {
		for (Structure MetaElem : metaElem.getSons()) {
			
			if (MetaElem instanceof ElementType && !Oda2013OperatinoalViewStaticFunctions.NotBasic((ElementType) MetaElem))
				{
				VerticalPanel PanelA = new VerticalPanel();
//				PanelA.setSize("100%", "100%");
				Pestanas.put((ElementType) MetaElem, PanelA);
				MetaOrden.add((ElementType) MetaElem);
				}
			else if (MetaElem instanceof Iterator)
				{
				procesaHijosMetaEstrella((Iterator)MetaElem);
				}
			

		}
		
	}
	
	@Override
	public void hide() {
		super.hide();
	}

	@Override
	public void hide(boolean autoClosed) {
		super.hide(autoClosed);
		if (AllClose)
			while (!SplitLayoutPanelPublicCollection.getPila_de_cerrado().isEmpty())
			{
				PoupPanelInterfaceCerrableGrupo RPP=(PoupPanelInterfaceCerrableGrupo) SplitLayoutPanelPublicCollection.getPila_de_cerrado().pop();
				RPP.setAllClose(false);
				((PopupPanel)RPP).hide();
			}
	}
	/**
	 * @return the allClose
	 */
	public boolean isAllClose() {
		return AllClose;
	}

	/**
	 * @param allClose the allClose to set
	 */
	public void setAllClose(boolean allClose) {
		AllClose = allClose;
	}


	
	
}
