package fdi.ucm.client.controller;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;

/**
 * Clase que Genera un panel de proceso configurable con un gif de animacion.
 * @author Joaquin Gayoso-Cabada
 *
 */
public class PopupPanelLoading extends PopupPanel {

    private static PopupPanelLoading MyPanelStatic;
	private Label LabelText;

    ;

    /**
     * Clase constructora del panel de proceso
     */
    private PopupPanelLoading() {
        super(false);
        setGlassEnabled(true);
        SimplePanel SP = new SimplePanel();
        add(SP);
        super.setGlassEnabled(true);
        SP.setSize("230px", "");
        
        VerticalPanel verticalPanel = new VerticalPanel();
        verticalPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        verticalPanel.setSpacing(6);
        verticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        SP.setWidget(verticalPanel);
        verticalPanel.setSize("100%", "100%");
        
        Image image = new Image("Loader.gif");
        verticalPanel.add(image);
        image.setSize("77px", "76px");
        
        LabelText = new Label(" ");
        verticalPanel.add(LabelText);

    }

    /**
     * Singleton de la clase del panel de proceso
     * @return Panel de proceso
     */
    public static PopupPanelLoading getInstance() {
        if (MyPanelStatic == null) {
            MyPanelStatic = new PopupPanelLoading();
        }
        return MyPanelStatic;
    }

    /**
     * Introduce el testo que define al panel de proceso
     * @param labelText Texto que define el proceso
     */
    public void setLabelTexto(String labelText) {
        LabelText.setText(labelText);
    }
}
