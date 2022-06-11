package RestAPIs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.transaction.SystemException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import entities.Trip;
import entities.User;
import entities.UserXTrip;
import services.TripService;
import services.UserService;


@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/trip")
public class TripRestAPIs {
   
    @EJB
    TripService trip;
   
    @POST
     public Response createTrip(Trip t) throws IllegalStateException, SecurityException, SystemException {
         Response.ResponseBuilder builder = null;
         try {
                 trip.createTrip(t);
                 builder = Response.ok();
         }
         catch(Exception e) {
             Map<String, String> responseObj= new HashMap<String,String>();
                responseObj.put("error", e.getMessage());
                builder = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(responseObj);
         }
         return builder.build();
     }

   
     @GET
     @Path("/all")
     public List<Trip> getAllTrips() {
         Response.ResponseBuilder builder = null;
         try {
                 return trip.getAllTrips();
         }
         catch(Exception e) {
             Map<String, String> responseObj= new HashMap<String,String>();
                responseObj.put("error", e.getMessage());
                builder = Response.status(Response.Status.BAD_REQUEST).entity(responseObj);
         }
         return trip.getAllTrips();
     }
     
     
     @POST
     @Path("/booktrip")
     public Response bookTrip(UserXTrip x) {
         Response.ResponseBuilder builder = null;
         try {
                 trip.bookTrip(x);
                 builder = Response.ok();
         }
         catch(Exception e) {
             Map<String, String> responseObj= new HashMap<String,String>();
                responseObj.put("error", e.getMessage());
                builder = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(responseObj);
         }
         return builder.build();
     }
     
     
     
     
     
}
