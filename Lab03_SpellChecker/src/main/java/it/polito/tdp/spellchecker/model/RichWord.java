package it.polito.tdp.spellchecker.model;

public class RichWord {
	
	//questa classe contiene una parola del text di input e verifica la corettezza
	
	private String word ; 
	
	public RichWord (String word) {
		this.word = word;
	}

	public boolean isCorretto(String s) {
		if(this.word.equals(s))
			return true;
		return false;
	}
	
}
