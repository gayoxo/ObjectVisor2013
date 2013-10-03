package fdi.ucm.client.window.modeleditor.model.vocabulary;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import fdi.ucm.shared.model.collection.meta.controlled.Term;

/**
 * Clase que implementa un boton con el elemento añadido de el termino y donde ira al ser pulsado.
 * @author Joaquin Gayoso-Cabada
 *
 */
public class TermButton extends Button {

	private Term termino;
	private TermButton Yo;
	private VerticalPanel seleccion;
	
	/**
	 * Contructor por parametros de la clase.
	 * @param terminoin termino de entrada que representa el boton.
	 * @param seleccion elemento seleccion donde ira al ser pulsado.
	 */
	public TermButton(Term terminoin, VerticalPanel seleccionin) {
		super(terminoin.getTerm());
		termino=terminoin;
		Yo=this;
		seleccion=seleccionin;
		addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if (!EnSeleccion())
				{
				seleccion.add(new TermButton(termino,(VerticalPanel)Yo.getParent()));
				}
				
				Yo.removeFromParent();
				
			}
			
			/**
			 * Clase que busca el termino dentro de la seleccion.
			 * @return true si el termino se encuentra en la clase, false en caso contrario.
			 */
			private boolean EnSeleccion() {
				for (Widget widget : seleccion) {
					if (widget instanceof TermButton)
						{
						TermButton T=(TermButton)widget;
						if (T.getTermino()==termino)
							return true;
						}
				}
				return false;
			}
		});
	}

	/**
	 * Retorna el termnino del boton.
	 * @return retorna el termno del boton.
	 */
	public Term getTermino() {
		return termino;
	}
}
