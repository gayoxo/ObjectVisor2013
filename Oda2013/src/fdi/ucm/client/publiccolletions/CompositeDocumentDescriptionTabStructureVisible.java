package fdi.ucm.client.publiccolletions;

import java.util.ArrayList;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import fdi.ucm.client.controller.Oda2013OperatinoalViewStaticFunctions;
import fdi.ucm.shared.model.collection.document.Documents;
import fdi.ucm.shared.model.collection.document.Element;
import fdi.ucm.shared.model.collection.document.LinkElement;
import fdi.ucm.shared.model.collection.document.ResourceElementFile;
import fdi.ucm.shared.model.collection.document.ResourceElementURL;
import fdi.ucm.shared.model.collection.document.TextElement;
import fdi.ucm.shared.model.collection.grammar.ElementType;
import fdi.ucm.shared.model.collection.grammar.LinkElementType;
import fdi.ucm.shared.model.collection.grammar.TextElementType;

public class CompositeDocumentDescriptionTabStructureVisible extends Composite {

	private static final String ICONOS_KEYICON_PNG = "Iconos/Keyicon.png";
	private static final String TWO_POINTS = ":";
	private VerticalPanel PanelHijos;
//	private static List<Structure> ColeccionSons;
	private static String ImagenAsociada;
	private Image MRVI;
	private Label LabelType;
	
	private ElementType Elemento;
	private Documents Recurso;
	private ArrayList<Integer> Ambitos;
	private boolean Active;
	
	
	public CompositeDocumentDescriptionTabStructureVisible(
			ElementType metaValue, Documents documentoG,
			ArrayList<Integer> ambitos) {
		Elemento=metaValue;
		
		Recurso=documentoG;
		
		Ambitos	= ambitos;
		
		Active = false;
		
		VerticalPanel verticalPanel = new VerticalPanel();
		initWidget(verticalPanel);

			HorizontalPanel ElementPanel = new HorizontalPanel();
			verticalPanel.add(ElementPanel);
			ElementPanel.setSize("", "100%");
			
			
			Image image = new Image(ICONOS_KEYICON_PNG);
			ElementPanel.add(image);
			image.setSize("25px", "22px");
			
			Element MV=getMetaValue((ElementType)Elemento);
			
			if (MV==null)
				{
				MV=generanuevo((ElementType)Elemento);
				MV.setAmbitos(Ambitos);
				ElementPanel.add(getElementbase((ElementType)Elemento));
				}
			else 
				{
				
				ElementPanel.add(getElementbase(MV));
				}

			HorizontalPanel horizontalPanel = new HorizontalPanel();
			verticalPanel.add(horizontalPanel);
			
			SimplePanel Glue = new SimplePanel();
			horizontalPanel.add(Glue);
			Glue.setWidth("35px");
			
			PanelHijos = new VerticalPanel();
			horizontalPanel.add(PanelHijos);
		
		
	}

	
	
	



	

	/**
	 * Obtiene el MetaValor Asociado y sino crea uno
	 * @param elemento1
	 * @return
	 */
	private Element getMetaValue(ElementType elemento1) {
		for (Element element : Recurso.getDescription()) {
			if (element.getHastype()==elemento1&&EqualsAmbitos(element.getAmbitos()))
				return element;
			
		}
		
		return null;
	}
	
	/**
	 * Metodo que genera el metavbalueNuevo
	 * @param elemento1
	 * @return
	 */
	private Element generanuevo(ElementType elemento1) {
		if (elemento1 instanceof TextElementType)
			return new TextElement((TextElementType) elemento1);
		if (elemento1 instanceof LinkElementType)
			return new LinkElement((LinkElementType) elemento1);
		return new Element(elemento1);
	}
	
	
	
	
	
	/**
	 * Test Si los ambitos son iguales
	 * @param ambitos2
	 * @return
	 */
	private boolean EqualsAmbitos(ArrayList<Integer> ambitos2) {
		if (ambitos2.size()<Ambitos.size())
			return false;
		for (int i = 0; i < Ambitos.size(); i++) {
			if (!Ambitos.get(i).equals(ambitos2.get(i)))
				return false;
		}
		return true;
	}
	
	
	

	/**
	 * Funcion que genera el elemento asociado a el valor
	 * @param elemento2 
	 * @param metaValueD elemento de valor de entrada
	 * @return widget asociado al valor
	 */
	private Widget getElementbase(fdi.ucm.shared.model.collection.grammar.ElementType elemento2) {
		HorizontalPanel V=new HorizontalPanel();
		LabelType = new Label(elemento2.getName()+TWO_POINTS);
		V.add(LabelType);
		return V;
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
			{
			Result=new Label(((TextElement) metaValueD).getValue());
			
			}
		else if (metaValueD instanceof ResourceElementFile)
			{
				ImagenAsociada=Oda2013OperatinoalViewStaticFunctions.calculaImagenAsociada(((ResourceElementFile)metaValueD).getValue());
			
			MRVI=new ImageMetaRelationResourceValue(((ResourceElementFile)metaValueD).getValue(),ImagenAsociada);
			
			Result= MRVI;	
			}
		else if (metaValueD instanceof ResourceElementURL)
		{
			ImagenAsociada=Oda2013OperatinoalViewStaticFunctions.calculaImagenAsociada(((ResourceElementURL)metaValueD).getValue());
		
		MRVI=new ImageMetaRelationResourceValue(((ResourceElementURL)metaValueD).getValue(),ImagenAsociada);
		
		Result= MRVI;	
		}
			else 
				if (metaValueD instanceof LinkElement)
				{
				ImagenAsociada=Oda2013OperatinoalViewStaticFunctions.calculaImagenAsociada(((LinkElement)metaValueD).getValue());
				
				MRVI=new ImageMetaRelationConstructValue(((LinkElement)metaValueD).getValue(),ImagenAsociada);
				
				Result= MRVI;	
				} 
		
		
		if (Result!=null)
			V.add(Result);
		
		
		return V;
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









	public boolean isActive() {
		return Active;
	}
}