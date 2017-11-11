package com.miage.crm365.model.service.impl;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
* Cette classe est purement utilise a des fins de documentation
* pour lister les differentes methodes de tests
* pour chaque classe contenu dans le repertoire test/java
* Sa methode main listera ces derniers sur la sortie standard console
* @author eric RAKOTOBE
*
*/
public class AbstractListClassMethodTest {
	
	
	public static void main(String[] args) throws Exception{
		File repertoire = new File("target/surefire-reports");
		String pathPrefixe = "target/surefire-reports/TEST-";
		int lengthPathPrefixe = pathPrefixe.length();
		File[] files=repertoire.listFiles();
		for(int i = 0 ; i < files.length ; i++){
			if (files[i].toString().endsWith(".xml")){
				String packageName = files[i].toString().substring(lengthPathPrefixe , files[i].toString().lastIndexOf(".xml"));	
				File fXmlFile = new File(files[i].toString());
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(fXmlFile);
				doc.getDocumentElement().normalize();
				NodeList nList = doc.getElementsByTagName("testcase");
				for (int temp = 0; temp < nList.getLength(); temp++) {
				   Node nNode = nList.item(temp);
				   if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		 
				      Element eElement = (Element) nNode;
				      String methodeName = eElement.getAttribute("name");
				      
				      System.out.println(packageName+"."+methodeName);
				   }
				}
			}
		}
	}
}
