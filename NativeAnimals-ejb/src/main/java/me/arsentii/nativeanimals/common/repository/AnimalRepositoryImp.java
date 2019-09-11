package me.arsentii.nativeanimals.common.repository;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import me.arsentii.nativeanimals.common.entities.Animal;
/**
 *
 * @author zakhar
 */
@Stateless
public class AnimalRepositoryImp implements AnimalRepository {
    
    @PersistenceContext(unitName = "me.arsentii_NativeAnimals-ejb_ejb_1.0-SNAPSHOTPU")
    EntityManager em;
    
    @Override
    public void addNewAnimal(Animal animal) {
        em.persist(animal);
    }

    @Override
    public void removeAnimal(long animalId) {
        Animal animal = em.find(Animal.class, animalId);
        if(animal != null) 
            em.remove(animal);
    }

    @Override
    public void modifyAnimal(Animal animal) {
        try {
            em.merge(animal);
        } catch(Exception e){
            
        }
    }
    
    @Override
    public List<Animal> getAllAnimals() {
        return em.createNamedQuery(Animal.GET_ALL_QUERY_NAME).getResultList();
    }

    @Override
    public Animal findById(long id) {
        return em.find(Animal.class, id);
    }
    
}
