package fdi.ucm.client.publiccolletions;

import java.util.ArrayList;

import fdi.ucm.shared.model.collection.meta.Meta;
import fdi.ucm.shared.model.collection.meta.show.Show;
import fdi.ucm.shared.model.collection.meta.show.ShowValoresResult;
import fdi.ucm.shared.model.collection.meta.show.ShowValues;

/**
 * Clase que define las funciones estaticas que se desarroyan en el visualizador basadas en los shows del objeto esperados
 * @author Coca-COla
 *
 */
public class ShowsStaticFunctions {

	public static boolean isSummary(Meta meta) {
		ArrayList<Show> Shows = meta.getShows();
		for (Show show : Shows) {
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

	public static boolean isVisible(Meta meta) {
		ArrayList<Show> Shows = meta.getShows();
		for (Show show : Shows) {
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

	public static boolean isBrowseable(Meta meta) {
		ArrayList<Show> Shows = meta.getShows();
		for (Show show : Shows) {
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

	
	
}
