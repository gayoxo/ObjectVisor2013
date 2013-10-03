package fdi.ucm.client.window.modeleditor.model;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;

import fdi.ucm.client.ConstantsError;
import fdi.ucm.client.window.modeleditor.EditorMainWindowEditor;
import fdi.ucm.shared.model.collection.Collection;
import fdi.ucm.shared.model.collection.CollectionAttribute;
import fdi.ucm.shared.model.collection.Iterator;
import fdi.ucm.shared.model.collection.meta.Meta;
import fdi.ucm.shared.model.collection.meta.MetaControlled;
import fdi.ucm.shared.model.collection.meta.MetaDate;
import fdi.ucm.shared.model.collection.meta.MetaNumeric;
import fdi.ucm.shared.model.collection.meta.MetaRelation;
import fdi.ucm.shared.model.collection.meta.MetaText;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.user.client.ui.HasVerticalAlignment;

/**
 * Clase que implementa el popup de creacion de un nuevo nodo para un meta objeto en el modelo de datos
 * @author Joaquin Gayoso-Cabada
 *
 */
public class PanelNewElementModelPopupPanel extends PopupPanel {
	
	private static final String OKBOTTON = "Ok";
	private static final String CANCELBOTTON = "Cancel";
	private static final String WELLCOME = "Insert new name for son of element : ";
	private static final String WELLCOME_CATALOG = "Insert new name for son of Collection";
	private EditorMainWindowEditor indexEntryPoint;
	private CollectionAttribute elementoBoton;
	private Collection Coleccion;
	private ListBox TypeNewElement;
	private CheckBox BrowseableCheckBox;
	private TextBox TextBoxNewElement;
	private Button OkBotton;
	private CompositeModeloBotonComposite Padre;
	private HorizontalPanel PanelOcultable;
	private VerticalPanel verticalPanel;
	private CheckBox VisibleCheckBox;
	private CheckBox SummaryCheckBox;
	private enum Types {Attribute,ControlledAttribute,TextAttribute,NumericAttribute,DateAttribute,Multivalued,Relation}

