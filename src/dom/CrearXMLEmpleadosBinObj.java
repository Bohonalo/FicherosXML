package dom;

import java.io.*;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;


public class CrearXMLEmpleadosBinObj {

	public static void main(String[] args) {
		
		ObjectInputStream ois = null;
		
		
		try {
			ois = new ObjectInputStream(new FileInputStream("empleadosObj.dat"));
			
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			DOMImplementation implementacion = db.getDOMImplementation();
			
			// Creamos un documento vacío de nombre doc con el nodo raíz de 
			// nombre Empleados y asignamos la versión del XML
			Document doc = implementacion.createDocument(null, "empleados", null);
			doc.setXmlVersion("1.0");
			
			// declaramos las variables que voy a utilizar en el while
			Empleado emp = null;
			Element elemento = null;
			
			try {
				while ((emp = (Empleado) ois.readObject())!= null) {
					System.out.println("ID: " + emp.getId() 
								+ " Nombre: " + emp.getNombre() 
								+" Depto: " + emp.getDep() 
								+ " Salario: " + emp.getSalario());
					// creamos un nodo o elemento de nombre empleado.
					elemento = doc.createElement("empleado");   
					doc.getDocumentElement().appendChild(elemento);
					
					crarElementoHijo(doc, elemento, "Id", emp.getId()+"");
					crarElementoHijo(doc, elemento, "Nombe", emp.getNombre());
					crarElementoHijo(doc, elemento, "Departamento", emp.getDep()+"");
					crarElementoHijo(doc, elemento, "Salario", emp.getSalario()+"");
					
				}
			}catch (EOFException e) {
				System.out.println("Fin del fichero.");
			}
			
			// Creamos la fuente XML a partir del documento
			Source source = new DOMSource(doc);
			// Creamos el resultado en el fichero empleados.xml
			Result result = new StreamResult(new File("empleados.xml"));
			
			// Obtenemos un TransformerFactory
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			// Le damos formato y realizamos la transformación del documento a fichero
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(OutputKeys.METHOD, "xml"); 
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			transformer.transform(source,  result); 
			
			// Mostramos el documento por pantalla especificando como canal de salida
			// el System.out
			Result console = new StreamResult(System.out);
			transformer.transform(source, console);

			
		} catch (FileNotFoundException e) {
			System.out.println("No se ha encontrado el fichero.");
		}catch (IOException e) {
			System.out.println("Error de entrada/salida.");
		}catch (ClassNotFoundException e) {
			System.out.println("Error al leer el fichero.");
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (ois !=null) {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	private static void crarElementoHijo(Document doc,  Element elemento, String nomElemento,
			String valor) {
		Element elemHijo = doc.createElement(nomElemento);
		Text text = doc.createTextNode(valor);
		elemento.appendChild(elemHijo);
		elemHijo.appendChild(text);
	}

}
