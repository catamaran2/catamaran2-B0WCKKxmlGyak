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

public class DOMParserB0WCKK {

	public static void main(String[] args) {
		
		
		try { 
		File inputFile = new File("G:\\Oxygen XML Editor 23\\projects\\student.xml");
		
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		Document doc = builder.parse(inputFile);
		
		doc.getDocumentElement().normalize();
		
		System.out.println("Root element: "+ doc.getDocumentElement().getNodeName());
		
		NodeList nList = doc.getElementsByTagName("student");
        System.out.println("----------------------------");
        
        for(int i = 0 ; i < nList.getLength(); i++ ) {
        	Node nNode = nList.item(i);
        	
        	Element eElement = (Element) nNode;
        	System.out.println("rollno: " + eElement.getAttribute("rollno"));
        	System.out.println("first name: " + eElement.getAttribute("firstname"));
        	System.out.println("last name: " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
        	System.out.println("nickname: " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
        	System.out.println("age: " + eElement.getElementsByTagName("age").item(0).getTextContent());
        }
		
		
		}catch (Exception e) {
	         e.printStackTrace();
	}

}
}
