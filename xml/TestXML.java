package Ray.xml;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class TestXML {
	public static void main(String[] args)  {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		try {
			dBuilder = documentBuilderFactory.newDocumentBuilder();
			Document parse = dBuilder.parse("hello.xml");
			NodeList childNodes = parse.getChildNodes();
			Node scores = childNodes.item(2);
			
			NodeList childNodes2 = scores.getChildNodes();
			for(int i =0;i<childNodes2.getLength();i++){
				Node node = childNodes2.item(i);
				if(node.getNodeType()==node.ELEMENT_NODE){
					NamedNodeMap attributes = node.getAttributes();
					System.out.println(attributes.getNamedItem("id").getNodeValue());
					NodeList childNodes3 = node.getChildNodes();
					for(int j =0;j<childNodes3.getLength();j++){
						Node item = childNodes3.item(j);
						if(item.getNodeType()==item.ELEMENT_NODE){
							System.out.println(item.getNodeName()+"----"+item.getTextContent());
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
