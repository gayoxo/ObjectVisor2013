package fdi.ucm.client.window.modeleditor.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

import fdi.ucm.client.ConstantsError;
import fdi.ucm.client.window.modeleditor.EditorMainWindowEditor;
import fdi.ucm.shared.model.collection.CollectionAttribute;
import fdi.ucm.shared.model.collection.meta.Meta;
import fdi.ucm.shared.model.collection.meta.MetaBoolean;
import fdi.ucm.shared.model.collection.meta.MetaControlled;
import fdi.ucm.shared.model.collection.meta.MetaDate;
import fdi.ucm.shared.model.collection.meta.MetaNumeric;
import fdi.ucm.shared.model.collection.meta.MetaText;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.user.client.ui.CheckBox;

/**
 * Popuppanel que permite unir dos elementos meta
 * @author Joaquin Gayoso-Cabada
 *
 */
public class PanelSeleccionMergeModeloPopupPanel extends PopupPanel {

	private static final String CANCEL_BUTTON = "Cancel";
	private static final String OK_BUTTON = "Ok";
	private static final String WELLCOMEMESSAGE = "Select two elements from seleccion panel to merge, the result type will be show under seleccion and take the first combobox element";
	private static final String RECURSIVE_MERGE = "Recursive Merge";
	private EditorMainWindowEditor padre;
	private enum Typos {Attribute,ControlledAttribute,TextAttribute,NumericAttribute,DateAttribute,BooleanAttribute}
	private ListBox Selection1;
	private ListBox Selection2;
	private Label ResultTypeLabel;
	private HashMap<Integer, Meta> MetaEnComboElementos;
	private HashMap<Integer, AtributoModeloButton> MetaEnComboElementosEnFrio;
	private CheckBox Recursive;


	/**
	 * Constructor.
	 * @param seleccion panel de elementos seleccionados.
	 * @param yo Panel padre donde se refrescara el cambio si se realiza.
	 */
	public PanelSeleccionMergeModeloPopupPanel(VerticalPanel seleccion, EditorMainWindowEditor yo) {
		setModal(true);
		setGlassEnabled(true);
		setAnimationEnabled(true);
		padre=yo;
		MetaEnComboElementos=new HashMap<Integer, Meta>();
		MetaEnComboElementosEnFrio=new HashMap<Integer, AtributoModeloButton>();
		VerticalPanel GeneralPanel = new VerticalPanel();
		GeneralPanel.setSpacing(10);
		GeneralPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		GeneralPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		setWidget(GeneralPanel);
		GeneralPanel.setSize("100%", "100%");
		
		Label LabelWellcome = new Label(WELLCOMEMESSAGE);
		GeneralPanel.add(LabelWellcome);
		
		VerticalPanel PanelSeleccionYResultado = new VerticalPanel();
		PanelSeleccionYResultado.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		GeneralPanel.add(PanelSeleccionYResultado);
		
		HorizontalPanel SelectionPanel = new HorizontalPanel();
		SelectionPanel.setSpacing(5);
		PanelSeleccionYResultado.add(SelectionPanel);
		
		ChangeHandler CH=new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				Meta A1=MetaEnComboElementos.get(Integer.parseInt(Selection1.getValue((Selection1.getSelectedIndex()))));
				Meta A2=MetaEnComboElementos.get(Integer.parseInt(Selection2.getValue((Selection2.getSelectedIndex()))));
				Typos T=generaTypo(A1,A2);
				ResultTypeLabel.setText(T.toString());
			}
		};
		
		
		Selection1 = new ListBox();
		Selection1.setSelectedIndex(0);
		Selection1.addChangeHandler(CH);
		
		
		SelectionPanel.add(Selection1);
		
		Selection2 = new ListBox();
		Selection2.setSelectedIndex(0);
		Selection2.addChangeHandler(CH);
		SelectionPanel.add(Selection2);
		int count=0;
		
		for (Widget widget : seleccion) {
			Meta A=(Meta) ((AtributoModeloButton)widget).getAttribute();
			Selection1.addItem(EditorMainWindowEditor.pathFather(A)+":"+count,Integer.toString(count));
			Selection2.addItem(EditorMainWindowEditor.pathFather(A)+":"+count,Integer.toString(count));
			MetaEnComboElementos.put(count, A);
			MetaEnComboElementosEnFrio.put(count, (AtributoModeloButton)widget);
			count++;
		}
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		PanelSeleccionYResultado.add(horizontalPanel);
		
		ResultTypeLabel = new Label("New label");
		horizontalPanel.add(ResultTypeLabel);
	
		
		Recursive = new CheckBox(RECURSIVE_MERGE);
		horizontalPanel.add(Recursive);
		
		Meta A1=MetaEnComboElementos.get(Integer.parseInt(Selection1.getValue((Selection1.getSelectedIndex()))));
		Meta A2=MetaEnComboElementos.get(Integer.parseInt(Selection2.getValue((Selection2.getSelectedIndex()))));
		Typos T=generaTypo(A1,A2);
		
		ResultTypeLabel.setText(T.toString());
		
		HorizontalPanel BotoneraPanel = new HorizontalPanel();
		BotoneraPanel.setSpacing(5);
		GeneralPanel.add(BotoneraPanel);
		
		Button OkButton = new Button(OK_BUTTON);
		OkButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				boolean recursive=Recursive.getValue();
				
				Meta A1=MetaEnComboElementos.get(Integer.parseInt(Selection1.getValue((Selection1.getSelectedIndex()))));
				Meta A2=MetaEnComboElementos.get(Integer.parseInt(Selection2.getValue((Selection2.getSelectedIndex()))));
				if (A1!=A2){
				CompositeModeloBotonComposite PadreARefrescar = MetaEnComboElementosEnFrio.get(Integer.parseInt(Selection1.getValue((Selection1.getSelectedIndex())))).getElementoEnArbol().getPadreComposite();
				mergeElements(A1, A2,PadreARefrescar,recursive); 
				
				}else Window.alert(ConstantsError.ERROR_SAME_ATTRIBUTE);
			}
		});
		BotoneraPanel.add(OkButton);
		
		Button CancelButton = new Button(CANCEL_BUTTON);
		CancelButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				hide();
			}
		});
		BotoneraPanel.add(CancelButton);
		
	}
