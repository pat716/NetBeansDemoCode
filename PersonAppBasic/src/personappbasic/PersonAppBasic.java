/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personappbasic;

import com.asgteach.familytree.model.Person;
/**
 * @author E0191MD
 */
public class PersonAppBasic {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Person homer = new Person("Homer", "Simpson", Person.Gender.MALE);
       Person marge = new Person("Marge", "Simpson", Person.Gender.FEMALE);
       
       homer.setMiddlename("Chester");
       marge.setMiddlename("Louise");
       homer.setSuffix("Junior");
       
        System.out.println(homer);
        System.out.println(marge);
        
        if(homer.equals(marge)){
            System.out.println(homer + " is equal to " + marge);
        } else {
            System.out.println(homer + " is not equal to " + marge);
        }
    }
    
}
