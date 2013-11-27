package fdi.ucm.shared.model.collection.meta;

import fdi.ucm.shared.model.collection.CollectionAttribute;

/**
 * Clase que genera una relacion entre secciones
 * @author Joaquin Gayoso
 *
 */
public class MetaRelationConstruct extends MetaRelation{

	private static final long serialVersionUID = 1L;
	
	
	public MetaRelationConstruct() {
		super();
	}


	/**
	 * @param name
	 * @param father
	 * @param summary
	 */
	public MetaRelationConstruct(String name, CollectionAttribute father) {
		super(name,father);
	}
	

}
