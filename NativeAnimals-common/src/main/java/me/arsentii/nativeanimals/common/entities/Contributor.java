/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package me.arsentii.nativeanimals.common.entities;

import java.io.Serializable;
import java.util.Date;
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
    private List<Animal> createdAnimalArticles;

    public Contributor() {
        super();
    }

    public Contributor(long id, String userName, String email, String password, List<Animal> createdAnimalArticles) {
        super(id, userName, email, password,  new Date());
        this.createdAnimalArticles = createdAnimalArticles;
    }

    public List<Animal> getCreatedAnimals() {
        return createdAnimalArticles;
    }

    public void setCreatedAnimals(List<Animal> createdAnimalArticles) {
        this.createdAnimalArticles = createdAnimalArticles;
    }

}
