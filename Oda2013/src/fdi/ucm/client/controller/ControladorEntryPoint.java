/**
 * 
 */
package fdi.ucm.client.controller;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

import fdi.ucm.client.publiccolletions.PublicCollectionVisualiceWindowEditor;
import fdi.ucm.client.visualizepanel.SplitLayoutPanelPropio;
import fdi.ucm.client.window.LoginWindowEditor;
import fdi.ucm.client.window.WindowEditor;
import fdi.ucm.client.window.modeleditor.EditorMainWindowEditor;
import fdi.ucm.client.window.visualize.VisualizeCollectionWindowEditor;
import fdi.ucm.shared.model.collection.Collection;
import fdi.ucm.shared.model.userserver.UserServer;

/**
 * Punto de entrada del sistema
 * @author Joaquin Gayoso-Cabada
 *
 */
public class ControladorEntryPoint implements EntryPoint{

	public static final String COOKIE_NAME = "ME2013";
	public static final long SemillaPrimo = 999983;
	public static final long SemillaPrimo_2 = 5021;
	public static UserServer ActualUSer;
	
	
	private static WindowEditor WE;
	private static LoginWindowEditor LWE;
	private static EditorMainWindowEditor EMWE;
	private static VisualizeCollectionWindowEditor VCWE;
	private static PublicCollectionVisualiceWindowEditor PCVWE;
	private static MasterIndexWindowEditor MIWE;
	
	@Override
	public void onModuleLoad() {
		LWE=new LoginWindowEditor();
		EMWE=new EditorMainWindowEditor();
		VCWE=new VisualizeCollectionWindowEditor();
		PCVWE=new PublicCollectionVisualiceWindowEditor();
		MIWE=new MasterIndexWindowEditor();
		WE=MIWE;
		WE.showWindow();
	}
	
	public static void ToLoginWindowEditor()
	{
		RootPanel.get().clear();
		WE=LWE;
		WE.showWindow();
	}
	
	public static void ToEditorMainWindowEditor()
	{
		RootPanel.get().clear();
		WE=EMWE;
		WE.showWindow();
	}

	public static void ToVisualizeCollection() {
		RootPanel.get().clear();
		WE=VCWE;
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
