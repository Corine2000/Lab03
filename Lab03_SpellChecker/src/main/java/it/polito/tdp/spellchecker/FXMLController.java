package it.polito.tdp.spellchecker;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.Dictionary;
import it.polito.tdp.spellchecker.model.RichWord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class FXMLController {
	
     private Dictionary model;
     
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> ComboBox;

    @FXML
    private TextArea txtAreaRisultati;

    @FXML
    private Button btnSpellCheck;

    @FXML
    private TextArea txtAreaParoleErrate;

    @FXML
    private Label LabelNumErrori;

    @FXML
    private Button btnClear;

    @FXML
    private Label LabelTempo;
    

    @FXML
    void doSpellCheck(ActionEvent event) { // metodo associato al bottone spell check
    	//devo scaricare il dizionario in base alla lingua scelta
    	
        	model.loadDictionary(ComboBox.getValue());   

    	
         // verifica dati di input
    	if(txtAreaRisultati.getText().isEmpty()) {
    		txtAreaParoleErrate.setText("Devi inserire almeno una parola ");
    		return ;
    	}
    	
    	String testoInput = txtAreaRisultati.getText().toLowerCase().replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_`~()\\[\\]\"]", "");
        String parole[] = testoInput.split(" ");
        List<String> listaParole = new ArrayList<String>();
        
        for(int i=0; i<parole.length; i++) {
        	listaParole.add(parole[i]);
        }
        
       List<RichWord> richword = model.spellCheckText(listaParole);
       txtAreaParoleErrate.setText(model.toString());
    }

    @FXML
    void doClearText(ActionEvent event) {
    }


    @FXML
    void initialize() {
        assert ComboBox != null : "fx:id=\"ComboBox\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAreaRisultati != null : "fx:id=\"txtAreaRisultati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnSpellCheck != null : "fx:id=\"btnSpellCheck\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAreaParoleErrate != null : "fx:id=\"txtAreaParoleErrate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert LabelNumErrori != null : "fx:id=\"LabelNumErrori\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Scene.fxml'.";
        assert LabelTempo != null : "fx:id=\"LabelTempo\" was not injected: check your FXML file 'Scene.fxml'.";

    }

	public void setModel(Dictionary model) {
		
		this.model = model;
		ComboBox.getItems().addAll("English", "Italian");
		
	}
}
