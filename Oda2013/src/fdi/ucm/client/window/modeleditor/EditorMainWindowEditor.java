package fdi.ucm.client.window.modeleditor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.MenuItemSeparator;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.SplitLayoutPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import fdi.ucm.client.ConstantsError;
import fdi.ucm.client.ConstantsInformation;
import fdi.ucm.client.controller.ControladorEntryPoint;
import fdi.ucm.client.service.LoadService;
import fdi.ucm.client.service.LoadServiceAsync;
import fdi.ucm.client.service.Oda3Service;
import fdi.ucm.client.service.Oda3ServiceAsync;
import fdi.ucm.client.service.SaveService;
import fdi.ucm.client.service.SaveServiceAsync;
import fdi.ucm.client.visualizepanel.SplitLayoutPanelPropio;
import fdi.ucm.client.window.LoadingPopupPanel;
import fdi.ucm.client.window.WindowEditor;
import fdi.ucm.client.window.modeleditor.model.AtributoModeloButton;
import fdi.ucm.client.window.modeleditor.model.CompositeModeloBotonComposite;
import fdi.ucm.client.window.modeleditor.model.PanelNewElementModelPopupPanel;
import fdi.ucm.client.window.modeleditor.model.PanelSeleccionMergeModeloPopupPanel;
import fdi.ucm.client.window.modeleditor.model.RenameSeleccionModeloPopupPanel;
import fdi.ucm.shared.model.CollectionExport;
import fdi.ucm.shared.model.CollectionImport;
import fdi.ucm.shared.model.collection.Collection;
import fdi.ucm.shared.model.collection.CollectionAttribute;
import fdi.ucm.shared.model.collection.meta.Meta;
import fdi.ucm.shared.model.collection.meta.MetaBoolean;
import fdi.ucm.shared.model.collection.meta.MetaControlled;
import fdi.ucm.shared.model.collection.meta.MetaDate;
import fdi.ucm.shared.model.collection.meta.MetaNumeric;
import fdi.ucm.shared.model.collection.meta.MetaText;
import fdi.ucm.shared.model.collection.meta.controlled.Term;
import fdi.ucm.shared.model.collection.meta.controlled.Vocabulary;
import fdi.ucm.shared.model.collection.metavalues.MetaBooleanValue;
import fdi.ucm.shared.model.collection.metavalues.MetaControlledValue;
import fdi.ucm.shared.model.collection.metavalues.MetaDateValue;
import fdi.ucm.shared.model.collection.metavalues.MetaNumericValue;
import fdi.ucm.shared.model.collection.metavalues.MetaTextValue;
import fdi.ucm.shared.model.collection.metavalues.MetaValue;
import fdi.ucm.shared.model.collection.resources.Construct;
import fdi.ucm.shared.model.collection.resources.Resources;
import fdi.ucm.shared.model.userserver.CollectionPropias;
import fdi.ucm.shared.model.userserver.UserAndCollection;
import fdi.ucm.shared.model.userserver.UserServer;


/**
 * Clase que implemebnta el punto de entrada de la aplicacion.
 * @author Joaquin Gayoso-Cabada
 *
 */
public class EditorMainWindowEditor implements WindowEditor {
	

	
	
	
	private static final String VISIBLE = ": Visible";
	private static final String NOVISIBLE = ": Not Visible";
	private static final String Space = " ";
	private static final String ARE_YOU_SURE_TO_REMOVE_THE_COLLECTION = "Are you sure to remove the collection ";
	private static final String DELETE_COLLECTION = "Delete Collection";
	private static final String COLLECTION_IS_NOT_SAVED_YET = "Collection is not saved yet";
	private static final String ARE_YOU_SURE_YOU_WANT_TO_SAVE_ONLY_THE_SCHEMA_LOCAL = "Are you sure you want to save \"ONLY\" the schema of the collection, the resources and his attributes will not be saved in the database?";
	private static final String ARE_YOU_SURE_TO_UNPLUBLISH_COLLECTION="Are you sure you want to un-plublish collection?";
	
	private static ArrayList<Vocabulary> VocabularyHashset;
	private static Oda3ServiceAsync serviceOda = GWT.create(Oda3Service.class);
	private static LoadServiceAsync importservice = GWT.create(LoadService.class);
	private static SaveServiceAsync exportservice = GWT.create(SaveService.class);
	
	//DEBUG
	private static final String CHASQUIMENUITEM = "Chasqui";
	private static final String ODAMENUITEM = "OdA";
	private static final String CHASQUILOCALHOSTMENUITEM = "localhost";
	
	
	private static final String LOADMODELMENUITEM = "Load Catalog";
	private static final String RENAMEBUTTON = "Rename";
	private static final String SAVEMODELMENUITEM = "Save Model";
	private static final String SAVEINODAMENUITEM = "Oda";
	private static final String LOADFROMCHASQUI = "Chasqui";
	private static final String MERGE_ATTRIBUTES = "Merge Attributes";
	private static final String MERGE_VOCABULARIES = "Merge Vocabularies";
	private static final String CHANGE_BROWSABILITY = "Change Browsability Value";
	private static final String DELETEMODELBUTTON = "Delete";
	private static final String MODEL_SCHEMA = "Model Schema";
	private static final String OBJECT_SCHEMA = "File System Schema";
	private static final String ATTRIBUTE = "Attribute";
	private static final String TEXT_ATTRIBUTE="Text Atribute";
	private static final String NUMERIC_ATTRIBUTE = "Numeric Attribute";
	private static final String DATE_ATTRIBUTE = "Date Atributte";
	private static final String CONTROLLED_ATTRIBUTE = "Controlled Attribute";
	private static final String NOT_BROWSEABLE = "-Not browseable";
	private static final String BROWSEABLE = "-Browseable";
	private static final String VOCABULARIO = "V: #";
	private static final String VOCABULARIO_INSTANCE = ": Vocabulary instance";
	private static final String IMAGEN_ADD = "<img src=\"Direccionales/add.gif\" >";
	private static final String LABEL_ADD = ": Add new attribute";
	private static final String SECTION = "Section";
	private static final String FILE = "File";
	private static final String URL = "URL";
	private static final String REFERENCE = "Reference";
	private static final String IMGADD = "<img src=\"Direccionales/add.gif\" >";
	private static final String DELETEOBJECTBUTTON = "Delete";
	private static final String MULTIVALUED = "Multivalued";
	private static final String VISUALIZECOLLECTION = "Visualize Collection";
	private static final String CHANGESUMMARYVALUE = "Change Summary Value";
	private static final String SALIR = "Salir";
	private static final String ATTNAME = "Att. Name";
	private static final String IMAGEATTNAME = "TreeKey/19.jpg";
	private static final String SUMMARYLABEL = ": Summary";
	private static final String PUBLISHED = "Published: ";
	private static final String COLLECTION_MENUITEM = "Collection:";
	private static final String EXPORT_MENUITEM = "Export";
	private static final String IMPORT_MENUITEM = "Import";
	private static final String SAVE_AS_MENUITEM = "Save As ...";
	private static final String SAVE_MENUITEM = "Save";
	private static final String NEW_COLLECTION = "New";
	private static final String ARE_YOU_SURE_YO_SAVE_ONLY_THE_SCHEMA = "Are you sure you want to save \"ONLY\" the schema of the collection, the resources and his attributes will be removed from the collection in the database?";
	private static final String OPEN_MENUITEM = "Open";
	private static final String FILEMENUITEM = "File";
	private static final String MENUITEMSTILEDISABLE = "MenuItemGris";
	private static final String SAVE_ALL = "Save All";
	private static final String ONLY_SCHEMA = "Only Schema";
	private static final String PublishCollectionText = "Publish Colection";
	private static final String UnPublishCollectionText = "Un-Publish Colection";
	private static final String CHANGE_VISIVBILITY = "Change Visibility Value";
	
	
	
	private VerticalPanel PanelModeloVertical;
	private VerticalPanel Seleccion;
	private static Collection ColeccionActual;
	private static String ColeccionActualPath;
	private static Boolean Published; 
	private static ArrayList<Button> BotonesAttributo;
	private static HashMap<CollectionAttribute, Boolean> ListaState;
	private static HashMap<Construct, Boolean> ListaStateSections;
	private static HashMap<CompositeModeloBotonComposite,Vocabulary > ListaVocabulary;

