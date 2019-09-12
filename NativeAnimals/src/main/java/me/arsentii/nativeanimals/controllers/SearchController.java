/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package me.arsentii.nativeanimals.controllers;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import me.arsentii.nativeanimals.common.entities.Animal;
import me.arsentii.nativeanimals.common.repository.AnimalRepository;

/**
 *
 * @author zakhar
 */
@Named
@RequestScoped
public class SearchController {
    @EJB
    private AnimalRepository animalReporsitory;
    private String searchValue;
    @Inject
    NativeAnimalsApplication app;
    private List<Animal> searchResult;

    public void setApp(NativeAnimalsApplication app) {
        this.app = app;
    }
    
    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public List<Animal> getSearchResult() {
        return searchResult;
    }

    public void setSearchResult(List<Animal> searchResult) {
        this.searchResult = searchResult;
    }

    public void searchByName(){
        app.searchByName(this.searchValue); 
    }
}
