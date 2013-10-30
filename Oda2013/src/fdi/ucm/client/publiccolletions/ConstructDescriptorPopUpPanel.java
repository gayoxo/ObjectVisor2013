/**
 * 
 */
package fdi.ucm.client.publiccolletions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.PopupPanel;

import fdi.ucm.shared.model.collection.CollectionAttribute;
import fdi.ucm.shared.model.collection.Iterator;
import fdi.ucm.shared.model.collection.meta.Meta;
import fdi.ucm.shared.model.collection.metavalues.MetaValue;
import fdi.ucm.shared.model.collection.resources.Construct;
import fdi.ucm.shared.model.collection.resources.Resources;

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
public class ConstructDescriptorPopUpPanel extends PopupPanel implements PoupCerrableGrupo{

	
	private static final String X = "X";
	private HashMap<Meta, VerticalPanel> Pestanas;
	private ArrayList<Meta> MetaOrden;
	private DecoratedTabPanel PanelDecorador;
	private HashMap<MetaValue,TabElement> Procesados;
	private Construct Recurso;
	private ArrayList<MetaValue> vaciosCreados;
	private boolean AllClose;
	private  HashMap<Meta, TabElement> MetaPestanaATab;
	private String Destino;
	private String ImagenAsociada;
	private Image Icono;
	protected static final int MaxHeight = 200;

	
	public ConstructDescriptorPopUpPanel(Construct value,List<CollectionAttribute> coleccionSons) {
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
		Pestanas=new HashMap<Meta, VerticalPanel>();
		MetaOrden= new ArrayList<Meta>();
		Procesados=new HashMap<MetaValue,TabElement>();	
		Recurso=value;
		vaciosCreados=new ArrayList<MetaValue>();
		MetaPestanaATab=new HashMap<Meta, TabElement>();
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
		

		
		Resources elementoIcono = ShowsStaticFunctions.getIcon(value);
		
		Destino=ShowsStaticFunctions.calculaDestino(elementoIcono);
		ImagenAsociada=ShowsStaticFunctions.calculaImagenAsociada(elementoIcono);
		
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
		
		for (CollectionAttribute MetaElem : coleccionSons) {
			
			if (MetaElem instanceof Meta)
				{
				VerticalPanel PanelA = new VerticalPanel();
				Pestanas.put((Meta) MetaElem, PanelA);
				MetaOrden.add((Meta) MetaElem);
				}
			else 
				{
				 procesaEstrella((Iterator)MetaElem);
				}
			

		}
		
		
		for (MetaValue MetaValueD : Recurso.getDescription()) {
			if (!Procesados.containsKey(MetaValueD)&&(ShowsStaticFunctions.isVisible(MetaValueD)))
					procesa(MetaValueD);
		}
		
		
		
		
		for (Meta MetaActual : MetaOrden) {
			VerticalPanel res=Pestanas.get(MetaActual);
			if (res.getWidgetCount()>0)
				{
				ScrollPanel panelScrollVertical = new ScrollPanel();
//				int WidthScroll = Width-10;
				int HeighScroll = Heigh-37;
//				panelScrollVertical.setSize(WidthScroll+"px", HeighScroll+"px");
				panelScrollVertical.setSize("100%", HeighScroll+"px");
				PanelDecorador.add(panelScrollVertical, MetaActual.getName(), true);
				if (ShowsStaticFunctions.NotBasic(MetaActual))
					panelScrollVertical.add(res);
				else
					{
					TabElement T=MetaPestanaATab.get(MetaActual);
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
	private TabElement procesa(MetaValue metaValueD) {
		
		if (Pestanas.containsKey(metaValueD.getHastype()))
		{
			
			VerticalPanel A = Pestanas.get(metaValueD.getHastype());
			TabElement nuevo= new TabElement(metaValueD);
			A.add(nuevo);
			Procesados.put(metaValueD, nuevo);
			MetaPestanaATab.put(metaValueD.getHastype(), nuevo);
			return nuevo;
		}
		else
		{
			Meta Padre;
			
			
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
					Pestanas.put((Meta) metaValueD.getHastype(), PanelA);
					MetaOrden.add((Meta) metaValueD.getHastype());
					TabElement nuevo= new TabElement(metaValueD);
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
	private boolean isVisibleMeta(Meta padre, MetaValue metaValueD) {
		MetaValue PadreMV=findMetaValue(padre, metaValueD.getAmbitos());
		if (PadreMV!=null)
			return ShowsStaticFunctions.isVisible(PadreMV);
		else
			return ShowsStaticFunctions.isVisible(padre);
				
	}


	/**
	 * Procesa un elemto sobre su padre
	 * @param metaValueD
	 * @param padre
	 * @return 
	 */
	private TabElement procesosobremipadre(MetaValue metaValueD, Meta padre) {
		
		MetaValue PadreValue=findMetaValue(padre,metaValueD.getAmbitos());
		TabElement PadreTab;
		if (PadreValue==null)
		{
			
			MetaValue MV=getMetavalueVacio(padre,metaValueD.getAmbitos());
			if (MV==null)
			{
				MV = new MetaValue(padre);
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
		TabElement nuevo= new TabElement(metaValueD);
		A.add(nuevo);
		Procesados.put(metaValueD, nuevo);
		return nuevo;
		
	}

	/**
	 * Busca al padre que ademas de se meta sea summary
	 * @param metaValueD
	 * @return
	 */
	private Meta FindPadreVisibleAscendente(MetaValue metaValueD,Meta Metain) {
		
		Meta Padre;
		
		if (Metain.getFather()==null)
			return Metain;
		
		if (Metain.getFather() instanceof Meta)
			Padre=(Meta) Metain.getFather();
		else 
			Padre=findMeta((Iterator) Metain.getFather());
		
		MetaValue PadreMV=findMetaValue(Padre, metaValueD.getAmbitos());
		
		
		
		if (PadreMV!=null)
			if (ShowsStaticFunctions.isVisible(PadreMV))
				return Padre;
			else 
				return FindPadreVisibleAscendente(PadreMV,PadreMV.getHastype());
		else
			if (ShowsStaticFunctions.isVisible(Padre))
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
	private MetaValue getMetavalueVacio(Meta padre, ArrayList<Integer> ambitos) {
		for (MetaValue vaciosCandidato : vaciosCreados) {
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
	private MetaValue findMetaValue(Meta element, ArrayList<Integer> AmbitosElementoBase) {
		for (MetaValue metaValuePro : Recurso.getDescription()) {
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
	private Meta findMeta(Iterator IteradorProcesar) {
		if (IteradorProcesar.getFather() instanceof Meta)
			return (Meta) IteradorProcesar.getFather();
		else return findMeta((Iterator)IteradorProcesar.getFather());
	}


	/**
	 * Mecanismo de proceso de un atributo estrella para la creacion de las pestañas
	 * @param metaElem
	 */
	private void procesaEstrella(Iterator metaElem) {
		for (CollectionAttribute MetaElem : metaElem.getSons()) {
			
			if (MetaElem instanceof Meta)
				{
				VerticalPanel PanelA = new VerticalPanel();
				PanelA.setSize("100%", "100%");
				Pestanas.put((Meta) MetaElem, PanelA);
				MetaOrden.add((Meta) MetaElem);
				}
			else 
				{
				 procesaEstrella((Iterator)MetaElem);
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
			while (!PublicCollectionSplitLayoutPanel.getPila_de_cerrado().isEmpty())
			{
				PoupCerrableGrupo RPP=(PoupCerrableGrupo) PublicCollectionSplitLayoutPanel.getPila_de_cerrado().pop();
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
