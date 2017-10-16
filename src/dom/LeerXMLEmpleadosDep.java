package dom;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class LeerXMLEmpleadosDep {
	
	public static void main(String[] args) {
		
		// careamos una instancia al DocumentBuilderFactory
				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
				
				try {
					// creamos un DocumentBuilder para usarlo como parseador
					DocumentBuilder db = dbf.newDocumentBuilder();
					// recuperamos el documento que vamos a leer
					Document document = db.parse(new File("empleadosDep.xml"));
					
					// Accedemos al nodo raíz --> empleados
					Node raiz = document.getFirstChild();
					// sacamos por consula el nodo raíz
					System.out.println(raiz.getNodeName());
					
					// accedemos a los nodos hijos del nodo raíz, obtenemos una lista
					NodeList elementos = raiz.getChildNodes();
										
					obtenerNodosHijos(elementos, "");
					
				} catch (ParserConfigurationException e) {
					e.printStackTrace();
				} catch (SAXException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
	}
	 private static void obtenerNodosHijos(NodeList elementos, String tab) {
		 
		 Node nodo;
		 NodeList hijos;
		 NamedNodeMap attrs;
		 Attr attribute;
		 if (elementos.getLength() > 1) {
			 for (int i = 0; i < elementos.getLength(); i++) {
					// accedemos a los elementos de la lista --> empleado
					nodo = elementos.item(i);
					
					// para cada nodo comprobamos que sea de tipo elemento
					if (nodo.getNodeType() == Node.ELEMENT_NODE) {
						// sacamos por consola el nombre de la etiqueta tabulandola con
						// respecto a nodo raíz
						System.out.print( tab +"\t" + nodo.getNodeName());
						
						if (nodo.hasAttributes()) {
							attrs = nodo.getAttributes();
							for (int j = 0; j < attrs.getLength(); j++) {
								attribute = (Attr)attrs.item(j);
								System.out.print("\t" + attribute);
								
							}
							
						}
						System.out.println("");
						// accedemos a la lista de leementos hijos del nodo que estamos trabajando
						hijos = nodo.getChildNodes();
						obtenerNodosHijos(hijos, tab +"\t");
					}
			 }
		 }else {
			 System.out.println( tab + "\t" + elementos.item(0).getNodeValue());
		 	}
	 }
	 
}
