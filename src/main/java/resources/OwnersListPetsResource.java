package resources;

import resources.pojos.Owner;
import resources.pojos.Pet;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Path("/owners/{username}/{name}/{neighborhood}")
public class OwnersListPetsResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(@PathParam("username") String username, @PathParam("name") String name, @PathParam("neighborhood") String neighborhood) {

        List<Owner> owners = new ArrayList<Owner>();
        owners.add(new Owner("SilenceCam", 102, "Camila", "Calle 115", "Usaquén"));
        owners.add(new Owner("Nipemo", 201, "Nicolas", "Calle 153", "Usaquén"));
        List<Pet> pets = new ArrayList<Pet>();
        pets.add(new Pet(1, 0L, "juanito", "loro", "tucan", "grande", "masculino", null, "Nipemo"));
        pets.add(new Pet(2, 1L, "mia", "perro", "labrador", "grande", "femenino", "1.png", "SilenceCam"));
        pets.add(new Pet(3, 2L, "matty", "perro", "shitzu", "pequeño", "masculino", "2.png", "SilenceCam"));
        List<Owner> ownersFilter = new ArrayList<Owner>();

        for (Integer i = 0; i < owners.size(); i++) {
            if (owners.get(i).getUsername().equals(username)) {
                ownersFilter.add(owners.get(i));
                for (Integer j = 0; j < pets.size(); j++) {
                    if (pets.get(j).getOwner_username().equals(owners.get(i).getUsername()) && owners.get(i).getUsername().equals(username) && owners.get(i).getName().equals(name) &&
                            owners.get(i).getNeighborhood().equals(neighborhood)) {
                        ownersFilter.get(i).addPets(pets.get(j));
                    }

                }
            }
        }

        return Response.ok()
                .entity(ownersFilter)
                .build();
    }

}