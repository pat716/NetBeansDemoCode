/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myrectanglefxapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 *
 * @author E0191MD
 */
public class MyRectangleFXController implements Initializable {
    private RotateTransition rt;
    
    @FXML
    private Label label;
    
    @FXML
    private Rectangle rectangle;
    
    @FXML
    private StackPane stackpane;
    
    @FXML
    private void handleMouseClick(MouseEvent evt){
        rt.play();
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        rectangle.setStrokeWidth(5.0);
        rectangle.setStroke(Color.GOLDENROD);
        
        rt = new RotateTransition(Duration.millis(3000), stackpane);
        rt.setToAngle(180);
        rt.setFromAngle(0);
        rt.setAutoReverse(true);
        rt.setCycleCount(4);
    }    
    
}
