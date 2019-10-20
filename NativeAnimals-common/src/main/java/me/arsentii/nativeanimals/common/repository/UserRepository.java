/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package me.arsentii.nativeanimals.common.repository;

import javax.ejb.Remote;
import me.arsentii.nativeanimals.common.entities.Animal;
import me.arsentii.nativeanimals.common.entities.User;

/**
 *
 * @author zakhar
 */
@Remote
public interface UserRepository {

    /** find user object by username , if it exists, otherwise return null
     *
     * @param name username
     * @return null or user object
     */
    public User getUserByUserName(String name);
    
    public void addNewUser(User user);

    public boolean isExistsWithName(String value);
    
    public void addAnimal(String username, Animal animal);
}
