/**
 * 
 */
package fdi.ucm.client.window.modeleditor.model.vocabulary;

import java.util.ArrayList;

import com.google.gwt.user.client.ui.PopupPanel;

import fdi.ucm.client.ConstantsInformation;
import fdi.ucm.client.window.modeleditor.EditorMainWindowEditor;
import fdi.ucm.shared.model.collection.meta.controlled.Term;
import fdi.ucm.shared.model.collection.meta.controlled.Vocabulary;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

/**
 * Panel que genera el popup que edita un vocabulario.
 * @author Joaquin Gayoso-Cabada
 *
 */
public class EditVocabularyPopupPanel extends PopupPanel {

	private Vocabulary vocabulary;
	private VerticalPanel PanelTerms;
	private VerticalPanel Seleccion;
	private static final String IMGADD = "<img src=\"Direccionales/add.gif\" >";
	private static final String DELETE = "Delete";
	private static final String CLOSE = "Close";
	private static final String RENAME = "Rename";
	private static final String MERGE = "Merge";
	private EditVocabularyPopupPanel yo;
	
	/**
	 * Constructor por parametros.
	 * @param vocabularyin voocabulario a editar.
	 */
	public EditVocabularyPopupPanel(Vocabulary vocabularyin) {
		vocabulary=vocabularyin;
		setSize("667px", "576px");
		setGlassEnabled(true);
		setAnimationEnabled(true);
		yo=this;
		
		DockLayoutPanel LayoutGeneral = new DockLayoutPanel(Unit.PX);
		setWidget(LayoutGeneral);
		int Height=Window.getClientHeight()-200;
		if (Height<200)
			Height=200;
		LayoutGeneral.setSize("675px", Height+ConstantsInformation.PX);
		
		MenuBar BarraDeMenu = new MenuBar(false);
		LayoutGeneral.addNorth(BarraDeMenu,25);
		
		MenuItem BotonCerrar = new MenuItem(CLOSE, false, new Command() {
			public void execute() {
				hide();
			}
		});
		BotonCerrar.setHTML(CLOSE);
		BarraDeMenu.addItem(BotonCerrar);
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		LayoutGeneral.add(horizontalPanel);
		horizontalPanel.setSize("", "100%");
		
		ScrollPanel scrollPanel = new ScrollPanel();
		scrollPanel.setAlwaysShowScrollBars(true);
		horizontalPanel.add(scrollPanel);
		scrollPanel.setSize("300px", "100%");
		
		PanelTerms = new VerticalPanel();
		scrollPanel.setWidget(PanelTerms);
		PanelTerms.setSize("100%", "100%");
		
		crearBotonNew();
		
		
		VerticalPanel verticalPanel_1 = new VerticalPanel();
		horizontalPanel.add(verticalPanel_1);
		verticalPanel_1.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel_1.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		verticalPanel_1.setHeight("100%");
		
		DecoratorPanel DecoradorPanelAcciones = new DecoratorPanel();
		verticalPanel_1.add(DecoradorPanelAcciones);
		
		VerticalPanel PanelAcciones = new VerticalPanel();
		PanelAcciones.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		PanelAcciones.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		DecoradorPanelAcciones.setWidget(PanelAcciones);
		PanelAcciones.setHeight("");
		
		Button BotonDelete = new Button(DELETE);
		BotonDelete.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				for (Widget widget : Seleccion) {
					TermButton T=(TermButton) widget;
					if (EditorMainWindowEditor.checkHaveRepresentacion(T.getTermino()))
					{
						Window.alert(ConstantsInformation.OV_ASIGNADOS + " " + T.getTermino().getTerm());	
					}
						else
					if (Window.confirm(ConstantsInformation.ARE_YOU_SURE_TO_REMOVE_THIS_TERM + T.getTermino().getTerm()))
						{
						 vocabulary.getList().remove(T.getTermino());
						}		
				}
				Refresh();
			}
		});
		PanelAcciones.add(BotonDelete);
		BotonDelete.setWidth("100%");
		
		Button BotonRename = new Button(RENAME);
		BotonRename.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				for (Widget widget : Seleccion)
				{
					TermButton T=(TermButton) widget;
					PanelRenombrarTermino PCNB=new PanelRenombrarTermino(T.getTermino(),vocabulary,yo);
					PCNB.center();
				}
			}
		});
		PanelAcciones.add(BotonRename);
		BotonRename.setWidth("100%");
		
		Button BotonMerge = new Button(MERGE);
		BotonMerge.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				ArrayList<Term> TerminosAUnir=new ArrayList<Term>();
				for (Widget widget : Seleccion)
				{
					TermButton T=(TermButton) widget;
					TerminosAUnir.add(T.getTermino());
					
				}
				if (TerminosAUnir.size()>0)
				{
					PanelMergeTerminos PCNB=new PanelMergeTerminos(TerminosAUnir,vocabulary,yo);
					PCNB.center();
				}
			}
		});
		PanelAcciones.add(BotonMerge);
		BotonMerge.setWidth("100%");
		
		ScrollPanel scrollPanel_1 = new ScrollPanel();
		scrollPanel_1.setAlwaysShowScrollBars(true);
		horizontalPanel.add(scrollPanel_1);
		scrollPanel_1.setSize("300px", "100%");
		
		Seleccion = new VerticalPanel();
		scrollPanel_1.setWidget(Seleccion);
		Seleccion.setSize("100%", "100%");
		Seleccion.setStyleName("min_width100px");
		
		Refresh();
		
	}

	/**
	 * Crea el Boton new par los nuevos terminos
	 */
	private void crearBotonNew() {
		Button btnNewButton = new Button(IMGADD);
		btnNewButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				PanelCrearNuevoTermino PCNB=new PanelCrearNuevoTermino(vocabulary,yo);
				PCNB.center();
			}
		});
		PanelTerms.add(btnNewButton);
		
	}

	public void Refresh() {
		PanelTerms.clear();
		Seleccion.clear();
		crearBotonNew();
		for (Term termino : vocabulary.getList()) {
			TermButton TB=new TermButton(termino,Seleccion);
			PanelTerms.add(TB);
		}
		
	}

}
