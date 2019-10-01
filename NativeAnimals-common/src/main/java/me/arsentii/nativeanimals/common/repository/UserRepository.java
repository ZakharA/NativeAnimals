/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package me.arsentii.nativeanimals.common.repository;

import javax.ejb.Remote;
import me.arsentii.nativeanimals.common.entities.Contributor;

/**
 *
 * @author zakhar
 */
@Remote
public interface ContributorRepository {

    /** find user object by username , if it exists, otherwise return null
     *
     * @param name username
     * @return null or user object
     */
    public Contributor getContributorByUserName(String name);
    
    public void addNewContributor(Contributor contributor);
}
