package dom;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.*;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class LeerXMLEmpleados {
	
	public static void main(String[] args) {
		// careamos una instancia al DocumentBuilderFactory
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
		try {
			// creamos un DocumentBuilder para usarlo como parseador
			DocumentBuilder db = dbf.newDocumentBuilder();
			// recuperamos el documento que vamos a leer
			Document document = db.parse(new File("empleados.xml"));
			
			// Accedemos al nodo raíz --> empleados
			Node raiz = document.getFirstChild();
			// sacamos por consula el nodo raíz
			System.out.println(raiz.getNodeName());
			
			// accedemos a los nodos hijos del nodo raíz, obtenemos una lista
			NodeList elementos = raiz.getChildNodes();
			
			Node nodo, nodo2;
			NodeList hijos, hijos2;
			
			// recorrer la lista de nodos hijos del nodo raíz
			for (int i = 0; i < elementos.getLength(); i++) {
				// accedemos a los elementos de la lista --> empleado
				nodo = elementos.item(i);
				
				// para cada nodo comprobamos que sea de tipo elemento
				if (nodo.getNodeType() == Node.ELEMENT_NODE) {
					// sacamos por consola el nombre de la etiqueta tabulandola con
					// respecto a nodo raíz
					System.out.println("\t" + nodo.getNodeName());
					
					// accedemos a la lista de leementos hijos del nodo que estamos trabajando
					hijos = nodo.getChildNodes();
					// ecorrer la lista de nodos hijos del nodo que estamos trabajando
					for (int j = 0; j < hijos.getLength(); j++) {
						// accedemos a los elementos de dicha lista --> id, nombres, departamento y salario
						nodo2 = hijos.item(j);
						
						// para cada ujno de estos nodos comprobamos que sea de tipo elemento
						if (nodo2.getNodeType() == Node.ELEMENT_NODE) {
							// sacamos por consola el nombre de la etiqueta tabulandola
							System.out.println("\t\t" + nodo2.getNodeName());
							
							// accedemos a la lista de leementos hijos
							hijos2 = nodo2.getChildNodes();
							
							//System.out.println("-----Nº hijos " + nodo2.getNodeName() + ": "  
							//				+ hijos2.getLength());
							
							// sabemos que el nodo2 ya contiene texto y por tanto solo tiene un nodo hijo,
							// accedemos directamente al valor
							System.out.println("\t\t\t" + hijos2.item(0).getNodeValue());
						}
					}
				}
			}
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}