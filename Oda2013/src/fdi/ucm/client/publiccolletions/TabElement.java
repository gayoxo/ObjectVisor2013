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
import fdi.ucm.shared.model.collection.resources.Resources;

/**
 * Clase que implementa un elemento tabulado;
 * @author Joaquin Gayoso-Cabada
 *
 */
public class TabElement extends Composite {
	
	
	private VerticalPanel PanelHijos;
	private static List<CollectionAttribute> ColeccionSons;
	private static String BasePath;
	private static String ImagenAsociada;

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
	private static Widget getElementbase(MetaValue metaValueD) {
		
		StringBuffer Sb = new StringBuffer();
	//	Sb.append("<img src=\"Keyicon.png\" alt=\"*\" align=\"middle\" >");
		Sb.append(metaValueD.getHastype().getName());
		Sb.append(":");
		Label lblNewLabel=new Label();
		if (metaValueD instanceof MetaTextValue)
			{
			Sb.append(((MetaTextValue) metaValueD).getValue());
			lblNewLabel.setText(Sb.toString());
			return lblNewLabel;
			}
		else if (metaValueD instanceof MetaControlledValue)
			{
//			if (((MetaControlledValue) metaValueD).getValue()==null) Sb.append("Error en :" + metaValueD.getHastype().getName());
//			else 
				Sb.append(((MetaControlledValue) metaValueD).getValue().getTerm());
			lblNewLabel.setText(Sb.toString());
			return lblNewLabel;
			}
		else if (metaValueD instanceof MetaNumericValue)
			{
			Sb.append( ((MetaNumericValue) metaValueD).getValue().toString());
			lblNewLabel.setText(Sb.toString());
			return lblNewLabel;
			}
		else if (metaValueD instanceof MetaBooleanValue)
			{
			Sb.append( ((MetaBooleanValue) metaValueD).getValue().toString());
			lblNewLabel.setText(Sb.toString());
			return lblNewLabel;
			}
		else if (metaValueD instanceof MetaDateValue)
		{
			DateTimeFormat fmt = DateTimeFormat.getFormat("dd/MM/yyyy"); 
			Sb.append( fmt.format(((MetaDateValue) metaValueD).getValue()));
			lblNewLabel.setText(Sb.toString());
			return lblNewLabel;
		}
		else if (metaValueD instanceof MetaRelationValue)
		{
			MetaRelationValue MRV=(MetaRelationValue)metaValueD;
			Resources elementoIconoBoton=MRV.getValue();
			

			ImagenAsociada=ShowsStaticFunctions.calculaImagenAsociada(elementoIconoBoton,BasePath);
			
			Image MRVI=new MetaRelationValueImage(MRV.getValue(),ColeccionSons,ImagenAsociada);
			return MRVI;
			
			
//			Image Icono = new Image(ImagenAsociada);
//			PanelVerticalIcono.add(Icono);
//			Icono.addLoadHandler(new LoadHandler() {
//				
//				@Override
//				public void onLoad(LoadEvent event) {
//					float porcent=Icono.getHeight()/MaxHeight;
//					float Width = Icono.getWidth()/porcent;
//					int width=Math.round(Width);
//					String PX="px";
//					Icono.setHeight(MaxHeight+PX);
//					Icono.setWidth(width+PX);
//					
//				}
//			});
//			
//		
//			
//			if ((MRV.getValue() instanceof File)&&
//					(
//							//Imagen
//					((File)MRV.getValue()).getPath().toLowerCase().endsWith(".jpg")
//					||
//					((File)MRV.getValue()).getPath().toLowerCase().endsWith(".jpge")	
//					||
//					((File)MRV.getValue()).getPath().toLowerCase().endsWith(".gif")
//					||
//					((File)MRV.getValue()).getPath().toLowerCase().endsWith(".png")
//					)
//					)
//			{
//				Image MRVI=new MetaRelationValueImage(BasePath,(File)MRV.getValue(),ColeccionSons);
//				return MRVI;
//			}
//			else{
//
//				MetaRelationValueButton B=new MetaRelationValueButton(MRV,ColeccionSons);
//				return B;
//			}
			
		}
		lblNewLabel.setText(Sb.toString());
		return lblNewLabel;
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

	/**
	 * @return the basePath
	 */
	public static String getBasePath() {
		return BasePath;
	}

	/**
	 * @param basePath the basePath to set
	 */
	public static void setBasePath(String basePath) {
		BasePath = basePath;
	}
	
	

}
