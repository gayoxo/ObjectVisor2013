package fdi.ucm.client.window;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.SimplePanel;

public class AboutPopupPanel extends PopupPanel {
	
	protected static final String Texto_To_INFO = "Digital models editing application developed at the University Complutense of Madrid through ILSA Research Group and developed by Joaquin Gayoso-Cabada";

	public AboutPopupPanel(boolean b) {
		super(b);
		Label L=new Label(Texto_To_INFO);
		SimplePanel SP=new SimplePanel();
		SP.setWidget(L);
		SP.setStyleName("AzulTransparente");
		setWidget(SP);
		L.setSize("417px", "57px");
	}

}
