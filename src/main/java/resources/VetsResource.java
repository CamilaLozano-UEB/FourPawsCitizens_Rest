package resources;

import resources.pojos.Vet;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/vets")
public class VetsResource {

    @Path("/vets/{id}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response modify(@PathParam("id") String username, Vet vet) {

        return Response.ok()
                .entity(vet)
                .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {

        List<Vet> vets = new ArrayList<Vet>();
        vets.add(new Vet("Pepito1", "Pepito Perez", "Calle 44", "Usme"));
        vets.add(new Vet("JoseJose", "Jose Ramirez", "Carrera 7", "Chapinero"));

        return Response.ok()
                .entity(vets)
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{username}")
    public Response create(@PathParam("username") String username, Vet vet) {

        vet.setUsername(username);

        return Response.status(Response.Status.CREATED)
                .entity(vet)
                .build();

    }
}