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

public class Municipio {

		private String provincia;
		private String municipio; 
	
		private String nombre_municipio;
		private String codigo_provincia;
		private String codigo_municipio;
		
		
		public Municipio(String provincia) {
			this.provincia = provincia;
		}
		public Municipio(String provincia, String municipio) {
			this.provincia = provincia;
			this.municipio = municipio;
		}
		public String getNombre_municipio() {
			return nombre_municipio;
		}

		public void setNombre_municipio(String nombre_municipio) {
			this.nombre_municipio = nombre_municipio;
		}

		public String getCodigo_provincia() {
			return codigo_provincia;
		}

		public void setCodigo_provincia(String codigo_provincia) {
			this.codigo_provincia = codigo_provincia;
		}

		public String getCodigo_municipio() {
			return codigo_municipio;
		}

		public void setCodigo_municipio(String codigo_municipio) {
			this.codigo_municipio = codigo_municipio;
		}

		public List<Municipio> List() {

			UrlConstructor urlConstructor = new UrlConstructor();
			String stUrl = urlConstructor.municipios();
			stUrl += "?Provincia=" + this.provincia + "&Municipio=" + (this.municipio != null ? this.municipio : "");
			System.out.println(stUrl);
			
			UrlReader urlReader = new UrlReader(stUrl);

			String resultContent = urlReader.getContent();
			
			List<Municipio> municipioList = new ArrayList<Municipio>();
			
			try {
				// https://www.tutorialspoint.com/java_xml/java_dom_parse_document.htm
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(new InputSource(new ByteArrayInputStream(resultContent.getBytes("utf-8"))));
				doc.getDocumentElement().normalize();
								
				NodeList nList = doc.getElementsByTagName("muni");
								
				for (int temp = 0; temp < nList.getLength(); temp++) {
					Municipio municipio = new Municipio(this.provincia);
					
					Node nNode = nList.item(temp);
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
						Element eElement = (Element) nNode;
						
						municipio.setCodigo_provincia(eElement.getElementsByTagName("cp").item(0).getTextContent());
						municipio.setCodigo_municipio(eElement.getElementsByTagName("cm").item(0).getTextContent());
						municipio.setNombre_municipio(eElement.getElementsByTagName("nm").item(0).getTextContent());
					
						municipioList.add(municipio);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return municipioList;

		}
}
