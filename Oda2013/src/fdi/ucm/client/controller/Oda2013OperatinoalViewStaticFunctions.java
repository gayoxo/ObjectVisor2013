package fdi.ucm.client.controller;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;

import fdi.ucm.shared.model.collection.document.Documents;
import fdi.ucm.shared.model.collection.document.Element;
import fdi.ucm.shared.model.collection.document.File;
import fdi.ucm.shared.model.collection.document.OperationalValue;
import fdi.ucm.shared.model.collection.document.Resources;
import fdi.ucm.shared.model.collection.document.URL;
import fdi.ucm.shared.model.collection.grammar.ElementType;
import fdi.ucm.shared.model.collection.grammar.Grammar;
import fdi.ucm.shared.model.collection.grammar.LinkElementType;
import fdi.ucm.shared.model.collection.grammar.MetaBoolean;
import fdi.ucm.shared.model.collection.grammar.MetaControlled;
import fdi.ucm.shared.model.collection.grammar.MetaDate;
import fdi.ucm.shared.model.collection.grammar.OperationalValueType;
import fdi.ucm.shared.model.collection.grammar.OperationalView;
import fdi.ucm.shared.model.collection.grammar.ResourceElementType;
import fdi.ucm.shared.model.collection.grammar.TextElementType;

/**
 * Clase que define las funciones estaticas que se desarroyan en el visualizador basadas en los shows del objeto esperados
 * @author Joaquin Gayoso-Cabada
 *
 */
public class Oda2013OperatinoalViewStaticFunctions {

	public static boolean isSummary(ElementType meta) {
		ArrayList<OperationalView> Shows = meta.getShows();
		for (OperationalView show : Shows) {
			ArrayList<OperationalValueType> ShowValue = show.getValues();
			for (OperationalValueType showValues : ShowValue) {
				if (showValues.getName().equals(Oda2013StaticNames.SUMMARYSHOWN))
					if (showValues.getDefault().equals(Boolean.toString(true)))
									return true;
					else	if (showValues.getDefault().equals(Boolean.toString(false)))
									return false;

			}
		}
		return false;
	}
	
