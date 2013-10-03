package fdi.ucm.client.window.modeleditor.model.vocabulary;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import fdi.ucm.client.ConstantsInformation;
import fdi.ucm.shared.model.collection.meta.controlled.Term;
import fdi.ucm.shared.model.collection.meta.controlled.Vocabulary;

/**
 * Clase que renombra un termino ya exuistente.
 * @author Joaquin Gayoso-Cabada
 *
 */
public class PanelRenombrarTermino extends PopupPanel {

	private static final String WELLCOMETEXT = "Insert the new name for the Term:: ";
	private static final String OK_BUTTON = "Rename";
	private static final String CANCEL = "Cancel";
	private TextBox TextoAIntroducir;
	private Vocabulary vocabulary;
	private Term termino;
	private EditVocabularyPopupPanel fatherpopup;
	
	
	/**
	 * Constructor por defecto del renombrador de terminos.
	 * @param terminoin termino a renombrar.
	 * @param vocabularyin vocabulario al que pertenece, para evitar repeticiones.
	 * @param fatherpopupin padre a refrescar.
	 */
	public PanelRenombrarTermino(Term terminoin, Vocabulary vocabularyin, EditVocabularyPopupPanel fatherpopupin) {
		setGlassEnabled(true);
		setAnimationEnabled(true);
		vocabulary=vocabularyin;
		fatherpopup=fatherpopupin;
		termino=terminoin;
		VerticalPanel PanelGeneral = new VerticalPanel();
		PanelGeneral.setSpacing(10);
		PanelGeneral.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		PanelGeneral.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		setWidget(PanelGeneral);
		PanelGeneral.setSize("100%", "100%");
		
		Label WellcomeText = new Label(WELLCOMETEXT+ termino.getTerm());
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
					if (!Namenew.equals(termino.getTerm()))
					{
						if (!ExistInVocabulary(Namenew))
						{
							termino.setTerm(Namenew);
							fatherpopup.Refresh();
							hide();
						}else
							Window.alert(ConstantsInformation.TERM_EXIST);	
						
					}else
						Window.alert(ConstantsInformation.SAME_NAME);
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


