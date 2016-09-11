/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostUpdate;
import javax.persistence.Version;

/**
 *
 * @author Blue
 */
@Entity
public class Car{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String make;
    private int year;
    @Version
    private int verison;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Car() {
    }

    public Car(String make, int year) {
        this.make = make;
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
    @PostUpdate
    public void printUpdate(){
        System.out.println("The car(id: "+this.id+") get Update");
    }
    
    public void addOneYear(){
        year+=1;
    }
    

   
    
}
