/**
 * 
 */
package fdi.ucm.client.publiccolletions;

import java.util.List;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Widget;

import fdi.ucm.shared.model.collection.CollectionAttribute;
import fdi.ucm.shared.model.collection.metavalues.MetaBooleanValue;
import fdi.ucm.shared.model.collection.metavalues.MetaControlledValue;
import fdi.ucm.shared.model.collection.metavalues.MetaDateValue;
import fdi.ucm.shared.model.collection.metavalues.MetaNumericValue;
import fdi.ucm.shared.model.collection.metavalues.MetaRelationValue;
import fdi.ucm.shared.model.collection.metavalues.MetaTextValue;
import fdi.ucm.shared.model.collection.metavalues.MetaValue;
import fdi.ucm.shared.model.collection.resources.Construct;
import fdi.ucm.shared.model.collection.resources.RelationObject;
import fdi.ucm.shared.model.collection.resources.Resources;

/**
 * Clase que implementa un elemento tabulado;
 * @author Joaquin Gayoso-Cabada
 *
 */
public class TabElement extends Composite {
	
	
	private VerticalPanel PanelHijos;
	private static List<CollectionAttribute> ColeccionSons;
	private static String ImagenAsociada;
	private Label LabelType;
	private static final String TWO_POINTS = ":";

	public TabElement(MetaValue metaValueD) {
		
		VerticalPanel verticalPanel = new VerticalPanel();
		initWidget(verticalPanel);
		
		HorizontalPanel ElementPanel = new HorizontalPanel();
		verticalPanel.add(ElementPanel);
		ElementPanel.setSize("", "100%");
		
		
		Image image = new Image("Iconos/Keyicon.png");
		ElementPanel.add(image);
		image.setSize("25px", "22px");
		
		ElementPanel.add(getElementbase(metaValueD));
		
	
		
//		Image image = new Image((String) null);
//		ElementPanel.add(image);
		
//		HTML htmlNewHtml = new HTML("<img src=\"Keyicon.png\" alt=\"*\" align=\"middle\" >", true);
//		ElementPanel.add(htmlNewHtml);
		
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
	private Widget getElementbase(MetaValue metaValueD) {
		
		HorizontalPanel V=new HorizontalPanel();
		LabelType = new Label(metaValueD.getHastype().getName()+TWO_POINTS);
		V.add(LabelType);
		
		Widget Result=null;
		
		if (metaValueD instanceof MetaTextValue)
			Result=new Label(((MetaTextValue) metaValueD).getValue());
		else if (metaValueD instanceof MetaControlledValue)
			Result=new Label(((MetaControlledValue) metaValueD).getValue().getTerm());
		else if (metaValueD instanceof MetaNumericValue)
			Result=new Label( ((MetaNumericValue) metaValueD).getValue().toString());
		else if (metaValueD instanceof MetaBooleanValue)
			Result=new Label( ((MetaBooleanValue) metaValueD).getValue().toString());
		else if (metaValueD instanceof MetaDateValue)
		{
			DateTimeFormat fmt = DateTimeFormat.getFormat("dd/MM/yyyy"); 
			Result=new Label( fmt.format(((MetaDateValue) metaValueD).getValue()));
		}
		else if (metaValueD instanceof MetaRelationValue)
		{
			MetaRelationValue MRV=(MetaRelationValue)metaValueD;
			RelationObject elementoIconoBoton=MRV.getValue();
			
			if (elementoIconoBoton instanceof Resources)
			{
			ImagenAsociada=ShowsStaticFunctions.calculaImagenAsociada((Resources)elementoIconoBoton);
			
			Image MRVI=new MetaRelationResourceValueImage((Resources)elementoIconoBoton,ColeccionSons,ImagenAsociada);
			Result= MRVI;
			}
			else if (elementoIconoBoton instanceof Construct)
			{
			ImagenAsociada=ShowsStaticFunctions.calculaImagenAsociada((Construct)elementoIconoBoton);
			
			Image MRVI=new MetaRelationConstructValueImage((Construct)elementoIconoBoton,ColeccionSons,ImagenAsociada);
			Result= MRVI;
				
			}
			
		}
		
		if (Result!=null)
			V.add(Result);
		
		
		return V;
	}

	/**
	 * @return the coleccionSons
	 */
	public static List<CollectionAttribute> getColeccionSons() {
		return ColeccionSons;
	}

	/**
	 * @param coleccionSons2 the coleccionSons to set
	 */
	public static void setColeccionSons(List<CollectionAttribute> coleccionSons2) {
		ColeccionSons = coleccionSons2;
	}

	

}