	private static int heightBotones;
	private static int widthBotones;
	private EditorMainWindowEditor yo;
	private Button DeleteModelButton;
	private Button MergeAttButton;
	private Button MergeVocabulary;
	private Button RenameButton;
	private Button ChangeBrowsablility;
	private VerticalPanel panelAccionesModelo;
	private HorizontalPanel PanelCentrar;
	private Button DeleteObjectButton;
	private MenuItem ExportMenuItem;
	private MenuBar BarraColecciones;
	private MenuItem OpenMenuItem;
	private MenuItem CollectionNameMenuItem;
	private MenuItem StateMenuItem;
	private MenuItem SaveSubMenu;
	private MenuItem SaveAsMenuItem;
	private MenuItem DeleteMenuItem;
	private MenuBar MenuImportElements;
	private MenuBar MenuExportElements;
	private MenuItem PublishColection;
	private MenuItem UnPublishColection;
	private String ColeccionAsociadaFin;

	
	
	/**
	 * Clase por defecto que se usa para mostrar la ventana en GWT
	 * @wbp.parser.entryPoint
	 */
	public void showWindow() {
	RootPanel rootPanel=RootPanel.get();
	
	yo=this;
	DockLayoutPanel dockLayoutPanel = new DockLayoutPanel(Unit.PX);
	rootPanel.add(dockLayoutPanel,0,0);
	dockLayoutPanel.setSize("100%", "100%");
	
	MenuBar menuBar = new MenuBar(false);
	menuBar.setAnimationEnabled(true);
	dockLayoutPanel.addNorth(menuBar, 33.0);
	MenuBar menuBar_1 = new MenuBar(true);
	
	MenuItem FileMenuItem = new MenuItem(FILEMENUITEM, true, menuBar_1);
	FileMenuItem.setHTML(FILEMENUITEM);
	
	MenuItem NewCollectionMenuItem = new MenuItem(NEW_COLLECTION, true, new Command() {
		
		@Override
		public void execute() {
			
			if (ColeccionActual!=null)
			{
				if (Window.confirm(ConstantsInformation.DO_YOU_WONT_TO_SAVE))
				{
				LoadingPopupPanel.getInstance().setLabelTexto(
						ConstantsInformation.SAVING);
				LoadingPopupPanel.getInstance().center();
				serviceOda.SaveCollection(ColeccionActual,ColeccionActualPath,ControladorEntryPoint.ActualUSer,
						new AsyncCallback<UserAndCollection>() {

							@Override
							public void onSuccess(UserAndCollection result) {

								LoadingPopupPanel.getInstance()
										.hide();
								ControladorEntryPoint.ActualUSer=result.getUsuario();
								Collection ColecccionNueva = new Collection();
								NewNamePoUp(ColecccionNueva);

							}

							@Override
							public void onFailure(Throwable caught) {
								
								LoadingPopupPanel.getInstance()
										.hide();
								Window.alert(ConstantsError.ERROR_SAVING_COLLECTION);
								caught.printStackTrace();
								

							}
						});
				}
				else{
					Collection ColecccionNueva = new Collection();
					NewNamePoUp(ColecccionNueva);
				}
			}
			
			else {
				Collection ColecccionNueva = new Collection();
				NewNamePoUp(ColecccionNueva);
			}
		}

		private void NewNamePoUp(Collection coleccionActual) {
			SalvadoPopUp PP=new SalvadoPopUp(coleccionActual,yo);
			PP.center();
			
		}
	});
	
	NewCollectionMenuItem.setHTML(NEW_COLLECTION);
	menuBar_1.addItem(NewCollectionMenuItem);
	
	MenuItemSeparator SeparadorNEwSave = new MenuItemSeparator();
	menuBar_1.addSeparator(SeparadorNEwSave);
		BarraColecciones = new MenuBar(true);
		
		OpenMenuItem = new MenuItem(OPEN_MENUITEM, false, BarraColecciones);
		
		RefreshListaCollections();
		
		OpenMenuItem.setHTML(OPEN_MENUITEM);
		menuBar_1.addItem(OpenMenuItem);
	
	MenuBar menuBar_4 = new MenuBar(true);
	
	SaveSubMenu = new MenuItem(SAVE_MENUITEM, false, menuBar_4);
	
	MenuItem SaveAllItem = new MenuItem(SAVE_ALL, false, new Command() {
		public void execute() {
			SaveCollectionMetod();
		}
	});
	SaveAllItem.setHTML(SAVE_ALL);
	menuBar_4.addItem(SaveAllItem);
	
	MenuItem SaveOnlySchema = new MenuItem(ONLY_SCHEMA, false, new Command() {
		public void execute() {
			if (ColeccionActual.getId()!=null)
			{
			 if (Window.confirm(ARE_YOU_SURE_YO_SAVE_ONLY_THE_SCHEMA))
			 { 
				ColeccionActual.setSectionValues(new ArrayList<Resources>());
				SaveCollectionMetod();
			 }
			}
		else if (Window.confirm(ARE_YOU_SURE_YOU_WANT_TO_SAVE_ONLY_THE_SCHEMA_LOCAL))
			{ 
				
				ColeccionActual.setSectionValues(new ArrayList<Resources>());
				SaveCollectionMetod();
			}
		}
	});
	SaveOnlySchema.setHTML(ONLY_SCHEMA);
	menuBar_4.addItem(SaveOnlySchema);
	SaveSubMenu.setHTML(SAVE_MENUITEM);
	menuBar_1.addItem(SaveSubMenu);
	
	SaveSubMenu.setEnabled(false);
	SaveSubMenu.addStyleName(MENUITEMSTILEDISABLE);
	


	MenuBar menuBar_5 = new MenuBar(true);
	
	SaveAsMenuItem = new MenuItem(SAVE_AS_MENUITEM, false, menuBar_5);
	
	
	SaveAsMenuItem.setEnabled(false);
	SaveAsMenuItem.addStyleName(MENUITEMSTILEDISABLE);
	
	
	MenuItem SaveAsAll = new MenuItem(SAVE_ALL, false, new Command() {
		public void execute() {
			ColeccionActual.setName("");
			ColeccionActual.setId(null);
			SaveCollectionMetod();
		}
	});
	menuBar_5.addItem(SaveAsAll);
	
	MenuItem SaveAsOnlySchema = new MenuItem(ONLY_SCHEMA, false, new Command() {
		public void execute() {
			ColeccionActual.setName("");
			ColeccionActual.setId(null);
			if (Window.confirm(ARE_YOU_SURE_YOU_WANT_TO_SAVE_ONLY_THE_SCHEMA_LOCAL))
				{ 
					ColeccionActual.setSectionValues(new ArrayList<Resources>());
					SaveCollectionMetod();
				}
			
		}
	});
	menuBar_5.addItem(SaveAsOnlySchema);
	menuBar_1.addItem(SaveAsMenuItem);
	
	MenuItemSeparator separator_2 = new MenuItemSeparator();
	menuBar_1.addSeparator(separator_2);
	MenuImportElements = new MenuBar(true);
	
	MenuItem ImportMenuItem = new MenuItem(IMPORT_MENUITEM, true, MenuImportElements);
	
	
	importservice.GetColecciones(new AsyncCallback<ArrayList<CollectionImport>>() {
		
		@Override
		public void onSuccess(ArrayList<CollectionImport> result) {
			for (CollectionImport colleciones : result) {
				MenuItem Load=new MenuItemImport(colleciones,yo);
				MenuImportElements.addItem(Load);
			}
			
		}
		
		@Override
		public void onFailure(Throwable caught) {
			Window.alert(ConstantsError.ERROR_RETRIVING_LOAD_COLLECTION);
			
		}
	});
	
	ImportMenuItem.setHTML(IMPORT_MENUITEM);
	menuBar_1.addItem(ImportMenuItem);
	MenuExportElements = new MenuBar(true);
	
	ExportMenuItem = new MenuItem(EXPORT_MENUITEM, true, MenuExportElements);
	ExportMenuItem.setEnabled(false);
	ExportMenuItem.addStyleName(MENUITEMSTILEDISABLE);
	

exportservice.GetColecciones(new AsyncCallback<ArrayList<CollectionExport>>() {
		
		@Override
		public void onSuccess(ArrayList<CollectionExport> result) {
			for (CollectionExport colleciones : result) {
				MenuItem Load=new MenuItemExport(colleciones);
				MenuExportElements.addItem(Load);
			}
			
		}
		
		@Override
		public void onFailure(Throwable caught) {
			Window.alert(ConstantsError.ERROR_RETRIVING_LOAD_COLLECTION);
			
		}
	});
	
	

	ExportMenuItem.setHTML(EXPORT_MENUITEM);
	menuBar_1.addItem(ExportMenuItem);
	
	MenuItemSeparator separator_3 = new MenuItemSeparator();
	menuBar_1.addSeparator(separator_3);
	
	DeleteMenuItem = new MenuItem(DELETE_COLLECTION, false, new Command() {
		public void execute() {
			if (ColeccionActual.getName() == null
					|| ColeccionActual.getName().isEmpty()) {
				Window.alert(COLLECTION_IS_NOT_SAVED_YET);

			} else {
				if (Window.confirm(ARE_YOU_SURE_TO_REMOVE_THE_COLLECTION+ ColeccionActual.getName() + ConstantsInformation.Q))
				{
					LoadingPopupPanel.getInstance().setLabelTexto(
							ConstantsInformation.DELETING);
					LoadingPopupPanel.getInstance().center();
					serviceOda.DeleteCollection(ColeccionActual,ControladorEntryPoint.ActualUSer,  new AsyncCallback<UserServer>() {
						
						@Override
						public void onSuccess(UserServer result) {
							
							ColeccionActual = null;
							ControladorEntryPoint.ActualUSer=result;
							Window.alert(ConstantsInformation.DELETECOMPLETE);
							Borradoinicio();
							RefreshListaCollections();
							LoadingPopupPanel.getInstance()
							.hide();

							
						}
						
						@Override
						public void onFailure(Throwable caught) {
							LoadingPopupPanel.getInstance()
							.hide();
							Window.alert(ConstantsError.ERROR_DELETECOMPLETE);
							
						}
					});
				}
		}
		}
	});
	DeleteMenuItem.setHTML(DELETE_COLLECTION);

		DeleteMenuItem.addStyleName(MENUITEMSTILEDISABLE);
		DeleteMenuItem.setEnabled(false);
	menuBar_1.addItem(DeleteMenuItem);
	
	MenuItemSeparator separator_4 = new MenuItemSeparator();
	menuBar_1.addSeparator(separator_4);
	
	
	PublishColection = new MenuItem(PublishCollectionText, false, new Command() {
		public void execute() {
			PublishedPopUpMenu PublishMenu=new PublishedPopUpMenu(yo);
			PublishMenu.center();
			
		}
	});
	PublishColection.setHTML(PublishCollectionText);
	menuBar_1.addItem(PublishColection);
	PublishColection.addStyleName(MENUITEMSTILEDISABLE);
	PublishColection.setEnabled(false);
	
	UnPublishColection = new MenuItem(PublishCollectionText, false, new Command() {

		public void execute() {
			if (Window.confirm(ARE_YOU_SURE_TO_UNPLUBLISH_COLLECTION))
				{
				serviceOda.UnPublishCollection(ControladorEntryPoint.ActualUSer, ColeccionActual,new AsyncCallback<UserServer>()
						{

							@Override
							public void onFailure(Throwable caught) {
								Window.alert(ConstantsError.ERROR_UNPUBLISHING_COLLECTION);
								
							}

							@Override
							public void onSuccess(UserServer result) {
								ControladorEntryPoint.ActualUSer=result;
								Reinicioinicio(ColeccionActual);
								
							}
					
						});
				}
			
		}
	});
	UnPublishColection.setHTML(UnPublishCollectionText);
	menuBar_1.addItem(UnPublishColection);
	UnPublishColection.addStyleName(MENUITEMSTILEDISABLE);
	UnPublishColection.setEnabled(false);
	
	MenuItemSeparator separator_5 = new MenuItemSeparator();
	menuBar_1.addSeparator(separator_5);
	
	MenuItem BotonSalir = new MenuItem(SALIR, true, new Command() {
		public void execute() {
			Cookies.removeCookie(ControladorEntryPoint.COOKIE_NAME);
			ColeccionActual=null;
			ControladorEntryPoint.ToLoginWindowEditor();
		}
	});
	menuBar_1.addItem(BotonSalir);
	BotonSalir.setHTML(SALIR);

	menuBar.addItem(FileMenuItem);
	
	yo=this;
	
	MenuItemSeparator separator = new MenuItemSeparator();
	menuBar.addSeparator(separator);
	
	MenuItem VisualizeMenuItem = new MenuItem(VISUALIZECOLLECTION, true, new Command() {
		public void execute() {
			SplitLayoutPanelPropio.setColeccionAndBasePath(ColeccionActual,"http://"+Window.Location.getHost()+"/ME2013/Files/"+ColeccionActualPath);
			ControladorEntryPoint.ToVisualizeCollection();
		}
	});
	VisualizeMenuItem.setHTML(VISUALIZECOLLECTION);
	menuBar.addItem(VisualizeMenuItem);
	
	MenuItemSeparator separator_1 = new MenuItemSeparator();
	menuBar.addSeparator(separator_1);
	
	CollectionNameMenuItem = new MenuItem(COLLECTION_MENUITEM, true, (Command) null);
	menuBar.addItem(CollectionNameMenuItem);
	CollectionNameMenuItem.setHTML(COLLECTION_MENUITEM);
	CollectionNameMenuItem.setEnabled(false);
	CollectionNameMenuItem.setVisible(false);
	
	StateMenuItem = new MenuItem(PUBLISHED, true, (Command) null);
	StateMenuItem.addStyleName("BotonletrasRojas");
	StateMenuItem.setHTML(PUBLISHED);
	StateMenuItem.setEnabled(false);
	StateMenuItem.setVisible(false);
	menuBar.addItem(StateMenuItem);
	
	SplitLayoutPanel PanelGeneral = new SplitLayoutPanel();
	dockLayoutPanel.add(PanelGeneral);
	
	SplitLayoutPanel PanelSeleccionOpciones = new SplitLayoutPanel();
	PanelGeneral.addEast(PanelSeleccionOpciones, 400.0);
	PanelSeleccionOpciones.setSize("100%", "100%");
	
	SimplePanel Acciones = new SimplePanel();
	PanelSeleccionOpciones.addWest(Acciones, 200.0);
	Acciones.setSize("", "100%");
	
	PanelCentrar = new HorizontalPanel();
	Acciones.setWidget(PanelCentrar);
	PanelCentrar.setSize("100%", "100%");
	PanelCentrar.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
	PanelCentrar.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
	
	panelAccionesModelo = new VerticalPanel();
	PanelCentrar.add(panelAccionesModelo);
	panelAccionesModelo.setSize("100%", "");
	
	DeleteModelButton = new Button(DELETEMODELBUTTON);
	DeleteModelButton.addClickHandler(new ClickHandler() {
		public void onClick(ClickEvent event) {
			for (int i = 0; i < Seleccion.getWidgetCount(); i++) {
				borrarelemento((AtributoModeloButton)Seleccion.getWidget(i));
				}
		}
	});
	panelAccionesModelo.add(DeleteModelButton);
	DeleteModelButton.setWidth("100%");
	
	RenameButton = new Button(RENAMEBUTTON);
	RenameButton.addClickHandler(new ClickHandler() {
		public void onClick(ClickEvent event) {
			for (int i = 0; i < Seleccion.getWidgetCount(); i++) {
				if (Seleccion.getWidget(i) instanceof AtributoModeloButton)
				{
				RenameSeleccionModeloPopupPanel RSPUP=new RenameSeleccionModeloPopupPanel((AtributoModeloButton)Seleccion.getWidget(i));
				RSPUP.center();
				}
			}
		}
	});
	panelAccionesModelo.add(RenameButton);
	RenameButton.setWidth("100%");
	
	MergeAttButton = new Button(MERGE_ATTRIBUTES);
	MergeAttButton.addClickHandler(new ClickHandler() {
		public void onClick(ClickEvent event) {
				if (Seleccion.getWidgetCount()<2)
					Window.alert(ConstantsError.ERROR_LESS_THAN_TWO_ELEMENTS);
				else 
					{
					PanelSeleccionMergeModeloPopupPanel PSPP=new PanelSeleccionMergeModeloPopupPanel(Seleccion,yo);
					PSPP.center();
				}

		}

	});
	panelAccionesModelo.add(MergeAttButton);
	MergeAttButton.setSize("100%", "");
	
	MergeVocabulary = new Button(MERGE_VOCABULARIES);
	MergeVocabulary.addClickHandler(new ClickHandler() {
		public void onClick(ClickEvent event) {
			if (Seleccion.getWidgetCount()<2)
				Window.alert(ConstantsError.ERROR_LESS_THAN_TWO_ELEMENTS);
			else if (!checkControlados())
				Window.alert(ConstantsError.ERROR_NOT_VOCABULARIES);
			else 
				{
				ArrayList<MetaControlled> Lista=new ArrayList<MetaControlled>();
				for (Widget widget : Seleccion) {
					Lista.add((MetaControlled)((AtributoModeloButton)widget).getAttribute());
				}
				unirvocabularios(Lista, true);
				Seleccion.clear();
				//refreshModeloActual();
				}
		}

		
		/**
		 * Funcion que chequea si todos los botones son MetaControlled
		 * @return si todos son meta controlled
		 */
		private boolean checkControlados() {
			for (Widget widget : Seleccion) {
				if (!(widget instanceof AtributoModeloButton))
					return false; 
				else if (!(((AtributoModeloButton)widget).getAttribute() instanceof MetaControlled))
					return false; 
				
			}
			return true;
		}
	});
	panelAccionesModelo.add(MergeVocabulary);
	MergeVocabulary.setWidth("100%");
	
	Button ChangeSummaryValue = new Button(CHANGESUMMARYVALUE);
	ChangeSummaryValue.addClickHandler(new ClickHandler() {
		public void onClick(ClickEvent event) {
			for (Widget widget : Seleccion) {
				AtributoModeloButton boton = ((AtributoModeloButton)widget);
				 boton.getElementoEnArbol().changeSummary();
				
			}
		}
	});
	panelAccionesModelo.add(ChangeSummaryValue);
	ChangeSummaryValue.setWidth("100%");
	
	ChangeBrowsablility = new Button(CHANGE_BROWSABILITY);
	ChangeBrowsablility.addClickHandler(new ClickHandler() {
		public void onClick(ClickEvent event) {
			for (Widget widget : Seleccion) {
				AtributoModeloButton boton = ((AtributoModeloButton)widget);
				 boton.getElementoEnArbol().changeBrosability();
				
			}

		}
	});
	panelAccionesModelo.add(ChangeBrowsablility);
	ChangeBrowsablility.setWidth("100%");
	
	Button ChangeVisibility = new Button(CHANGE_VISIVBILITY);
	ChangeVisibility.addClickHandler(new ClickHandler() {
		public void onClick(ClickEvent event) {
			for (Widget widget : Seleccion) {
				AtributoModeloButton boton = ((AtributoModeloButton)widget);
				 boton.getElementoEnArbol().changeVisibility();
				
			}
		}
	});
	panelAccionesModelo.add(ChangeVisibility);
	ChangeVisibility.setWidth("100%");
	
	
	SimplePanel PanelSeleccionContainer = new SimplePanel();
	PanelSeleccionOpciones.add(PanelSeleccionContainer);
	PanelSeleccionContainer.setSize("100%", "100%");
	
	ScrollPanel ScrollPanelSeleccion = new ScrollPanel();
	PanelSeleccionContainer.setWidget(ScrollPanelSeleccion);
	ScrollPanelSeleccion.setSize("100%", "100%");
	
	Seleccion = new VerticalPanel();
	ScrollPanelSeleccion.setWidget(Seleccion);
	Seleccion.setSize("100%", "100%");
	
	DockLayoutPanel PanelSchemas = new DockLayoutPanel(Unit.PX);
	PanelGeneral.add(PanelSchemas);
	PanelSchemas.setSize("100%", "100%");
	
	SimplePanel PanelLeyendaModel = new SimplePanel();
	PanelSchemas.addSouth(PanelLeyendaModel, 75.0);
	
	ScrollPanel ScrollPanelLeyenda = new ScrollPanel();
	PanelLeyendaModel.setWidget(ScrollPanelLeyenda);
	ScrollPanelLeyenda.setSize("100%", "100%");
	
	HorizontalPanel PanleLeyendaGeneralModel = new HorizontalPanel();
	ScrollPanelLeyenda.setWidget(PanleLeyendaGeneralModel);
	PanleLeyendaGeneralModel.setSpacing(3);
	PanleLeyendaGeneralModel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
	PanleLeyendaGeneralModel.setSize("100%", "100%");
	
	HorizontalPanel PanelLeyendaAtributosModel = new HorizontalPanel();
	PanleLeyendaGeneralModel.add(PanelLeyendaAtributosModel);
	PanelLeyendaAtributosModel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
	PanelLeyendaAtributosModel.setSpacing(10);
	PanelLeyendaAtributosModel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
	PanelLeyendaAtributosModel.setSize("920px", "100%");
	
	Label AttributeLabel = new Label(ATTRIBUTE);
	PanelLeyendaAtributosModel.add(AttributeLabel);
	
	Label TextAttributeLabel = new Label(TEXT_ATTRIBUTE);
	TextAttributeLabel.setStyleName("gwt-LabelTextAttribute");
	PanelLeyendaAtributosModel.add(TextAttributeLabel);
	
	Label NumericAttributeLabel = new Label(NUMERIC_ATTRIBUTE);
	NumericAttributeLabel.setStyleName("gwt-LabelNumericAttribute");
	PanelLeyendaAtributosModel.add(NumericAttributeLabel);
	
	Label DateAttributeLabel = new Label(DATE_ATTRIBUTE);
	DateAttributeLabel.setStyleName("gwt-LabelDateAttribute");
	PanelLeyendaAtributosModel.add(DateAttributeLabel);
	
	Label ControlledAttributeLabel = new Label(CONTROLLED_ATTRIBUTE);
	ControlledAttributeLabel.setStyleName("gwt-LabelControlledAttribute");
	PanelLeyendaAtributosModel.add(ControlledAttributeLabel);
	
	Label BooleanAttributeLabel = new Label("Boolean Attribute");
	BooleanAttributeLabel.setStyleName("gwt-LabelBooleanAttribute");
	PanelLeyendaAtributosModel.add(BooleanAttributeLabel);
	
	Label RelationAttributeLabel = new Label("Relation Attribute");
	RelationAttributeLabel.setStyleName("gwt-LabelRelationAttribute");
	PanelLeyendaAtributosModel.add(RelationAttributeLabel);
	
	Label Multievaluado = new Label(MULTIVALUED);
	PanelLeyendaAtributosModel.add(Multievaluado);
	Multievaluado.setStyleName("gwt-LabelMultievaluado");
	
	SimplePanel Glue1Model = new SimplePanel();
	PanleLeyendaGeneralModel.add(Glue1Model);
	Glue1Model.setSize("22px", "10px");
	
	VerticalPanel PanelLeyendaNevegabilidadModel = new VerticalPanel();
	PanleLeyendaGeneralModel.add(PanelLeyendaNevegabilidadModel);
	PanelLeyendaNevegabilidadModel.setWidth("120px");
	
	Label NoNavegable = new Label(NOT_BROWSEABLE);
	PanelLeyendaNevegabilidadModel.add(NoNavegable);
	
	Label Navegable = new Label(BROWSEABLE);
	Navegable.setStyleName("gwt-LabelNegrita");
	PanelLeyendaNevegabilidadModel.add(Navegable);
	
	SimplePanel Glue2Model = new SimplePanel();
	PanleLeyendaGeneralModel.add(Glue2Model);
	Glue2Model.setSize("22px", "10px");
	
	HorizontalPanel PanelLeyendaVocabularioModel = new HorizontalPanel();
	PanelLeyendaVocabularioModel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
	PanleLeyendaGeneralModel.add(PanelLeyendaVocabularioModel);
	PanelLeyendaVocabularioModel.setWidth("190px");
	
	Button BotonEjemploVocabulario = new Button(VOCABULARIO);
	BotonEjemploVocabulario.setStyleName("vocabularyButton gwt-Button");
	PanelLeyendaVocabularioModel.add(BotonEjemploVocabulario);
	
	Label LabelLeyendaVocabulario = new Label(VOCABULARIO_INSTANCE);
	PanelLeyendaVocabularioModel.add(LabelLeyendaVocabulario);
	
	SimplePanel Glue3Model = new SimplePanel();
	PanleLeyendaGeneralModel.add(Glue3Model);
	Glue3Model.setSize("22px", "10px");
	
	HorizontalPanel SummaryPanelLeyenda = new HorizontalPanel();
	SummaryPanelLeyenda.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
	SummaryPanelLeyenda.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
	PanleLeyendaGeneralModel.add(SummaryPanelLeyenda);
	SummaryPanelLeyenda.setWidth("170px");
	
	VerticalPanel ButtonMasImage = new VerticalPanel();
	ButtonMasImage.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
	ButtonMasImage.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
	SummaryPanelLeyenda.add(ButtonMasImage);
	
	Button btnAttName = new Button(ATTNAME);
	ButtonMasImage.add(btnAttName);
	
	Image image = new Image(IMAGEATTNAME);
	ButtonMasImage.add(image);
	image.setSize("100%", "12px");
	
	Label LeyendaSummary = new Label(SUMMARYLABEL);
	SummaryPanelLeyenda.add(LeyendaSummary);
	
	SimplePanel Glue4Model = new SimplePanel();
	PanleLeyendaGeneralModel.add(Glue4Model);
	Glue4Model.setSize("22px", "10px");
	
	HorizontalPanel VisiblePanelLeyelda = new HorizontalPanel();
	VisiblePanelLeyelda.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
	VisiblePanelLeyelda.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
	PanleLeyendaGeneralModel.add(VisiblePanelLeyelda);
	VisiblePanelLeyelda.setWidth("170px");
	
	Button Visible = new Button(Space);
	Visible.addStyleName("vocabularyButton2");
	VisiblePanelLeyelda.add(Visible);
	
	Label VisibleLabel = new Label(VISIBLE);
	VisiblePanelLeyelda.add(VisibleLabel);
	
	HorizontalPanel horizontalPanel = new HorizontalPanel();
	horizontalPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
	horizontalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
	PanleLeyendaGeneralModel.add(horizontalPanel);
	horizontalPanel.setWidth("170px");
	
	Button NoVisible = new Button(Space);
	horizontalPanel.add(NoVisible);
	NoVisible.addStyleName("vocabularyButton3");
	
	Label NoVisibleLabel = new Label(NOVISIBLE);
	horizontalPanel.add(NoVisibleLabel);
	
	
	SimplePanel Glue5Model = new SimplePanel();
	PanleLeyendaGeneralModel.add(Glue5Model);
	Glue5Model.setSize("22px", "10px");
	
	HorizontalPanel PanelLeyendaAnadirModel = new HorizontalPanel();
	PanelLeyendaAnadirModel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
	PanleLeyendaGeneralModel.add(PanelLeyendaAnadirModel);
	PanelLeyendaAnadirModel.setWidth("170px");
	
	Button BotonEjemploAnadir = new Button(IMAGEN_ADD);
	PanelLeyendaAnadirModel.add(BotonEjemploAnadir);
	
	Label LabelEjemploAñadir = new Label(LABEL_ADD);
	PanelLeyendaAnadirModel.add(LabelEjemploAñadir);
	
	SimplePanel ModeloActualPanel = new SimplePanel();
	PanelSchemas.add(ModeloActualPanel);
	ModeloActualPanel.setSize("100%", "100%");
	
	ScrollPanel panelModeloScroll = new ScrollPanel();
	ModeloActualPanel.setWidget(panelModeloScroll);
	panelModeloScroll.setSize("100%", "100%");
	
	PanelModeloVertical = new VerticalPanel();
	panelModeloScroll.setWidget(PanelModeloVertical);
	PanelModeloVertical.setSize("100%", "100%");
	
	
	if (ColeccionActual!=null)
		{
		refreshSchemas();
		ExportMenuItem.setEnabled(true);
		ExportMenuItem.removeStyleName(MENUITEMSTILEDISABLE);
		SaveSubMenu.setEnabled(true);
		SaveSubMenu.removeStyleName(MENUITEMSTILEDISABLE);
		SaveAsMenuItem.setEnabled(true);
		SaveAsMenuItem.removeStyleName(MENUITEMSTILEDISABLE);
		
		if (ColeccionActual!=null&&ColeccionActual.getId()!=null)
			{
			DeleteMenuItem.setEnabled(true);
			DeleteMenuItem.removeStyleName(MENUITEMSTILEDISABLE);
		}
			
		CollectionPropias ColeccionAsociada=EditorMainWindowEditor.getCollectionInterbyCollection();
		if (ColeccionAsociada!=null)

			if (ColeccionAsociada.isPublica())
			{
			StateMenuItem.setVisible(true);
			StateMenuItem.setEnabled(true);
			StateMenuItem.setText(PUBLISHED+ GWT.getHostPageBaseURL()+"?name="+ColeccionAsociada.getPublicname());
			
			ColeccionAsociadaFin=ColeccionAsociada.getPublicname();
			StateMenuItem.setScheduledCommand(new Command() {
				
				@Override
				public void execute() {
					Window.open(GWT.getHostPageBaseURL()+"?name="+ColeccionAsociadaFin, "_blank", "");
					
				}
			});
			UnPublishColection.setEnabled(true);
			UnPublishColection.removeStyleName(MENUITEMSTILEDISABLE);
			PublishColection.setEnabled(false);
			PublishColection.addStyleName(MENUITEMSTILEDISABLE);
			}
			else
			{
				PublishColection.setEnabled(true);
				PublishColection.removeStyleName(MENUITEMSTILEDISABLE);
			}
			
			
			
		
		String Name="Unknown";
		if (ColeccionActual.getName()!=null&&!ColeccionActual.getName().isEmpty())
			Name=ColeccionActual.getName();
		CollectionNameMenuItem.setHTML(COLLECTION_MENUITEM+ Space + Name);
		CollectionNameMenuItem.setVisible(true);
		}
	
	
	
	}
	
	
	protected void SaveCollectionMetod() {
		
			if (ColeccionActual.getName() == null
					|| ColeccionActual.getName().isEmpty()) {
				SalvadoPopUp PP=new SalvadoPopUp(ColeccionActual,yo);
				PP.center();

			} else {
					LoadingPopupPanel.getInstance().setLabelTexto(
							ConstantsInformation.SAVING);
					LoadingPopupPanel.getInstance().center();
					serviceOda.SaveCollection(ColeccionActual,ColeccionActualPath,ControladorEntryPoint.ActualUSer,
							new AsyncCallback<UserAndCollection>() {

								@Override
								public void onSuccess(UserAndCollection result) {

									LoadingPopupPanel.getInstance()
											.hide();
									ControladorEntryPoint.ActualUSer=result.getUsuario();
									ColeccionActual = result.getColeccion();
									CollectionPropias ColeccionAsociada=EditorMainWindowEditor.getCollectionInterbyCollection();
									if (ColeccionAsociada!=null)
										{
										ColeccionActualPath=ColeccionAsociada.getFilePath();
										}
									
									Window.alert(ConstantsInformation.SAVECOMPLETE);

								}

								@Override
								public void onFailure(Throwable caught) {
									LoadingPopupPanel.getInstance()
											.hide();
									Window.alert(ConstantsError.ERROR_SAVING_COLLECTION);
									caught.printStackTrace();
								}
							});
				}
//			}
		
		
	}