	/**
	 * Ser sumario con la instancia incluida
	 * @param metaValueD
	 * @return
	 */
	public static boolean isSummary(Element metaValueD) {
		
		
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
	private static Boolean isSummaryVal(Element metaValueD) {
	
		ArrayList<OperationalValue> Shows = metaValueD.getShows();
		for (OperationalValue show : Shows) {
				if (show.getType().getName().equals(Oda2013StaticNames.SUMMARYSHOWN))
					if (show.getValue().equals(Boolean.toString(true)))
							return true;
					if (show.getValue().equals(Boolean.toString(false)))
							return false;

		}
		return null;
	}

	public static boolean isVisible(ElementType meta) {
		ArrayList<OperationalView> Shows = meta.getShows();
		for (OperationalView show : Shows) {
			ArrayList<OperationalValueType> ShowValue = show.getValues();
			for (OperationalValueType showValues : ShowValue) {
				if (showValues.getName().equals(Oda2013StaticNames.VISIBLESHOWN))
					if (showValues.getDefault().equals(Boolean.toString(true)))
						return true;
					else if (showValues.getDefault().equals(Boolean.toString(false)))
						return false;

			}
		}
		return false;
	}

	
	/**
	 * Ser visible con la instancia incluida
	 * @param metaValueD
	 * @return
	 */
	public static boolean isVisible(Element metaValueD) {
		
		
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
	private static Boolean isVisibleVal(Element metaValueD) {
	
		ArrayList<OperationalValue> Shows = metaValueD.getShows();
		for (OperationalValue show : Shows) {
				if (show.getType().getName().equals(Oda2013StaticNames.VISIBLESHOWN))
					if (show.getValue().equals(Boolean.toString(true)))
						return true;
					else if (show.getValue().equals(Boolean.toString(false)))
						return false;
		}
		return null;
	}
	
	/**
	 * Funcion que define si un meta es navegable
	 * @param meta
	 * @return
	 */
	public static boolean isBrowseable(ElementType meta) {
		ArrayList<OperationalView> Shows = meta.getShows();
		for (OperationalView show : Shows) {
			ArrayList<OperationalValueType> ShowValue = show.getValues();
			for (OperationalValueType showValues : ShowValue) {
				if (showValues.getName().equals(Oda2013StaticNames.BROWSERSHOWN))
						if (showValues.getDefault().equals(Boolean.toString(true)))
									return true;
						if (showValues.getDefault().equals(Boolean.toString(false)))
									return false;
							}
						}
		return false;
	}

	/**
	 * Funcion que define si un meta es navegable
	 * @param meta
	 * @return
	 */
	public static boolean isBrowseable(Grammar meta) {
		ArrayList<OperationalView> Shows = meta.getViews();
		for (OperationalView show : Shows) {
			ArrayList<OperationalValueType> ShowValue = show.getValues();
			for (OperationalValueType showValues : ShowValue) {
				if (showValues.getName().equals(Oda2013StaticNames.BROWSERSHOWN))
						if (showValues.getDefault().equals(Boolean.toString(true)))
									return true;
						if (showValues.getDefault().equals(Boolean.toString(false)))
									return false;
							}
						}
		return false;
	}
	
	/**
	 * Funcion que retorna el icono de un recurso Objeto digital
	 * @param objetoDigital
	 * @return
	 */
	public static Resources getIcon(Documents recurso) {
		for (Element elem : recurso.getDescription()) {
			String res=getIcon(elem);
				if (res!=null)
					return new File(res);
		}
		
		return null;
	}
	
	
	/**
	 * Funcion que retorna el icono de un MetaValue donde esta definido el icono
	 * @param elem
	 * @return
	 */
	private static String getIcon(Element elem) {
		
		ArrayList<OperationalValue> ShowsInst = elem.getShows();
		for (OperationalValue show : ShowsInst) {
				if (show.getType().getName().equals(Oda2013StaticNames.ICON))
					return show.getValue();

		}
		
		ArrayList<OperationalView> Shows = elem.getHastype().getShows();
		for (OperationalView show : Shows) {
			ArrayList<OperationalValueType> ShowValue = show.getValues();
			for (OperationalValueType showValues : ShowValue) {
				if (showValues.getName().equals(Oda2013StaticNames.ICON))
					if (!showValues.getDefault().isEmpty())
						return showValues.getDefault();
			}
		}
		return null;
		
	}
	
/**
 * Calcula el destino dependiendo si es imagen o URL
 * @param elementoIcono recurso a calcular destino
 * @param BasePath path del sistema de archivos
 * @return Direccion destino
 */
	public static String calculaDestino(Resources elementoIcono) {
		if (elementoIcono==null)
			return null;
		else if (elementoIcono instanceof File)
			return ((File)elementoIcono).getPath();
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
	public static String calculaImagenAsociada(Resources elementoIcono) {
		if (elementoIcono==null)
			return GWT.getHostPageBaseURL()+Oda2013StaticIconos.ICONODEFAULT;
		if (elementoIcono instanceof File)
			{
			return calculaIconoPorExtension(((File)elementoIcono).getPath());
							
			}
		else if (elementoIcono instanceof URL)
			return GWT.getHostPageBaseURL()+Oda2013StaticIconos.ICONOURL;
		
		return GWT.getHostPageBaseURL()+Oda2013StaticIconos.ICONODEFAULT;
	}

	
	/**
	 * Calcula el icono en base a la extension
	 * @param path
	 * @return 
	 */
	private static String calculaIconoPorExtension(String path) {
		
		if
		(
				//Imagen
		path.toLowerCase().endsWith(".jpg")
		||
		path.toLowerCase().endsWith(".jpge")	
		||
		path.toLowerCase().endsWith(".gif")
		||
		path.toLowerCase().endsWith(".png")
		)
		return path;
	else
		if (path.toLowerCase().endsWith(".rar"))
			return GWT.getHostPageBaseURL()+Oda2013StaticIconos.ICONORAR;
	else
		if (path.toLowerCase().endsWith(".avi"))
			return GWT.getHostPageBaseURL()+Oda2013StaticIconos.ICONOAVI;
		else
			if (path.toLowerCase().endsWith(".doc"))
				return GWT.getHostPageBaseURL()+Oda2013StaticIconos.ICONODOC;
			else
				if (path.toLowerCase().endsWith(".docx"))
					return GWT.getHostPageBaseURL()+Oda2013StaticIconos.ICONODOCX;
				else
					if (path.toLowerCase().endsWith(".pdf"))
						return GWT.getHostPageBaseURL()+Oda2013StaticIconos.ICONOPDF;
					else
						if (path.toLowerCase().endsWith(".html"))
							return GWT.getHostPageBaseURL()+Oda2013StaticIconos.ICONOHTML;
						else
							if (path.toLowerCase().endsWith(".htm"))
								return GWT.getHostPageBaseURL()+Oda2013StaticIconos.ICONOHTML;
							else
								if (path.toLowerCase().endsWith(".php"))
									return GWT.getHostPageBaseURL()+Oda2013StaticIconos.ICONOHTML;
								else
									if (path.toLowerCase().endsWith(".ppt"))
										return GWT.getHostPageBaseURL()+Oda2013StaticIconos.ICONOPPT;
									else
										if (path.toLowerCase().endsWith(".pptx"))
											return GWT.getHostPageBaseURL()+Oda2013StaticIconos.ICONOPPTX;
										else
											if (path.toLowerCase().endsWith(".mov"))
												return GWT.getHostPageBaseURL()+Oda2013StaticIconos.ICONOMOV;
											else
												if (path.toLowerCase().endsWith(".fla"))
													return GWT.getHostPageBaseURL()+Oda2013StaticIconos.ICONOFLA;
												else
													if (path.toLowerCase().endsWith(".swf"))
														return GWT.getHostPageBaseURL()+Oda2013StaticIconos.ICONOSWF;
													else
														if (path.toLowerCase().endsWith(".midi"))
															return GWT.getHostPageBaseURL()+Oda2013StaticIconos.ICONOMIDI;
														else
															if (path.toLowerCase().endsWith(".mp3"))
																return GWT.getHostPageBaseURL()+Oda2013StaticIconos.ICONOMP3;
															else
																if (path.toLowerCase().endsWith(".mp4"))
																	return GWT.getHostPageBaseURL()+Oda2013StaticIconos.ICONOMP4;
																else
																	if (path.toLowerCase().endsWith(".mpg"))
																		return GWT.getHostPageBaseURL()+Oda2013StaticIconos.ICONOMPG;
																	else
																		if (path.toLowerCase().endsWith(".odt"))
																			return GWT.getHostPageBaseURL()+Oda2013StaticIconos.ICONOODT;
																		else
																			if (path.toLowerCase().endsWith(".ods"))
																				return GWT.getHostPageBaseURL()+Oda2013StaticIconos.ICONOODS;
																			else
																				if (path.toLowerCase().endsWith(".zip"))
																					return GWT.getHostPageBaseURL()+Oda2013StaticIconos.ICONOZIP;
																				else
																					if (path.toLowerCase().endsWith(".rtf"))
																						return GWT.getHostPageBaseURL()+Oda2013StaticIconos.ICONORTF;
																					else
																						if (path.toLowerCase().endsWith(".ttf"))
																							return GWT.getHostPageBaseURL()+Oda2013StaticIconos.ICONOTTF;
																						else
																							if (path.toLowerCase().endsWith(".txt"))
																								return GWT.getHostPageBaseURL()+Oda2013StaticIconos.ICONOTXT;
																							else
																								if (path.toLowerCase().endsWith(".wav"))
																									return GWT.getHostPageBaseURL()+Oda2013StaticIconos.ICONOWAV;
																								else
																									if (path.toLowerCase().endsWith(".wma"))
																										return GWT.getHostPageBaseURL()+Oda2013StaticIconos.ICONOWMA;
																									else
																										if (path.toLowerCase().endsWith(".wmv"))
																											return GWT.getHostPageBaseURL()+Oda2013StaticIconos.ICONOWMV;
																										else
																											if (path.toLowerCase().endsWith(".xls"))
																												return GWT.getHostPageBaseURL()+Oda2013StaticIconos.ICONOXLS;
																											else
																												if (path.toLowerCase().endsWith(".xlsx"))
																													return GWT.getHostPageBaseURL()+Oda2013StaticIconos.ICONOXLSX;
																												else
																													if (path.toLowerCase().endsWith(".xml"))
																														return GWT.getHostPageBaseURL()+Oda2013StaticIconos.ICONOXML;
	
	
											
	
		
		return GWT.getHostPageBaseURL()+Oda2013StaticIconos.ICONODEFAULT;
		
	}

	/**
	 * Devuelve si el tipo es de tipo meta Basico
	 * @param metaActual
	 * @return
	 */
	public static boolean NotBasic(ElementType metaActual) {
		if (metaActual instanceof MetaControlled)
			return true;
		else if (metaActual instanceof TextElementType)
			return true;
		else if (metaActual instanceof MetaDate)
			return true;
//		else if (metaActual instanceof MetaNumeric)
//			return true;
		else if (metaActual instanceof MetaBoolean)
			return true;
		else if (metaActual instanceof LinkElementType)
			return true;
		else if (metaActual instanceof ResourceElementType)
			return true;
		else return false;
	}

	public static String calculaImagenAsociada(Documents elementoIconoBoton) {
		for (Element elem : elementoIconoBoton.getDescription()) {
			String res=getIcon(elem);
				if (res!=null)
					return 	calculaIconoPorExtension(res);
		}
		
		return GWT.getHostPageBaseURL()+Oda2013StaticIconos.ICONODEFAULT;
	}

	
}
