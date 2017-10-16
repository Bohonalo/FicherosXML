package sax;

import java.io.IOException;

import org.xml.sax.*;
import org.xml.sax.helpers.*;

public class LeerEmpleadosSXMLSAX {
	
	public static void main(String[] args) {
		
		try {
			XMLReader procXML = XMLReaderFactory.createXMLReader();
			GestionContenido gestor = new GestionContenido();
			procXML.setContentHandler(gestor);
			InputSource fileXML = new InputSource("empleados.xml");
			procXML.parse(fileXML);
			
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
			
	}

}
