/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package me.arsentii.country;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author zakhar
 */
@Entity
@Table(name = "COUNTRIES")
public class Country implements Serializable {
    
    @Id
    private int ID;

    private String NAME;

    public Country(int ID, String NAME) {
        this.ID = ID;
        this.NAME = NAME;
    }

    public Country() {
    }

    /**
     * Get the value of NAME
     *
     * @return the value of NAME
     */
    public String getNAME() {
        return NAME;
    }

    /**
     * Set the value of NAME
     *
     * @param NAME new value of NAME
     */
    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    /**
     * Get the value of ID
     *
     * @return the value of ID
     */
    public int getID() {
        return ID;
    }

    /**
     * Set the value of ID
     *
     * @param ID new value of ID
     */
    public void setID(int ID) {
        this.ID = ID;
    }

}