	/**
	 * Funcion que reinicia para un catalogo nuevo.
	 * @param result
	 */
	public void Reinicioinicio(Collection result) {
		ColeccionActual=result;
		Seleccion.clear();
		ListaState=new HashMap<CollectionAttribute, Boolean>();
		ListaStateSections=new HashMap<Construct, Boolean>();
		ListaVocabulary=new HashMap<CompositeModeloBotonComposite, Vocabulary>();
		VocabularyHashset=new ArrayList<Vocabulary>();
		BotonesAttributo=new ArrayList<Button>();
		SplitLayoutPanelPropio.setFlagsDeApertura(new HashMap<Meta, Boolean>());
		SplitLayoutPanelPropio.setFlagsDeAperturaTerm(new HashMap<Term, Boolean>());
		LoadingPopupPanel.getInstance().hide();
		refreshSchemas();
		ExportMenuItem.setEnabled(true);
		ExportMenuItem.removeStyleName(MENUITEMSTILEDISABLE);
		SaveSubMenu.setEnabled(true);
		SaveSubMenu.removeStyleName(MENUITEMSTILEDISABLE);
		SaveAsMenuItem.setEnabled(true);
		SaveAsMenuItem.removeStyleName(MENUITEMSTILEDISABLE);
		DeleteMenuItem.setEnabled(false);
		DeleteMenuItem.addStyleName(MENUITEMSTILEDISABLE);
		String Name="Unknown";
		
		
		
		if (ColeccionActual!=null&&ColeccionActual.getId()!=null)
			{
			DeleteMenuItem.setEnabled(true);
			DeleteMenuItem.removeStyleName(MENUITEMSTILEDISABLE);
			Name=result.getName();
			

			PublishColection.setEnabled(true);
			PublishColection.removeStyleName(MENUITEMSTILEDISABLE);
			UnPublishColection.setEnabled(false);
			UnPublishColection.addStyleName(MENUITEMSTILEDISABLE);
			StateMenuItem.setVisible(false);
			StateMenuItem.setEnabled(false);
		
			}
		else
		{
			StateMenuItem.setVisible(false);
			StateMenuItem.setEnabled(false);
			PublishColection.setEnabled(false);
			PublishColection.addStyleName(MENUITEMSTILEDISABLE);
			UnPublishColection.setEnabled(false);
			UnPublishColection.addStyleName(MENUITEMSTILEDISABLE);
		}
		
		CollectionPropias ColeccionAsociada=EditorMainWindowEditor.getCollectionInterbyCollection();
		if (ColeccionAsociada!=null)

			if (ColeccionAsociada.isPublica())
			{
			StateMenuItem.setVisible(true);
			StateMenuItem.setEnabled(true);
			StateMenuItem.setText(PUBLISHED+ GWT.getHostPageBaseURL()+"?name="+ColeccionAsociada.getPublicname());
			
			ColeccionAsociadaFin=ColeccionAsociada.getPublicname();
			StateMenuItem.setScheduledCommand(new Command() {
				
				@Override
				public void execute() {
					Window.open(GWT.getHostPageBaseURL()+"?name="+ColeccionAsociadaFin, "_blank", "");
					
				}
			});
			UnPublishColection.setEnabled(true);
			UnPublishColection.removeStyleName(MENUITEMSTILEDISABLE);
			PublishColection.setEnabled(false);
			PublishColection.addStyleName(MENUITEMSTILEDISABLE);
			}
			else
			{
				PublishColection.setEnabled(true);
				PublishColection.removeStyleName(MENUITEMSTILEDISABLE);
				StateMenuItem.setVisible(false);
				StateMenuItem.setEnabled(false);
			}
		
			
		CollectionNameMenuItem.setHTML(COLLECTION_MENUITEM+ Space + Name);
		CollectionNameMenuItem.setVisible(true);
		
	}

