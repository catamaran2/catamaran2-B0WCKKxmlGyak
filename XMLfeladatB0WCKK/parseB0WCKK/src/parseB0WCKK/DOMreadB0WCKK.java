package XMLbeadandoB0WCKK;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class DOMReadB0WCKK {

	public static void main(String[] args) {
		
		try {
			//megnyitja az xml filet
			File inputFile = new File("G:\\Oxygen XML Editor 23\\projects\\beadandoB0WCKK.xml");
			
			//documentbuilder
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setNamespaceAware(true);
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			Document doc = builder.parse(inputFile);
			
			
			//dokumentum normalizálása
			doc.getDocumentElement().normalize();
			//root element kiírása
			System.out.println("Root element: "+ doc.getDocumentElement().getNodeName());
			//létrehoz egy nodelistet a filmekről
			NodeList nList = doc.getElementsByTagName("film");
	        System.out.println("----------------------------");
	        //végigmegy az összes node-on a listában, és mindegyiknek kiírja az összes adatát
	        for(int i = 0 ; i < nList.getLength(); i++ ) {
	        	Node nNode = nList.item(i);
	        	System.out.println("\nCurrent node: " + nNode.getNodeName());
	        	
	        	Element eElement = (Element) nNode;
	        	System.out.println("Film címe: " + eElement.getAttribute("cim"));
	        	System.out.println("Genre: " + eElement.getElementsByTagName("genre").item(0).getTextContent());
	        	System.out.println("Rendező neve, film(db), szül.év: " + eElement.getElementsByTagName("rendező").item(0).getTextContent());
	        	System.out.println("Főszereplő neve, film(db), szül.év: " + eElement.getElementsByTagName("főszereplő").item(0).getTextContent());
	        	System.out.println("Kritikai értékelés és nézői értékelés: " + eElement.getElementsByTagName("értékelés").item(0).getTextContent());
	        }
			
			
		}catch (Exception e) {
	         e.printStackTrace();
	      }
	}

}
