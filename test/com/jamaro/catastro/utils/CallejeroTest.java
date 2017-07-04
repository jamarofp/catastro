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
	public void testProvinciaList() {
		
		Provincia prov = new Provincia();
	
		List<Provincia> provinciasList = prov.List();
		
		assertEquals(provinciasList.get(0).getCodigo_ine_provincia(),"15");
		assertEquals(provinciasList.get(0).getNombre_provincia(),"A CORUÑA");
		assertEquals(provinciasList.get(1).getCodigo_ine_provincia(),"03");
		assertEquals(provinciasList.get(1).getNombre_provincia(),"ALACANT");
		assertEquals(provinciasList.get(47).getCodigo_ine_provincia(),"50");
		assertEquals(provinciasList.get(47).getNombre_provincia(),"ZARAGOZA");
		
	}
	
	
	@Test
	public void testMunicipioList_for_VALENCIA() {
		String provincia = "VALENCIA";
		Municipio mun = new Municipio(provincia);
		
		List<Municipio> municipiosList = mun.List();
		
		assertEquals(municipiosList.get(0).getCodigo_municipio(), "1");
		assertEquals(municipiosList.get(0).getNombre_municipio(), "ADEMUZ");
		assertEquals(municipiosList.get(265).getCodigo_municipio(), "263");
		assertEquals(municipiosList.get(265).getNombre_municipio(), "ZARRA");
		
	}
	
	@Test
	public void testMunicipioList_for_VALENCIA_with_ENI_string() {
		String provincia = "VALENCIA";
		String municipio_string_to_search = "ENI";
		Municipio mun = new Municipio(provincia, municipio_string_to_search);
		
		List<Municipio> municipiosList = mun.List();
		
		assertEquals(municipiosList.get(0).getCodigo_municipio(), "55");
		assertEquals(municipiosList.get(0).getNombre_municipio(), "BENIARJO");
		assertEquals(municipiosList.get(15).getCodigo_municipio(), "69");
		assertEquals(municipiosList.get(15).getNombre_municipio(), "BENISSUERA");
		
	}
	
	@Test
	public void testMunicipioList_for_VALENCIA_with_FAR_string() {
		String provincia = "VALENCIA";
		String municipio_string_to_search = "FAR";
		Municipio mun = new Municipio(provincia, municipio_string_to_search);
		
		List<Municipio> municipiosList = mun.List();
		
		assertEquals(municipiosList.get(0).getCodigo_municipio(), "22");
		assertEquals(municipiosList.get(0).getNombre_municipio(), "ALFAFAR");
		assertEquals(municipiosList.get(6).getCodigo_municipio(), "199");
		assertEquals(municipiosList.get(6).getNombre_municipio(), "LA POBLA DE FARNALS");
		
	}
}
