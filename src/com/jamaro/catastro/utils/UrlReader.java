package com.jamaro.catastro.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class UrlReader {
	private String url_to_read;
	
	public UrlReader(String url_to_read){
		this.url_to_read = url_to_read;
	}
	
	public String getContent(){
		String inputLine = "";
		String inputText = "";
		
		try {
			URL url = new URL(url_to_read);
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			while ((inputLine = in.readLine()) != null) {
			     inputText = inputText + inputLine;
			     System.out.println(inputLine);
			}
		} catch(Throwable t){
			System.out.println(t.getMessage());
		}
		return inputText;
	}

}
