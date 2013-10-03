/**
 * 
 */
package fdi.ucm.shared.model;

import java.io.Serializable;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * clase que define para la creacion de coleccion de exportacion
 * @author Joaquin Gayoso-Cabada
 *
 */
public class CollectionExport implements Serializable,IsSerializable{

	
		/**
	 * 
	 */
	private static final long serialVersionUID = 1685803534196521662L;
		private Long Id;
		private String name;
		
		
		public CollectionExport() {
		}


		/**
		 * @param id
		 * @param name
		 */
		public CollectionExport(Long id, String name) {
			super();
			Id = id;
			this.name = name;
		}


		/**
		 * @return the id
		 */
		public Long getId() {
			return Id;
		}


		/**
		 * @param id the id to set
		 */
		public void setId(Long id) {
			Id = id;
		}


		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}


		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}
		
		
		
}
