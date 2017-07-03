package com.jamaro.catastro.utils;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.List;

import javax.xml.parsers.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class UrlReaderTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void tesOVCCoordenadas_getRCCOOR()  {
		System.out.println("--- PuertaDelSolMadrid ---");
		String coords = "40.416546, -3.703758";
		OVCCoordenadas ovc = new OVCCoordenadas(coords);
		Inmueble resultRCCOOR = ovc.getRCCOOR();

		assertEquals(resultRCCOOR.getpc1(),"0444101");
		assertEquals(resultRCCOOR.getpc2(),"VK4704C");
		assertEquals(resultRCCOOR.getxcen(),"-3.703758");
		assertEquals(resultRCCOOR.getycen(),"40.416546");
		assertEquals(resultRCCOOR.getldt(),"PZ PUERTA DEL SOL 7 MADRID (MADRID)");
		
		
		System.out.println("--- AytoValencia ---");
		coords = "39.469771, -0.377021";
		ovc.setCoords(coords);		

		resultRCCOOR = ovc.getRCCOOR();
		
		assertEquals(resultRCCOOR.getpc1(),"5724701");
		assertEquals(resultRCCOOR.getpc2(),"YJ2752D");
		assertEquals(resultRCCOOR.getxcen(),"-0.377021");
		assertEquals(resultRCCOOR.getycen(),"39.469771");
		assertEquals(resultRCCOOR.getldt(),"PZ AYUNTAMIENTO DEL 1 VALENCIA (VALENCIA)");
		
		System.out.println("--- Burguer King Ayto Valencia ---");
		coords = "39.470586, -0.375960";
		ovc.setCoords(coords);
		
		resultRCCOOR = ovc.getRCCOOR();
		
		assertEquals(resultRCCOOR.getpc1(),"5825704");
	}
	
	@Test
	public void testOVCCoordenadas_getRCCOOR_Distancia() {
		System.out.println("--- Distancia coordenadas Burguer King Ayto. Valencia ---");
		String coords = "39.470586, -0.375960";
		
		OVCCoordenadas ovc = new OVCCoordenadas(coords);
		List<Inmueble> resultRCCOOR = ovc.getRCCOOR_Distancia();

		assertEquals(resultRCCOOR.size(),3);

		
		assertEquals(resultRCCOOR.get(0).getpc1(),"5825704");
		assertEquals(resultRCCOOR.get(1).getpc1(),"5825703");
		assertEquals(resultRCCOOR.get(2).getpc1(),"5825705");
		
		assertEquals(resultRCCOOR.get(0).getldt(),"PZ AYUNTAMIENTO DEL 19 VALENCIA (VALENCIA)");
		assertEquals(resultRCCOOR.get(1).getldt(),"CL MORATIN 14 VALENCIA (VALENCIA)");
		assertEquals(resultRCCOOR.get(2).getldt(),"PZ AYUNTAMIENTO DEL 18 VALENCIA (VALENCIA)");
		
	}
	
	@Test
	public void testOVCCoordenadas_getCPMRC() {
		System.out.println("--- RC Ayuntamiento ---");
		String rc = "5724701YJ2752D";
		String provincia = "VALENCIA";
		String municipio = "VALENCIA";
		OVCCoordenadas ovc = new OVCCoordenadas(provincia, municipio, rc);
		
		Inmueble resultCPMRC = ovc.getCPMRC();
		
		assertEquals(resultCPMRC.getpc1(),"5724701");
		assertEquals(resultCPMRC.getpc2(),"YJ2752D");
		assertEquals(resultCPMRC.getxcen(),"-0.376977278911663");
		assertEquals(resultCPMRC.getycen(),"39.4697979017582");
		assertEquals(resultCPMRC.getldt(),"PZ AYUNTAMIENTO DEL 1 VALENCIA (VALENCIA)");
	}
	
	

}
