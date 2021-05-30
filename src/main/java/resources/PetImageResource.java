package resources;

import resources.pojos.pets.Pet;
import resources.pojos.pets.PetImage;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/pets/{pet_id}/image")
public class PetImageResource {

    /**
     * Method that creates an Object imagePet, with the image on base64 format, the pet id and a description
     *
     * @param pet_id   the pet id
     * @param petImage a image in base64 format String
     * @return The object created
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createImage(@PathParam("pet_id") Integer pet_id, PetImage petImage) {
        petImage.setPet_id(pet_id);
        Pet pet = new Pet(pet_id, 0L, "juanito", "felino", "maine coon", "grande", "macho", petImage, "npm");

        return Response
                .status(Response.Status.CREATED)
                .entity(petImage)
                .build();
    }

}