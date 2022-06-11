package services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import javax.ws.rs.core.Response;

import entities.Trip;
import entities.User;



@Stateless
@LocalBean
public class UserService {
   
     @PersistenceContext(unitName="gotobus")
     private EntityManager em;
     
//     @Resource
//     private UserTransaction ut;
     
     @EJB
     User u;
     
     Response.ResponseBuilder builder = null;

     public void createUser(User user) {
              em.persist(user);
              System.out.println("User registered successfully");
     }
     
     public List<User> getAllUsers(){
         TypedQuery<User> query = em.createQuery("SELECT u FROM User u",User.class);
//         List<User> users = query.getResultList();
         System.out.println("get all users");
         return query.getResultList();
         
     }
     
     
     
//     public void login(String username, String password) {
//         for (int i = 0; i< getAllUsers().size(); i++) {
//             u = getAllUsers().get(i);
//             if(u.getUsername().equals(username) && u.getPassword().equals(password) ) {
//                 System.out.println("User logged in successfully");
//                 u.isLoggedIn=true;
//             }
//             else {
//                 System.out.println("Incorrect username or password");
//                 u.isLoggedIn=false;
//             }
//         
//         }
//     }


     
     public boolean login(String username, String password) {
         TypedQuery<User> query = em.createQuery("Select u from User u Where u.username=:abc",User.class);
         query.setParameter("abc",username);
         User u1 = query.getSingleResult();
         if(u1.getUsername().equals(username)) {
             if (u1.getPassword().equals(password)) {
             System.out.println("User logged in successfully");
             u1.isLoggedIn=true;
             return true;
         }
         else {
             System.out.println("Incorrect username or password");
             u.isLoggedIn=false;
             return false;
         }
             
         }
         return false;
         }
     
         public Set<Trip> viewTrips(int id){
         User u1 = em.find(User.class, id);
         return u1.getTrips();
         }
     

}