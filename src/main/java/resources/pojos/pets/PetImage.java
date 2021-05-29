package resources.pojos.pets;

public class PetImage {

    private Integer pet_id;
    private String image_file;
    private String description;

    /**
     * @param pet_id      the pet id
     * @param imageFile   the base64 Image string file
     * @param description the image description
     */
    public PetImage(Integer pet_id, String imageFile, String description) {
        this.pet_id = pet_id;
        this.image_file = imageFile;
        this.description = description;
    }

    public PetImage() {
    }

    /**
     * @return the image file string on base64 format
     */
    public String getImage_file() {
        return image_file;
    }

    /**
     * @param image_file a new image file string on base64 format
     */
    public void setImage_file(String image_file) {
        this.image_file = image_file;
    }

    /**
     * @return the description of the image
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description a new description for the image
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the pet id
     */
    public Integer getPet_id() {
        return pet_id;
    }

    /**
     * @param pet_id a new Pet id
     */
    public void setPet_id(Integer pet_id) {
        this.pet_id = pet_id;
    }
}
