/**
 * 
 */
package fdi.ucm.shared.model.userserver;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * Clase que define a que Usuario pertenece cada colecccion
 * @author Joaquin Gayoso-Cabada
 *
 */
@Entity
@Table(name = "Users")
public class UserServer implements Serializable,IsSerializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(unique=true, nullable=false)
	private String User;
	
	@Column(nullable=false)
	private String Password;
	
	@Column(nullable=false)
	private String publicName;
	
	@OneToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CollectionPropias> Colecciones;

	@Column(unique=true, nullable=false)
	private String Email;
	
	
	
	
	
	/**
	 * @param user
	 * @param password
	 * @param publicName
	 * @param email
	 */
	public UserServer(String user, String password, String publicName,
			String email) {
		super();
		User = user;
		Password = password;
		this.publicName = publicName;
		Email = email;
		Colecciones=new ArrayList<CollectionPropias>();
	}



	public UserServer() {
		Colecciones=new ArrayList<CollectionPropias>();
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
	 * @return the user
	 */
	public String getUser() {
		return User;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		User = user;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return Password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		Password = password;
	}

	/**
	 * @return the publicName
	 */
	public String getPublicName() {
		return publicName;
	}

	/**
	 * @param publicName the publicName to set
	 */
	public void setPublicName(String publicName) {
		this.publicName = publicName;
	}

	/**
	 * @return the colecciones
	 */
	public List<CollectionPropias> getColecciones() {
		return Colecciones;
	}

	/**
	 * @param colecciones the colecciones to set
	 */
	public void setColecciones(List<CollectionPropias> colecciones) {
		Colecciones = colecciones;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return Email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		Email = email;
	}
	
	

	
}
