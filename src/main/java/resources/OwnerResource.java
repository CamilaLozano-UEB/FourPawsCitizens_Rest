package resources;

import resources.pojos.Owner;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/owners/{id}")
public class OwnerResource {

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response modify(@PathParam("id") String username, Owner owner) {

        return Response.ok()
                .entity(owner)
                .build();
    }

}
