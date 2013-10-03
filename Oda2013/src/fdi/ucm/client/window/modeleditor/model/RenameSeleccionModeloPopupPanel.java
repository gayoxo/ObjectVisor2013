package fdi.ucm.client.window.modeleditor.model;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

import fdi.ucm.client.ConstantsError;
import fdi.ucm.client.window.modeleditor.EditorMainWindowEditor;
import fdi.ucm.shared.model.collection.meta.Meta;

/**
 * Panel que permite el renombrado de un meta
 * @author Joaquin Gayoso-Cabada
 *
 */
public class RenameSeleccionModeloPopupPanel extends PopupPanel {

	private static final String INSERT_NAME_FOR_NEW_ATTRIBUTE = "Insert new name for Attribute: ";
	private static final String OK = "Ok";
	private static final String CANCEL = "Cancel";
	private AtributoModeloButton atributo;
	private TextBox textBox;
	
	/**
	 * Procedimiento constructor de la clase.
	 * @param atributoentrada elemento a renombrar
	 */
	public RenameSeleccionModeloPopupPanel(AtributoModeloButton atributoentrada) {
		setGlassEnabled(true);
		setModal(true);
		setAnimationEnabled(true);
		
		
		atributo=atributoentrada;
		VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		verticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		setWidget(verticalPanel);
		verticalPanel.setSize("202px", "105px");
		
		Label NewNameLabel = new Label(INSERT_NAME_FOR_NEW_ATTRIBUTE + EditorMainWindowEditor.pathFather(atributo.getAttribute()));
		verticalPanel.add(NewNameLabel);
		
		textBox = new TextBox();
		verticalPanel.add(textBox);
		textBox.setWidth("182px");
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setSpacing(3);
		verticalPanel.add(horizontalPanel);
		
		Button OkButton = new Button("Ok");
		OkButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if (textBox.getText().isEmpty())
					Window.alert(ConstantsError.ERROR_TEXTBOX_EMPTY);
				else if (((Meta) atributo.getAttribute()).getName().equals(textBox.getText()))
					{
					hide();
					atributo.removeFromParent();
					}
				else 
				{
					hide();
						((Meta) atributo.getAttribute()).setName(textBox.getText());
						atributo.getElementoEnArbol().getBotonatributo().setHTML(textBox.getText());
						atributo.removeFromParent();
						
					
				}
			}
		});
		OkButton.setText(OK);
		horizontalPanel.add(OkButton);
		
		Button CancelButton = new Button(CANCEL);
		CancelButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				hide();
			}
		});
		horizontalPanel.add(CancelButton);
		
	}

}
