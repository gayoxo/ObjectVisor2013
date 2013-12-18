package fdi.ucm.shared.model.collection;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.rpc.IsSerializable;

import fdi.ucm.shared.model.collection.document.Documents;
import fdi.ucm.shared.model.collection.document.Resources;
import fdi.ucm.shared.model.collection.grammar.Structure;


/**
 * Clase que implemeta una coleccion
 * @author Joaquin Gayoso-Cabada
 *
 */
public class Collection  implements Serializable,IsSerializable{

	private static final long serialVersionUID = 3540633522691779763L;
	
	private Long id;
	
	private String Name;
	
	private List<Structure> MetamodelSchemas;
	
	private List<Resources> SectionValues;
	
	private List<Documents> Estructuras;
	
	

	/**
	 * Constructor por defecto necesario para serializacion
	 */
	public Collection() {
		MetamodelSchemas= new ArrayList<Structure>();
		SectionValues=new ArrayList<Resources>();
		Estructuras=new ArrayList<Documents>();
		id=null;
				
	}

	/**
	 * Constructor por defecto necesario para serializacion
	 */
	public Collection(String Namein) {
		MetamodelSchemas= new ArrayList<Structure>();
		SectionValues=new ArrayList<Resources>();
		Name=Namein;
		id=null;		
	}
	
	/**
	 * @return the metamodelSchemas
	 */
	public List<Structure> getMetamodelSchemas() {
		return MetamodelSchemas;
	}

	/**
	 * @param metamodelSchemas the metamodelSchemas to set
	 */
	public void setMetamodelSchemas(ArrayList<Structure> metamodelSchemas) {
		MetamodelSchemas = metamodelSchemas;
	}

	/**
	 * @return the sectionValues
	 */
	public List<Resources> getSectionValues() {
		return SectionValues;
	}

	/**
	 * @param sectionValues the sectionValues to set
	 */
	public void setSectionValues(ArrayList<Resources> sectionValues) {
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