/**
	 * Genera el tipo resultado de la promocion de los atributos
	 * @param a1 atributo 1
	 * @param a2 atributo 2
	 * @return Tipo resultado
	 */
	protected Typos generaTypo(Meta a1, Meta a2) {
		if (a1 instanceof MetaControlled)
			{
			if (a2 instanceof MetaControlled)
				return Typos.ControlledAttribute;
			else return Typos.TextAttribute;
			}
		else if (a1 instanceof MetaDate)
		{
			if (a2 instanceof MetaDate)
				return Typos.DateAttribute;
			else return Typos.TextAttribute;
		}
		else if (a1 instanceof MetaNumeric)
		{
			if (a2 instanceof MetaNumeric)
				return Typos.NumericAttribute;
			else return Typos.TextAttribute;
		}
		else if (a1 instanceof MetaBoolean)
		{
			if (a2 instanceof MetaBoolean)
				return Typos.BooleanAttribute;
			else return Typos.TextAttribute;
		}
		else if (a1 instanceof MetaText)
			return Typos.TextAttribute;
		else 
		{
			if (a2 instanceof MetaNumeric)
				return Typos.NumericAttribute;
			else if (a2 instanceof MetaControlled)
				return Typos.ControlledAttribute;
			else if (a2 instanceof MetaDate)
				return Typos.DateAttribute;
			else if (a1 instanceof MetaText)
				return Typos.TextAttribute;
			else return Typos.Attribute;
		}
	}


	/**
	 * Une dos atributos en un atributo destino, calculado en funcion de sus tipos propios
	 * @param attribute Atributo de entrada que define el atributo de destino en caso de que se conserve y las propiedades en caso de que se genere uno nuevo.
	 * @param attribute2 Atributo que sirve de origen de union para generar el nuevo tipo, solo hereda algo si ambos son controlados, entonces hereda el vocabulario.
	 * @param padreARefrescar Boton de donde se obtendra el refreco
	 * @param recursive denota si la union es recursiva
	 */
	public void mergeElements(Meta attribute, Meta attribute2, CompositeModeloBotonComposite padreARefrescar, boolean recursive) {
			if (attribute.getFather()==attribute2.getFather()||attribute.getFather()==attribute2||attribute2.getFather()==attribute)
				if (recursive)
				{
					if (!EditorMainWindowEditor.IndexExistDuplicitiWarning(attribute,attribute2)||!procesIndexExistDuplicitiWarningSons(attribute,attribute2))
						{
						Meta Salida=Unir(attribute,attribute2);
						if (recursive)
							procesa_copias(Salida.getSons());
						if (padreARefrescar!=null)
							padreARefrescar.ProcessSons(padreARefrescar.getPanelSeleccion(), padre);
						else padre.refreshModeloActual();
						padre.getSeleccion().clear();
						hide();
						}
					else Window.alert(ConstantsError.ERROR_CANT_MERGE_DUPLICITY);
					}
				else{
					if (!EditorMainWindowEditor.IndexExistDuplicitiWarning(attribute,attribute2))
					{
					Unir(attribute,attribute2);	
					if (padreARefrescar!=null)
						padreARefrescar.ProcessSons(padreARefrescar.getPanelSeleccion(), padre);
					else padre.refreshModeloActual();
					padre.getSeleccion().clear();
					hide();
					}
					else Window.alert(ConstantsError.ERROR_CANT_MERGE_DUPLICITY);
				}
			else Window.alert(ConstantsError.ERROR_CANT_MERGE);
		
	}

	/**
	 * 
	 * @param attribute atributo a unir 1
	 * @param attribute2 attributo a unir 2
	 */
	private Meta Unir(Meta attribute, Meta attribute2) {
		//Genero Destino
		Typos T=generaTypo(attribute,attribute2);
		Meta nuevo=generaAttributo(T);
		
		//Hereda atributos
		nuevo.setBrowseable(attribute.getBrowseable());
		nuevo.setName(attribute.getName());
		nuevo.setVisible(attribute.getVisible());
		nuevo.setSummary(attribute.getSummary());
		
		//Borra del padre
		if (attribute.getFather()!=null)
			attribute.getFather().getSons().remove(attribute);
		else
			EditorMainWindowEditor.getColeccionActual().getMetamodelSchemas().remove(attribute);
		
		if (attribute2.getFather()!=null)
			attribute2.getFather().getSons().remove(attribute2);
		else
			EditorMainWindowEditor.getColeccionActual().getMetamodelSchemas().remove(attribute2);
		
		//Setea el Nuevo Padre
		if (attribute.getFather()==attribute2.getFather())
			nuevo.setFather(attribute.getFather());
		else if (attribute.getFather()==attribute2)
			nuevo.setFather(attribute2.getFather());
		else if (attribute2.getFather()==attribute) 
			nuevo.setFather(attribute.getFather());

		
		//Une los Hijos		
		ArrayList<CollectionAttribute> Sons;
			Sons=uneHijos(attribute.getSons(),attribute2.getSons());
		
		for (CollectionAttribute attribute3 : Sons) {
			attribute3.setFather(nuevo);
		}
		
		nuevo.setSons(Sons);
		
		//Une los  vocabularios
		uneVocabularios(nuevo,attribute,attribute2);
		
		//Me añado al padre
		if (attribute.getFather()!=null)
				nuevo.getFather().getSons().add(nuevo);
		else
			EditorMainWindowEditor.getColeccionActual().getMetamodelSchemas().add(nuevo);
		
		EditorMainWindowEditor.eliminaRepetidos(attribute,attribute2);
		susituye(attribute,nuevo);
		susituye(attribute2,nuevo);
		return nuevo;
		
	}
	
	/**
	 * Procesa copias para unir en el caso de las recursiones
	 * @param sons hijos a unir
	 */
	private void procesa_copias(List<CollectionAttribute> list) {
		ArrayList<CollectionAttribute> sons=new ArrayList<CollectionAttribute>();
		for (CollectionAttribute meta : list) {
			sons.add(meta);
		}
		Meta Hermano=new Meta();
		while (sons.size()!=0) {
			CollectionAttribute Source=sons.get(0);
			sons.remove(0);
			if (Source instanceof Meta)
			{
				Hermano=(Meta) findhermanos((Meta) Source,sons);
				if (Hermano!=null)
				{
					sons.remove(Hermano);
					Meta Nuevo=Unir((Meta)Source, Hermano);	
					procesa_copias(Nuevo.getSons());
				}
			}
		}
	}
	/**
	 * Busca mis hermanos en una lista
	 * @param source fuente a buscar
	 * @param sons lista donde buscar
	 * @return 
	 */
	private CollectionAttribute findhermanos(Meta source, ArrayList<CollectionAttribute> sons) {
		for (CollectionAttribute meta2 : sons) {
		if ((meta2 instanceof Meta)&&source!=meta2&&source.getName().equals(((Meta) meta2).getName())&&(EqualType(source,(Meta) meta2)))
		{
			return meta2;
		}
		}
		return null;
		
	}

	/**
	 * Comprueba si los hijos tienen problema para unirse
	 * @param attribute atributo source1
	 * @param attribute2 atributo source2
	 * @return si existe la posibilidad de unir retorna false
	 */
	private boolean procesIndexExistDuplicitiWarningSons(Meta attribute,
			Meta attribute2) {
		for (CollectionAttribute iterable_element1 : attribute.getSons()) {
			for (CollectionAttribute iterable_element2 : attribute2.getSons()) {
				if ((iterable_element1 instanceof Meta)&&((Meta) iterable_element1).getName().equals(((Meta) iterable_element2).getName()))
				{
					if (EditorMainWindowEditor.IndexExistDuplicitiWarning((Meta) iterable_element1,(Meta) iterable_element2)||procesIndexExistDuplicitiWarningSons((Meta) iterable_element1,(Meta) iterable_element2))
						return true;
				}
			}
		}
		
		return false;
	}
	/**
	 * Une los vocvabularios sobre nuevo si este es de tipo controlado y los atributos entrantes tambien.
	 * @param nuevo tipo a insertar vocabularios si todos los atributos entrantes son vocabularios.
	 * @param attribute tipo fuente vocabulario si es controlado
	 * @param attribute2 tipo fuente 2 de vocabulario si es controlado
	 */
	private void uneVocabularios(Meta nuevo, Meta attribute,
			Meta attribute2) {
		if ((nuevo instanceof MetaControlled)&&(attribute instanceof MetaControlled)&&(attribute2 instanceof MetaControlled))
				{
			ArrayList<MetaControlled> lista=new ArrayList<MetaControlled>();
			lista.add((MetaControlled)nuevo);
			lista.add((MetaControlled)attribute);
			lista.add((MetaControlled)attribute2);
			EditorMainWindowEditor.unirvocabularios(lista,false);
				
			}
//		else {
//			Logger logger = Logger.getLogger("Graves");
//			logger.log(Level.SEVERE, "Error en uneVocabularios clase PanelSeleccionMergePopupPanel.java,fdi.ucm.client.window.index");
//		}
		
	}
		
		
	/**
	 * Sustituye los en los DO el atributo attribute por el nuevo
	 * @param attribute atributo a sustituir
	 * @param nuevo	atributo destino
	 */
	private void susituye(Meta attribute, Meta nuevo) {
		EditorMainWindowEditor.Sustituye(attribute, nuevo);
	}

	/**
	 * Une los hijos de los dos atributos en una sola lista.
	 * @param list Atributo 1
	 * @param list2 Atributo 2
	 * @return Lista de hijos final
	 */
	private ArrayList<CollectionAttribute> uneHijos(List<CollectionAttribute> list,
			List<CollectionAttribute> list2) {
		ArrayList<CollectionAttribute> salida=new ArrayList<CollectionAttribute>();
		for (CollectionAttribute attribute : list) {
			salida.add(attribute);
		}
		for (CollectionAttribute attribute : list2) {
			salida.add(attribute);
		}
		
		return salida;
	}

