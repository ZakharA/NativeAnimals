package me.arsentii.nativeanimals.mbeans;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import me.arsentii.nativeanimals.common.entities.User;
import me.arsentii.nativeanimals.common.repository.UserRepository;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zakhar
 */
@ManagedBean(name = "userManagedBean")
@RequestScoped
public class UserManagedBean {
    
    @EJB
    UserRepository userRepository;
    
    public void addNewUser(User user){
        userRepository.addNewUser(user);
    }
}
