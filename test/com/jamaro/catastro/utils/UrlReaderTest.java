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
	public void tesOVCCordenadas()  {
		System.out.println("--- PuertaDelSolMadrid ---");
		String coords = "40.416546, -3.703758";
		OVCCoordenadas ovc = new OVCCoordenadas();
		ovc.setCoords(coords);
		String resultRCOOR = ovc.getRCCOOR();
		
		assertEquals(resultRCOOR,"pc1 : 0444101\npc2 : VK4704C\nxcen : -3.703758\nycen : 40.416546\nldt : PZ PUERTA DEL SOL 7 MADRID (MADRID)\n");
		
		System.out.println("--- AytoValencia ---");
		coords = "39.469771, -0.377021";
		ovc.setCoords(coords);		
		resultRCOOR = ovc.getRCCOOR();
		
		assertEquals(resultRCOOR,"pc1 : 5724701\npc2 : YJ2752D\nxcen : -0.377021\nycen : 39.469771\nldt : PZ AYUNTAMIENTO DEL 1 VALENCIA (VALENCIA)\n");

	}
	

}
