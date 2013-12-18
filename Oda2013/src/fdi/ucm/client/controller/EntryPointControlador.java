/**
 * 
 */
package fdi.ucm.client.controller;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

import fdi.ucm.client.publiccolletions.WindowEditorPublicCollectionVisualice;
import fdi.ucm.client.publiccolletions.SplitLayoutPanelPublicCollection;
import fdi.ucm.shared.model.collection.Collection;

/**
 * Punto de entrada del sistema
 * @author Joaquin Gayoso-Cabada
 *
 */
public class EntryPointControlador implements EntryPoint{

	
	
	private static WindowEditorInterface WE;
	private static WindowEditorPublicCollectionVisualice PCVWE;
	private static WindowEditorMasterIndex MIWE;
	
	
	@Override
	public void onModuleLoad() {
		PCVWE=new WindowEditorPublicCollectionVisualice();
		MIWE=new WindowEditorMasterIndex();
		WE=MIWE;
		WE.showWindow();
	}
	

	public static void ToPublicCollectionVisualiceWindowEditor(Collection Coleccion, String Description) {
		RootPanel.get().clear();
		SplitLayoutPanelPublicCollection.setColeccionAndBasePath(Coleccion);
		WE=PCVWE;
		WE.showWindow();
		PCVWE.setLabelInformativa(Description);
	}

	
}