	/**
	 * Constructor de paneles nuevos para construir sobre la otro Meta.
	 * @param elementoBoton2 elemento padre sobre el que se construira el nuevo meta.
	 * @param Padre Padre de el elemento
	 */
	public PanelNewElementModelPopupPanel(CollectionAttribute elementoBoton2, CompositeModeloBotonComposite Padrein) {
		elementoBoton=elementoBoton2;
		Padre=Padrein;
		AccionesComunesConstructor();
		OkBotton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				String Select=TypeNewElement.getItemText(TypeNewElement.getSelectedIndex());
				if ( Select.equals(Types.Multivalued.toString())||!TextBoxNewElement.getText().isEmpty())
				{
					String Selected=TypeNewElement.getItemText(TypeNewElement.getSelectedIndex());
				
					CollectionAttribute nuevoElemento = generatenuevo(Selected);	
				if (nuevoElemento!=null)
					{
					elementoBoton.getSons().add(nuevoElemento);
					hide();
					Padre.ProcessSons(Padre.getPanelSeleccion(), Padre.getIndexEntryPoint());
					EditorMainWindowEditor.processSize();
					}
				else Window.alert(ConstantsError.ERROR_GENERATING_ATTRIBUTE);
			
				}
				else Window.alert(ConstantsError.ERROR_TEXTBOX_EMPTY);
			}
		});
		
	}

	/**
	 * Constructor de paneles nuevos para construir sobre la colleccion.
	 * @param coleccionActual coleccion padre
	 * @param indexEntryPointin indes a refrescar.
	 * @wbp.parser.constructor
	 */
	public PanelNewElementModelPopupPanel(Collection coleccionActual,
			EditorMainWindowEditor indexEntryPointin) {
		Coleccion=coleccionActual;
		indexEntryPoint=indexEntryPointin;
		AccionesComunesConstructor();
		OkBotton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				String Select=TypeNewElement.getItemText(TypeNewElement.getSelectedIndex());
				if ( Select.equals(Types.Multivalued.toString())||!TextBoxNewElement.getText().isEmpty())
				{
					String Selected=TypeNewElement.getItemText(TypeNewElement.getSelectedIndex());
				
					CollectionAttribute nuevoElemento = generatenuevo(Selected);	
				if (nuevoElemento!=null)
					{
					Coleccion.getMetamodelSchemas().add(nuevoElemento);
					hide();
					indexEntryPoint.refreshModeloActual();
					}
				else Window.alert(ConstantsError.ERROR_GENERATING_ATTRIBUTE);
			
				}
				else Window.alert(ConstantsError.ERROR_TEXTBOX_EMPTY);
			}
		});
	}
	
	/**
	 * Acciones comunes para todos los constructores del popup.
	 */
	private void AccionesComunesConstructor() {
		setModal(true);
		setGlassEnabled(true);
		setAnimationEnabled(true);	
		VerticalPanel PanelGeneral = new VerticalPanel();
		PanelGeneral.setSpacing(10);
		PanelGeneral.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		setWidget(PanelGeneral);
		PanelGeneral.setSize("100%", "100%");
		
		Label LabelWellcome;
		if (elementoBoton!=null)
			LabelWellcome = new Label(WELLCOME + EditorMainWindowEditor.pathFather(elementoBoton));
		else
			LabelWellcome= new Label(WELLCOME_CATALOG);
		PanelGeneral.add(LabelWellcome);
		
		TextBoxNewElement = new TextBox();
		TextBoxNewElement.setVisibleLength(40);
		PanelGeneral.add(TextBoxNewElement);
		
		PanelOcultable = new HorizontalPanel();
		PanelOcultable.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		PanelOcultable.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		PanelGeneral.add(PanelOcultable);
		
		TypeNewElement = new ListBox();
		TypeNewElement.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				String Select=TypeNewElement.getItemText(TypeNewElement.getSelectedIndex());
				if (Select.equals(Types.Multivalued.toString()))
					{
					TextBoxNewElement.setVisible(false);
					BrowseableCheckBox.setVisible(false);
					}
				else {
					TextBoxNewElement.setVisible(true);
					BrowseableCheckBox.setVisible(true);
				}
			}
		});
		PanelOcultable.add(TypeNewElement);
		TypeNewElement.addItem(Types.Attribute.toString());
		TypeNewElement.addItem(Types.ControlledAttribute.toString());
		TypeNewElement.addItem(Types.TextAttribute.toString());
		TypeNewElement.addItem(Types.NumericAttribute.toString());
		TypeNewElement.addItem(Types.DateAttribute.toString());
		TypeNewElement.addItem(Types.Multivalued.toString());
		TypeNewElement.addItem(Types.Relation.toString());
		
		verticalPanel = new VerticalPanel();
		PanelOcultable.add(verticalPanel);
		
		BrowseableCheckBox = new CheckBox("Browsable");
		verticalPanel.add(BrowseableCheckBox);
		
		VisibleCheckBox = new CheckBox("Visible");
		VisibleCheckBox.setHTML("Visible");
		verticalPanel.add(VisibleCheckBox);
		
		SummaryCheckBox = new CheckBox("Summary");
		SummaryCheckBox.setHTML("Summary");
		verticalPanel.add(SummaryCheckBox);
		
		HorizontalPanel PanelBotones = new HorizontalPanel();
		PanelBotones.setSpacing(3);
		PanelBotones.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		PanelGeneral.add(PanelBotones);
		
		OkBotton = new Button("");
		PanelBotones.add(OkBotton);
		OkBotton.setHTML(OKBOTTON);
		
		Button CancelBotton = new Button("");
		CancelBotton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				hide();
			}
		});
		PanelBotones.add(CancelBotton);
		CancelBotton.setHTML(CANCELBOTTON);
		
	}

	/**
	 * Metodo que genera el nuevo Meta
	 * @param selected tipo de elemento en modo texto
	 * @return Meta generado
	 */
	protected CollectionAttribute generatenuevo(String selected) {
		CollectionAttribute nuevoElemento=null;
		if (selected.equals(Types.Attribute.toString()))
		{
			nuevoElemento=new Meta(TextBoxNewElement.getText(),BrowseableCheckBox.getValue(),elementoBoton,SummaryCheckBox.getValue(),VisibleCheckBox.getValue());
		}
		else if (selected.equals(Types.ControlledAttribute.toString()))
		{
			nuevoElemento=new MetaControlled(TextBoxNewElement.getText(),BrowseableCheckBox.getValue(),elementoBoton,SummaryCheckBox.getValue(),VisibleCheckBox.getValue());
		}
		else if (selected.equals(Types.TextAttribute.toString()))
		{
			nuevoElemento=new MetaText(TextBoxNewElement.getText(),BrowseableCheckBox.getValue(),elementoBoton,SummaryCheckBox.getValue(),VisibleCheckBox.getValue());
		}
		else if (selected.equals(Types.NumericAttribute.toString()))
		{
			nuevoElemento=new MetaNumeric(TextBoxNewElement.getText(),BrowseableCheckBox.getValue(),elementoBoton,SummaryCheckBox.getValue(),VisibleCheckBox.getValue());
		}
		else if (selected.equals(Types.DateAttribute.toString()))
		{
			nuevoElemento=new MetaDate(TextBoxNewElement.getText(),BrowseableCheckBox.getValue(),elementoBoton,SummaryCheckBox.getValue(),VisibleCheckBox.getValue());
		}
		else if (selected.equals(Types.Relation.toString()))
		{
			nuevoElemento=new MetaRelation(TextBoxNewElement.getText(),BrowseableCheckBox.getValue(),elementoBoton,SummaryCheckBox.getValue(),VisibleCheckBox.getValue());
		}
		else if (selected.equals(Types.Multivalued.toString()))
		{
			nuevoElemento=new Iterator(elementoBoton);
		}
		return nuevoElemento;
	}

	

}
