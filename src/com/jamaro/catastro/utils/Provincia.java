package com.jamaro.catastro.utils;

public class Provincia {
	
	private String codigo_ine_provincia;
	private String nombre_provincia;
	
	public String getCodigo_ine_provincia() {
		return codigo_ine_provincia;
	}
	public void setCodigo_ine_provincia(String codigo_ine_provincia) {
		this.codigo_ine_provincia = codigo_ine_provincia;
	}
	public String getNombre_provincia() {
		return nombre_provincia;
	}
	public void setNombre_provincia(String nombre_provincia) {
		this.nombre_provincia = nombre_provincia;
	}
	
	public String toString() {
		return "CPINE: " + this.codigo_ine_provincia + " NP: " + this.nombre_provincia;
	}

}
