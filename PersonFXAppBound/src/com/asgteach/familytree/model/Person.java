/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asgteach.familytree.model;

import java.io.Serializable;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleObjectProperty;
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
    
    private final ObjectProperty<Gender> gender = 
            new SimpleObjectProperty<>(this, "gender", Gender.UNKNOWN);
    private final StringProperty notes = new SimpleStringProperty(this, "notes", "");
    
    private final StringBinding fullNameBinding = new StringBinding() {
        {
            super.bind(firstname, middlename, lastname, suffix);
        }
        
        @Override
        protected String computeValue() {
            StringBuilder sb = new StringBuilder();
            if(!firstname.get().isEmpty()){
                sb.append(firstname.get());
            }
            if(!middlename.get().isEmpty()){
                sb.append(middlename.get());
            }
            if(!lastname.get().isEmpty()){
                sb.append(lastname.get());
            }
            if(!suffix.get().isEmpty()){
                sb.append(suffix.get());
            }
            return sb.toString();
        }
    };
    
    private final ReadOnlyStringWrapper fullname = new ReadOnlyStringWrapper(this, "fullname");
    private static long count = 0;
    
    public Person(){
        this("", "", Gender.UNKNOWN);
    }
    
    public Person(String first, String last, Gender gender){
        this.firstname.set(first);
        this.lastname.set(last);
        this.gender.set(gender);
        this.id = count++;
    }
    
    public Person(Person person){
        
    }
    
    public final long getId(){
        return id;
    }
    
    public final ReadOnlyStringProperty fullnameProperty(){
        return fullname.getReadOnlyProperty();
    }
    
    public final String getFullname(){
        return fullname.get();
    }
    
    public String getNotes(){
        return notes.get();
    }
    
    public void setNotes(String notes){
        this.notes.set(notes);
    }
    
    public final StringProperty notesProperty(){
        return notes;
    }
    
    public String getFirstname(){
        return firstname.get();
    }
    
    public void setFirstname(String firstname){
        this.firstname.set(firstname);
    }
    
    public final StringProperty firstnameProperty(){
        return firstname;
    }
    
    
    public String getMiddlename(){
        return middlename.get();
    }
    
    public void setMiddlename(String middlename){
        this.middlename.set(middlename);
    }
    
    public final StringProperty middlenameProperty(){
        return middlename;
    }
    
    
    public String getLastname(){
        return lastname.get();
    }
    
    public void setLastname(String lastname){
        this.lastname.set(lastname);
    }
    
    public final StringProperty lastnameProperty(){
        return lastname;
    }
    
    public String getSuffix(){
        return suffix.get();
    }
    
    public void setSuffix(String suffix){
        this.suffix.set(suffix);
    }
    
    public final StringProperty suffixProperty(){
        return suffix;
    }
}


