package fdi.ucm.shared.model.collection.meta;

import fdi.ucm.shared.model.collection.CollectionAttribute;

/**
 * Clase que genera una relacion entre secciones
 * @author Joaquin Gayoso
 *
 */
public class MetaRelationResource extends MetaRelation{

	private static final long serialVersionUID = 1L;
	
	
	public MetaRelationResource() {
		super();
	}


	/**
	 * @param name
	 * @param father
	 * @param summary
	 */
	public MetaRelationResource(String name, CollectionAttribute father) {
		super(name,father);
	}
	

}
