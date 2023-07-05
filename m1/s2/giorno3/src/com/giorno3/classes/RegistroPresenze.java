package com.giorno3.classes;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class RegistroPresenze {
	public  List<Presenza> presenze;
	
	public RegistroPresenze() {
		presenze = new ArrayList<>();
	}
	
	public void aggiungiPresenza(String nome, int giorniPresenza) {
		presenze.add(new Presenza(nome, giorniPresenza));
	}
	
	public void salvaPresenzaSuFile(String nomeFile) {
		StringBuilder sb = new StringBuilder();
		for (Presenza presenza : presenze) {
			sb.append(presenza.getNome()).append("@").append(presenza.getGiorniPresenza()).append("#");
		}
		sb.deleteCharAt(sb.length() - 1);
	
	
	try {
		FileUtils.writeStringToFile(new File(nomeFile), sb.toString(), "UTF-8");
	} catch (IOException e) {
		e.printStackTrace();
	}
}
	
	 public void caricaPresenzeDaFile(String nomeFile) {
	        try {
	            String data = FileUtils.readFileToString(new File(nomeFile), "UTF-8");
	            String[] presenzeStr = data.split("#");

	            for (String presenzaStr : presenzeStr) {
	                String[] presenzaData = presenzaStr.split("@");
	                if (presenzaData.length == 2) {
	                    String nome = presenzaData[0];
	                    int giorniPresenza = Integer.parseInt(presenzaData[1]);
	                    presenze.add(new Presenza(nome, giorniPresenza));
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
}
