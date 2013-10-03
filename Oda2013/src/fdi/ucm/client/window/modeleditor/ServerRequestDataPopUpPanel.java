package fdi.ucm.client.window.modeleditor;

import java.util.ArrayList;
import java.util.Date;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteHandler;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.SimpleCheckBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

import fdi.ucm.shared.model.ImportExportDataEnum;
import fdi.ucm.shared.model.ImportExportPair;
import fdi.ucm.shared.model.SharedConstants;

import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent;

/**
 * Clase que implemeta un popUp para introducir los datos del servidor de MySQL
 * @author Joaquin Gayoso-Cabada
 *
 */
public class ServerRequestDataPopUpPanel extends PopupPanel {

	private static final String CANCEL = "Cancel";
	private static final String OK = "Ok";
	private static final String INSERT_DATABASE_INFORMATION = "Insert Database Information";
	private static final String ErrorUploadingData = "Error Uploading Data";
	private ArrayList<FileUpload> ListaUploaders;
	private ArrayList<Widget> ResultadoWidget;
	private FormPanel SibmitUploadPanel;
	private int Fileuploaders;
	private String FolderKeyValue;
	private ClickHandler accionPosterior;
	private VerticalPanel panelGeneral;

	/**
	 * Constructor por defecto 
	 * @param ClickHandler
	 */
	public ServerRequestDataPopUpPanel(ArrayList<ImportExportPair> DatConfig,ClickHandler ClickHandler) {
		
		setModal(true);
		setGlassEnabled(true);
		setAnimationEnabled(true);

		accionPosterior=ClickHandler;
		ResultadoWidget=new ArrayList<Widget>();
		ListaUploaders=new ArrayList<FileUpload>();
		
		VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setSpacing(5);
		verticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		setWidget(verticalPanel);
		verticalPanel.setSize("100%", "100%");
		
		HorizontalPanel horizontalPanel_3 = new HorizontalPanel();
		verticalPanel.add(horizontalPanel_3);
		
		Label InformationDatabase = new Label(INSERT_DATABASE_INFORMATION);
		horizontalPanel_3.add(InformationDatabase);
		
		SimplePanel simplePanel = new SimplePanel();
		verticalPanel.add(simplePanel);
		
		Grid PanelDatos = new Grid(DatConfig.size(), 2);
		simplePanel.setWidget(PanelDatos);
		PanelDatos.setSize("100%", "100%");
		
		SibmitUploadPanel = new FormPanel();
		SibmitUploadPanel.setEncoding(FormPanel.ENCODING_MULTIPART);
		SibmitUploadPanel.setMethod(FormPanel.METHOD_POST);
		verticalPanel.add(SibmitUploadPanel);
		
		panelGeneral=new VerticalPanel();
		
		TextBox KeyFolder=new TextBox();
		Date date = new Date();
		Long fechanumerica = (Long) date.getTime();
		FolderKeyValue = Long.toString(fechanumerica);
		KeyFolder.setName(SharedConstants.KeyFolderNumber);
		KeyFolder.setText(FolderKeyValue);
		panelGeneral.add(KeyFolder);
		KeyFolder.setVisible(false);
		
		Grid PanelUploads = null;
		Fileuploaders=CalculaFiles(DatConfig);
		if (Fileuploaders>0)
		{	PanelUploads = new Grid(Fileuploaders, 2);
			SibmitUploadPanel.setWidget(panelGeneral);
			panelGeneral.add(PanelUploads);
		//	SibmitUploadPanel.setWidget(PanelUploads);
			PanelUploads.setSize("100%", "100%");
		}
		
		
		String BaseURL = GWT.getHostPageBaseURL();
		BaseURL = BaseURL + "upload";
		SibmitUploadPanel.setAction(BaseURL);
		SibmitUploadPanel.addSubmitCompleteHandler(new SubmitCompleteHandler() {
			
			@Override
			public void onSubmitComplete(SubmitCompleteEvent event) {
				String results = event.getResults();
				results = results.replaceAll("\\<.*?\\>", "");
				if ((event.getResults() != null) && !(results.isEmpty()))
					Window.alert(ErrorUploadingData);
				else 
				{
					LlamaAGeneral();
					
				}
					
			}
		});


		
		int count=0;
		int countFileUpload=0;
		for (ImportExportPair pair : DatConfig) {
			if (pair.getTipo()!=ImportExportDataEnum.File)
			{
			if (pair.getTipo()==ImportExportDataEnum.Text)
				{
					Label A=new Label(pair.getLabel());
					TextBox AT=new TextBox();
					PanelDatos.setWidget(count, 0, A);
					PanelDatos.setWidget(count, 1, AT);
					ResultadoWidget.add(AT);
				}
			else if (pair.getTipo()==ImportExportDataEnum.Number)
				{
					Label A=new Label(pair.getLabel());
					IntegerBox AT=new IntegerBox();
					PanelDatos.setWidget(count, 0, A);
					PanelDatos.setWidget(count, 1, AT);
					ResultadoWidget.add(AT);
				}
			else if  (pair.getTipo()==ImportExportDataEnum.EncriptedText)
				{
					Label A=new Label(pair.getLabel());
					PasswordTextBox AT=new PasswordTextBox();
					PanelDatos.setWidget(count, 0, A);
					PanelDatos.setWidget(count, 1, AT);
					ResultadoWidget.add(AT);
				}
			else if  (pair.getTipo()==ImportExportDataEnum.Boolean)
			{
				Label A=new Label(pair.getLabel());
				SimpleCheckBox AT=new SimpleCheckBox();
				PanelDatos.setWidget(count, 0, A);
				PanelDatos.setWidget(count, 1, AT);
				ResultadoWidget.add(AT);
			}
			count++;
			}
			else 
				{
				
				Label A=new Label(pair.getLabel());
				FileUpload AT=new FileUpload();
				AT.setName(countFileUpload+"");
				AT.getElement().setAttribute("accept", "application/zip,application/rar");
				PanelUploads.setWidget(countFileUpload, 0, A);
				PanelUploads.setWidget(countFileUpload, 1, AT);
				countFileUpload++;
				ListaUploaders.add(AT);
				}
				
		}
		
		
		
		
		HorizontalPanel horizontalPanel_8 = new HorizontalPanel();
		verticalPanel.add(horizontalPanel_8);
		
		HorizontalPanel horizontalPanel_9 = new HorizontalPanel();
		horizontalPanel_9.setSpacing(5);
		horizontalPanel_8.add(horizontalPanel_9);
		
		Button btnNewButton = new Button(OK);
		
		btnNewButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if (Fileuploaders>0)
				{
					boolean Existe=false;
					for (FileUpload FU : ListaUploaders) {
						if (!FU.getFilename().isEmpty())
							{
							Existe=true;
							break;
							}
					}
					if(Existe)
						SibmitUploadPanel.submit();
					else 
						LlamaAGeneral();
				}
				else 
					LlamaAGeneral();
			}
		});
