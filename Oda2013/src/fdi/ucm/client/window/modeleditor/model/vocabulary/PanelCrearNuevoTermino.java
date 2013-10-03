/**
 * 
 */
package fdi.ucm.client.window.modeleditor.model.vocabulary;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

import fdi.ucm.client.ConstantsInformation;
import fdi.ucm.shared.model.collection.meta.controlled.Term;
import fdi.ucm.shared.model.collection.meta.controlled.Vocabulary;

/**
 * Clase que implementa la ventana de creacion de terminos.
 * @author Joaquin Gayoso-Cabada
 *
 */
public class PanelCrearNuevoTermino extends PopupPanel {
	private static final String WELLCOMETEXT = "Insert the name for the new Term of the vocabulary";
	private static final String OK_BUTTON = "Create";
	private static final String CANCEL = "Cancel";
	private TextBox TextoAIntroducir;
	private Vocabulary vocabulary;
	private EditVocabularyPopupPanel fatherpopup;

	/**
	 * Constructor por defecto.
	 * @param fatherPopupin Panel a refrescar
	 * @param vocabularyin vocabulario a añadir.
	 */
	public PanelCrearNuevoTermino(Vocabulary vocabularyin, EditVocabularyPopupPanel fatherPopupin) {
		setGlassEnabled(true);
		setAnimationEnabled(true);
		vocabulary=vocabularyin;
		fatherpopup=fatherPopupin;
		VerticalPanel PanelGeneral = new VerticalPanel();
		PanelGeneral.setSpacing(10);
		PanelGeneral.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		PanelGeneral.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		setWidget(PanelGeneral);
		PanelGeneral.setSize("100%", "100%");
		
		Label WellcomeText = new Label(WELLCOMETEXT);
		PanelGeneral.add(WellcomeText);
		
		TextoAIntroducir = new TextBox();
		PanelGeneral.add(TextoAIntroducir);
		
		VerticalPanel panelCentrarBotones = new VerticalPanel();
		PanelGeneral.add(panelCentrarBotones);
		
		HorizontalPanel panelBotones = new HorizontalPanel();
		panelBotones.setSpacing(10);
		panelCentrarBotones.add(panelBotones);
		
		Button BotonOk = new Button(OK_BUTTON);
		BotonOk.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if (!TextoAIntroducir.getText().isEmpty())
				{
					String Namenew=TextoAIntroducir.getText();
					if (!ExistInVocabulary(Namenew))
					{
						Term T=new Term(Namenew);
						vocabulary.getList().add(T);
						fatherpopup.Refresh();
						hide();
					}else
					{
					Window.alert(ConstantsInformation.TERM_EXIST);	
					}
				}
				else 
					Window.alert(ConstantsInformation.THE_NAME_FOR_NEW_TERM_CATT_BE_EMPTY);
			}
		});
		panelBotones.add(BotonOk);
		
		Button BotonCancel = new Button(CANCEL);
		BotonCancel.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				hide();
			}
		});
		panelBotones.add(BotonCancel);
	}

	/**
	 * Funcion que busca el termino dentro del vocabulario.
	 * @param namenew nombre del futuro nuevo termnino.
	 * @return cierto si el termino esta en el vocabulario, falso en caso contrario.
	 */
	protected boolean ExistInVocabulary(String namenew) {
		for (Term candidato : vocabulary.getList()) {
			if (candidato.getTerm().equals(namenew))
				return true;
		}
		return false;
	}

}
