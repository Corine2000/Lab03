package it.polito.tdp.spellchecker;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.Dictionary;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
    private TextArea txtNumErrori;

    @FXML
    private Button btnClear;

    @FXML
    private TextArea txtTempoImpiegato;

    @FXML
    void doClearText(ActionEvent event) { //metodo associato al bottone spell check
         String paroleInserite = txtAreaRisultati.getText();
    }

    @FXML
    void doSpellCheck(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert ComboBox != null : "fx:id=\"ComboBox\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAreaRisultati != null : "fx:id=\"txtAreaRisultati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnSpellCheck != null : "fx:id=\"btnSpellCheck\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAreaParoleErrate != null : "fx:id=\"txtAreaParoleErrate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNumErrori != null : "fx:id=\"txtNumErrori\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTempoImpiegato != null : "fx:id=\"txtTempoImpiegato\" was not injected: check your FXML file 'Scene.fxml'.";

    }

	public void setModel(Dictionary model) {
		
		this.model = model;
		ComboBox.getItems().addAll("English", "Italian");
		
	}
}
