package com.jamaro.catastro.utils;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;

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
		Inmueble resultRCOOR = ovc.getRCCOOR();

		assertEquals(resultRCOOR.getpc1(),"0444101");
		assertEquals(resultRCOOR.getpc2(),"VK4704C");
		assertEquals(resultRCOOR.getxcen(),"-3.703758");
		assertEquals(resultRCOOR.getycen(),"40.416546");
		assertEquals(resultRCOOR.getldt(),"PZ PUERTA DEL SOL 7 MADRID (MADRID)");
		
		
		System.out.println("--- AytoValencia ---");
		coords = "39.469771, -0.377021";
		ovc.setCoords(coords);		

		resultRCOOR = ovc.getRCCOOR();
		
		assertEquals(resultRCOOR.getpc1(),"5724701");
		assertEquals(resultRCOOR.getpc2(),"YJ2752D");
		assertEquals(resultRCOOR.getxcen(),"-0.377021");
		assertEquals(resultRCOOR.getycen(),"39.469771");
		assertEquals(resultRCOOR.getldt(),"PZ AYUNTAMIENTO DEL 1 VALENCIA (VALENCIA)");
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
