package com.jamaro.catastro.utils;

public class UrlConstructor {
	static final boolean DEBUG = false;
	
	static final String URL_CATASTRO = "https://www1.sedecatastro.gob.es/";
	static final String URL_MAP = URL_CATASTRO + "Cartografia/mapa.aspx?refcat=";
	static final String URL_CALLEJERO = "http://ovc.catastro.meh.es/ovcservweb/OVCSWLocalizacionRC/OVCCallejero.asmx";
	static final String URL_COORDENADAS = "http://ovc.catastro.meh.es/ovcservweb/OVCSWLocalizacionRC/OVCCoordenadas.asmx";
	
	
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
	
	public String DNPPP() {
		String url = URL_CALLEJERO + "/Consulta_DNPPP";
		sop(url);
		return url;
	}
	
	public String DNPRC() {
		String url = URL_CALLEJERO + "/Consulta_DNPRC";
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
	
	public String RCCOOR_Distancia() {
		String url = URL_COORDENADAS + "/Consulta_RCCOOR_Distancia";
		sop(url);
		return url;
	}
	
	public String RCCOOR() {
		String url = URL_COORDENADAS + "/Consulta_RCCOOR";
		sop(url);
		return url;
	}	
	public String CPMRC() {
		String url = URL_COORDENADAS + "/Consulta_CPMRC";
		sop(url);
		return url;
	}
	
	
	
	
	public static int getLineNumber() {
	    return Thread.currentThread().getStackTrace()[2].getLineNumber();
	}
	
	private void sop(String st){
		if (DEBUG) {
			System.out.println(st);
		}
	}

}
