package RestAPIs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.EJB;
import javax.transaction.SystemException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import entities.Trip;
import entities.User;
import services.UserService;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/user")
public class UserRestAPIs {
    @EJB
    UserService user;
   
     @POST
     public Response createUser(User u) throws IllegalStateException, SecurityException, SystemException {
         Response.ResponseBuilder builder = null;
         try {
                 user.createUser(u);
                 builder = Response.ok();
         }
         catch(Exception e) {
             Map<String, String> responseObj= new HashMap<String,String>();
                responseObj.put("error", e.getMessage());
                builder = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(responseObj);
         }
         return builder.build();
     }
     
     @POST
     @Path("/login")
     public Response login(User u1) {
         Response.ResponseBuilder builder = null;
         try {
                 user.login(u1.getUsername(),u1.getPassword());
                 builder = Response.ok();
         }
         catch(Exception e) {
             Map<String, String> responseObj= new HashMap<String,String>();
                responseObj.put("error", e.getMessage());
                builder = Response.status(Response.Status.BAD_REQUEST).entity(responseObj);
         }
         return builder.build();
         
     }
     
     @GET
     @Path("/all")
     public List<User> getAllUsers() {
         Response.ResponseBuilder builder = null;
         try {
                 return user.getAllUsers();
         }
         catch(Exception e) {
             Map<String, String> responseObj= new HashMap<String,String>();
                responseObj.put("error", e.getMessage());
                builder = Response.status(Response.Status.BAD_REQUEST).entity(responseObj);
         }
         return user.getAllUsers();
     }
     
     @GET
     @Path("/viewtrips/{id}")
     public Set<Trip> viewTrips(@PathParam("id") int id) {
             return user.viewTrips(id);
     }
     
}