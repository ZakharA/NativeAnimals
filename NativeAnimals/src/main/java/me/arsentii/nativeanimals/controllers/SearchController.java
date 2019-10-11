/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package me.arsentii.nativeanimals.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import me.arsentii.nativeanimals.common.entities.Animal;
import me.arsentii.nativeanimals.common.repository.AnimalRepository;

/**
 *
 * @author zakhar
 */
@Named
@RequestScoped
public class SearchController implements Serializable {
    
    @EJB
    private AnimalRepository animalReporsitory;
    private String searchValue = "";
    private List<Animal> animals = new ArrayList<>();
   
    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }
    
    public List<Animal> getSearchResult() {
        return animals;
    }

    public void setSearchResult(List<Animal> searchResult) {
        this.animals = searchResult;
    }

    public void searchByName(){
         List<Animal> result  =  animalReporsitory.findByCommonName(this.searchValue); 
        if (result != null)
            this.animals = result;
    }
    
}
