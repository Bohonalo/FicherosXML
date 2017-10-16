package sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class GestionContenido extends DefaultHandler {

	public void startDocument() {
		System.out.println("Comienzo del documento XML");
	}

	public void endDocument() {
		System.out.println("Fin del documento XML");
	}

	public void startElement(String uri, String nom, String nomC, Attributes atts) {
		System.out.println("\t Principio elemento: " + nom);
	}

	public void endElement(String uri, String nom, String nomC) {
		System.out.println("\t Fin elemento: " + nom);
	}

	public void characters(char[] ch, int inicio, int longitud) throws SAXException {
		String car = new String(ch, inicio, longitud);
		car = car.replace("[\t\n]", "");
		System.out.println("\t Caracteres: " + car);
	}

}
