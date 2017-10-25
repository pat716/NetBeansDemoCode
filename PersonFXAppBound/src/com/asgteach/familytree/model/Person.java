/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asgteach.familytree.model;

import java.io.Serializable;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author E0191MD
 */
public class Person implements Serializable{
    public enum Gender {
        MALE, FEMALE, UNKNOWN
    }
    private final long id;
    private final StringProperty firstname = new SimpleStringProperty(this, "firstname", "");
    private final StringProperty middlename = new SimpleStringProperty(this, "middlename", "");
    private final StringProperty lastname = new SimpleStringProperty(this, "lastname", "");
    private final StringProperty suffix = new SimpleStringProperty(this, "suffix", "");
    
    private final ObjectProperty<
}
