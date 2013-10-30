/**
 * 
 */
package fdi.ucm.client.controller;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

import fdi.ucm.client.publiccolletions.PublicCollectionVisualiceWindowEditor;
import fdi.ucm.client.publiccolletions.SplitLayoutPanelPropio;
import fdi.ucm.shared.model.collection.Collection;

/**
 * Punto de entrada del sistema
 * @author Joaquin Gayoso-Cabada
 *
 */
public class ControladorEntryPoint implements EntryPoint{

	
	
	private static WindowEditor WE;
	private static PublicCollectionVisualiceWindowEditor PCVWE;
	private static MasterIndexWindowEditor MIWE;
	
	
	@Override
	public void onModuleLoad() {
		PCVWE=new PublicCollectionVisualiceWindowEditor();
		MIWE=new MasterIndexWindowEditor();
		WE=MIWE;
		WE.showWindow();
	}
	

	public static void ToPublicCollectionVisualiceWindowEditor(Collection Coleccion, String FilePath, String Description) {
		RootPanel.get().clear();
		SplitLayoutPanelPropio.setColeccionAndBasePath(Coleccion, FilePath);
		WE=PCVWE;
		WE.showWindow();
		PCVWE.setLabelInformativa(Description);
	}

	
}
