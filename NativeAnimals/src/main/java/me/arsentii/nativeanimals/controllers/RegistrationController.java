/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package me.arsentii.nativeanimals.controllers;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import me.arsentii.nativeanimals.common.entities.User;
import me.arsentii.nativeanimals.mbeans.UserManagedBean;

/**
 *
 * @author zakhar
 */
@Named
@RequestScoped
public class RegistrationController implements Serializable {
    
    @Inject
    private UserManagedBean userManagedBean;
    
    User newUser = new User();

    public RegistrationController() {
    }
    
    public User getNewUser() {
        return newUser;
    }

    public void setNewUser(User newUser) {
        this.newUser = newUser;
    }
    
    public String register(){
        userManagedBean.addNewUser(newUser);
        return "index.xhmtl";
    }
}
