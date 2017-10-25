/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package racetrackfxapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.beans.binding.When;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 *
 * @author E0191MD
 */
public class RaceTrackController implements Initializable {
    final double maxRate = 7.0;
    final double minRate = .3;
    final double rateDelta = .3;
    
    @FXML
    private Rectangle rectangle;
    
    @FXML
    private Path path;
    
    @FXML
    private Text text;
    
    @FXML
    private Button startPauseButton;
    
    @FXML
    private Button slowerButton;
    
    @FXML
    private Button fasterButton;
    private PathTransition pathTransition;
    
    @FXML
    private void startPauseAction(ActionEvent event){
        if(pathTransition.getStatus() == Animation.Status.RUNNING) {
            pathTransition.pause();
        } else {
            pathTransition.play();
        }
    }
    
    @FXML
    private void slowerAction(ActionEvent event){
        double currentRate = pathTransition.getRate();
        if(currentRate <= minRate){
            return;
        }
        pathTransition.setRate(currentRate - rateDelta);
        System.out.printf("slower rate = %2f\n", pathTransition.getRate());
    }
    
    @FXML
    private void fasterAction(ActionEvent event){
        double currentRate = pathTransition.getRate();
        if(currentRate >= maxRate){
            return;
        }
        pathTransition.setRate(currentRate + rateDelta);
        System.out.printf("faster rate = %2f\n", pathTransition.getRate());
    }
       
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pathTransition = new PathTransition(Duration.seconds(6), path, rectangle);
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.setCycleCount(Animation.INDEFINITE);
        pathTransition.setInterpolator(Interpolator.LINEAR);
        
        final IntegerProperty lapCounterProperty = new SimpleIntegerProperty(0);
        pathTransition.currentTimeProperty().addListener(
                (ObservableValue<? extends Duration> ov,
                Duration oldValue, Duration newValue) -> {
                    if(oldValue.greaterThan(newValue)){
                        lapCounterProperty.set(lapCounterProperty.get() + 1);
                    }
                }
        );
        text.textProperty().bind(lapCounterProperty.asString("Lap Counter: %s"));
        
        startPauseButton.textProperty().bind(
            new When(pathTransition.statusProperty().isEqualTo(Animation.Status.RUNNING))
                .then("Pause").otherwise("Start")
        );
        
        fasterButton.disableProperty().bind(pathTransition.statusProperty().isNotEqualTo(Animation.Status.RUNNING));
        slowerButton.disableProperty().bind(pathTransition.statusProperty().isNotEqualTo(Animation.Status.RUNNING));
        fasterButton.setText(" >> ");
        slowerButton.setText(" << ");
    }    
    
}
