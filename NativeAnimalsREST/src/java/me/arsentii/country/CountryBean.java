/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package me.arsentii.country;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author zakhar
 */

@Stateless
public class CountryBean {

    private String Country;

    @PersistenceContext(unitName = "NativeAnimalsRESTPU")
    private EntityManager em;
    
    public CountryBean() {
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }

    public Countries getCountry(String countryLetter) {
        List<String> result = em.createQuery("SELECT c.NAME FROM Country c WHERE LOWER(c.NAME) like Lower( :searchKeyword ) GROUP BY c.NAME ")
                .setParameter("searchKeyword", "%"+ countryLetter + "%")
                .setMaxResults(10)
                .getResultList();
        return new Countries(result);
    }
    
    
       
}
