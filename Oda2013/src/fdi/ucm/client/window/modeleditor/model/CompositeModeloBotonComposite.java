package fdi.ucm.client.window.modeleditor.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Widget;

import fdi.ucm.client.ConstantsInformation;
import fdi.ucm.client.window.modeleditor.EditorMainWindowEditor;
import fdi.ucm.shared.model.collection.CollectionAttribute;
import fdi.ucm.shared.model.collection.Iterator;
import fdi.ucm.shared.model.collection.meta.Meta;
import fdi.ucm.shared.model.collection.meta.MetaBoolean;
import fdi.ucm.shared.model.collection.meta.MetaControlled;
import fdi.ucm.shared.model.collection.meta.MetaDate;
import fdi.ucm.shared.model.collection.meta.MetaNumeric;
import fdi.ucm.shared.model.collection.meta.MetaRelation;
import fdi.ucm.shared.model.collection.meta.MetaText;

import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Image;

/**
 * Clase que representa un elemento del modelo de manera visual, ademas implementa 
 * @author Joaquin Gayoso-Cabada
 *
 */
public class CompositeModeloBotonComposite extends Composite{
	
//	private static final String X = "X";
	private static final String VOCABULARY = "V: ";
//	private static final String ONLY_CONTROLLED_ELEMENTS_HAS_VOCABULARY = "Only Controlled Elements has Vocabulary";
	private static final String IMGUP = "<img src=\"Direccionales/Arriba.gif\" >";
	private static final String IMGDOWN = "<img src=\"Direccionales/Abajo.gif\" >";
	private static final String IMGDER = "<img src=\"Direccionales/Derecha.gif\" >";
	private static final String IMGIZQ = "<img src=\"Direccionales/Izquierda.gif\" >";
	private static final String IMGOPEN = "<img src=\"Direccionales/menos.gif\" >";
	private static final String IMGCLOSE = "<img src=\"Direccionales/mas.gif\" >";
	private static final String IMGADD = "<img src=\"Direccionales/add.gif\" >";
	private static final String MORE_ELEMENTS_IN_FATHER = " more elements with the same name in father";
	private static final String LINEA_HORIZONTAL = "TreeKey/19.jpg";

	
	private CollectionAttribute ElementoBoton;
	private VerticalPanel SonsPanel;
	private EditorMainWindowEditor indexEntryPoint;
	private CompositeModeloBotonComposite yo;
	private Button Botonatributo;
	private enum StateEnum {open,close};
	private StateEnum State;
	private VerticalPanel PanelOcultable;
	private Button BotonAbrirCerrarLLaves;
	private VocabularyControlledModeloButton VocabularyButton;
	private HorizontalPanel Vocabulary;
	private VerticalPanel panelSeleccion;
	private CompositeModeloBotonComposite padreComposite;
	private VerticalPanel PanelBotonyLinea;
	private Image Linea;
	private Button Visible;
	
	
	/**
	 * Contructor de la clase por parametros.
	 * @param attHijo elemento a representar.
	 * @param panelSeleccionin panel de seleccion al pulsar el boton principal.
	 * @param indexEntryPointin Clase padre general para el refresco.
	 */
	public CompositeModeloBotonComposite(CollectionAttribute attHijo,VerticalPanel panelSeleccionin, EditorMainWindowEditor indexEntryPointin,CompositeModeloBotonComposite padreCompositein) {
		
		yo=this;
		ElementoBoton=attHijo;
		State=StateEnum.open;
		panelSeleccion=panelSeleccionin;
		padreComposite=padreCompositein;
		this.indexEntryPoint=indexEntryPointin;
		VerticalPanel verticalPanel = new VerticalPanel();
		initWidget(verticalPanel);
		verticalPanel.setSize("100%", "100%");
		
		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		horizontalPanel_1.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		verticalPanel.add(horizontalPanel_1);
		
		Vocabulary = new HorizontalPanel();
		Vocabulary.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel_1.add(Vocabulary);
		Vocabulary.setHeight("100%");
		
		
		PanelBotonyLinea = new VerticalPanel();
		Vocabulary.add(PanelBotonyLinea);
		
		Botonatributo = new Button();
		PanelBotonyLinea.add(Botonatributo);

		EditorMainWindowEditor.getBotonesAttributo().add(Botonatributo);
		
		
		Linea = new Image(LINEA_HORIZONTAL);
		Linea.setSize("100%", "12px");
		
		if ((attHijo instanceof Meta)&&(((Meta)attHijo).getSummary()))
		{
			showImage();
		}
		
		
		if (attHijo instanceof Meta)
			Botonatributo.setHTML(((Meta) attHijo).getName());
		else if (attHijo instanceof Iterator)
			Botonatributo.setHTML("*");
		
		if (attHijo instanceof Meta)
			Botonatributo.addDoubleClickHandler(new BotonesModeloDoubleClickHandler(panelSeleccion,yo));
		else if (attHijo instanceof Iterator)
				Botonatributo.addDoubleClickHandler(new BotonesModeloDoubleClickHandlerIterador(indexEntryPoint,yo));
		
		Button UpButton = new Button(IMGUP);
		horizontalPanel_1.add(UpButton);
		UpButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
					SwapUp();
			
			}
		});
		horizontalPanel_1.setCellVerticalAlignment(UpButton, HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel_1.setCellHorizontalAlignment(UpButton, HasHorizontalAlignment.ALIGN_CENTER);
		
		Button DownButton = new Button(IMGDOWN);
		horizontalPanel_1.add(DownButton);
		DownButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				SwapDown();
			}
		});
		horizontalPanel_1.setCellVerticalAlignment(DownButton, HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel_1.setCellHorizontalAlignment(DownButton, HasHorizontalAlignment.ALIGN_CENTER);
		
		Button PromotButton = new Button(IMGIZQ);
		PromotButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if (ElementoBoton.getFather()!=null)
				{
					if (!(ElementoBoton.getFather() instanceof Iterator))
					{
					ElementoBoton.getFather().getSons().remove(ElementoBoton);
					if (ElementoBoton.getFather().getFather()==null)
						{
						CollectionAttribute Padre = ElementoBoton.getFather();
						int position=GetPositionRoot(Padre);
						ElementoBoton.setFather(null);
						
						if (position>=EditorMainWindowEditor.getColeccionActual().getMetamodelSchemas().size())
							EditorMainWindowEditor.getColeccionActual().getMetamodelSchemas().add(ElementoBoton);
						else
						{
						ArrayList<CollectionAttribute> NuevaLista=new ArrayList<CollectionAttribute>();	
						for (int i = 0; i < EditorMainWindowEditor.getColeccionActual().getMetamodelSchemas().size(); i++) {
							if (i==position)
							{	
								NuevaLista.add(EditorMainWindowEditor.getColeccionActual().getMetamodelSchemas().get(i));
								NuevaLista.add(ElementoBoton);
								
							}
							else 
								NuevaLista.add(EditorMainWindowEditor.getColeccionActual().getMetamodelSchemas().get(i));
							
						}
						EditorMainWindowEditor.getColeccionActual().setMetamodelSchemas(NuevaLista);
						}
						indexEntryPoint.refreshModeloActual();
						
						}
					else
						{
						CollectionAttribute Padre = ElementoBoton.getFather();
						int position=GetPosition(Padre);
						CollectionAttribute PadreNew = Padre.getFather();
						
						if (position>=PadreNew.getSons().size())
							PadreNew.getSons().add(ElementoBoton);
						else
						{
						ArrayList<CollectionAttribute> NuevaLista=new ArrayList<CollectionAttribute>();	
						for (int i = 0; i < PadreNew.getSons().size(); i++) {
							if (i==position)
							{	
								NuevaLista.add(PadreNew.getSons().get(i));
								NuevaLista.add(ElementoBoton);
								
							}
							else 
								NuevaLista.add(PadreNew.getSons().get(i));
							
						}
						PadreNew.setSons(NuevaLista);
						}
						ElementoBoton.setFather(ElementoBoton.getFather().getFather());
						yo.getPadreComposite().getPadreComposite().ProcessSons(yo.getPadreComposite().getPadreComposite().getPanelSeleccion(), indexEntryPoint);
						EditorMainWindowEditor.processSize();
						}
					panelSeleccion.clear();
					
					}
					else Window.alert(ConstantsInformation.YOUR_ARE_IN_A_SCOPE_PROMOTE);
				}
				else Window.alert(ConstantsInformation.YOU_ARE_ON_TOP);
			}

			/**
			 * Da la posicion del elemento dentro del padre cuando un padre es el root.
			 * @param ElementoABuscar elemento a buscar la posicion dentro del padre.
			 * @return La posicion dentro del Root del elemento.
			 */
			private int GetPositionRoot(CollectionAttribute ElementoABuscar) {
				for (int i = 0; i < EditorMainWindowEditor.getColeccionActual().getMetamodelSchemas().size(); i++) {
					if (EditorMainWindowEditor.getColeccionActual().getMetamodelSchemas().get(i)==ElementoABuscar)
						return i;
				};
				return ElementoABuscar.getFather().getSons().size();
			}

			/**
			 * Da la posicion del elemento dentro del padre.
			 * @param ElementoABuscar elemento a buscar en la lista del padre.
			 * @return Posicion del elemento en la lista del padre
			 */
			private int GetPosition(CollectionAttribute ElementoABuscar) {
				for (int i = 0; i < ElementoABuscar.getFather().getSons().size(); i++) {
					if (ElementoABuscar.getFather().getSons().get(i)==ElementoABuscar)
						return i;
				};
				return ElementoABuscar.getFather().getSons().size();
			}
		});
		horizontalPanel_1.add(PromotButton);
		
		Button DegradeButton = new Button(IMGDER);
		DegradeButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				
				VerticalPanel V=(VerticalPanel)yo.getParent();
				CompositeModeloBotonComposite hermanoMayor=findHermanoMayor(V,yo);
				if (hermanoMayor==null)
					Window.alert(ConstantsInformation.YOU_ARE_NOT_DEGRADE_BROTHER);
				else 
				if (!(hermanoMayor.getElementoBoton() instanceof Iterator))
				{	
						
				if (ElementoBoton.getFather()==null)
						{
					EditorMainWindowEditor.getColeccionActual().getMetamodelSchemas().remove(ElementoBoton);
					ElementoBoton.setFather(hermanoMayor.getElementoBoton());
					hermanoMayor.getElementoBoton().getSons().add(ElementoBoton);
					indexEntryPoint.refreshModeloActual();
						}
					else {
						ElementoBoton.getFather().getSons().remove(ElementoBoton);
						ElementoBoton.setFather(hermanoMayor.getElementoBoton());
						hermanoMayor.getElementoBoton().getSons().add(ElementoBoton);
						yo.getPadreComposite().ProcessSons(hermanoMayor.getPanelSeleccion(), indexEntryPoint);
						EditorMainWindowEditor.processSize();
					}
			
				panelSeleccion.clear();
				}
				else Window.alert(ConstantsInformation.YOUR_ARE_IN_A_SCOPE_DEGRADE);
				
			}

			private CompositeModeloBotonComposite findHermanoMayor(
					VerticalPanel v, CompositeModeloBotonComposite yo) {
				CompositeModeloBotonComposite Final=null;
				for (int i = 0; i < v.getWidgetCount(); i++) {
					if (v.getWidget(i) instanceof CompositeModeloBotonComposite)
						if (((CompositeModeloBotonComposite)v.getWidget(i))==yo)
							return Final;
						else Final=(CompositeModeloBotonComposite)v.getWidget(i);
				}
				return null;
			}
		});
		horizontalPanel_1.add(DegradeButton);
		
		BotonAbrirCerrarLLaves = new Button(IMGOPEN);
		horizontalPanel_1.add(BotonAbrirCerrarLLaves);
			BotonAbrirCerrarLLaves.addClickHandler(new ClickHandler() {
				public void onClick(ClickEvent event) {
					if (State==StateEnum.open)
					{
						EditorMainWindowEditor.setState(ElementoBoton,false);
						State=StateEnum.close;
						PanelOcultable.setVisible(false);
						BotonAbrirCerrarLLaves.setHTML(IMGCLOSE);
						
					}
					else 
					{
						EditorMainWindowEditor.setState(ElementoBoton,true);
						BotonAbrirCerrarLLaves.setHTML(IMGOPEN);
						State=StateEnum.open;
						PanelOcultable.setVisible(true);
						ProcessSons(panelSeleccion,indexEntryPoint);
						EditorMainWindowEditor.processSize();
					}
				}
			});

		horizontalPanel_1.setCellVerticalAlignment(BotonAbrirCerrarLLaves, HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel_1.setCellHorizontalAlignment(BotonAbrirCerrarLLaves, HasHorizontalAlignment.ALIGN_CENTER);
		if (ElementoBoton instanceof MetaText)
			Botonatributo.addStyleName("gwt-LabelTextAttribute");
		else if (ElementoBoton instanceof MetaControlled)
			Botonatributo.addStyleName("gwt-LabelControlledAttribute");
		else if (ElementoBoton instanceof MetaDate)
			Botonatributo.addStyleName("gwt-LabelDateAttribute");
		else if (ElementoBoton instanceof MetaNumeric)
			Botonatributo.addStyleName("gwt-LabelNumericAttribute");
		else if (ElementoBoton instanceof MetaBoolean)
			Botonatributo.addStyleName("gwt-LabelBooleanAttribute");
		else if (ElementoBoton instanceof MetaRelation)
			Botonatributo.addStyleName("gwt-LabelRelationAttribute");
		else if (ElementoBoton instanceof Iterator)
			Botonatributo.addStyleName("gwt-LabelMultievaluado");

		if ((ElementoBoton instanceof Meta)&&(((Meta) ElementoBoton).getBrowseable()))
			Botonatributo.addStyleName("gwt-LabelNegrita");
		
		 PanelOcultable = new VerticalPanel();
		PanelOcultable.setStyleName("minimo40px");
		horizontalPanel_1.add(PanelOcultable);
		PanelOcultable.setHeight("100%");
		
		SimplePanel simplePanel_1 = new SimplePanel();
		simplePanel_1.setStyleName("backgroundKeyUp");
		PanelOcultable.add(simplePanel_1);
		PanelOcultable.setCellVerticalAlignment(simplePanel_1, HasVerticalAlignment.ALIGN_BOTTOM);
		simplePanel_1.setSize("40px", "25px");
		
		HorizontalPanel horizontalPanel_2 = new HorizontalPanel();
		horizontalPanel_2.setStyleName("backgroundKey");
		horizontalPanel_2.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		PanelOcultable.add(horizontalPanel_2);
		horizontalPanel_2.setHeight("100%");
		
		SimplePanel simplePanel = new SimplePanel();
		horizontalPanel_2.add(simplePanel);
		simplePanel.setWidth("19px");
		
		SonsPanel = new VerticalPanel();
		horizontalPanel_2.add(SonsPanel);
		SonsPanel.setSize("100%", "");
		
		
		
		if (ElementoBoton instanceof Meta)
		{
			Visible=new Button(" ");
			 Vocabulary.add(Visible);
		//	 Visible.setHeight("100%");
		 if (((Meta) ElementoBoton).getVisible())
			 Visible.addStyleName("vocabularyButton2");
		 else  Visible.addStyleName("vocabularyButton3");
		 	

			
		}
		
		
		
		if ( ElementoBoton instanceof MetaControlled )
		{
		int Voc=EditorMainWindowEditor.getVocabulario(((MetaControlled) ElementoBoton).getVocabulary());
		EditorMainWindowEditor.getListaVocabulary().put(yo, ((MetaControlled) ElementoBoton).getVocabulary());
		VocabularyButton = new VocabularyControlledModeloButton(Voc,((MetaControlled) ElementoBoton).getVocabulary(),yo);
		VocabularyButton.addStyleName("vocabularyButton");
		VocabularyButton.setHTML(VOCABULARY + Voc);
		Vocabulary.add(VocabularyButton);
		//Vocabulary.setHeight("100%");
		}
//		else
//		{
//			Button VocabularyOff=new Button(VOCABULARY+ X);
//			 Vocabulary.add(VocabularyOff);
//			 VocabularyOff.addClickHandler(new ClickHandler() {
//				
//				@Override
//				public void onClick(ClickEvent event) {
//					Window.alert(ONLY_CONTROLLED_ELEMENTS_HAS_VOCABULARY);
//					
//				}
//			});
//			 VocabularyOff.addStyleName("vocabularyButton");
//		}
		
		
		
		SimplePanel simplePanel_2 = new SimplePanel();
		simplePanel_2.setStyleName("backgroundKeyDown");
		PanelOcultable.add(simplePanel_2);
		simplePanel_2.setSize("40px", "25px");
		if (!EditorMainWindowEditor.getState(attHijo))
			{
			State=StateEnum.close;
			PanelOcultable.setVisible(false);
			BotonAbrirCerrarLLaves.setHTML(IMGCLOSE);
			}
		else {
			ProcessSons(panelSeleccion,indexEntryPoint);
		}

	}





	/**
	 * cambiar posiciones con el elemento inferior
	 */
	protected void SwapDown() {
		
		if (ElementoBoton.getFather()==null)
		{
		int pos=findme(EditorMainWindowEditor.getColeccionActual().getMetamodelSchemas());
		if (pos>=0)
			{
			CollectionAttribute Aux=EditorMainWindowEditor.getColeccionActual().getMetamodelSchemas().get(pos+1);
			EditorMainWindowEditor.getColeccionActual().getMetamodelSchemas().set(pos+1, ElementoBoton);
			EditorMainWindowEditor.getColeccionActual().getMetamodelSchemas().set(pos, Aux);		
			Swap(pos+1,pos+2,(VerticalPanel)yo.getParent());

			}
		}
	else{
		CollectionAttribute padre= ElementoBoton.getFather();
		int pos=findme(padre.getSons());
		if (pos<padre.getSons().size()-1)
		{
		CollectionAttribute Aux=padre.getSons().get(pos+1);
		padre.getSons().set(pos+1, ElementoBoton);
		padre.getSons().set(pos, Aux);
		Swap(pos+1,pos+2,(VerticalPanel)yo.getParent());

		}
	}
	}




	/**
	 * Buscarme a mi en una lista de elementos.
	 * @param list hijos donde buscar.
	 * @return posicion en la lista.
	 */
	private int findme(List<CollectionAttribute> list) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i)==ElementoBoton)
				return i;
		}
		return list.size();
	}




	/**
	 * Cambia posiciones con el elemento superior
	 */
	protected void SwapUp() {
		if (ElementoBoton.getFather()==null)
			{
			int pos=findme(EditorMainWindowEditor.getColeccionActual().getMetamodelSchemas());
			if (pos>0)
				{
				CollectionAttribute Aux=EditorMainWindowEditor.getColeccionActual().getMetamodelSchemas().get(pos-1);
				EditorMainWindowEditor.getColeccionActual().getMetamodelSchemas().set(pos-1, ElementoBoton);
				EditorMainWindowEditor.getColeccionActual().getMetamodelSchemas().set(pos, Aux);		
				Swap(pos+1,pos,(VerticalPanel)yo.getParent());

				}
			}
		else{
		CollectionAttribute padre= ElementoBoton.getFather();
		int pos=findme(padre.getSons());
		if (pos>0)
			{
			CollectionAttribute Aux=padre.getSons().get(pos-1);
			padre.getSons().set(pos-1, ElementoBoton);
			padre.getSons().set(pos, Aux);		
			Swap(pos+1,pos,(VerticalPanel)yo.getParent());

			}
		}
		
	}

	/**
	 * Cambia dos posiciones entre si
	 * @param myPos pasicion del elemento 1
	 * @param myPos2 posicion del elemento 2
	 * @param padre Panel donde estan los dos elementos a intercambiar.
	 */
	protected void Swap(int myPos, int myPos2, VerticalPanel padre) {
		ArrayList<Widget> backup=new ArrayList<Widget>();
		Widget a=padre.getWidget(myPos);
		Widget b=padre.getWidget(myPos2);
		for (int i = 0; i < padre.getWidgetCount(); i++) {
			if (i==myPos)
				backup.add(b);
			else if (i==myPos2)
				backup.add(a);
			else 
				backup.add(padre.getWidget(i));
			}
		padre.clear();
		for (Widget widget : backup) {
			padre.add(widget);
		}


	}


	/**
	 * Procesar hijos de el elemento de la clase.
	 * @param panelSeleccion panel de seleccion donde iran al ser pulsados.
	 * @param indexEntryPoint panel padre general de refresco.
	 */
	public void ProcessSons(VerticalPanel panelSeleccion, EditorMainWindowEditor indexEntryPoint) {
		cleanHijos();
		SonsPanel.clear();
		
		Button NewButton = new Button(IMGADD);
		NewButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				PanelNewElementModelPopupPanel PN =new PanelNewElementModelPopupPanel(ElementoBoton,yo);
				PN.center();
			}
		});
		SonsPanel.add(NewButton);
		NewButton.setSize("", "");
		
		
		ArrayList<CompositeModeloBotonComposite> lista=new ArrayList<CompositeModeloBotonComposite>();
		for (CollectionAttribute Attributeson : ElementoBoton.getSons()) {
			CompositeModeloBotonComposite newComp=new CompositeModeloBotonComposite(Attributeson,panelSeleccion,indexEntryPoint,yo);
			lista.add(newComp);
		}
		CompositeModeloBotonComposite pre=null;
		ArrayList<CompositeModeloBotonComposite> ocultar=new ArrayList<CompositeModeloBotonComposite>();
		int count=0;
		for (CompositeModeloBotonComposite componentUni : lista) {
			if (pre==null)
				pre=componentUni;
			else if ((pre.getElementoBoton() instanceof Meta)&&(componentUni.getElementoBoton()  instanceof Meta) &&(((Meta) pre.getElementoBoton()).getName().equals(((Meta) componentUni.getElementoBoton()).getName())))
				{
				count++;
				ocultar.add(componentUni);
				}
			else{
				pre=componentUni;
				
				if (count>=4)
			{
				for (int i = 3; i < ocultar.size(); i++) {
					ocultar.get(i).setVisible(false);
				}
				Button MasAle=new Button("..."+(ocultar.size()-4)+MORE_ELEMENTS_IN_FATHER);
				SonsPanel.add(MasAle);
				MasAle.addClickHandler(new WidgetVisualModelClickHandler(ocultar,MasAle));
			}
				ocultar=new ArrayList<CompositeModeloBotonComposite>();
				count=0;
			}
			SonsPanel.add(componentUni);
		}

		if (count>=4)
		{
			for (int i = 3; i < ocultar.size(); i++) {
				ocultar.get(i).setVisible(false);
			}
			Button MasAle=new Button("..."+(ocultar.size()-4)+MORE_ELEMENTS_IN_FATHER);
			SonsPanel.add(MasAle);
			MasAle.addClickHandler(new WidgetVisualModelClickHandler(ocultar,MasAle));
		}
		
	}
	
	/**
	 * Borra los hijos de la lista de hijos
	 */
	public void cleanHijos() {
		for (Widget widget : SonsPanel) {
			if (widget instanceof CompositeModeloBotonComposite)
				{
				EditorMainWindowEditor.getBotonesAttributo().remove(((CompositeModeloBotonComposite)widget).getBotonatributo());
				((CompositeModeloBotonComposite)widget).cleanHijos();
				if (((CompositeModeloBotonComposite)widget).getElementoBoton() instanceof MetaControlled)
					{
					EditorMainWindowEditor.getListaVocabulary().remove((CompositeModeloBotonComposite)widget);
					}
					
				}
		}
		
		
	}
	
	
	/**
	 * Retorna el boton que contiene al atributo.
	 * @return el boton contenedor del atributo
	 */
	public Button getBotonatributo() {
		return Botonatributo;
	}
	
	/**
	 * Devuelve el meta que contiene al atributo.
	 * @return the meta contenido en la clase
	 */
	public CollectionAttribute getElementoBoton() {
		return ElementoBoton;
	}
	
	/**
	 * Setea el elemento que contiene el atributo
	 * @param elementoBoton elemento que sustituira en el objeto
	 */
	public void setElementoBoton(Meta elementoBoton) {
		ElementoBoton = elementoBoton;
	}
	
	/**
	 * Devuelve el elemento padre de refresco general
	 * @return
	 */
	public EditorMainWindowEditor getIndexEntryPoint() {
		return indexEntryPoint;
	}
	
	/**
	 * Cambia la Navegabilidad del elemento
	 */
	public void changeBrosability() {
		if (ElementoBoton instanceof Iterator)
			Window.alert(ConstantsInformation.ITERATORS_HAVENOT_BROWSER_ATTRIBUTE);
		else if (ElementoBoton instanceof Meta)
			if (Window.confirm(ConstantsInformation.CHANGE_BROWSER + EditorMainWindowEditor.pathFather(ElementoBoton) + ConstantsInformation.TO + !((Meta) ElementoBoton).getBrowseable() + ConstantsInformation.Q))
			{
			((Meta) ElementoBoton).setBrowseable(!((Meta) ElementoBoton).getBrowseable());
			if (((Meta) ElementoBoton).getBrowseable())
				Botonatributo.addStyleName("gwt-LabelNegrita");
			else 
				Botonatributo.removeStyleName("gwt-LabelNegrita");
			}
		
	}

	/**
	 * Retorna el vocabulario del elemento ( solo si es controlado, sino devuelve null)
	 * @return vocabulario o null en caso de ser un elemento no controlado
	 */
	public VocabularyControlledModeloButton getVocabularyButton() {
		return VocabularyButton;
	}
	
	/**
	 * Setea el boton vocabulario en el elemento visual.
	 */
	public void setVocabularyButton() {
		int Voc=EditorMainWindowEditor.getVocabulario(((MetaControlled) ElementoBoton).getVocabulary());
		VocabularyButton.setVocNumber(Voc);
		VocabularyButton.setVocabulary(((MetaControlled) ElementoBoton).getVocabulary());
		VocabularyButton.setHTML(VOCABULARY + Voc);
	}




	/**
	 * @return the padreComposite
	 */
	public CompositeModeloBotonComposite getPadreComposite() {
		return padreComposite;
	}




	/**
	 * @param padreComposite the padreComposite to set
	 */
	public void setPadreComposite(CompositeModeloBotonComposite padreComposite) {
		this.padreComposite = padreComposite;
	}




	/**
	 * @return the panelSeleccion
	 */
	public VerticalPanel getPanelSeleccion() {
		return panelSeleccion;
	}




	/**
	 * @param panelSeleccion the panelSeleccion to set
	 */
	public void setPanelSeleccion(VerticalPanel panelSeleccion) {
		this.panelSeleccion = panelSeleccion;
	}



	/**
	 * Cambia la propiedad de ser sumario en la clase.
	 */
	public void changeSummary() {
		if (ElementoBoton instanceof Iterator)
			Window.alert(ConstantsInformation.ITERATORS_CANNOT_BE_A_SUMMARY);
		else if (ElementoBoton instanceof Meta)
			if (((Meta) ElementoBoton).getSummary())
			{
				if (Window.confirm(ConstantsInformation.CHANGE_SUMMARY_YES_NO + EditorMainWindowEditor.pathFather(ElementoBoton) + ConstantsInformation.Q))
				{
					((Meta) ElementoBoton).setSummary(false);
					unshowImage();
				}
			}
			else 
			{
				if (Window.confirm(ConstantsInformation.CHANGE_SUMMARY_NO_YES + EditorMainWindowEditor.pathFather(ElementoBoton) + ConstantsInformation.Q))
				{
					((Meta) ElementoBoton).setSummary(true);
					showImage();
				}
			}
	}

	/**
	 * Cambia la visibilidad del elemento.
	 */
	public void changeVisibility() {
		if (ElementoBoton instanceof Iterator)
			Window.alert(ConstantsInformation.ITERATORS_HAVENOT_VISIBILITY_ATTRIBUTE);
		else if (ElementoBoton instanceof Meta)
			if (Window.confirm(ConstantsInformation.CHANGE_VISIBILITY + EditorMainWindowEditor.pathFather(ElementoBoton) + ConstantsInformation.TO + !((Meta) ElementoBoton).getVisible() + ConstantsInformation.Q))
			{
			((Meta) ElementoBoton).setVisible(!((Meta) ElementoBoton).getVisible());
			if (((Meta) ElementoBoton).getVisible())
			{
				Visible.removeStyleName("vocabularyButton3");
				Visible.addStyleName("vocabularyButton2");
			}
				else{
					Visible.removeStyleName("vocabularyButton2");
				Visible.addStyleName("vocabularyButton3");
			}
				
			}
		
	}

	/**
	 * Quita la imagen de summary del panel.
	 */
	private void unshowImage() {
		PanelBotonyLinea.remove(Linea);
		
	}
	
	/**
	 * Muestra la imagen de Summary en panel.
	 */
	private void showImage() {
		PanelBotonyLinea.add(Linea);
		
	}





	
	
}
