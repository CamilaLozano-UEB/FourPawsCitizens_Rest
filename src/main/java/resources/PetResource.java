package resources;


import resources.pojos.pets.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("owners/{username}/pets")
public class PetResource {
    //Pet's list
    List<Pet> pets = new ArrayList<Pet>();

    /**
     * method that obtains a list of pets with their owners filtered by identification, sex, breed, size and species
     *
     * @param username  owner's username
     * @param microchip pet's microchip
     * @param name      pet's name
     * @param species   pet's species
     * @param race      pet's race
     * @param size      pet's size
     * @param sex       pet's sex
     * @return status and entity of the operations
     */
    @GET
    @Path("/{microchip}/{name}/{species}/{race}/{size}/{sex}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(@PathParam("username") String username, @PathParam("microchip") Long microchip, @PathParam("name") String name,
                         @PathParam("species") String species, @PathParam("race") String race, @PathParam("size") String size, @PathParam("sex") String sex) {
        // pet's list
        List<Pet> pets_filter = new ArrayList<Pet>();
        pets.add(new Pet(1, 0L, "juanito", "loro", "tucan", "grande", "macho", null, "npm"));
        pets.add(new Pet(2, 1L, "mia", "perro", "labrador", "grande", "hembra", "1.png", "mclg"));
        pets.add(new Pet(3, 2L, "lola", "vaca", "vaca", "grande", "hembra", null, "jvtp"));

        //a for that goes through the list of pets, compares their attributes and, if they are the same, adds them to the pets_filter arraylist
        for (Integer i = 0; i < pets.size(); i++) {
            if (pets.get(i).getOwner_username().equals(username) && pets.get(i).getMicrochip().equals(microchip) && pets.get(i).getName().equals(name) && pets.get(i).getSpecies().equals(species) &&
                    pets.get(i).getRace().equals(race) && pets.get(i).getSize().equals(size) && pets.get(i).getSex().equals(sex)) {
                pets_filter.add(pets.get(i));
            }
        }

        return Response.ok()
                .entity(pets_filter)
                .build();
    }

    /**
     * method that returns a list with all the pets, discriminated by size, species, race and sex
     *
     * @return status and entity of the operations
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {
        // lists of pet's sex, pet's size, pet's race and pet's species
        List<SexPets> sexPets = new ArrayList<>();
        List<SizePets> sizePets = new ArrayList<>();
        List<RacePets> racePets = new ArrayList<>();
        List<SpeciesPets> speciesPets = new ArrayList<>();

        sexPets.add(new SexPets("Hembra", 5));
        sexPets.add(new SexPets("Macho", 4));

        sizePets.add(new SizePets("Mediano", 3));
        sizePets.add(new SizePets("Pequeño", 3));
        sizePets.add(new SizePets("Grande", 3));

        racePets.add(new RacePets("Labrador", 2));
        racePets.add(new RacePets("Siberiano", 1));
        racePets.add(new RacePets("Pug", 3));
        racePets.add(new RacePets("Mestizo", 2));
        racePets.add(new RacePets("Siamés", 1));

        speciesPets.add(new SpeciesPets("Perro", 5));
        speciesPets.add(new SpeciesPets("Gato", 4));

        Pets pets = new Pets(9, 6, 3, sexPets, sizePets, racePets, speciesPets);

        return Response.ok()
                .entity(pets)
                .build();
    }

    /**
     * Method that creates a pet using his id
     *
     * @param pet pet's pojo
     * @return status and entity of the operations
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Pet pet) {

        pet.setPet_id(7);
        pet.setOwner_username("mclg");
        pets.add(pet);

        return Response.status(Response.Status.CREATED)
                .entity(pet)
                .build();
    }

    /**
     * Method that modifies the vet, using his pet_id as a key
     *
     * @param id  pet's id
     * @param pet pet's pojo
     * @return status and entity of the operations
     */
    @PUT
    @Path("/{pet_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response modify(@PathParam("pet_id") Integer id, Pet pet) {
        // for that goes through the list of pets, when it finds the id it compares it,
        // if they are the same it deletes it from the list and adds it again modified
        for (Integer i = 0; i < pets.size(); i++) {
            if (pets.get(i).getPet_id().equals(id)) {
                pets.remove(pets.get(i));
                pets.add(pet);
            }
        }
        return Response.ok()
                .entity(pet)
                .build();
    }

}
