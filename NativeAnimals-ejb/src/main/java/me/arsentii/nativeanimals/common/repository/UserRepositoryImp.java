/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.arsentii.nativeanimals.common.repository;

import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import me.arsentii.nativeanimals.common.entities.Animal;
import me.arsentii.nativeanimals.common.entities.User;

/**
 *
 * @author zakhar
 */
@Stateless
public class UserRepositoryImp implements UserRepository {

    @PersistenceContext(unitName = "me.arsentii_NativeAnimals-ejb_ejb_1.0-SNAPSHOTPU")
    EntityManager em;

    @Override
    public User getUserByUserName(String name) {
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<User> cq = cb.createQuery(User.class);
            Root<User> user = cq.from(User.class);
            cq.where(cb.equal(user.get("userName"), name));
            cq.select(user);
            TypedQuery<User> q = em.createQuery(cq);
            User result = q.getSingleResult();
            return result;
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void addNewUser(User user) {
        if (!isExistsWithName(user.getUserName())) {
            user.setRegistrationDate(new Date());
            user.hashPassword();
            user.setGroupName("Contributor");
            em.persist(user);
        }
    }

    @Override
    public boolean isExistsWithName(String value) {
        return this.getUserByUserName(value) != null;
    }

    @Override
    public void addAnimal(String username, Animal animal) {
        User user = getUserByUserName(username);
        animal.setCreationDate(new Date());
        animal.setContributor(user);
        user.getCreatedEntries().add(animal);
        em.persist(user);
    }

}
