package services;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import java.util.Date;
import java.util.List;
import java.util.Set;
import entities.UserXTrip;
import entities.Notifications;
import entities.Trip;
import entities.User;

@Stateless
@LocalBean
public class TripService {

   
    @PersistenceContext(unitName="gotobus")
    private EntityManager em;

    @EJB
    User u;
    Trip t;
    StationService oo;
    UserService mm;
    

   
    public boolean createTrip(Trip trip) {
    	 TypedQuery<User> query=em.createQuery("Select u from User u where u.isLoggedIn=true and u.role ='admin'",User.class);
    	 List<User> user =query.getResultList();
    	 if(user.isEmpty()) {
    		 return false;
    	 }
    	 else
    	 {
    		 
        em.persist(trip);
        System.out.println("Trip created successfully");
        return true;
    }}
   
    public List<Trip> getAllTrips(){
         TypedQuery<Trip> query = em.createQuery("SELECT t FROM Trip t",Trip.class);
         System.out.println("get all Trips");
         return query.getResultList();
         
     }

    public String bookTrip(UserXTrip x) {
       User  u1 = em.find(User.class, x.getUserId());
        Trip t1 = em.find(Trip.class, x.getTripId());
        Notifications n = new Notifications();
        //Date d=new Date();
        if(u1.isLoggedIn == true) {
            if(t.getAvailable_seats() > 0) {
                
            	//em.persist(x);
                u1.addTrip(t1);
                t1.addUser(u1);
                t1.setAvailable_seats(t.getAvailable_seats()-1);
                n.setMsg("You have booked trip from " + t1.getFrom_station() + "to " + t1.getTo_station() +"successfully");
             //   n.setNotifications_datetime(d);
                n.setUser(u1);
                u1.addNotifications(n);
                em.merge(u1);
                em.persist(n);
                return n.getMsg();
            }
            else {
            n.setMsg("Sorry trip from " + t1.getFrom_station() + "to " + t1.getTo_station() + "has no avialable seats");
           // n.setNotifications_datetime(d);
            u1.addNotifications(n);
            em.persist(n);
            return n.getMsg();
            }
        }
        return "Can't book trip because u are not logged in";
       
    }
   
   

}
