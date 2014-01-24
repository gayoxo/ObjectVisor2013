package fdi.ucm.shared.model.collection;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.rpc.IsSerializable;

import fdi.ucm.shared.model.collection.document.Documents;
import fdi.ucm.shared.model.collection.document.File;
import fdi.ucm.shared.model.collection.grammar.Grammar;


/**
 * Clase que implemeta una coleccion
 * @author Joaquin Gayoso-Cabada
 *
 */
public class Collection  implements Serializable,IsSerializable{

	private static final long serialVersionUID = 3540633522691779763L;
	
	private Long id;
	
	private String Name;
	
	private List<Grammar> MetamodelSchemas;
	
	private List<File> SectionValues;
	
	private List<Documents> Estructuras;
	
	

	/**
	 * Constructor por defecto necesario para serializacion
	 */
	public Collection() {
		MetamodelSchemas= new ArrayList<Grammar>();
		SectionValues=new ArrayList<File>();
		Estructuras=new ArrayList<Documents>();
		id=null;
				
	}

	/**
	 * Constructor por defecto necesario para serializacion
	 */
	public Collection(String Namein) {
		MetamodelSchemas= new ArrayList<Grammar>();
		SectionValues=new ArrayList<File>();
		Name=Namein;
		id=null;		
	}
	
	/**
	 * @return the metamodelSchemas
	 */
	public List<Grammar> getMetamodelGrammar() {
		return MetamodelSchemas;
	}

	/**
	 * @param metamodelSchemas the metamodelSchemas to set
	 */
	public void setMetamodelGrammar(ArrayList<Grammar> metamodelSchemas) {
		MetamodelSchemas = metamodelSchemas;
	}

	/**
	 * @return the sectionValues
	 */
	public List<File> getSectionValues() {
		return SectionValues;
	}

	/**
	 * @param sectionValues the sectionValues to set
	 */
	public void setSectionValues(ArrayList<File> sectionValues) {
		SectionValues = sectionValues;
	}	


	/**
	 * @return the name
	 */
	public String getName() {
		return Name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		Name = name;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the estructuras
	 */
	public List<Documents> getEstructuras() {
		return Estructuras;
	}

	/**
	 * @param estructuras the estructuras to set
	 */
	public void setEstructuras(List<Documents> estructuras) {
		Estructuras = estructuras;
	}
	
	
	
}
