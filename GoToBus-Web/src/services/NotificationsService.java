package services;

import java.util.Set;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Notifications;
import entities.Trip;
import entities.User;
//import entities.UserXNotifications;
import entities.UserXTrip;


@Stateless
@LocalBean
public class NotificationsService {
   
     @PersistenceContext(unitName="gotobus")
     private EntityManager em;
     
     TripService ts ;
     UserXTrip x;
   //  UserXNotifications un;
     
     public Set<Notifications> notify(int id) {
         User u = em.find(User.class, id);
         return u.getNs();
         
     }
     

}