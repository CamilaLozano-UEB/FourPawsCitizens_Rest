package resources;

import resources.pojos.Owner;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/owners")
public class OwnersResource {

    @Path("{username}")
        @PUT
        @Produces(MediaType.APPLICATION_JSON)
        public Response modify(@PathParam("username") String username, Owner owner) {

            return Response.ok()
                    .entity(owner)
                    .build();
        }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {

        List<Owner> owners = new ArrayList<Owner>();
        owners.add(new Owner("SilenceCam", 102, "Camila", "Calle 115", "Usaquén"));
        owners.add(new Owner("Nipemo", 201, "Nicolas", "Calle 153", "Usaquén"));

        return Response.ok()
                .entity(owners)
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{username}")
    public Response create(@PathParam("username") String username, Owner owner) {

        owner.setUsername(username);

        return Response.status(Response.Status.CREATED)
                .entity(owner)
                .build();
    }
}