package resources.pojos.pets;

public class SizePets {
    private String type;
    private Integer totalPets;

    public SizePets() {
    }

    /**
     *
     * @param type pet size type
     * @param totalPets amount of type entered
     */
    public SizePets(String type, Integer totalPets) {
        this.type = type;
        this.totalPets = totalPets;
    }

    /**
     *
     * @return pet size type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type pet size type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return amount of type entered
     */
    public Integer getTotalPets() {
        return totalPets;
    }

    /**
     *
     * @param totalPets amount of type entered
     */
    public void setTotalPets(Integer totalPets) {
        this.totalPets = totalPets;
    }
}
