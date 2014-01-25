/**
 * 
 */
package fdi.ucm.client.publiccolletions;

import java.util.ArrayList;
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
import fdi.ucm.shared.model.collection.grammar.Iterator;
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
					PopupPanelCentradoFrame P = new PopupPanelCentradoFrame(true);
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
		
		processSons();
		
		

		
	}





	/**
	 * Procesa los hijos a tratar sobre el panel que se incorporaran
	 * @param list
	 * @param panelA2
	 * @param ambitos 
	 */
	private void processSons() {
		for (Structure elementoHijo : Recurso.getDocument().getSons()) {
			
			if (elementoHijo instanceof ElementType && Oda2013OperatinoalViewStaticFunctions.isSummary((ElementType)elementoHijo))
			{
				CompositeDocumentDescriptionTabStructureSummary T=new CompositeDocumentDescriptionTabStructureSummary((ElementType)elementoHijo,Recurso,new ArrayList<Integer>() ,true);
				PanelA.add(T);
			} 
			else if (elementoHijo instanceof ElementType && !Oda2013OperatinoalViewStaticFunctions.isSummary((ElementType)elementoHijo))
			{
				CompositeDocumentDescriptionTabStructureSummary T=new CompositeDocumentDescriptionTabStructureSummary((ElementType)elementoHijo,Recurso,new ArrayList<Integer>() ,false);
				PanelA.add(T);
			} 
			else if (elementoHijo instanceof Iterator){
				CompositeDocumentDescriptionTabStructureSummary T=new CompositeDocumentDescriptionTabStructureSummary((Iterator)elementoHijo,Recurso,new ArrayList<Integer>() );
				PanelA.add(T);
			}
		}
		
	}





	@Override
	protected void onLoad() {
		super.onLoad();
		if (decoratorPanel.getOffsetWidth()>0)
			PanelGeneral2.setWidth((decoratorPanel.getOffsetWidth()-MaxWidth-13)+PX);
		
	}
	

}