//	/**
//	 * Chequea si un atributo se enctra en una lista de atributos.
//	 * @param attribute atributo de entrada
//	 * @param salida posibles valores
//	 * @return el elemento encontrado o null si no esta.
//	 */
//	private Meta checkattribute(Meta attribute,
//			ArrayList<Meta> salida) {
//		for (Meta attribute2 : salida) {
//			if (attribute.getName().equals(attribute2.getName()))
//				if (EqualType(attribute,attribute2))
//					return attribute2;
//		}
//		return null;
//	}

	/**
	 * Chequea si ambos son del mismo tipo.
	 * @param attribute atributo fuente 1.
	 * @param attribute2 atributo fuente 2.
	 * @return si los dos elementos son del mismo tipo.
	 */
	private boolean EqualType(Meta attribute, Meta attribute2) {
		if ((attribute instanceof MetaControlled)&&(attribute2 instanceof MetaControlled))
			return true;
		else if ((attribute instanceof MetaText)&&(attribute2 instanceof MetaText))
			return true;
		else if ((attribute instanceof MetaBoolean)&&(attribute2 instanceof MetaBoolean))
			return true;
		else if ((attribute instanceof MetaNumeric)&&(attribute2 instanceof MetaNumeric))
			return true;
		else if ((attribute instanceof MetaDate)&&(attribute2 instanceof MetaDate))
			return true;
		else if ((attribute instanceof Meta)&&(attribute2 instanceof Meta))
			return true;
		else return false;
	}
	/**
	 * Genera atributo nuevo de salida como resultado de el tipo de entrada t
	 * @param t tipo del que resultara la salida
	 * @return Attributo nuevo que resulta de el tipo t
	 */
	private Meta generaAttributo(Typos t) {
		if (t==Typos.Attribute)
			return new Meta();
		else if (t==Typos.ControlledAttribute)
			return new MetaControlled();
		else if (t==Typos.TextAttribute)
			return new MetaText();
		else if (t==Typos.DateAttribute)
			return new MetaDate();
		else if (t==Typos.NumericAttribute)
			return new MetaNumeric();
		else if (t==Typos.BooleanAttribute)
			return new MetaBoolean();
		else return new Meta();
	}

}
