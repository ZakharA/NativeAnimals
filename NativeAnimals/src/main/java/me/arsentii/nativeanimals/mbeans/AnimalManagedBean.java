/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.arsentii.nativeanimals.mbeans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import me.arsentii.nativeanimals.common.entities.Animal;
import me.arsentii.nativeanimals.common.entities.User;
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
    private Animal animal = new Animal();
    private long animalId;

    @ManagedProperty(value = "#{userManagedBean}")
    private UserManagedBean userBean;

    public UserManagedBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserManagedBean userBean) {
        this.userBean = userBean;
    }

    public List<Animal> getAllAnimals() {
        List<Animal> an =  animalRepository.getAllAnimals();
        return an;
    }

    public List<Animal> findByCommonName(String commonName) {
        return animalRepository.findByCommonName(commonName);
    }

    public AnimalRepository getAnimalRepository() {
        return animalRepository;
    }

    public void setAnimalRepository(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public Animal getAnimal() {
        return animal;
    }

    public String modifyAnimal(String username) {
        Animal temp = animalRepository.findById(animalId);
        animal.setId(animalId);
        animal.setContributor(temp.getContributor());
        animalRepository.modifyAnimal(animal);
        return "/protectedArea/myAnimals.xhtml";
    }

    public void deleteAnimal(Animal animalId) {
        animalRepository.removeAnimal(animalId.getId());
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

    public String addAnimalToUserList(String username) {
        this.animal.setCreationDate(new Date());
        userBean.addAnimal(username, this.animal);
        return "/protectedArea/myAnimals.xhtml";
    }

    public List<Animal> getAnimalCreatedBy(String username) {
        User user = userBean.getUserByName(username);
        return user.getCreatedEntries();
    }
    
    public List<Animal> searchByNameInCreatedBy(String username, String animalName){
        return animalRepository.searchByNameInCreatedBy(username, animalName);
    }

    public AnimalManagedBean() {
    }
}
