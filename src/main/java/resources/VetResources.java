package resources;

import resources.pojos.Vet;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/vets/{id}")
public class VetResources {
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response modify(@PathParam("id") String username, Vet vet) {

        return Response.ok()
                .entity(vet)
                .build();
    }

}