/**
 * 
 */
package fdi.ucm.shared.model.userserver;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * Clase que define las colecciones que posee un usuario
 * @author Joaquin Gayoso-Cabada
 *
 */
@Entity
@Table(name = "Collections")
public class CollectionPropias implements Serializable,IsSerializable{

	private static final long serialVersionUID = 3540633522691779763L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(nullable=false)
	private String Name;
	
	@Column(nullable=false)
	private String SavePath;
	
	@Column(nullable=true)
	private String FilePath;
	
	@Column(nullable=false)
	private boolean Publica;
	
	@Column(length = 140, nullable=true)
	private String Description;
	
	@Column(length = 40, unique = true , nullable=true)
	private String Publicname;

	/**
	 * @param name
	 * @param path
	 * @param filepath
	 */
	public CollectionPropias(String name, String path,String filepath) {
		super();
		Name = name;
		SavePath = path;
		FilePath=filepath;
		Publica=false;
	}

	
	public CollectionPropias() {
		super();
		Name = "Unknow";
		SavePath = "Unknow";
		Publica=false;
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

	public String getSavePath() {
		return SavePath;
	}
	
	public void setSavePath(String savePath) {
		SavePath = savePath;
	}
	
	public String getFilePath() {
		return FilePath;
	}
	
	public void setFilePath(String filePath) {
		FilePath = filePath;
	}


	/**
	 * @return the publica
	 */
	public boolean isPublica() {
		return Publica;
	}


	/**
	 * @param publica the publica to set
	 */
	public void setPublica(boolean publica) {
		Publica = publica;
	}


	/**
	 * @return the description
	 */
	public String getDescription() {
		return Description;
	}


	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		Description = description;
	}


	/**
	 * @return the publicname
	 */
	public String getPublicname() {
		return Publicname;
	}


	/**
	 * @param publicname the publicname to set
	 */
	public void setPublicname(String publicname) {
		Publicname = publicname;
	}
	
	
	
}
