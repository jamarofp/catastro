package com.jamaro.catastro.utils;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UrlConstructorTest {
	
	private UrlConstructor url;

	@Before
	public void setUp() throws Exception {
		this.url = new UrlConstructor();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testUrlMap() {
		UrlConstructor url = new UrlConstructor();
		String pc1 = "1911606";
		String pc2 = "YJ2411S";
		String urlmap = url.map(pc1,pc2);
		
		assertEquals(urlmap, "https://www1.sedecatastro.gob.es/Cartografia/mapa.aspx?refcat=1911606YJ2411S");

	}
	
	@Test
	public void testUrlProvincias(){
		String urlProvincias = url.provincias();
		
		assertEquals(urlProvincias,"http://ovc.catastro.meh.es/ovcservweb/OVCSWLocalizacionRC/OVCCallejero.asmx/ConsultaProvincia");
	}
	
	@Test
	public void testUrlMunicipios(){
		String urlMunicipios = url.municipios();
		
		assertEquals(urlMunicipios,"http://ovc.catastro.meh.es/ovcservweb/OVCSWLocalizacionRC/OVCCallejero.asmx/ConsultaMunicipio");
	}
	
	@Test
	public void testUrlDNPPP() {
		String urlDNPPP = url.DNPPP();
		
		assertEquals(urlDNPPP,"http://ovc.catastro.meh.es/ovcservweb/OVCSWLocalizacionRC/OVCCallejero.asmx/Consulta_DNPPP");
	}
	
	@Test
	public void testUrlDNPRC() {
		String urlDNPRC = url.DNPRC();
		
		assertEquals(urlDNPRC, "http://ovc.catastro.meh.es/ovcservweb/OVCSWLocalizacionRC/OVCCallejero.asmx/Consulta_DNPRC");
	}
	@Test
	public void testUrlDNPLOC() {
		String urlDNPLOC = url.DNPLOC();
		
		assertEquals(urlDNPLOC,"http://ovc.catastro.meh.es/ovcservweb/OVCSWLocalizacionRC/OVCCallejero.asmx/Consulta_DNPLOC");
	}
	
	@Test
	public void testUrlVia() {
		String urlVia = url.via();
		
		assertEquals(urlVia, "http://ovc.catastro.meh.es/ovcservweb/OVCSWLocalizacionRC/OVCCallejero.asmx/ConsultaVia");
	}
	
	@Test
	public void testUrlNumero() {
		String urlNumero = url.numero();
		
		assertEquals(urlNumero, "http://ovc.catastro.meh.es/ovcservweb/OVCSWLocalizacionRC/OVCCallejero.asmx/ConsultaNumero");
	}

	@Test
	public void testUrlRCCOOR_Distancia() {
		String urlRCCOOR_Distancia = url.RCCOOR_Distancia();
		
		assertEquals(urlRCCOOR_Distancia,"http://ovc.catastro.meh.es/ovcservweb/OVCSWLocalizacionRC/OVCCoordenadas.asmx/Consulta_RCCOOR_Distancia");
	}
	@Test
	public void testUrlRCCOOR() {
		String urlRCCOOR = url.RCCOOR();
		
		assertEquals(urlRCCOOR,"http://ovc.catastro.meh.es/ovcservweb/OVCSWLocalizacionRC/OVCCoordenadas.asmx/Consulta_RCCOOR");
	}	
	@Test
	public void testUrlCPMRC() {
		String urlCPMRC = url.CPMRC();
		
		assertEquals(urlCPMRC, "http://ovc.catastro.meh.es/ovcservweb/OVCSWLocalizacionRC/OVCCoordenadas.asmx/Consulta_CPMRC");
	}
}
