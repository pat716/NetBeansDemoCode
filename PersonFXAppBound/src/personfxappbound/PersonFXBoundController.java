/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personfxappbound;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import com.asgteach.familytree.model.Person;

/**
 *
 * @author E0191MD
 */
public class PersonFXBoundController implements Initializable {
    @FXML
    private Label margeLabel;
    
    final Person marge = new Person("Marge", "Simpson", Person.Gender.FEMALE);
    
    @FXML
    private void changeButtonAction(ActionEvent event){
        marge.setMiddlename("Louise");
    }
    
    @FXML
    private void resetButtonAction(ActionEvent event){
        marge.setMiddlename("");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        margeLabel.textProperty().bind(marge.fullnameProperty());
    }    
    
}
