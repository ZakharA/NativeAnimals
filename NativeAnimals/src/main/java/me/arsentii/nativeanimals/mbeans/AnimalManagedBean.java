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
        return animalRepository.getAllAnimals();
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

    public void modifyAnimal() {
        animal.setId(animalId);
        animalRepository.modifyAnimal(animal);
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

    public void addAnimalToUserList(String username) {
        userBean.addAnimal(username, this.animal);
    }

    public List<Animal> getAnimalCreatedBy(String username) {
        User user = userBean.getUserByName(username);
        return user.getCreatedEntries();
    }

    public AnimalManagedBean() {
    }
}
