/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package me.arsentii.nativeanimals.mbeans;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import me.arsentii.nativeanimals.common.entities.Animal;
import me.arsentii.nativeanimals.common.repository.AnimalRepository;

/**
 *
 * @author zakhar
 */
@ManagedBean(name = "animalManagedBean")
@SessionScoped
public class AnimalManagedBean implements Serializable {
    
    @EJB
    AnimalRepository animalRepository;

    public AnimalManagedBean() {
    }
    
    public List<Animal> getAllAnimals(){
        try {
            return animalRepository.getAllAnimals();
        } catch (Exception e) {
            
        }
        return null;
    }
    
    public List<Animal> findByCommonName(String commonName) {
        return animalRepository.findByCommonName(commonName);
    }
}
