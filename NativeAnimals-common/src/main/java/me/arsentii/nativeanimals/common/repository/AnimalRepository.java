/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package me.arsentii.nativeanimals.common.repository;

import java.util.List;
import javax.ejb.Remote;
import me.arsentii.nativeanimals.common.entities.Animal;

/**
 *
 * @author zakhar
 */
@Remote
public interface AnimalRepository {

    /** add a new animal into the repository
     *
     * @param animal
     */
    public void addNewAnimal(Animal animal);

    /** remove animal from the repository by animal id
     *
     * @param animalId
     */
    public void removeAnimal(long animalId);

    /** merge update animal instance with persisted one in database
     *
     * @param animal
     */
    public void modifyAnimal(Animal animal);
    
     /** find a animal by id
     *
     * @param id
     * @return animal object
     */
    public Animal findById(long id);
    
    /** select all animals from the repository
     *
     * @return a list of all animals 
     */
    public List<Animal> getAllAnimals();
    
    /** find animals by their common name
     *
     * @param commonName animal common name
     * @return list of animals
     */
    public List<Animal> findByCommonName(String commonName);
}
