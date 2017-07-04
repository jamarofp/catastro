package com.jamaro.catastro.utils;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CallejeroTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testOVCCallejero_List() {
		
		Provincia prov = new Provincia();
	
		List<Provincia> provinciasList = prov.List();
		
		assertEquals(provinciasList.get(0).getCodigo_ine_provincia(),"15");
		assertEquals(provinciasList.get(0).getNombre_provincia(),"A CORUÑA");
		assertEquals(provinciasList.get(1).getCodigo_ine_provincia(),"03");
		assertEquals(provinciasList.get(1).getNombre_provincia(),"ALACANT");
		assertEquals(provinciasList.get(47).getCodigo_ine_provincia(),"50");
		assertEquals(provinciasList.get(47).getNombre_provincia(),"ZARAGOZA");
		
	}

}
