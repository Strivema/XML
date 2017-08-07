package Ray.xml;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class TestXML2 {
	public static void main(String[] args) {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder document = documentBuilderFactory.newDocumentBuilder();
			Document parse = document.parse("hello.xml");
			NodeList element = parse.getElementsByTagName("student");
			for(int i = 0;i<element.getLength();i++){
				//System.out.println(element.item(i));
				Node item = element.item(i);
				Element e = (Element)item;
				String attribute = e.getAttribute("id");
				System.out.println(attribute);
				Element name = (Element) e.getElementsByTagName("name").item(0);
				Element gender =(Element) e.getElementsByTagName("gender").item(0);
				Element score =(Element) e.getElementsByTagName("score").item(0);
				Element course =(Element) e.getElementsByTagName("course").item(0);
				System.out.println(name.getTagName()+"-------"+name.getTextContent());
				System.out.println(gender.getTagName()+"------"+gender.getTextContent());
				System.out.println(score.getTagName()+"-----"+score.getTextContent());
				System.out.println(course.getTagName()+"-------"+course.getTextContent());
				System.out.println("---------------------");
			}
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
