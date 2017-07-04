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

public class Via {

	private String provincia;
	private String municipio;
	private String tipoVia;
	private String via;

	private String tipo_via;
	private String nombre_via;

	
	public String getTipo_via() {
		return tipo_via;
	}

	public void setTipo_via(String tipo_via) {
		this.tipo_via = tipo_via;
	}

	public String getNombre_via() {
		return nombre_via;
	}

	public void setNombre_via(String nombre_via) {
		this.nombre_via = nombre_via;
	}

	public Via(String provincia, String municipio, String via) {
		this.provincia = provincia;
		this.municipio = municipio;
		this.via = via;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getTipoVia() {
		return tipoVia;
	}

	public void setTipoVia(String tipoVia) {
		this.tipoVia = tipoVia;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}
	public List<Via> List() {
		UrlConstructor urlConstructor = new UrlConstructor();
		String stUrl = urlConstructor.via();
		stUrl += "?Provincia=" + this.provincia + "&Municipio=" + (this.municipio != null ? this.municipio : "") + "&TipoVia=" + (this.tipoVia != null ? this.tipoVia : "") + "&NombreVia=" + this.via;
		System.out.println(stUrl);
		
		UrlReader urlReader = new UrlReader(stUrl);

		String resultContent = urlReader.getContent();
		
		List<Via> viaList = new ArrayList<Via>();
		
		try {
			// https://www.tutorialspoint.com/java_xml/java_dom_parse_document.htm
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(new InputSource(new ByteArrayInputStream(resultContent.getBytes("utf-8"))));
			doc.getDocumentElement().normalize();
							
			NodeList nList = doc.getElementsByTagName("calle");
							
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Via via = new Via(this.provincia, this.municipio, this.via);
				
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					
					via.setTipo_via(eElement.getElementsByTagName("tv").item(0).getTextContent());
					via.setNombre_via(eElement.getElementsByTagName("nv").item(0).getTextContent());
									
					viaList.add(via);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return viaList;
	}
	
}
