/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package me.arsentii.nativeanimals.controllers;

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
public class AnimalController {
    
    @EJB
    AnimalRepository animalRepository;
    private Animal animal = new Animal();
    private long animalId;

    public AnimalRepository getAnimalRepository() {
        return animalRepository;
    }

    public void setAnimalRepository(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
    
    public void findAnimalById() {
        this.animal = animalRepository.findById(animalId);
    }

    public long getAnimalId() {
        return animalId;
    }

    public void setAnimalId(long animalId) {
        this.animalId = animalId;
    }
    
}
