package resources;

import resources.pojos.owner.Owner;
import resources.pojos.pets.Pet;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/owners/{username}/{name}/{neighborhood}")
public class OwnersListPetsResource {
    /**
     * Method that obtains as a resource the list of owners with their respective pets, adds their pet to each owner and returns it
     *
     * @param username,     owner's username
     * @param name,         owner´s name
     * @param neighborhood, owner's neighborhood
     * @return status and entity of the operation
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(@PathParam("username") String username, @PathParam("name") String name, @PathParam("neighborhood") String neighborhood) {
        // owner's list
        List<Owner> owners = new ArrayList<Owner>();
        owners.add(new Owner("SilenceCam", 102, "Camila", "Calle 115", "Usaquén"));
        owners.add(new Owner("Nipemo", 201, "Nicolas", "Calle 153", "Usaquén"));
        //pet's list
        List<Pet> pets = new ArrayList<Pet>();
        pets.add(new Pet(1, 0L, "juanito", "loro", "tucan", "grande", "masculino", null, "Nipemo"));
        pets.add(new Pet(2, 1L, "mia", "perro", "labrador", "grande", "femenino", null, "SilenceCam"));
        pets.add(new Pet(3, 2L, "matty", "perro", "shitzu", "pequeño", "masculino", null, "SilenceCam"));
        List<Owner> ownersFilter = new ArrayList<Owner>();
        // A for that goes through the list of owners, if the owner is the same, add it to ownersFilter.
        // Then another cycle goes through the list of pets, eats them and adds them to ownersFilter.
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