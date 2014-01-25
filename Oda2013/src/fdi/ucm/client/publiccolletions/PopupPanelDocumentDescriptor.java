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
import fdi.ucm.shared.model.collection.grammar.ElementType;
import fdi.ucm.shared.model.collection.grammar.Iterator;
import fdi.ucm.shared.model.collection.grammar.Structure;

import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratedTabPanel;
import com.google.gwt.user.client.ui.Frame;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.VerticalPanel;
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
public class PopupPanelDocumentDescriptor extends PopupPanel implements InterfacePoupPanelCerrableGrupo{

	
	private static final String X = "X";
	private DecoratedTabPanel PanelDecorador;
	private Documents Recurso;
	private boolean AllClose;
	private String Destino;
	private String ImagenAsociada;
	private Image Icono;
	private VerticalPanel PanelA;
	private int Heigh;
	protected static final int MaxHeight = 200;

	
	public PopupPanelDocumentDescriptor(Documents value) {
		setAutoHideEnabled(true);
		setModal(true);
		AllClose=true;
		AbsolutePanel General=new AbsolutePanel();
		setAnimationEnabled(true);
		setGlassEnabled(true);
		int Width = Window.getClientWidth();
		Heigh = Window.getClientHeight();
		
		if (Width>200)
			Width=Width-100;
		if (Heigh>200)
			Heigh=Heigh-100;
		
		setSize(Width+"px", Heigh+"px");
		new HashMap<ElementType, VerticalPanel>();
		new ArrayList<ElementType>();
		new HashMap<Element,CompositeTabElement>();	
		Recurso=value;
		new ArrayList<Element>();
		new HashMap<ElementType, CompositeTabElement>();
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
		

		
		String elementoIcono = Oda2013OperatinoalViewStaticFunctions.getIcon(value);
		
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
		
		
		Refresh();
		
//		PanelGrammar = new VerticalPanel();
//			procesaHijosMeta(Recurso.getDocument().getSons());
//		
//			Composite Descripcion=new CompositeDocumentDescriptionDescriptionTab(Recurso.getDescriptionText());
//			PanelGrammar.add(Descripcion);
////		
////		for (Grammar MetaElem : SplitLayoutPanelPublicCollection.getColeccion().getMetamodelGrammar()) {
////			
////			if (MetaElem instanceof ElementType)
////				{
////				VerticalPanel PanelA = new VerticalPanel();
////				Pestanas.put((ElementType) MetaElem, PanelA);
////				MetaOrden.add((ElementType) MetaElem);
////				procesaHijosMeta(MetaElem.getSons());
////				}
////			else 
////				{
////				 procesaEstrella((Iterator)MetaElem);
////				}
////			
////
////		}
////		
//		
//		for (Element MetaValueD : Recurso.getDescription()) {
//			if (!Procesados.containsKey(MetaValueD)&&(Oda2013OperatinoalViewStaticFunctions.isVisible(MetaValueD)))
//					procesa(MetaValueD);
//		}
//		
//		
//
//		if (PanelGrammar.getWidgetCount()>0)
//		{
//		ScrollPanel panelScrollVertical = new ScrollPanel();
//		panelScrollVertical.setSize("100%","100%");
//		PanelDecorador.add(panelScrollVertical, Recurso.getDocument().getNombre(), true); 
//			panelScrollVertical.add(PanelGrammar);
//
//		}
//		
//		for (ElementType MetaActual : MetaOrden) {
//			VerticalPanel res=Pestanas.get(MetaActual);
//			if (res.getWidgetCount()>0)
//				{
//				ScrollPanel panelScrollVertical = new ScrollPanel();
////				int WidthScroll = Width-10;
//				int HeighScroll = Heigh-37;
////				panelScrollVertical.setSize(WidthScroll+"px", HeighScroll+"px");
//				panelScrollVertical.setSize("100%", HeighScroll+"px");
//				PanelDecorador.add(panelScrollVertical, MetaActual.getName(), true);
//				if (Oda2013OperatinoalViewStaticFunctions.NotBasic(MetaActual))
//					panelScrollVertical.add(res);
//				else
//					{
//					CompositeTabElement T=MetaPestanaATab.get(MetaActual);
//					panelScrollVertical.add(T.getPanelHijos());
//					}
//				
//				}
//		}
//		
////		for (Entry<Meta, VerticalPanel> PanelPestanas : Pestanas.entrySet()) {
////			if (PanelPestanas.getValue().getWidgetCount()>0)
////				{
////				ScrollPanel panelScrollVertical = new ScrollPanel();
////				panelScrollVertical.setSize("914px", "451px");
////				PanelDecorador.add(panelScrollVertical, PanelPestanas.getKey().getName(), true);
////				panelScrollVertical.add(PanelPestanas.getValue());
////				}
////		}
		
		if (PanelDecorador.getWidgetCount()>0)
			PanelDecorador.selectTab(0);
		
		
	}
	
	

