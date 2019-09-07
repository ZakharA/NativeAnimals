/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package me.arsentii.nativeanimals.common.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author zakhar
 */
@Entity
public class Contributor {
    @Id
    @GeneratedValue
    private long id;
    private String userName;
    private String email;
    private String password;
    private List<Animal> createdAnimals;

    public Contributor() {
    }

    public Contributor(long id, String userName, String email, String password, List<Animal> createdAnimals) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.createdAnimals = createdAnimals;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Animal> getCreatedAnimals() {
        return createdAnimals;
    }

    public void setCreatedAnimals(List<Animal> createdAnimals) {
        this.createdAnimals = createdAnimals;
    }

}