	public static CollectionPropias getCollectionInterbyCollection() {
		List<CollectionPropias> A = ControladorEntryPoint.ActualUSer.getColecciones();
		for (CollectionPropias collectionPropias : A) {
			if (collectionPropias.getId().equals(ColeccionActual.getId()))
				return collectionPropias;
		}
		return null;
	}


	/**
	 * Funcion que reinicia para un Borrado nuevo.
	 * @param result
	 */
	public void Borradoinicio() {
		ColeccionActual=null;
		Seleccion.clear();
		ListaState=new HashMap<CollectionAttribute, Boolean>();
		ListaStateSections=new HashMap<Construct, Boolean>();
		ListaVocabulary=new HashMap<CompositeModeloBotonComposite, Vocabulary>();
		VocabularyHashset=new ArrayList<Vocabulary>();
		BotonesAttributo=new ArrayList<Button>();
		SplitLayoutPanelPropio.setFlagsDeApertura(new HashMap<Meta, Boolean>());
		SplitLayoutPanelPropio.setFlagsDeAperturaTerm(new HashMap<Term, Boolean>());
		LoadingPopupPanel.getInstance().hide();
		BotonesAttributo=new ArrayList<Button>();
		PanelModeloVertical.clear();
		ExportMenuItem.setEnabled(false);
		ExportMenuItem.addStyleName(MENUITEMSTILEDISABLE);
		SaveSubMenu.setEnabled(false);
		SaveSubMenu.addStyleName(MENUITEMSTILEDISABLE);
		SaveAsMenuItem.setEnabled(false);
		SaveAsMenuItem.addStyleName(MENUITEMSTILEDISABLE);
		DeleteMenuItem.setEnabled(false);
		DeleteMenuItem.addStyleName(MENUITEMSTILEDISABLE);
		String Name="Unknown";
		CollectionNameMenuItem.setHTML(COLLECTION_MENUITEM+ Space + Name);
		CollectionNameMenuItem.setVisible(false);
		PublishColection.setEnabled(false);
		PublishColection.addStyleName(MENUITEMSTILEDISABLE);
		StateMenuItem.setVisible(false);
		UnPublishColection.setEnabled(false);
		UnPublishColection.addStyleName(MENUITEMSTILEDISABLE);
		ColeccionActualPath="";
		
	}


