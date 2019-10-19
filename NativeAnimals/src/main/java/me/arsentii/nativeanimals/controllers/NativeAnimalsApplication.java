/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package me.arsentii.nativeanimals.controllers;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import me.arsentii.nativeanimals.common.entities.Animal;
import me.arsentii.nativeanimals.mbeans.AnimalManagedBean;

/**
 *
 * @author zakhar
 */
@Named(value = "animalApplication")
@ApplicationScoped
public class NativeAnimalsApplication {
    
    @Inject
    private AnimalManagedBean animalManagedBean;

    private List<Animal> animals;

    public NativeAnimalsApplication() {
        
    }

    public void setAnimalManagedBean(AnimalManagedBean animalManagedBean) {
        this.animalManagedBean = animalManagedBean;
    }
    
    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }
    
    @PostConstruct
    public void initiateAnimalList(){
        animals = new ArrayList<>();
        this.animals = getAllAnimals();
    }
    
    public List<Animal> getAllAnimals(){
        return animalManagedBean.getAllAnimals();
    }
}
