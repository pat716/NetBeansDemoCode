/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxpersonproperties;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author E0191MD
 */
public class Person {
    private final StringProperty firstname = new SimpleStringProperty(this, "firstname", "");
    
    public String getFirstname(){
        return firstname.get();
    }
    
    public void setFirstname(String firstname){
        this.firstname.set(firstname);
    }
    
    public final StringProperty firstnameProperty(){
        return firstname;
    }
    
    
}
