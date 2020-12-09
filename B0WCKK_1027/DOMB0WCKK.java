package XMLbeadandoB0WCKK;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element.*;
import javax.xml.xpath.*;

public class DOMB0WCKK {

	public static void main(String[] args) {
		
		
		try { 
		File inputFile = new File("G:\\Oxygen XML Editor 23\\projects\\szemelyek.xml");
		
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		Document doc = builder.parse(inputFile);
		
		doc.getDocumentElement().normalize();
		
		System.out.println("Root element: "+ doc.getDocumentElement().getNodeName());
		
		NodeList nList = doc.getElementsByTagName("szemely");
        System.out.println("----------------------------");
        
        for(int i = 0 ; i < nList.getLength(); i++ ) {
        	Node nNode = nList.item(i);
        	System.out.println("\nCurrent node: " + nNode.getNodeName());
        	
        	Element eElement = (Element) nNode;
        	System.out.println("név: " + eElement.getAttribute("nev"));
        	System.out.println("kor: " + eElement.getElementsByTagName("kor").item(0).getTextContent());
        	System.out.println("varos: " + eElement.getElementsByTagName("város").item(0).getTextContent());
        }
		
		
		}catch (Exception e) {
	         e.printStackTrace();
	}

}
}
