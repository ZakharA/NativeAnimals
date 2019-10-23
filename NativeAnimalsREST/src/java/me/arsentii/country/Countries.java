/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package me.arsentii.country;

import java.util.List;

/**
 *
 * @author zakhar
 */
public class Countries {

    private List<String> countries;
    
    public Countries() {
    }

    public Countries(List<String> countries) {
        this.countries = countries;
    }
    
    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }
    
    
    
    
}
