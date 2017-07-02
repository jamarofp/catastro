package com.jamaro.catastro.utils;

public class UrlConstructor {
	static final String URL_CATASTRO = "https://www1.sedecatastro.gob.es/";
	static final String URL_MAP = URL_CATASTRO + "Cartografia/mapa.aspx?refcat=";
	static final String URL_CALLEJERO = "http://ovc.catastro.meh.es/ovcservweb/OVCSWLocalizacionRC/OVCCallejero.asmx";
	
	
	
	public String map(String pc1, String pc2) {
		String url = URL_MAP + pc1 + pc2;
		sop(url);
		return url;
	}

	public String provincias() {
		String url = URL_CALLEJERO + "/ConsultaProvincia";
		sop(url);
		return url;
	}
	
	public String municipios() {
		String url = URL_CALLEJERO + "/ConsultaMunicipio";
		sop(url);
		return url;
	}
	
	public String DNPLOC() {
		String url = URL_CALLEJERO + "/Consulta_DNPLOC";
		sop(url);
		return url;
	}
	
	public String via(){
		String url = URL_CALLEJERO + "/ConsultaVia";
		sop(url);
		return url;
	}
	
	public String numero(){
		String url = URL_CALLEJERO + "/ConsultaNumero";
		sop(url);
		return url;
	}
	
	
	
	
	
	
	private void sop(String st){
		System.out.println(st);
	}

}
