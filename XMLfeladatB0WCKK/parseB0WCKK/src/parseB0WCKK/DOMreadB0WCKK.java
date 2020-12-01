package parseB0WCKK;

import java.nio.file.Path;
import java.nio.file.Paths;

import java.io.File;
import java.io.IOException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class DOMreadB0WCKK {

	public static void main(String[] args) {

		
		//java file jelenlegi hely keresése, troubleshootinghoz
		Path currentRelativePath = Paths.get(""); 
		String s = currentRelativePath.toAbsolutePath().toString();
		System.out.println("Current relative path is: " + s);

		try {

			//xml file elérése. Nem találja a filet sehogy sem.
		    String filepath = "C:/Users/Intel/eclipse-workspace/parseB0WCKK/XMLB0WCKK.xml";
			File fXmlFile = new File(filepath);
		    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		    Document doc = dBuilder.parse(fXmlFile);
		            
		    //struktúra normalizálás
		    doc.getDocumentElement().normalize();

		    System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
		            
		    NodeList nList = doc.getElementsByTagName("filmek");
		            
		    System.out.println("----------------------------");

		    for (int temp = 0; temp < nList.getLength(); temp++) {

		        Node nNode = nList.item(temp);
		                
		        System.out.println("\nCurrent Element :" + nNode.getNodeName());
		                
		        if (nNode.getNodeType() == Node.ELEMENT_NODE) {

		            Element eElement = (Element) nNode;
		            

		            System.out.println("Film címe : " + eElement.getElementsByTagName("cím").item(0).getTextContent());

		            System.out.println("rendezõ neve : " + eElement.getAttribute("név"));
		            System.out.println("Genre : " + eElement.getElementsByTagName("genre").item(0).getTextContent());

		        }
		    }
		    } catch (Exception e) {
		    e.printStackTrace();
		    }
		
		
	}

}
