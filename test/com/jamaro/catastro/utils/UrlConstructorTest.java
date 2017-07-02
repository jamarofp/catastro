package com.jamaro.catastro.utils;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UrlConstructorTest {

	@Before
	public void setUp() throws Exception {
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
		UrlConstructor url = new UrlConstructor();
		String urlProvincias = url.provincias();
		assertEquals(urlProvincias,"http://ovc.catastro.meh.es/ovcservweb/OVCSWLocalizacionRC/OVCCallejero.asmx/ConsultaProvincia");
	}
	
	@Test
	public void testUrlMunicipios(){
		UrlConstructor url = new UrlConstructor();
		String urlMunicipios = url.municipios();
		
		assertEquals(urlMunicipios,"http://ovc.catastro.meh.es/ovcservweb/OVCSWLocalizacionRC/OVCCallejero.asmx/ConsultaMunicipio");
	}
	
	@Test
	public void testUrlDNPLOC() {
		UrlConstructor url = new UrlConstructor();
		String urlDNPLOC = url.DNPLOC();
		
		assertEquals(urlDNPLOC,"http://ovc.catastro.meh.es/ovcservweb/OVCSWLocalizacionRC/OVCCallejero.asmx/Consulta_DNPLOC");
	}

}
