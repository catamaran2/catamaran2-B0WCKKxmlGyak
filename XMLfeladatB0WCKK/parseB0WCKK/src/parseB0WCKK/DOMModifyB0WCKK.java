package XMLbeadandoB0WCKK;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMModifyB0WCKK {

    public static void main(String argv[]) {

       try {
    	   //file keresése
        String filepath = "G:\\Oxygen XML Editor 23\\projects\\beadandoB0WCKK.xml";
        
        //doc builder
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.parse(filepath);

        // gyökérelem
        Node filmek = doc.getFirstChild();

        //nodelist létrehozása
        NodeList film = doc.getElementsByTagName("film");

        
        //nodelist végigjárása egyesével
        for(int i = 0 ; i < film.getLength(); i++) {
        	Node filmNode = film.item(i);
        	//minden filmnek átírja a címét
        	NamedNodeMap attr = filmNode.getAttributes();
            Node nodeAttr = attr.getNamedItem("cim");
            nodeAttr.setTextContent("EDITED");
        }


        // editeli az xml file-t
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(filepath));
        transformer.transform(source, result);

        System.out.println("Done");

       } catch (ParserConfigurationException pce) {
        pce.printStackTrace();
       } catch (TransformerException tfe) {
        tfe.printStackTrace();
       } catch (IOException ioe) {
        ioe.printStackTrace();
       } catch (SAXException sae) {
        sae.printStackTrace();
       }
    }
}
