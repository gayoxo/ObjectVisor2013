package fdi.ucm.client.publiccolletions;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;

import fdi.ucm.client.controller.StaticIconos;
import fdi.ucm.shared.model.collection.meta.Meta;
import fdi.ucm.shared.model.collection.meta.MetaBoolean;
import fdi.ucm.shared.model.collection.meta.MetaControlled;
import fdi.ucm.shared.model.collection.meta.MetaDate;
import fdi.ucm.shared.model.collection.meta.MetaNumeric;
import fdi.ucm.shared.model.collection.meta.MetaRelation;
import fdi.ucm.shared.model.collection.meta.MetaText;
import fdi.ucm.shared.model.collection.meta.show.ShowInstance;
import fdi.ucm.shared.model.collection.meta.show.ShowSchema;
import fdi.ucm.shared.model.collection.meta.show.ShowValoresResult;
import fdi.ucm.shared.model.collection.meta.show.ShowValues;
import fdi.ucm.shared.model.collection.meta.show.ShowValuesInstance;
import fdi.ucm.shared.model.collection.metavalues.MetaValue;
import fdi.ucm.shared.model.collection.resources.Construct;
import fdi.ucm.shared.model.collection.resources.File;
import fdi.ucm.shared.model.collection.resources.Resources;
import fdi.ucm.shared.model.collection.resources.URL;

/**
 * Clase que define las funciones estaticas que se desarroyan en el visualizador basadas en los shows del objeto esperados
 * @author Joaquin Gayoso-Cabada
 *
 */
public class ShowsStaticFunctions {

	public static boolean isSummary(Meta meta) {
		ArrayList<ShowSchema> Shows = meta.getShows();
		for (ShowSchema show : Shows) {
			ArrayList<ShowValues> ShowValue = show.getValues();
			for (ShowValues showValues : ShowValue) {
				if (showValues.getValor().equals(Oda2013StaticNames.SUMMARYSHOWN))
						{
						ArrayList<ShowValoresResult> result=showValues.getResultado();
							for (ShowValoresResult showValoresResult : result) {
								if (showValoresResult.getResultado().equals(Boolean.toString(true)))
									return true;
								if (showValoresResult.getResultado().equals(Boolean.toString(false)))
									return false;
							}
						}
			}
		}
		return false;
	}
	
	/**
	 * Ser sumario con la instancia incluida
	 * @param metaValueD
	 * @return
	 */
	public static boolean isSummary(MetaValue metaValueD) {
		
		
		Boolean B=isSummaryVal(metaValueD);
		if (B!=null)
			return B;
		else 
			return isSummary(metaValueD.getHastype());

	}

	/**
	 * Comprueba si el metavalue es sumario y sobre escribe el normal
	 * @param metaValueD
	 * @return
	 */
	private static Boolean isSummaryVal(MetaValue metaValueD) {
	
		ArrayList<ShowInstance> Shows = metaValueD.getShows();
		for (ShowInstance show : Shows) {
			ArrayList<ShowValuesInstance> ShowValue = show.getValues();
			for (ShowValues showValues : ShowValue) {
				if (showValues.getValor().equals(Oda2013StaticNames.SUMMARYSHOWN))
						{
						ArrayList<ShowValoresResult> result=showValues.getResultado();
							for (ShowValoresResult showValoresResult : result) {
								if (showValoresResult.getResultado().equals(Boolean.toString(true)))
									return true;
								if (showValoresResult.getResultado().equals(Boolean.toString(false)))
									return false;
							}
						}
			}
		}
		return null;
	}

	public static boolean isVisible(Meta meta) {
		ArrayList<ShowSchema> Shows = meta.getShows();
		for (ShowSchema show : Shows) {
			ArrayList<ShowValues> ShowValue = show.getValues();
			for (ShowValues showValues : ShowValue) {
				if (showValues.getValor().equals(Oda2013StaticNames.VISIBLESHOWN))
						{
						ArrayList<ShowValoresResult> result=showValues.getResultado();
							for (ShowValoresResult showValoresResult : result) {
								if (showValoresResult.getResultado().equals(Boolean.toString(true)))
									return true;
								if (showValoresResult.getResultado().equals(Boolean.toString(false)))
									return false;
							}
						}
			}
		}
		return false;
	}

	
	/**
	 * Ser visible con la instancia incluida
	 * @param metaValueD
	 * @return
	 */
	public static boolean isVisible(MetaValue metaValueD) {
		
		
		Boolean B=isVisibleVal(metaValueD);
		if (B!=null)
			return B;
		else 
			return isVisible(metaValueD.getHastype());

	}
	
	
	/**
	 * Comprueba si el metavalue es visible y sobre escribe el normal
	 * @param metaValueD
	 * @return
	 */
	private static Boolean isVisibleVal(MetaValue metaValueD) {
	
		ArrayList<ShowInstance> Shows = metaValueD.getShows();
		for (ShowInstance show : Shows) {
			ArrayList<ShowValuesInstance> ShowValue = show.getValues();
			for (ShowValues showValues : ShowValue) {
				if (showValues.getValor().equals(Oda2013StaticNames.VISIBLESHOWN))
						{
						ArrayList<ShowValoresResult> result=showValues.getResultado();
							for (ShowValoresResult showValoresResult : result) {
								if (showValoresResult.getResultado().equals(Boolean.toString(true)))
									return true;
								if (showValoresResult.getResultado().equals(Boolean.toString(false)))
									return false;
							}
						}
			}
		}
		return null;
	}
	
	public static boolean isBrowseable(Meta meta) {
		ArrayList<ShowSchema> Shows = meta.getShows();
		for (ShowSchema show : Shows) {
			ArrayList<ShowValues> ShowValue = show.getValues();
			for (ShowValues showValues : ShowValue) {
				if (showValues.getValor().equals(Oda2013StaticNames.BROWSERSHOWN))
						{
						ArrayList<ShowValoresResult> result=showValues.getResultado();
							for (ShowValoresResult showValoresResult : result) {
								if (showValoresResult.getResultado().equals(Boolean.toString(true)))
									return true;
								if (showValoresResult.getResultado().equals(Boolean.toString(false)))
									return false;
							}
						}
			}
		}
		return false;
	}

	

	
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

	
	/**
	 * Devuelve si el tipo es de tipo meta Basico
	 * @param metaActual
	 * @return
	 */
	public static boolean NotBasic(Meta metaActual) {
		if (metaActual instanceof MetaControlled)
			return true;
		else if (metaActual instanceof MetaText)
			return true;
		else if (metaActual instanceof MetaDate)
			return true;
		else if (metaActual instanceof MetaNumeric)
			return true;
		else if (metaActual instanceof MetaBoolean)
			return true;
		else if (metaActual instanceof MetaRelation)
			return true;
		else return false;
	}
}
