package services;

import javax.annotation.Resource;

import javax.ejb.EJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import entities.Station;



@Stateless

public class StationService {
     @PersistenceContext(unitName="gotobus")
     private EntityManager em;
     

     
     @EJB
     Station s;
     
     public void createStation(Station station) throws IllegalStateException, SecurityException, SystemException {
             
              em.persist(station);
              System.out.println("Station created successfully");
             
     }
     
     public Station findByID(int id) {
         s = em.find(Station.class, id);
         return s;
         
     }

}
