package dom;

import java.io.Serializable;

public class Departamento implements Serializable {


	private static final long serialVersionUID = 7933808777871788149L;
	
		private int id;
		private String nombre;
		private String localizacion;
		
		
		public Departamento(int id, String nombre, String localizacion) {
			this.id = id;
			this.nombre = nombre;
			this.localizacion = localizacion;
		}
		
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getLocalizacion() {
			return localizacion;
		}
		public void setLocalizacion(String localizacion) {
			this.localizacion = localizacion;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		
		


}
