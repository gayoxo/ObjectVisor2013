package fdi.ucm.client.window.modeleditor.model;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;

import fdi.ucm.client.window.modeleditor.model.vocabulary.EditVocabularyPopupPanel;
import fdi.ucm.shared.model.collection.meta.controlled.Vocabulary;

/**
 * Calse que impolementa la creacion de botones de vocabulario.
 * @author Joaquin Gayoso-Cabada
 *
 */
public class VocabularyControlledModeloButton extends Button {

	private Integer vocNumber;
	private Vocabulary vocabulary;
	private CompositeModeloBotonComposite Padre;

	/**
	 * Procedimiento constructor de la clase.
	 * @param voc Numero del vocabulario
	 * @param vocabularyin vocabulario en si
	 * @param panelSeleccion panel de seleccion al pulaslo
	 * @param padrein padre del vocabulario.
	 */
	public VocabularyControlledModeloButton(int voc, Vocabulary vocabularyin, CompositeModeloBotonComposite padrein) {
		super("");
		vocNumber=voc;
		vocabulary=vocabularyin;
		Padre=padrein;
		addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				EditVocabularyPopupPanel EVPUP=new EditVocabularyPopupPanel(vocabulary);
				EVPUP.center();
				
			}
		});
	}

	/**
	 * @return the vocNumber
	 */
	public Integer getVocNumber() {
		return vocNumber;
	}

	/**
	 * @param vocNumber the vocNumber to set
	 */
	public void setVocNumber(Integer vocNumber) {
		this.vocNumber = vocNumber;
	}

	/**
	 * @return the vocabulary
	 */
	public Vocabulary getVocabulary() {
		return vocabulary;
	}

	/**
	 * @param vocabulary the vocabulary to set
	 */
	public void setVocabulary(Vocabulary vocabulary) {
		this.vocabulary = vocabulary;
	}


	/**
	 * @return the padre
	 */
	public CompositeModeloBotonComposite getPadre() {
		return Padre;
	}

	/**
	 * @param padre the padre to set
	 */
	public void setPadre(CompositeModeloBotonComposite padre) {
		Padre = padre;
	}
	
	
}
