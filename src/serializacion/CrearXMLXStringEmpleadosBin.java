package serializacion;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.thoughtworks.xstream.XStream;

import dom.Empleado;

public class CrearXMLXStringEmpleadosBin {

	public static void main(String[] args) {
		
		ObjectInputStream ois = null;

			try {
				ois = new ObjectInputStream(new FileInputStream("empleadosObj.dat"));
				Empleado emp = null;
				ListaEmpleados listaEmp = new ListaEmpleados();
				try {
					while ((emp = (Empleado) ois.readObject()) != null) {
						// añadimos el empleado a la lista
						listaEmp.add(emp);
					}
				}catch (EOFException e) {
					System.out.println("Final del fichero");
			}
				
			// Creamos el fichero XML 
			XStream xs = new XStream();
			xs.alias("Empleados", ListaEmpleados.class);
			xs.alias("DatosEmpleado", Empleado.class);
			xs.addImplicitCollection(ListaEmpleados.class, "lista");
			xs.toXML(listaEmp, new FileOutputStream("empleados3.xml"));

				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}finally {
				if (ois != null) {
					try {
						ois.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}		
	}

}