	private void Refresh() {
	
		PanelA = new VerticalPanel();
		PanelA.setSize("100%", "100%");
		
		ScrollPanel panelScrollVertical = new ScrollPanel();
		int HeighScroll = Heigh-37;
	panelScrollVertical.setSize("100%", HeighScroll+"px");
	PanelDecorador.add(panelScrollVertical, Recurso.getDocument().getNombre(), true);
		
	panelScrollVertical.add(PanelA);
		
		Composite Descripcion=new CompositeDocumentDescriptionDescriptionTab(Recurso.getDescriptionText());
		PanelA.add(Descripcion);
		
		processSonGrammar();
		
	}



	private void processSonGrammar() {

		for (Structure elementoHijo : Recurso.getDocument().getSons()) {
			
			if (elementoHijo instanceof ElementType &&Oda2013OperatinoalViewStaticFunctions.NotBasic((ElementType)elementoHijo) && Oda2013OperatinoalViewStaticFunctions.isVisible((ElementType)elementoHijo))
			{
				CompositeDocumentDescriptionTabStructureVisible T=new CompositeDocumentDescriptionTabStructureVisible((ElementType)elementoHijo,Recurso,new ArrayList<Integer>(),true,null);
				
				if (T.isActive())
				PanelA.add(T);
			} 
			else if (elementoHijo instanceof ElementType &&Oda2013OperatinoalViewStaticFunctions.NotBasic((ElementType)elementoHijo) &&!Oda2013OperatinoalViewStaticFunctions.isVisible((ElementType)elementoHijo))
			{
				CompositeDocumentDescriptionTabStructureVisible T=new CompositeDocumentDescriptionTabStructureVisible((ElementType)elementoHijo,Recurso,new ArrayList<Integer>(),false,null);
				if (T.isActive())
				PanelA.add(T);
			}
			else if (elementoHijo instanceof ElementType &&!Oda2013OperatinoalViewStaticFunctions.NotBasic((ElementType)elementoHijo) && Oda2013OperatinoalViewStaticFunctions.isVisible((ElementType)elementoHijo))
			{
				VerticalPanel PanelAA = new VerticalPanel();
				PanelAA.setSize("100%", "100%");
				
				ScrollPanel panelScrollVertical = new ScrollPanel();
				int HeighScroll = Heigh-37;
			panelScrollVertical.setSize("100%", HeighScroll+"px");
			PanelDecorador.add(panelScrollVertical, ((ElementType)elementoHijo).getName(), true);
				
			panelScrollVertical.add(PanelAA);
				
				
				processSons(elementoHijo.getSons(), PanelAA);
				
			}else if (elementoHijo instanceof ElementType &&!Oda2013OperatinoalViewStaticFunctions.NotBasic((ElementType)elementoHijo) && !Oda2013OperatinoalViewStaticFunctions.isVisible((ElementType)elementoHijo))
			{
				processSons(elementoHijo.getSons(), PanelA);
			}
			else if (elementoHijo instanceof Iterator)
			{
				CompositeDocumentDescriptionTabStructureVisible T=new CompositeDocumentDescriptionTabStructureVisible((Iterator)elementoHijo,Recurso,new ArrayList<Integer>());
				if (T.isActive())
				PanelA.add(T);
			}	
			
		}
		
	}



	private void processSons(List<Structure> sons, VerticalPanel panelHijos) {
		
	for (Structure elementoHijo : sons) {
			
		if (elementoHijo instanceof ElementType && Oda2013OperatinoalViewStaticFunctions.isVisible((ElementType)elementoHijo))
		{
			CompositeDocumentDescriptionTabStructureVisible T=new CompositeDocumentDescriptionTabStructureVisible((ElementType)elementoHijo,Recurso,new ArrayList<Integer>(),true,null);
			if (T.isActive())
			panelHijos.add(T);
		} 
		else if (elementoHijo instanceof ElementType &&!Oda2013OperatinoalViewStaticFunctions.isVisible((ElementType)elementoHijo))
		{
			CompositeDocumentDescriptionTabStructureVisible T=new CompositeDocumentDescriptionTabStructureVisible((ElementType)elementoHijo,Recurso,new ArrayList<Integer>(),false,null);
			if (T.isActive())
			panelHijos.add(T);
		}
		else if (elementoHijo instanceof Iterator)
		{
			CompositeDocumentDescriptionTabStructureVisible T=new CompositeDocumentDescriptionTabStructureVisible((Iterator)elementoHijo,Recurso,new ArrayList<Integer>());
			if (T.isActive())
			panelHijos.add(T);
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
				InterfacePoupPanelCerrableGrupo RPP=(InterfacePoupPanelCerrableGrupo) SplitLayoutPanelPublicCollection.getPila_de_cerrado().pop();
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