//		btnNewButton.addClickHandler(new ClickHandler() {
//			public void onClick(ClickEvent event) {
//				hide();
//			}
//		});
		horizontalPanel_9.add(btnNewButton);
		
		Button btnNewButton_1 = new Button(CANCEL);
		btnNewButton_1.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				hide();
			}
		});
		horizontalPanel_9.add(btnNewButton_1);
	}

	/**
	 * Lla a a la funcion general asiada en el constructor
	 */
	protected void LlamaAGeneral() {
		Button B =new Button("Oculto");
		B.addClickHandler(accionPosterior);
		panelGeneral.add(B);
		B.click();
		panelGeneral.remove(B);		
	}

	private int CalculaFiles(ArrayList<ImportExportPair> datConfig) {
		int result=0;
		for (ImportExportPair importExportPair : datConfig) {
			if (importExportPair.getTipo()==ImportExportDataEnum.File)
				result++;
		}
		return result;
	}

	/**
	 * @return the resultado
	 */
	public ArrayList<String> getResultado() {
		ArrayList<String> Resultado = new ArrayList<String>();
		for (Widget widgetsalida : ResultadoWidget) {
			if (widgetsalida instanceof TextBox)
				Resultado.add(((TextBox) widgetsalida).getValue());
			else if (widgetsalida instanceof IntegerBox)
				Resultado.add(Integer.toString(((IntegerBox) widgetsalida).getValue()));
			else if (widgetsalida instanceof PasswordTextBox)
				Resultado.add(((PasswordTextBox) widgetsalida).getValue());
			else if (widgetsalida instanceof SimpleCheckBox)
				Resultado.add(Boolean.toString(((SimpleCheckBox) widgetsalida).getValue()));
		}
		return Resultado;
	}

	public boolean isComplete() {
		for (Widget widgetsalida : ResultadoWidget) {
			if ((widgetsalida instanceof TextBox)&&((((TextBox) widgetsalida).getValue()).isEmpty()))
					return false;
			else if ((widgetsalida instanceof IntegerBox)&&(Integer.toString(((IntegerBox) widgetsalida).getValue()).isEmpty()))
					return false;
			else if ((widgetsalida instanceof PasswordTextBox)&&((PasswordTextBox) widgetsalida).getValue().isEmpty())
					return false;

		}
		return true;
	}




	public String getFolderKeyValue() {
		return FolderKeyValue;
	}
	
	public void setFolderKeyValue(String folderKeyValue) {
		FolderKeyValue = folderKeyValue;
	}
	
	
	
	
}