	/**
	 * Funcion que une dos vocabularios
	 * @param lista Lista de vocabyularios a unir
	 * @param refresco desfine si se necesita el refresco de los padres unidos o se realizara un refresco desde la zona superior.
	 */
	public static void unirvocabularios(ArrayList<MetaControlled> lista,Boolean refresco) {
		MetaControlled A=lista.get(0);
		Vocabulary Voca=A.getVocabulary();
		HashSet<Vocabulary> procesados=new HashSet<Vocabulary>();
		procesados.add(Voca);
		for (int i = 1; i < lista.size(); i++) {
			if (!procesados.contains(lista.get(i).getVocabulary()))
				{
				procesados.add(lista.get(i).getVocabulary());
				unirTerminos(Voca.getList(),lista.get(i).getVocabulary().getList());
				foundAndChangeVocabularies(lista.get(i).getVocabulary(),Voca,ColeccionActual.getMetamodelSchemas());
				}
		}
		if (refresco)
			refrescapadres(procesados);
		
	}
	
	/**
	 * Refresca los padre de los vocabularios procesados
	 * @param procesados lista cullos padres necesitan refresco.
	 */
	private static void refrescapadres(HashSet<Vocabulary> procesados) {
		ArrayList<CompositeModeloBotonComposite> aRefrescar=new ArrayList<CompositeModeloBotonComposite>();
		for (Entry<CompositeModeloBotonComposite, Vocabulary> entryset : ListaVocabulary.entrySet()) {
			if (procesados.contains(entryset.getValue()))
				aRefrescar.add(entryset.getKey());
		}
		for (CompositeModeloBotonComposite compositeModeloBotonComposite : aRefrescar) {
			if (compositeModeloBotonComposite.getPadreComposite()!=null)
				compositeModeloBotonComposite.getPadreComposite().ProcessSons(compositeModeloBotonComposite.getPanelSeleccion(), compositeModeloBotonComposite.getIndexEntryPoint());
			else compositeModeloBotonComposite.getIndexEntryPoint().refreshModeloActual();
		}
		processSize();
	}



