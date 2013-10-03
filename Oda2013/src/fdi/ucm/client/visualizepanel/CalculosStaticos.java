package fdi.ucm.client.visualizepanel;

import com.google.gwt.core.client.GWT;

import fdi.ucm.client.controller.StaticIconos;
import fdi.ucm.shared.model.collection.resources.Resources;
import fdi.ucm.shared.model.collection.resources.Construct;
import fdi.ucm.shared.model.collection.resources.File;
import fdi.ucm.shared.model.collection.resources.URL;

public class CalculosStaticos {


	
/**
 * Calcula el destino dependiendo si es imagen o URL
 * @param elementoIcono recurso a calcular destino
 * @param BasePath path del sistema de archivos
 * @return Direccion destino
 */
	public static String calculaDestino(Resources elementoIcono,String BasePath) {
		if (elementoIcono instanceof Construct)
			return null;
		else if (elementoIcono instanceof File)
			return BasePath+"/"+((File)elementoIcono).getPath();
		else if (elementoIcono instanceof URL)
			return ((URL)elementoIcono).getSrc();
		else return null;
	}

	/**
	 * Clase que define el icono en funcion del elemento
	 * @param elementoIcono elemento entrada
	 * @param BasePath path del sistema de archivos
	 * @return path del icono o imagen asociado.
	 */
	public static String calculaImagenAsociada(Resources elementoIcono,String BasePath) {
		if (elementoIcono instanceof File)
			{
			if
				(
						//Imagen
				((File)elementoIcono).getPath().toLowerCase().endsWith(".jpg")
				||
				((File)elementoIcono).getPath().toLowerCase().endsWith(".jpge")	
				||
				((File)elementoIcono).getPath().toLowerCase().endsWith(".gif")
				||
				((File)elementoIcono).getPath().toLowerCase().endsWith(".png")
				)
				return BasePath+"/"+((File)elementoIcono).getPath();
			else
				if (((File)elementoIcono).getPath().toLowerCase().endsWith(".rar"))
					return GWT.getHostPageBaseURL()+StaticIconos.ICONORAR;
			else
				if (((File)elementoIcono).getPath().toLowerCase().endsWith(".avi"))
					return GWT.getHostPageBaseURL()+StaticIconos.ICONOAVI;
				else
					if (((File)elementoIcono).getPath().toLowerCase().endsWith(".doc"))
						return GWT.getHostPageBaseURL()+StaticIconos.ICONODOC;
					else
						if (((File)elementoIcono).getPath().toLowerCase().endsWith(".docx"))
							return GWT.getHostPageBaseURL()+StaticIconos.ICONODOCX;
						else
							if (((File)elementoIcono).getPath().toLowerCase().endsWith(".pdf"))
								return GWT.getHostPageBaseURL()+StaticIconos.ICONOPDF;
							else
								if (((File)elementoIcono).getPath().toLowerCase().endsWith(".html"))
									return GWT.getHostPageBaseURL()+StaticIconos.ICONOHTML;
								else
									if (((File)elementoIcono).getPath().toLowerCase().endsWith(".htm"))
										return GWT.getHostPageBaseURL()+StaticIconos.ICONOHTML;
									else
										if (((File)elementoIcono).getPath().toLowerCase().endsWith(".php"))
											return GWT.getHostPageBaseURL()+StaticIconos.ICONOHTML;
										else
											if (((File)elementoIcono).getPath().toLowerCase().endsWith(".ppt"))
												return GWT.getHostPageBaseURL()+StaticIconos.ICONOPPT;
											else
												if (((File)elementoIcono).getPath().toLowerCase().endsWith(".pptx"))
													return GWT.getHostPageBaseURL()+StaticIconos.ICONOPPTX;
												else
													if (((File)elementoIcono).getPath().toLowerCase().endsWith(".mov"))
														return GWT.getHostPageBaseURL()+StaticIconos.ICONOMOV;
													else
														if (((File)elementoIcono).getPath().toLowerCase().endsWith(".fla"))
															return GWT.getHostPageBaseURL()+StaticIconos.ICONOFLA;
														else
															if (((File)elementoIcono).getPath().toLowerCase().endsWith(".swf"))
																return GWT.getHostPageBaseURL()+StaticIconos.ICONOSWF;
															else
																if (((File)elementoIcono).getPath().toLowerCase().endsWith(".midi"))
																	return GWT.getHostPageBaseURL()+StaticIconos.ICONOMIDI;
																else
																	if (((File)elementoIcono).getPath().toLowerCase().endsWith(".mp3"))
																		return GWT.getHostPageBaseURL()+StaticIconos.ICONOMP3;
																	else
																		if (((File)elementoIcono).getPath().toLowerCase().endsWith(".mp4"))
																			return GWT.getHostPageBaseURL()+StaticIconos.ICONOMP4;
																		else
																			if (((File)elementoIcono).getPath().toLowerCase().endsWith(".mpg"))
																				return GWT.getHostPageBaseURL()+StaticIconos.ICONOMPG;
																			else
																				if (((File)elementoIcono).getPath().toLowerCase().endsWith(".odt"))
																					return GWT.getHostPageBaseURL()+StaticIconos.ICONOODT;
																				else
																					if (((File)elementoIcono).getPath().toLowerCase().endsWith(".ods"))
																						return GWT.getHostPageBaseURL()+StaticIconos.ICONOODS;
																					else
																						if (((File)elementoIcono).getPath().toLowerCase().endsWith(".zip"))
																							return GWT.getHostPageBaseURL()+StaticIconos.ICONOZIP;
																						else
																							if (((File)elementoIcono).getPath().toLowerCase().endsWith(".rtf"))
																								return GWT.getHostPageBaseURL()+StaticIconos.ICONORTF;
																							else
																								if (((File)elementoIcono).getPath().toLowerCase().endsWith(".ttf"))
																									return GWT.getHostPageBaseURL()+StaticIconos.ICONOTTF;
																								else
																									if (((File)elementoIcono).getPath().toLowerCase().endsWith(".txt"))
																										return GWT.getHostPageBaseURL()+StaticIconos.ICONOTXT;
																									else
																										if (((File)elementoIcono).getPath().toLowerCase().endsWith(".wav"))
																											return GWT.getHostPageBaseURL()+StaticIconos.ICONOWAV;
																										else
																											if (((File)elementoIcono).getPath().toLowerCase().endsWith(".wma"))
																												return GWT.getHostPageBaseURL()+StaticIconos.ICONOWMA;
																											else
																												if (((File)elementoIcono).getPath().toLowerCase().endsWith(".wmv"))
																													return GWT.getHostPageBaseURL()+StaticIconos.ICONOWMV;
																												else
																													if (((File)elementoIcono).getPath().toLowerCase().endsWith(".xls"))
																														return GWT.getHostPageBaseURL()+StaticIconos.ICONOXLS;
																													else
																														if (((File)elementoIcono).getPath().toLowerCase().endsWith(".xlsx"))
																															return GWT.getHostPageBaseURL()+StaticIconos.ICONOXLSX;
																														else
																															if (((File)elementoIcono).getPath().toLowerCase().endsWith(".xml"))
																																return GWT.getHostPageBaseURL()+StaticIconos.ICONOXML;
			
			
													
							
			}
		else if (elementoIcono instanceof Construct)
			return GWT.getHostPageBaseURL()+StaticIconos.ICONOCONSTRUCT;
		else if (elementoIcono instanceof URL)
			return GWT.getHostPageBaseURL()+StaticIconos.ICONOURL;
		
		return GWT.getHostPageBaseURL()+StaticIconos.ICONODEFAULT;
	}

}
