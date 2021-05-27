package resources;


import resources.pojos.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("owners/{username}/pets")
public class PetResource {
    List<Pet> pets = new ArrayList<Pet>();

    @GET
    @Path("/{microchip}/{name}/{species}/{race}/{size}/{sex}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(@PathParam("username") String username,@PathParam("microchip") Long microchip,@PathParam("name") String name,
                         @PathParam("species") String species, @PathParam("race") String race, @PathParam("size") String size,@PathParam("sex") String sex) {
       List<Pet> pets_filter = new ArrayList<Pet>();
        pets.add(new Pet(1, 0L,"juanito","loro","tucan","grande", "macho",null, "npm"));
        pets.add(new Pet(2, 1L,"mia","perro","labrador","grande", "hembra","1.png", "mclg"));
        pets.add(new Pet(3,2L,"lola","vaca","vaca","grande", "hembra",null, "jvtp"));

        for (Integer i= 0; i< pets.size(); i++){
            if(pets.get(i).getOwner_username().equals(username)&&pets.get(i).getMicrochip().equals(microchip)&&pets.get(i).getName().equals(name)&&pets.get(i).getSpecies().equals( species)&&
                    pets.get(i).getRace().equals(race)&&pets.get(i).getSize().equals(size)&&pets.get(i).getSex().equals(sex)){
                pets_filter.add(pets.get(i));
            }
        }

        return Response.ok()
                .entity(pets_filter)
                .build();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {

        List<SexPets> sexPets = new ArrayList<>();
        List<SizePets> sizePets= new ArrayList<>();
        List<RacePets> racePets = new ArrayList<>();
        List<SpeciesPets> speciesPets = new ArrayList<>();

        sexPets.add(new SexPets("Hembra", 5));
        sexPets.add(new SexPets("Macho", 4));

        sizePets.add(new SizePets("Mediano", 3));
        sizePets.add(new SizePets("Pequeño", 3));
        sizePets.add(new SizePets("Grande", 3));

        racePets.add(new RacePets("Labrador",2));
        racePets.add(new RacePets("Siberiano",1));
        racePets.add(new RacePets("Pug",3));
        racePets.add(new RacePets("Mestizo",2));
        racePets.add(new RacePets("Siamés",1));

        speciesPets.add(new SpeciesPets("Perro", 5));
        speciesPets.add(new SpeciesPets("Gato", 4));

        Pets pets = new Pets(9,6, 3, sexPets, sizePets,racePets, speciesPets);

        return Response.ok()
                .entity(pets)
                .build();
    }
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
    @PUT
    @Path("/{pet_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response modify(@PathParam("pet_id") Integer id, Pet pet) {
        for (Integer i= 0; i< pets.size(); i++){
            if(pets.get(i).getPet_id().equals(id)){
                pets.remove(pets.get(i));
                pets.add(pet);
            }
        }
        return Response.ok()
                .entity(pet)
                .build();
    }

}
