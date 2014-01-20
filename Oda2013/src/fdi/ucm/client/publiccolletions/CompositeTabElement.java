/**
 * 
 */
package fdi.ucm.client.publiccolletions;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Widget;

import fdi.ucm.client.controller.Oda2013OperatinoalViewStaticFunctions;
import fdi.ucm.shared.model.collection.document.Documents;
import fdi.ucm.shared.model.collection.document.Element;
import fdi.ucm.shared.model.collection.document.LinkElement;
import fdi.ucm.shared.model.collection.document.ResourceElement;
import fdi.ucm.shared.model.collection.document.Resources;
import fdi.ucm.shared.model.collection.document.TextElement;

/**
 * Clase que implementa un elemento tabulado;
 * @author Joaquin Gayoso-Cabada
 *
 */
public class CompositeTabElement extends Composite {
	
	
	private VerticalPanel PanelHijos;
	private static String ImagenAsociada;
	private Label LabelType;
	private static final String TWO_POINTS = ":";

	public CompositeTabElement(Element metaValueD) {
		
		VerticalPanel verticalPanel = new VerticalPanel();
		initWidget(verticalPanel);
		
		HorizontalPanel ElementPanel = new HorizontalPanel();
		verticalPanel.add(ElementPanel);
		ElementPanel.setSize("", "100%");
		
		
		Image image = new Image("Iconos/Keyicon.png");
		ElementPanel.add(image);
		image.setSize("25px", "22px");
		
		ElementPanel.add(getElementbase(metaValueD));
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		verticalPanel.add(horizontalPanel);
		
		SimplePanel Glue = new SimplePanel();
		horizontalPanel.add(Glue);
		Glue.setWidth("35px");
		
		PanelHijos = new VerticalPanel();
		horizontalPanel.add(PanelHijos);
		
		
	}

	/**
	 * @return the panelHijos
	 */
	public VerticalPanel getPanelHijos() {
		return PanelHijos;
	}

	/**
	 * @param panelHijos the panelHijos to set
	 */
	public void setPanelHijos(VerticalPanel panelHijos) {
		PanelHijos = panelHijos;
	}
	
	
	/**
	 * Funcion que genera el elemento asociado a el valor
	 * @param metaValueD elemento de valor de entrada
	 * @return widget asociado al valor
	 */
	private Widget getElementbase(Element metaValueD) {
		
		HorizontalPanel V=new HorizontalPanel();
		LabelType = new Label(metaValueD.getHastype().getName()+TWO_POINTS);
		V.add(LabelType);
		
		Widget Result=null;
		
		if (metaValueD instanceof TextElement)
			Result=new Label(((TextElement) metaValueD).getValue());
		else if (metaValueD instanceof LinkElement)
		{
			LinkElement MRV=(LinkElement)metaValueD;

			Documents elementoIconoBoton=MRV.getValue();
			ImagenAsociada=Oda2013OperatinoalViewStaticFunctions.calculaImagenAsociada(elementoIconoBoton);
			
			Image MRVI=new ImageMetaRelationConstructValue(elementoIconoBoton,ImagenAsociada);
			Result= MRVI;
			
		}
		else if (metaValueD instanceof ResourceElement)
		{
			ResourceElement MRV=(ResourceElement)metaValueD;

			Resources elementoIconoBoton=MRV.getValue();
			ImagenAsociada=Oda2013OperatinoalViewStaticFunctions.calculaImagenAsociada(elementoIconoBoton);
			
			Image MRVI=new ImageMetaRelationResourceValue(elementoIconoBoton,ImagenAsociada);
			Result= MRVI;

			
			
		}
		
		if (Result!=null)
			V.add(Result);
		
		
		return V;
	}


	

}
