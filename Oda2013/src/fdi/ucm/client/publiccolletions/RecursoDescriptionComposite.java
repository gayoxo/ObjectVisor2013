/**
 * 
 */
package fdi.ucm.client.publiccolletions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.google.gwt.user.client.ui.Composite;

import fdi.ucm.shared.model.collection.CollectionAttribute;
import fdi.ucm.shared.model.collection.Iterator;
import fdi.ucm.shared.model.collection.meta.Meta;
import fdi.ucm.shared.model.collection.metavalues.MetaValue;
import fdi.ucm.shared.model.collection.resources.Resources;
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

/**
 * Clase que implemeneta un elemento recurso de tipo composite para mostrar el elemento.
 * @author Joaquin Gayoso-Cabada
 *
 */
public class RecursoDescriptionComposite extends Composite {

	private static final String SHOWMORE = "Show More";
	protected static final int MaxWidth = 50;
	private static final String PX = "PX";
	private static String BasePath;
	private HashMap<Meta, VerticalPanel> Pestanas;
	private SimplePanel PanelDecorador;
	private HashMap<MetaValue,TabElement> Procesados;
	private Resources Recurso;
	private ArrayList<MetaValue> vaciosCreados;
	private ArrayList<Meta> MetaOrden;
	private List<CollectionAttribute> ColeccionSons;
	private Image Icono;
	private String Destino;
	private String ImagenAsociada;
	private VerticalPanel PanelA;
	private SimplePanel PanelDelIcono;
	private DecoratorPanel decoratorPanel;
	private HorizontalPanel PanelGeneral;
	private VerticalPanel PanelGeneral2;

	public RecursoDescriptionComposite(Resources recurso,List<CollectionAttribute> list) {
		super();
		Pestanas=new HashMap<Meta, VerticalPanel>();
		
		ColeccionSons=list;
		Procesados=new HashMap<MetaValue,TabElement>();	
		Recurso=recurso;
		vaciosCreados=new ArrayList<MetaValue>();
		MetaOrden=new ArrayList<Meta>();
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
		
Resources elementoIcono = ShowsStaticFunctions.getIcon(recurso);
		
		
		Destino=ShowsStaticFunctions.calculaDestino(elementoIcono,BasePath);
		ImagenAsociada=ShowsStaticFunctions.calculaImagenAsociada(elementoIcono,BasePath);
		
		
		
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


		
		TabElement.setColeccionSons(ColeccionSons);
		
		PanelDecorador = new SimplePanel();
		PanelContenedorDecoyBoton.add(PanelDecorador);
		PanelDecorador.setSize("100%", "100%");
		ReferencePopUpPanel.setBasePath(BasePath);
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		PanelContenedorDecoyBoton.add(horizontalPanel);
		
		SimplePanel Glue = new SimplePanel();
		horizontalPanel.add(Glue);
		Glue.setWidth("25px");
		
		Button OpenElement = new Button(SHOWMORE);
		horizontalPanel.add(OpenElement);
		OpenElement.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				ReferencePopUpPanel RPUP=new ReferencePopUpPanel(Recurso,ColeccionSons);
				SplitLayoutPanelPropio.getPila_de_cerrado().add(RPUP);
				RPUP.center();
			}
		});
		

	
		
		
	
		
		PanelA = new VerticalPanel();
		PanelA.setSize("100%", "100%");
		
		PanelDecorador.add(PanelA);
		
		for (CollectionAttribute MetaElem : ColeccionSons) {
				
			if (MetaElem instanceof Meta)
				{
				
				Pestanas.put((Meta) MetaElem, PanelA);
				MetaOrden.add((Meta) MetaElem);
				}
			else 
				{
				 procesaEstrella((Iterator)MetaElem);
				}
			

		}
		
		
		
		for (MetaValue MetaValueD : recurso.getDescription()) {
			if (!Procesados.containsKey(MetaValueD)&&(ShowsStaticFunctions.isSummary(MetaValueD)))
					procesa(MetaValueD);
		}
		

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
//			MetaPestanaATab.put(metaValueD.getHastype(), nuevo);
			return nuevo;
		}
		else
		{
			Meta Padre;
			
			Padre=FindPadreSummaryAscendente(metaValueD, metaValueD.getHastype());
			
			if (Pestanas.containsKey(Padre))
				if (isSummaryMeta(Padre,metaValueD))
					{
					//Se retorno el padre por ser el padre
						return procesosobremipadre(metaValueD,Padre);
					}
				else
				{
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
	private boolean isSummaryMeta(Meta padre, MetaValue metaValueD) {
		MetaValue PadreMV=findMetaValue(padre, metaValueD.getAmbitos());
		if (PadreMV!=null)
			return ShowsStaticFunctions.isSummary(PadreMV);
		else
			return ShowsStaticFunctions.isSummary(padre);
				
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
	private Meta FindPadreSummaryAscendente(MetaValue metaValueD,Meta Metain) {
		
		Meta Padre;
		
		if (Metain.getFather()==null)
			return Metain;
		
		if (Metain.getFather() instanceof Meta)
			Padre=(Meta) Metain.getFather();
		else 
			Padre=findMeta((Iterator) Metain.getFather());
		
		MetaValue PadreMV=findMetaValue(Padre, metaValueD.getAmbitos());
		
		
		
		if (PadreMV!=null)
			if (ShowsStaticFunctions.isSummary(PadreMV))
				return Padre;
			else 
				return FindPadreSummaryAscendente(PadreMV,PadreMV.getHastype());
		else
			if (ShowsStaticFunctions.isSummary(Padre))
				return Padre;
			else 
				return FindPadreSummaryAscendente(metaValueD,Padre);

	}





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
		if (IteradorProcesar.getFather()==null)
			return null;
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
//				VerticalPanel PanelA = new VerticalPanel();
//				PanelA.setSize("100%", "100%");
				Pestanas.put((Meta) MetaElem, PanelA);
				MetaOrden.add((Meta) MetaElem);
				}
			else 
				{
				 procesaEstrella((Iterator)MetaElem);
				}
			

		}
		
	}

	/**
	 * @return the basePath
	 */
	public static String getBasePath() {
		return BasePath;
	}

	/**
	 * @param basePath the basePath to set
	 */
	public static void setBasePath(String basePath) {
		BasePath = basePath;
	}


	

	@Override
	protected void onLoad() {
		super.onLoad();
		if (decoratorPanel.getOffsetWidth()>0)
			PanelGeneral2.setWidth((decoratorPanel.getOffsetWidth()-MaxWidth-13)+PX);
		
	}
	

}
