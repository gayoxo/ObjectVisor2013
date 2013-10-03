package fdi.ucm.client.window.modeleditor.model;

import com.google.gwt.event.dom.client.DoubleClickEvent;
import com.google.gwt.event.dom.client.DoubleClickHandler;
import com.google.gwt.user.client.ui.VerticalPanel;

import fdi.ucm.shared.model.collection.meta.MetaBoolean;
import fdi.ucm.shared.model.collection.meta.MetaControlled;
import fdi.ucm.shared.model.collection.meta.MetaDate;
import fdi.ucm.shared.model.collection.meta.MetaNumeric;
import fdi.ucm.shared.model.collection.meta.MetaRelation;
import fdi.ucm.shared.model.collection.meta.MetaText;

/**
 * Clase que implementa el dobleclick sobre un boton del Modelo.
 * @author Joaquin Gayoso-Cabada
 *
 */
public class BotonesModeloDoubleClickHandler implements DoubleClickHandler {

	private VerticalPanel seleccion;
	private CompositeModeloBotonComposite elementoEnArbol;

	/**
	 * Constructor por parametros de la clase
	 * @param panelSeleccion panel donde se insertara el nuevo elemento
	 * @param yo
	 */
	public BotonesModeloDoubleClickHandler(VerticalPanel panelSeleccion,
			CompositeModeloBotonComposite yo) {
		elementoEnArbol=yo;
		seleccion=panelSeleccion;
	}

	@Override
	public void onDoubleClick(DoubleClickEvent event) {
		boolean salvar=true;
		for (int i = 0; i < seleccion.getWidgetCount(); i++) {
			if ((seleccion.getWidget(i) instanceof AtributoModeloButton)&&((AtributoModeloButton)seleccion.getWidget(i)).getAttribute().equals(elementoEnArbol.getElementoBoton()))
				 {
				salvar = false;
				break;
				 }
			
				
		}
		
		if (salvar)
		{	
			AtributoModeloButton Anew=new AtributoModeloButton(elementoEnArbol);
			Anew.setWidth("100%");
			if (elementoEnArbol.getElementoBoton() instanceof MetaText)
				Anew.addStyleName("gwt-LabelTextAttribute");
			else if (elementoEnArbol.getElementoBoton() instanceof MetaControlled)
				Anew.addStyleName("gwt-LabelControlledAttribute");
			else if (elementoEnArbol.getElementoBoton() instanceof MetaDate)
				Anew.addStyleName("gwt-LabelDateAttribute");
			else if (elementoEnArbol.getElementoBoton() instanceof MetaNumeric)
				Anew.addStyleName("gwt-LabelNumericAttribute");
			else if (elementoEnArbol.getElementoBoton() instanceof MetaBoolean)
				Anew.addStyleName("gwt-LabelBooleanAttribute");
			else if (elementoEnArbol.getElementoBoton() instanceof MetaRelation)
				Anew.addStyleName("gwt-LabelRelationAttribute");
			seleccion.add(Anew);
		}
		
	}

	
	
}
