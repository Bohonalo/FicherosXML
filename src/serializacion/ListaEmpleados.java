package serializacion;

import java.util.ArrayList;
import dom.Empleado;

public class ListaEmpleados {

		private ArrayList<Empleado> lista;

		public ListaEmpleados() {
			this.lista = new ArrayList<Empleado>();
		}
	
		 public void add(Empleado emp) {
			  lista.add(emp);
		 }

		public ArrayList<Empleado> getLista() {
			return lista;
		}
		 

}
