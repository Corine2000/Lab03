package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Dictionary {
	
	List<RichWord> dizionarioInglese ;
	List<RichWord> dizionarioItaliano;
	
	public Dictionary() {
		dizionarioInglese = new ArrayList<RichWord>();
		dizionarioItaliano = new  ArrayList<RichWord>();
	}
	
	
	public void loadDictionary(String language) { // con questo metodo devo caricare il dizionario in base alla lingua scelta
		
		if(language.equals("English")) {
			try {
				FileReader fr = new FileReader("scr/main/resouces/English.txt");
				BufferedReader br = new BufferedReader(fr);
				String word;
				while ((word = br.readLine()) != null) {
				// Aggiungere parola alla struttura dati
					RichWord parola = new RichWord(word);
					dizionarioInglese.add(parola);
				}
				br.close();
				} catch (IOException e){
				System.out.println("Errore nella lettura del file");
				}
		}
		else {
			try {
				FileReader fr = new FileReader("scr/main/resouces/Italian.txt");
				BufferedReader br = new BufferedReader(fr);
				String word;
				while ((word = br.readLine()) != null) {
				// Aggiungere parola alla struttura dati
					RichWord parola = new RichWord(word);
					dizionarioItaliano.add(parola);
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
			RichWord newWord = new RichWord(ss);
			if(newWord.isCorretto(ss)) {
				lista.add(newWord);
			}
		}
		return lista;
	  }
	}

