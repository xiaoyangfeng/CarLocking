/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

/**
 *
 * @author Blue
 */
@Named(value = "indexMB")
@RequestScoped
public class indexMB {

    private int id;
    @PersistenceContext(unitName = "CarLocking-warPU")
    private EntityManager em;
    private Car car = new Car("ford", 2016);
    private long number;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getNumber() {
        return number;
    }

    /**
     * Creates a new instance of indexMB
     */
    public indexMB() {

    }

    @PostConstruct
    private void carNum() {
        Query query = em.createQuery("select count(c) from Car c");
        number = (long) query.getSingleResult();
    }

    @Transactional
    public String createCar() {
        String page = null;
        em.persist(car);
        return page;
    }

    @Transactional
    public String deleteCar() {
        car = em.find(Car.class, id);
        em.remove(car);
        return null;
    }
    
     @Transactional
    public String addOneYear() {
        car = em.find(Car.class, id);
        car.addOneYear();
        return null;
    }
}
