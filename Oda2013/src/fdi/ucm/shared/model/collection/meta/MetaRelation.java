package fdi.ucm.shared.model.collection.meta;

import fdi.ucm.shared.model.collection.CollectionAttribute;

/**
 * Clase que genera una relacion entre secciones
 * @author Joaquin Gayoso
 *
 */
public class MetaRelation extends Meta{

	private static final long serialVersionUID = 1L;
	
	
	public MetaRelation() {
		super();
	}


	/**
	 * @param name
	 * @param browseable
	 * @param father
	 * @param summary
	 * @param visible
	 */
	public MetaRelation(String name, Boolean browseable,
			CollectionAttribute father, Boolean summary) {
		super(name, browseable, father, summary);
	}
	

}
