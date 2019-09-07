/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fit5042.tutex.calculator;

import fit5042.tutex.repository.entities.Property;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author zakhar
 */
@Stateful
public class ComparePropertySessionBean implements ComparePropertySessionBeanRemote {
    
    @PersistenceContext(unitName = "W6ExeStudent-ejbPU")
    private EntityManager em;
    
    private List<Integer> roomsToCompare;

    public ComparePropertySessionBean() {
        roomsToCompare = new ArrayList<>();
    }
    
    @Override
    public void addProperty(int propertyId) {
        if(!roomsToCompare.contains(propertyId))
            roomsToCompare.add(propertyId);
    }

    @Override
    public void removeProperty(int propertyId) {
        if(roomsToCompare.contains(propertyId))
            roomsToCompare.remove(propertyId);
    }

    @Override
    public String getBestPerRoom() {
       int maxNumberOfRooms = 0;
       String bestPropertyId = "";
        for (Integer propertyId : roomsToCompare) {
            Property pr = em.find(Property.class, propertyId);
            if (pr.getNumberOfBedrooms() > maxNumberOfRooms)
                bestPropertyId = String.valueOf(propertyId);
        }
        return bestPropertyId;
    }
    
}