	/**
	 * Busca dentro de cada objeto virtual y une sus vocabularios
	 * @param buscar vocabulario a buscar 1
	 * @param destinio vocabulario destino 2
	 * @param list lista en la que se sustituye
	 * 
	 */
	public static void foundAndChangeVocabularies(Vocabulary buscar,
			Vocabulary destinio, List<CollectionAttribute> list) {
		if (list!=null)
			for (CollectionAttribute elemento : list) {
				if ((elemento instanceof MetaControlled)&& (((MetaControlled)elemento).getVocabulary()==buscar))
					((MetaControlled)elemento).setVocabulary(destinio);
				foundAndChangeVocabularies(buscar, destinio, elemento.getSons());

		}
	}

	/**
	 * Funcionq une los terminos en una sola lista.
	 * @param list lista 1 y lista salida de la union
	 * @param list2 lista 2 que se unira a las lista 1 o list
	 */
	public static void unirTerminos(List<Term> list,
			List<Term> list2) {
		boolean found=false;
		for (Term candidato : list2) {
			found=false;
			for (Term Actuales : list) {
				if (candidato.getTerm().equals(Actuales.getTerm()))
					{
					found=true;
					if (candidato!=Actuales)
						sustituye(candidato,Actuales);
					}
			}
			if (!found)
				list.add(candidato);
		}
	}	
	
	
	/**
		 * Funcion que sustituye en los terminos dentro de los objetos.
		 * @param candidato a sustituir
		 * @param nuevo destino
		 */
		public static void sustituye(Term candidato, Term nuevo) {
			for (Resources elemento : ColeccionActual.getSectionValues()) {
				for (MetaValue atributo : elemento.getDescription()) {
					if ((atributo instanceof MetaControlledValue)&& (((MetaControlledValue)atributo).getValue()==candidato))
						((MetaControlledValue)atributo).setValue(nuevo);
				}

			}
			
			}


