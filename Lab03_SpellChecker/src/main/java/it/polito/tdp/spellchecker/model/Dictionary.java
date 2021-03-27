package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Dictionary {
	
	List<String> dizionarioInglese ;
	List<String> dizionarioItaliano;
	List<String> listaParoleErrate;
	private String  linguaScelta;
	
	public Dictionary() {
		dizionarioInglese = new ArrayList<String>();
		dizionarioItaliano = new  ArrayList<String>();
		listaParoleErrate = new ArrayList<String>();
	}
	
	
	public void loadDictionary(String language) { // con questo metodo devo caricare il dizionario in base alla lingua scelta
		linguaScelta  = language;
		
		if(language.equals("English")) {
			try {
				FileReader fr = new FileReader("scr/main/resources/English.txt");
				BufferedReader br = new BufferedReader(fr);
				String word;
				while ((word = br.readLine()) != null) {
				// Aggiungere parola alla struttura dati
				//	RichWord parola = new RichWord(word);
					dizionarioInglese.add(word);
				}
				br.close();
				} catch (IOException e){
				System.out.println("Errore nella lettura del file");
				}
		}
		else {
			try {
				FileReader fr = new FileReader("scr/main/resources/styles/Italian.txt");
				BufferedReader br = new BufferedReader(fr);
				String word;
				while ((word = br.readLine()) != null) {
				// Aggiungere parola alla struttura dati
				//	RichWord parola = new RichWord(word);
					dizionarioItaliano.add(word);
				}
				br.close();
				} catch (IOException e){
				System.out.println("Errore nella lettura del file");
				}
		   }
		}
	public List<RichWord> spellCheckText(List<String> inputTextList){
		List<RichWord> lista = new ArrayList<RichWord>();
		
		for(String ss: inputTextList) {
			//RichWord newWord = new RichWord(ss);
			
			if(linguaScelta.equals("English") && dizionarioInglese.contains(ss)) {
				RichWord newWord = new RichWord(ss);
				lista.add(newWord);
			} else 
				listaParoleErrate.add(ss);
			
			if(linguaScelta.equals("Italian") && dizionarioItaliano.contains(ss)) {
				RichWord newWord = new RichWord(ss);
				lista.add(newWord);
			} else 
				listaParoleErrate.add(ss);
		}
		return lista;
	  }


	@Override
	public String toString() {
		String ss = "";
	
		for(String s: listaParoleErrate ) {
			ss+= s+"\n";
		}
		return ss;
	}
	
	
	}

