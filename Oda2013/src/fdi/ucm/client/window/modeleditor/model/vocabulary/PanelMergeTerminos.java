/**
 * 
 */
package fdi.ucm.client.window.modeleditor.model.vocabulary;

import java.util.ArrayList;
import java.util.HashMap;

import com.google.gwt.user.client.ui.PopupPanel;

import fdi.ucm.client.window.modeleditor.EditorMainWindowEditor;
import fdi.ucm.shared.model.collection.meta.controlled.Term;
import fdi.ucm.shared.model.collection.meta.controlled.Vocabulary;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

/**
 * Clase que une los terminos sobre uno dado
 * @author Joaquin Gayoso-Cabada
 *
 */
public class PanelMergeTerminos extends PopupPanel {

	private static final String WELLCOMETEXT = "Select the destiny element";
	private static final String OK_BUTTON = "Merge";
	private static final String CANCEL = "Cancel";
	private Vocabulary vocabulary;
	private ArrayList<Term> terminosAUnir;
	private EditVocabularyPopupPanel fatherpopup;
	private HashMap<Integer, Term> listaTerminosenCombobox;
	private ListBox comboBox;
	
	/**
	 * Constructor por parametros de la clase.
	 * @param terminosAUnirin lista de terminos a unir.
	 * @param vocabularyin vocabulario al que pertenecen los terminos.
	 * @param fatherpopupin panel padre a refrescar.
	 */
	public PanelMergeTerminos(ArrayList<Term> terminosAUnirin,
			Vocabulary vocabularyin, EditVocabularyPopupPanel fatherpopupin) {
		
		terminosAUnir=terminosAUnirin;
		vocabulary=vocabularyin;
		fatherpopup=fatherpopupin;
		VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		verticalPanel.setSpacing(10);
		verticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		setWidget(verticalPanel);
		verticalPanel.setSize("100%", "100%");
		
		Label label = new Label(WELLCOMETEXT);
		verticalPanel.add(label);
		
		listaTerminosenCombobox=new HashMap<Integer,Term>();
		comboBox = new ListBox();
		int i=0;
		for (Term term : terminosAUnirin) {
			listaTerminosenCombobox.put(i, term);
			comboBox.addItem(term.getTerm(),Integer.toString(i));	
			i++;
		}
		
		
		
		verticalPanel.add(comboBox);
		
		VerticalPanel verticalPanel_1 = new VerticalPanel();
		verticalPanel.add(verticalPanel_1);
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setSpacing(10);
		verticalPanel_1.add(horizontalPanel);
		
		Button button = new Button(OK_BUTTON);
		button.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				String S=comboBox.getValue(comboBox.getSelectedIndex());
				Integer i= Integer.parseInt(S);
				Term select=listaTerminosenCombobox.get(i);
				terminosAUnir.remove(select);
				for (Term term : terminosAUnir) {
//					if (!IndexEntryPoint.IndexExistDuplicitiWarning(select,term))
//						{
						vocabulary.getList().remove(term);
						EditorMainWindowEditor.sustituye(term, select);
//						}
//					else Window.alert(ConstantsError.ERROR_CANT_MERGE_DUPLICITY);
				}
				fatherpopup.Refresh();
				hide();
			}
		});
		horizontalPanel.add(button);
		
		Button button_1 = new Button(CANCEL);
		button_1.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				hide();
			}
		});
		horizontalPanel.add(button_1);
		terminosAUnir=terminosAUnirin;
		vocabulary=vocabularyin;
		fatherpopup=fatherpopupin;
		
	}

	

	
}
