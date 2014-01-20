/**
 * 
 */
package fdi.ucm.client.publiccolletions;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Clase que define el interface para la descripcion
 * @author Joaquin Gayoso-Cabada
 *
 */
public class CompositeDocumentDescriptionDescriptionTab extends Composite {

	private static final String ICONOS_KEYICON_PNG = "Iconos/Keyicon.png";
	private static final String TWO_POINTS = ":";
	
	public CompositeDocumentDescriptionDescriptionTab(String descriptionText) {
		super();
		
		VerticalPanel verticalPanel = new VerticalPanel();
		initWidget(verticalPanel);
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel.add(horizontalPanel);
		
		Image image = new Image(ICONOS_KEYICON_PNG);
		horizontalPanel.add(image);
		image.setSize("25px", "22px");
		
		Label lblNewLabel = new Label("Description" + TWO_POINTS );
		horizontalPanel.add(lblNewLabel);
		lblNewLabel.setHeight("22px");
	
		Label lblNewLabel2 = new Label(descriptionText);
		horizontalPanel.add(lblNewLabel2);
		lblNewLabel2.setStyleName("Cursiva");
		
		
	}
}
