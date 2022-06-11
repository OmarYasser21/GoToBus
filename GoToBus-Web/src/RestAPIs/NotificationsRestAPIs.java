package RestAPIs;


import java.util.Set;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import entities.Notifications;
import services.NotificationsService;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/notifications")
public class NotificationsRestAPIs {
   
    @EJB
    NotificationsService n;
   
     @GET
     @Path("/{id}")
     public Set<Notifications> notify(@PathParam("id") int id) {
             return n.notify(id);
     }
//     
//     @GET
//     @Path("/{id}")
//     public Response notify(@PathParam("id") int id) {
//         Response.ResponseBuilder builder = null;
//     try {
//             //station.findByID(id);
//             builder = Response.ok(n.notify(id));
//         }
//     catch(Exception e) {
//         Map<String, String> responseObj= new HashMap<String,String>();
//         responseObj.put("error", e.getMessage());
//         builder = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(responseObj);
//     }
//     return builder.build();
//}   

}