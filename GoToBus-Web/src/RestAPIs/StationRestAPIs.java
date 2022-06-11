package RestAPIs;

import java.util.HashMap;
import java.util.Map;

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

import entities.Station;
import services.StationService;


@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/station")

public class StationRestAPIs {
    @EJB
    StationService station;
   
     @POST
     public Response createStation(Station s) throws IllegalStateException, SecurityException, SystemException {
         Response.ResponseBuilder builder = null;
         try {
                 station.createStation(s);
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
     @Path("/{id}")
     public Response findByID(@PathParam("id") int id) {
         Response.ResponseBuilder builder = null;
     try {
             //station.findByID(id);
             builder = Response.ok(station.findByID(id));
         }
     catch(Exception e) {
         Map<String, String> responseObj= new HashMap<String,String>();
         responseObj.put("error", e.getMessage());
         builder = Response.status(Response.Status.NOT_FOUND).entity(responseObj);
     }
     return builder.build();
}

}
