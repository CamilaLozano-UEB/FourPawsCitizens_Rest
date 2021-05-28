package resources;

import resources.pojos.vet.Vet;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/vets")
public class VetsResource {
    /**
     * method that modifies the vet, using his username as a key
     *
     * @param username, vet's username that it´s his key
     * @param vet,      vet's pojo
     * @return status and entity of the operations
     */
    @Path("/vets/{id}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response modify(@PathParam("id") String username, Vet vet) {

        return Response.ok()
                .entity(vet)
                .build();
    }

    /**
     * Method that obtains as a resource the list of vets
     *
     * @return status and entity of the operation
     */
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

    /**
     * Method that creates a vet using a username key
     *
     * @param username, vet's username
     * @param vet       vet's pojo
     * @return status and entity of the operation
     */
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