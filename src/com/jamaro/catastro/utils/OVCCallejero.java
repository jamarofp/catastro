package com.jamaro.catastro.utils;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class OVCCallejero {
	
	

	
	public List<Provincia> List() {
		System.out.println("List de OVCCallejero");
		
		UrlConstructor urlConstructor = new UrlConstructor();
		String stUrl = urlConstructor.provincias();
		System.out.println(stUrl);
		UrlReader urlReader = new UrlReader(stUrl);

		String resultContent = urlReader.getContent();
		List<Provincia> provinciaList = new ArrayList<Provincia>();
		
		try {
			// https://www.tutorialspoint.com/java_xml/java_dom_parse_document.htm
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(new InputSource(new ByteArrayInputStream(resultContent.getBytes("utf-8"))));
			doc.getDocumentElement().normalize();
			
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			
			NodeList nList = doc.getElementsByTagName("prov");
			
			System.out.println("----------------------------");
			
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Provincia prov = new Provincia();
				
				Node nNode = nList.item(temp);
				System.out.println("\nCurrent Element :" + nNode.getNodeName());
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					System.out.println("cepine : " + eElement.getElementsByTagName("cpine").item(0).getTextContent());
					System.out.println("np : " + eElement.getElementsByTagName("np").item(0).getTextContent());
					
					
					prov.setCodigo_ine_provincia(eElement.getElementsByTagName("cpine").item(0).getTextContent());
					prov.setNombre_provincia(eElement.getElementsByTagName("np").item(0).getTextContent());
					
					provinciaList.add(prov);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return provinciaList;
	}

}