	/**
	 * Funcion que borra un atributo del esquema de modelo
	 * @param atributoaBorrar atributo a borrar del equema del modelo
	 */
	protected void borrarelemento(AtributoModeloButton atributoaBorrar) {
		if (!tieneODAtribuidos(atributoaBorrar.getAttribute()))
			{
			if (Window.confirm(ConstantsInformation.ARE_YOU_SURE_TO_REMOVE_ATTIBUTE + Space+ pathFather(atributoaBorrar.getAttribute())))
				{
				if (atributoaBorrar.getAttribute().getFather()==null)
				{
					ColeccionActual.getMetamodelSchemas().remove(atributoaBorrar.getAttribute());
					refreshModeloActual();
				}
				else {
					atributoaBorrar.getAttribute().getFather().getSons().remove(atributoaBorrar.getAttribute());
					atributoaBorrar.getElementoEnArbol().getPadreComposite().ProcessSons(Seleccion, yo);
					EditorMainWindowEditor.processSize();
				}
					
				
				Seleccion.clear();
				}
			}
		else Window.alert(ConstantsInformation.OV_ASIGNADOS + Space + ((Meta)atributoaBorrar.getAttribute()).getName());
		
		
	}
	
	
	/**
	 * Funcion que borra un atributo del esquema de modelo
	 * @param atributoaBorrar atributo a borrar del equema del modelo
	 */
	public void borrarelementoIterador(CompositeModeloBotonComposite elementoEnArbol,
			EditorMainWindowEditor indexEntryPoint) {
		if (!tieneODAtribuidos(elementoEnArbol.getElementoBoton()))
			{
			if (Window.confirm(ConstantsInformation.ARE_YOU_SURE_TO_REMOVE_ATTIBUTE + Space+ pathFather(elementoEnArbol.getElementoBoton())))
				{
				if (elementoEnArbol.getElementoBoton().getFather()==null)
				{
					ColeccionActual.getMetamodelSchemas().remove(elementoEnArbol.getElementoBoton());
					refreshModeloActual();
				}
				else {
					elementoEnArbol.getElementoBoton().getFather().getSons().remove(elementoEnArbol.getElementoBoton());
					elementoEnArbol.getPadreComposite().ProcessSons(Seleccion, yo);
					EditorMainWindowEditor.processSize();
				}
				
				Seleccion.clear();
				}
			}
		else Window.alert(ConstantsInformation.OV_ASIGNADOS);
		
		
	}


	/**
	 * Busca en los atributos si existe una referencia de el meta
	 * @param elementohijo2 atributo a buscar
	 * @return si esta en las referencias
	 */
	private boolean tieneODAtribuidos(CollectionAttribute elementohijo2) {
		for (Resources elemento : ColeccionActual.getSectionValues()) {
			for (MetaValue atributo : elemento.getDescription()) {
				if (atributo.getHastype()==elementohijo2)
					return true;
			}

		}
		for (CollectionAttribute elementohijo : elementohijo2.getSons()) {
			if (tieneODAtribuidos(elementohijo))
				return true;
		}
		return false;
	}




	/**
	 * Funcion que refresca el model actual
	 */
	public void refreshModeloActual() {
		BotonesAttributo=new ArrayList<Button>();
		if (ColeccionActual!=null)
			{
			cleanHijos();
			PanelModeloVertical.clear();
			Button NewButton = new Button(IMGADD);
			NewButton.addClickHandler(new ClickHandler() {
				public void onClick(ClickEvent event) {
					PanelNewElementModelPopupPanel PN =new PanelNewElementModelPopupPanel(ColeccionActual,yo);
					PN.center();
				}
			});
			PanelModeloVertical.add(NewButton);
			for (CollectionAttribute AttHijo : ColeccionActual.getMetamodelSchemas()) {
				CompositeModeloBotonComposite Compnuew=new CompositeModeloBotonComposite(AttHijo,Seleccion,yo,null);
				PanelModeloVertical.add(Compnuew);
			}
			}
		processSize();
	}

