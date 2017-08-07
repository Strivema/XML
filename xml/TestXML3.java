package Ray.xml;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class TestXML3 {
	public static void main(String[] args) {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder dBuilder = documentBuilderFactory.newDocumentBuilder();
			Document parse = dBuilder.parse("hello.xml");
			Element document= parse.getDocumentElement();
			
			parseXml(document);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void parseXml(Element ele) {
		System.out.print("<");
		System.out.print(ele.getTagName());
		if(ele.hasAttributes()){
			NamedNodeMap attrs = ele.getAttributes();
			for(int i = 0;i<attrs.getLength();i++){
				Attr attr = (Attr) attrs.item(i);
				System.out.print(attr+" ");
			}
		}
		System.out.print(">");
		NodeList childNodes = ele.getChildNodes();
		for(int i=0;i<childNodes.getLength();i++){
			Node item = childNodes.item(i);
			if(item.getNodeType()==item.ELEMENT_NODE){
				parseXml((Element)item);
			}else{
				System.out.print(item.getTextContent());
			}
		}
		System.out.print("</"+ele.getTagName()+">");
	}
}
