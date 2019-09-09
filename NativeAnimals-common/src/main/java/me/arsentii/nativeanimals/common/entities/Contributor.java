/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package me.arsentii.nativeanimals.common.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author zakhar
 */
@Entity
public class Contributor extends User implements Serializable {
    
    @OneToMany
    private List<Animal> createdAnimals;

    public Contributor() {
        super();
    }

    public Contributor(long id, String userName, String email, String password, List<Animal> createdAnimals) {
        super(id, userName, email, password,  LocalDate.now());
        this.createdAnimals = createdAnimals;
    }

    public List<Animal> getCreatedAnimals() {
        return createdAnimals;
    }

    public void setCreatedAnimals(List<Animal> createdAnimals) {
        this.createdAnimals = createdAnimals;
    }

}
