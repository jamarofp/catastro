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

public class OVCCoordenadas {

	static final String SRS_GOOGLEMAPS = "EPSG:4326";
	private String coords;
	private String srs;
	private String provincia;
	private String municipio;
	private String referencia_catastral;

	public OVCCoordenadas() {

	}
	
	public OVCCoordenadas(String coords) {
		this.coords = coords;
	}
	
	public OVCCoordenadas(String provincia, String municipio, String rc) {
		this.provincia = provincia;
		this.municipio = municipio;
		this.referencia_catastral = rc;
	}

	public String setCoords(String coords) {
		this.coords = coords;
		return this.coords;
	}

	public String setSRS(String srs) {
		this.srs = srs;
		return this.srs;
	}

	public Inmueble getRCCOOR() {
		UrlConstructor urlConstructor = new UrlConstructor();
		String stUrl = urlConstructor.RCCOOR();
		String coords = this.coords.replace(" ", "");
		srs = (this.srs == null) ? SRS_GOOGLEMAPS : this.srs;
		stUrl += "?SRS=" + this.srs + "&Coordenada_X=" + coords.split(",")[1] + "&Coordenada_Y=" + coords.split(",")[0];
		System.out.println(stUrl);
		UrlReader urlReader = new UrlReader(stUrl);

		String resultContent = urlReader.getContent();
		String txtResult = "";

		Inmueble inmueble = new Inmueble();
		
		try {
			// https://www.tutorialspoint.com/java_xml/java_dom_parse_document.htm
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(new InputSource(new ByteArrayInputStream(resultContent.getBytes("utf-8"))));
			doc.getDocumentElement().normalize();
			
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			
			NodeList nList = doc.getElementsByTagName("coordenadas");//pcd");
			
			System.out.println("----------------------------");
			
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				System.out.println("\nCurrent Element :" + nNode.getNodeName());
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					System.out.println("pc1 : " + eElement.getElementsByTagName("pc1").item(0).getTextContent());
					System.out.println("pc2 : " + eElement.getElementsByTagName("pc2").item(0).getTextContent());
					System.out.println("xcen : " + eElement.getElementsByTagName("xcen").item(0).getTextContent());
					System.out.println("ycen : " + eElement.getElementsByTagName("ycen").item(0).getTextContent());
					System.out.println("ldt : " + eElement.getElementsByTagName("ldt").item(0).getTextContent());
					
					inmueble.setpc1(eElement.getElementsByTagName("pc1").item(0).getTextContent());
					inmueble.setpc2(eElement.getElementsByTagName("pc2").item(0).getTextContent());
					inmueble.setxcen(eElement.getElementsByTagName("xcen").item(0).getTextContent());
					inmueble.setycen(eElement.getElementsByTagName("ycen").item(0).getTextContent());
					inmueble.setldt(eElement.getElementsByTagName("ldt").item(0).getTextContent());
					
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("------------------------------------------------------------------------");
		System.out.println(inmueble.toString());
		System.out.println("------------------------------------------------------------------------");
		//return txtResult;
		return inmueble;
	}

	public List<Inmueble> getRCCOOR_Distancia() {
		UrlConstructor urlConstructor = new UrlConstructor();
		String stUrl = urlConstructor.RCCOOR_Distancia();
		String coords = this.coords.replace(" ", "");
		srs = (this.srs == null) ? SRS_GOOGLEMAPS : this.srs;
		stUrl += "?SRS=" + this.srs + "&Coordenada_X=" + coords.split(",")[1] + "&Coordenada_Y=" + coords.split(",")[0];
		System.out.println(stUrl);
		UrlReader urlReader = new UrlReader(stUrl);

		String resultContent = urlReader.getContent();
		String txtResult = "";
		List<Inmueble> inmuebleList = new ArrayList<Inmueble>();

		
		try {
			// https://www.tutorialspoint.com/java_xml/java_dom_parse_document.htm
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(new InputSource(new ByteArrayInputStream(resultContent.getBytes("utf-8"))));
			doc.getDocumentElement().normalize();
			
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			
			NodeList nList = doc.getElementsByTagName("pcd");//pcd");
			
			System.out.println("----------------------------");
			System.out.println(nList.getLength());
			System.out.println("----------------------------");
			
			
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Inmueble inmueble = new Inmueble();

				Node nNode = nList.item(temp);
				System.out.println("\nCurrent Element :" + nNode.getNodeName());
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					System.out.println("pc1 : " + eElement.getElementsByTagName("pc1").item(0).getTextContent());
					System.out.println("pc2 : " + eElement.getElementsByTagName("pc2").item(0).getTextContent());
					System.out.println("ldt : " + eElement.getElementsByTagName("ldt").item(0).getTextContent());
					System.out.println("dis : " + eElement.getElementsByTagName("dis").item(0).getTextContent());
					
					inmueble.setpc1(eElement.getElementsByTagName("pc1").item(0).getTextContent());
					inmueble.setpc2(eElement.getElementsByTagName("pc2").item(0).getTextContent());
					inmueble.setldt(eElement.getElementsByTagName("ldt").item(0).getTextContent());
					inmueble.setdis(eElement.getElementsByTagName("dis").item(0).getTextContent());
					
					inmuebleList.add(inmueble);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return inmuebleList;
	}
	
	public Inmueble getCPMRC() {
		UrlConstructor urlConstructor = new UrlConstructor();
		String stUrl = urlConstructor.CPMRC();
		srs = (this.srs == null) ? SRS_GOOGLEMAPS : this.srs;
		stUrl += "?Provincia=" + this.provincia + "&Municipio=" + this.municipio + "&SRS=" + srs + "&RC=" + this.referencia_catastral;
		System.out.println(stUrl);
		UrlReader urlReader = new UrlReader(stUrl);

		String resultContent = urlReader.getContent();
		String txtResult = "";
		
		Inmueble inmueble = new Inmueble();

		try {
			// https://www.tutorialspoint.com/java_xml/java_dom_parse_document.htm
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(new InputSource(new ByteArrayInputStream(resultContent.getBytes("utf-8"))));
			doc.getDocumentElement().normalize();
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("coordenadas");//pcd");
			System.out.println("----------------------------");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				System.out.println("\nCurrent Element :" + nNode.getNodeName());
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					System.out.println("pc1 : " + eElement.getElementsByTagName("pc1").item(0).getTextContent());
					System.out.println("pc2 : " + eElement.getElementsByTagName("pc2").item(0).getTextContent());
					System.out.println("xcen : " + eElement.getElementsByTagName("xcen").item(0).getTextContent());
					System.out.println("ycen : " + eElement.getElementsByTagName("ycen").item(0).getTextContent());
					System.out.println("ldt : " + eElement.getElementsByTagName("ldt").item(0).getTextContent());
					
					txtResult += "pc1 : " + eElement.getElementsByTagName("pc1").item(0).getTextContent() + "\n";
					txtResult += "pc2 : " + eElement.getElementsByTagName("pc2").item(0).getTextContent() + "\n";
					txtResult += "xcen : " + eElement.getElementsByTagName("xcen").item(0).getTextContent() + "\n";
					txtResult += "ycen : " + eElement.getElementsByTagName("ycen").item(0).getTextContent() + "\n";
					txtResult += "ldt : " + eElement.getElementsByTagName("ldt").item(0).getTextContent() + "\n";
					
					inmueble.setpc1(eElement.getElementsByTagName("pc1").item(0).getTextContent());
					inmueble.setpc2(eElement.getElementsByTagName("pc2").item(0).getTextContent());
					inmueble.setxcen(eElement.getElementsByTagName("xcen").item(0).getTextContent());
					inmueble.setycen(eElement.getElementsByTagName("ycen").item(0).getTextContent());
					inmueble.setldt(eElement.getElementsByTagName("ldt").item(0).getTextContent());
					
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("------------------------------------------------------------------------");
		System.out.println(inmueble.toString());
		System.out.println("------------------------------------------------------------------------");
		//return txtResult;
		return inmueble;
	}



}
