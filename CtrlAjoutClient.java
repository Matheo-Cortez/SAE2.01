package SAE201;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;

public class CtrlAjoutClient {
	@FXML private TextField txtVille;
    @FXML private Label lblTitre;
    @FXML private TextField txtPrenom;
    @FXML private TextField txtMail;
    @FXML private TextField txtTel;
    @FXML private CheckBox abonne;
    @FXML private Button bnValider;
    @FXML private TextField txtAdresse2;
    @FXML private Button bnAnnuler;
    @FXML private TextField txtAdresse;
    @FXML private TextField txtNom;
    
    @FXML void clicAnnuler(ActionEvent event) {
    	Main.fermerAjoutClient();
    }
    
    @FXML void clicAbo(ActionEvent event) {
    	
    }

    @FXML void clicValider(ActionEvent event) {
    	Main.validerNouveauClient( 
    			txtPrenom.getText(),
				txtNom.getText(),
				txtAdresse.getText(),
				txtMail.getText(),
				txtTel.getText(),
				txtVille.getText()
			);
    }
    
    private boolean telValide(String tel) {
    	return tel.matches("^(\\\\+33|0|0033)[0-9]{9}$");
    }
    
    @FXML void verifieTel(ActionEvent event) {
    	if(!telValide(txtTel.getText()) ) {
    		txtTel.setText("Format incorrect");
    		txtTel.setStyle("-fx-text-fill: red;");
    	}
    }
    
    public void effacer() {
    	txtPrenom.clear();
    	txtNom.clear();
    	txtAdresse.clear();
    	txtMail.clear();
    	txtTel.clear();
    	txtVille.clear();
    }
    
    
    
    public void initialize() {
    	BooleanBinding manque = Bindings.or(Bindings.or(txtPrenom.textProperty().isEmpty(), txtNom.textProperty().isEmpty()),Bindings.or(txtAdresse.textProperty().isEmpty(), txtMail.textProperty().isEmpty())) ;
    	bnValider.disableProperty().bind(Bindings.when(manque).then(true).otherwise(false));
    	txtTel.setTooltip(new Tooltip("10 chiffres"));
    }

}
