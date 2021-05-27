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
        owners.add(new Owner("Jvtp", 216, "Juana", "Cra 80", "Fontibón"));
        owners.add(new Owner("Mcmp", 816, "Ana", "Cra 45", "Teusaquillo"));
        owners.add(new Owner("Ampm", 987, "Maria", "Cra 50", "Teusaquillo"));
        owners.add(new Owner("Jmp", 785, "Judit", "Calle 53", "Teusaquillo"));

        List<String> neighborhood = new ArrayList<String>();
        List<String> result = new ArrayList<String>();
        List<Integer> contNeighborhood = new ArrayList<Integer>();
        for (Integer i = 0; i < owners.size(); i++) {
            if (neighborhood.size() == 0) {
                neighborhood.add(owners.get(i).getNeighborhood());
            }
            boolean validate = true;
            for (Integer j = 0; j < neighborhood.size(); j++) {
                if (owners.get(i).getNeighborhood().equals(neighborhood.get(j))) {
                    validate = false;
                }
            }
            if (validate) {
                neighborhood.add(owners.get(i).getNeighborhood());
            }
        }

        for (Integer j = 0; j < neighborhood.size(); j++) {
            int cont = 0;
            for (Integer i = 0; i < owners.size(); i++) {
                if (owners.get(i).getNeighborhood().equals(neighborhood.get(j))) {
                    cont++;
                }
            }
            contNeighborhood.add(cont);
        }
        result.add("Total de propietarios="+owners.size());
        for (Integer i = 0; i < neighborhood.size(); i++) {
            result.add(neighborhood.get(i)+"="+contNeighborhood.get(i));
        }
        return Response.ok().entity(result).build();
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