	/**
	 * Limpia los hijos del modelo actual
	 */
	private void cleanHijos() {
		for (Widget widget : PanelModeloVertical) {
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
	 * Funcion que refresca todos los esquemas
	 */
	private void refreshSchemas()
	{
		refreshModeloActual();
	}



	


	/**
	 * Procesa el tamaño de los botones
	 */
	public static void processSize() {
		heightBotones=0;
		widthBotones=0;
		for (Button iterable_element : BotonesAttributo) {
			if (iterable_element.getOffsetHeight()>heightBotones)
				heightBotones=iterable_element.getOffsetHeight();
			if (iterable_element.getOffsetWidth()>widthBotones)
				widthBotones=iterable_element.getOffsetWidth();
		}
		for (Button iterable_element : BotonesAttributo) {
			iterable_element.setHeight(heightBotones+"px");
			iterable_element.setWidth(widthBotones+"px");
		}
		StringBuffer SB=new StringBuffer();
		for (Button iterable_element : BotonesAttributo) {
			SB.append(iterable_element.getHTML());
		}
		
		
	}
	
	/**
	 * Saca informacion por consola
	 * @param message
	 */
	native static void consoleLog( String message) /*-{
    console.log( message );
}-*/;



	/**
	 * Recupera la representacion numerica dentro de la aplicacion del vocabulario, lo inserta si no lo encuentra.
	 * @param vocabulary vocabulario a buscar o insertar si no existe.
	 * @return representacion numerica del vocabulario.
	 */
	public static int getVocabulario(Vocabulary vocabulary) {
		for (int i = 0; i < VocabularyHashset.size(); i++) {
			Vocabulary candidato = VocabularyHashset.get(i);
			if (candidato==vocabulary)
				return i;
		}

		VocabularyHashset.add(vocabulary);

		return VocabularyHashset.size()-1;
		
	}
	
	/**
	 * Sustituye el meta en 2 elementos.
	 * @param fuente
	 * @param Destino
	 */
	public static void Sustituye(Meta fuente,Meta Destino)
	{
		for (Resources elemento : ColeccionActual.getSectionValues()) {
			for (MetaValue atributo : elemento.getDescription()) {
				if (atributo.getHastype()==fuente)
					{
						if (Destino instanceof MetaText)
						{
							SustituyeTexto(elemento,atributo, (MetaText)Destino);
						}
						else atributo.setHastype(Destino);
						
						
					}
					
			}

		}
	}
	
	/**
	 * Sustituye para el caso de que el destino sea un texto.
	 * @param elemento seccion a la que pertenece.
	 * @param atributo fuente a cabiar.
	 * @param destino destino de tipo texto.
	 */
	private static void SustituyeTexto(Resources elemento, MetaValue atributo, MetaText destino) {
		Meta fuente=atributo.getHastype();
		if (fuente instanceof MetaText)
			atributo.setHastype(destino);
		else{
		elemento.getDescription().remove(atributo);
		if (fuente instanceof MetaControlled)
			{
			String term=((MetaControlledValue)atributo).getValue().getTerm();
			MetaTextValue MTV=new MetaTextValue(destino, term);
			elemento.getDescription().add(MTV);
			}
		else if (fuente instanceof MetaNumeric)
			{
			String term=((MetaNumericValue)atributo).getValue().toString();
			MetaTextValue MTV=new MetaTextValue(destino, term);
			elemento.getDescription().add(MTV);
			}
		else if (fuente instanceof MetaDate)
		{
		String term=((MetaDateValue)atributo).getValue().toString();
		MetaTextValue MTV=new MetaTextValue(destino, term);
		elemento.getDescription().add(MTV);
		}
		else if (fuente instanceof MetaBoolean)
		{
		String term=((MetaBooleanValue)atributo).getValue().toString();
		MetaTextValue MTV=new MetaTextValue(destino, term);
		elemento.getDescription().add(MTV);
		}
		else {
			MetaTextValue MTV=new MetaTextValue(destino, "");
			elemento.getDescription().add(MTV);
		}
		}
	}

	/**
	 * 
	 * @return the Seleccion
	 */
	public VerticalPanel getSeleccion() {
		return Seleccion;
	}



	/**
	 * Detecta si existe una representacion de un termino concreto en la coleccion
	 * @param term sermino a observar
	 * @return si existe en la coleccion retorna true, false en caso contrario
	 */
	public static boolean checkHaveRepresentacion(Term term) {
			for (Resources elemento : ColeccionActual.getSectionValues()) {
				for (MetaValue atributo : elemento.getDescription()) {
					if ((atributo instanceof MetaControlledValue)&& (((MetaControlledValue)atributo).getValue()==term))
						return true;
				}
			}
		return false;
	}


	
	/**
	 * Revias si dos atributos coexisten en el mismo sector
	 * @param attribute2 atributo1 a observar
	 * @param attribute22 atributo2 a observar
	 * @return true si existren en cohexistencia en el mismo sector
	 */
	public static boolean IndexExistDuplicitiWarning(Meta attribute2,
			Meta attribute22) {
		MetaValue afound =null;
		MetaValue bfound =null;
		for (Resources elemento : ColeccionActual.getSectionValues()) {
			for (MetaValue atributo : elemento.getDescription()) {
				if (atributo.getHastype()==attribute2)
					afound=atributo;
				if (atributo.getHastype()==attribute22)
					bfound=atributo;
					}
			if (afound!=null&&bfound!=null)
				if (!testUniblePar(bfound,afound))
					return true;

		}
		return false;
	}
	
	
	/**
	 * Procesa si una pareja de valores es igual y ademas es sustituible uno por el otro.
	 * @param atributo atributo base
	 * @param metaValue atributo comparado
	 * @return true si es unible, false en caso contrario.
	 */
	private static boolean testUniblePar(MetaValue atributo, MetaValue metaValue) {
		if (atributo instanceof MetaControlledValue)
			if (metaValue instanceof MetaControlledValue)
				if (((MetaControlledValue)atributo).getValue().getTerm().equals(((MetaControlledValue)metaValue).getValue().getTerm()))
					return true;
				else return false;
			else return false;
		else  if (atributo instanceof MetaTextValue)
				if (metaValue instanceof MetaTextValue)
					if (((MetaTextValue)atributo).getValue().equals(((MetaTextValue)metaValue).getValue()))
						return true;
					else return false;
				else return false;
			else if (atributo instanceof MetaDateValue)
					if (metaValue instanceof MetaDateValue)
						if (((MetaDateValue)atributo).getValue().compareTo((((MetaDateValue)metaValue).getValue()))==0)
							return true;
						else return false;
					else return false;
				else if (atributo instanceof MetaNumericValue)
						if (metaValue instanceof MetaNumericValue)
							if (((MetaNumericValue)atributo).getValue()==(((MetaNumericValue)metaValue).getValue()))
								return true;
							else return false;
						else return false;
					else if (atributo instanceof MetaBooleanValue)
						if (metaValue instanceof MetaBooleanValue)
							if (((MetaBooleanValue)atributo).getValue()==(((MetaBooleanValue)metaValue).getValue()))
								return true;
							else return false;
						else return false;
					else return false;
	}



	/**
	 * @return the coleccionActual
	 */
	public static Collection getColeccionActual() {
		return ColeccionActual;
	}



	/**
	 * @param coleccionActual the coleccionActual to set
	 */
	public static void setColeccionActual(Collection coleccionActual) {
		ColeccionActual = coleccionActual;
	}



	/**
	 * @return the listaVocabulary
	 */
	public static HashMap<CompositeModeloBotonComposite, Vocabulary> getListaVocabulary() {
		return ListaVocabulary;
	}



	/**
	 * @param listaVocabulary the listaVocabulary to set
	 */
	public static void setListaVocabulary(
			HashMap<CompositeModeloBotonComposite, Vocabulary> listaVocabulary) {
		ListaVocabulary = listaVocabulary;
	}



	/**
	 * @return the botonesAttributo
	 */
	public static ArrayList<Button> getBotonesAttributo() {
		return BotonesAttributo;
	}



	/**
	 * @param botonesAttributo the botonesAttributo to set
	 */
	public static void setBotonesAttributo(ArrayList<Button> botonesAttributo) {
		BotonesAttributo = botonesAttributo;
	}


	/**
	 * Obtiene el estado del elemento boton para un meta dado
	 * @param elemento elemento del que deseo el eetado 
	 * @return estado del elemenento
	 */
	public static boolean getState(CollectionAttribute elemento) {
		if (ListaState.get(elemento)==null)
			if (elemento instanceof Meta)
				ListaState.put(elemento, false);
			else ListaState.put(elemento, true);

		return ListaState.get(elemento);
	}



	/**
	 * Setea el estado de un meta dado por el elemento boton.
	 * @param elementoBoton elemento del que deseo setear el meta.
	 * @param newState estado del que deseo poner el meta.
	 */
	public static void setState(CollectionAttribute elementoBoton, boolean newState) {
		ListaState.put(elementoBoton, newState);
	}
	
	/**
	 * Obtiene el estado del elemento boton para un section dado
	 * @param elemento elemento del que deseo el eetado 
	 * @return estado del elemenento
	 */
	public static boolean getState(Construct elemento) {
		if (ListaStateSections.get(elemento)==null)
			ListaStateSections.put(elemento, false);

		return ListaStateSections.get(elemento);
	}



	/**
	 * Setea el estado de un meta dado por el elemento boton.
	 * @param elementoBoton elemento del que deseo setear el meta.
	 * @param newState estado del que deseo poner el meta.
	 */
	public static void setState(Construct elementoBoton, boolean newState) {
		ListaStateSections.put(elementoBoton, newState);
	}



	/**
	 * Funcion que elimina los repetidos de attribute22 si existe attribute2
	 * @param attribute2 atributo comparacion 1
	 * @param attribute22 atributo comparacion 2
	 */
	public static void eliminaRepetidos(Meta attribute2, Meta attribute22) {
		
		MetaValue afound =null;
		MetaValue bfound =null;
		for (Resources elemento : ColeccionActual.getSectionValues()) {
			{
				ArrayList<MetaValue> aBorrar=new ArrayList<MetaValue>();
			for (MetaValue atributo : elemento.getDescription()) {
				if (atributo.getHastype()==attribute2)
					afound=atributo;
				if (atributo.getHastype()==attribute22)
					bfound=atributo;
				}
			if (afound!=null&&bfound!=null)
				if (!testUniblePar(bfound,afound))
					aBorrar.add(bfound);
			for (MetaValue metaValue : aBorrar) {
			elemento.getDescription().remove(metaValue);
			}
			}
	}

	}
	
	/**
	 *  Retorna el Texto que representa al path.
	 *  @return Texto cadena para el elemento
	 */
	public static String pathFather(CollectionAttribute entrada)
	{
		String DataShow;
		if (entrada instanceof Meta)
			DataShow= ((Meta) entrada).getName();
		else DataShow= ConstantsInformation.ASTERISCO;
		
		if (entrada.getFather()!=null)
			return pathFather(entrada.getFather())+ConstantsInformation.BARRAINVERTIDA+DataShow;
		else return DataShow;
	}


	/**
	 * Refresca la lsita de colecciones actuales
	 */
	public void RefreshListaCollections() {
		BarraColecciones.clearItems();
		
		if (!ControladorEntryPoint.ActualUSer.getColecciones().isEmpty()){
			for (CollectionPropias Nombre : ControladorEntryPoint.ActualUSer.getColecciones()) {
				MenuItem Elemento1 = new MenuItemUserCollections(Nombre,
						false, yo);

				BarraColecciones.addItem(Elemento1);
				
			}
			OpenMenuItem.setEnabled(true);
			OpenMenuItem.removeStyleName(MENUITEMSTILEDISABLE);
		}
		else
			{
			OpenMenuItem.setEnabled(false);
			OpenMenuItem.setStyleName(MENUITEMSTILEDISABLE);
			}
		


	}



	/***
	 * Setea el boton save de la ventana
	 * @param b
	 */
	public void setSaveEnabled(boolean b) {
		SaveSubMenu.setEnabled(b);
		SaveAsMenuItem.setEnabled(b);
		
	}


	public static void setColeccionActualPath(String coleccionActualPath) {
		ColeccionActualPath = coleccionActualPath;
	}
	
	public static String getColeccionActualPath() {
		return ColeccionActualPath;
	}
}
