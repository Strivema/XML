package Ray.xml;

import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class TestXml4 {
	public static void main(String[] args) {
		SAXReader saxReader =new SAXReader();
		try {
			Document document = saxReader.read("hello.xml");
			Element ele = document.getRootElement();
			
			
			List elements = ele.elements();
			
			/*for(int i =0;i<elements.size();i++){
				Element stu = (Element)elements.get(i);
				Attribute attribute = stu.attribute("id");
				System.out.println(attribute.getName()+"-----"+attribute.getValue());
			}*/
			
			
			Iterator elIterator = ele.elementIterator();
			while(elIterator.hasNext()){
				
				Element next = (Element) elIterator.next();
				
				Attribute attribute = next.attribute("id");
				System.out.println(attribute.getName()+"-"+attribute.getValue());
				
				List<Element> element = next.elements();
				
				for(Element list:element){
					System.out.println(list.getName()+"----"+list.getStringValue());
				}
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
