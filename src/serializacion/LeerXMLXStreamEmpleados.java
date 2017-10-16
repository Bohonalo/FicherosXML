package serializacion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;

import dom.Empleado;


public class LeerXMLXStreamEmpleados {

	public static void main(String[] args) {
		FileInputStream fis = null;
		
		XStream xs = new XStream();
		xs.alias("Empleados", ListaEmpleados.class);
		xs.alias("DatosEmpleado", Empleado.class);
		xs.addImplicitCollection(ListaEmpleados.class, "lista");
		
		
		try {
			fis = new FileInputStream("empleados3.xml");
			ListaEmpleados listaTotal = (ListaEmpleados) xs.fromXML(fis);
			
			ArrayList<Empleado> listaEmp = new ArrayList<Empleado>();
			listaEmp = listaTotal.getLista();
			
			for (Empleado emp : listaEmp) {
				System.out.println("ID: " + emp.getId() + " Nombre " + emp.getNombre() +
						" Departamento " + emp.getDep() + " Salario " + emp.getSalario());
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			if(fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
