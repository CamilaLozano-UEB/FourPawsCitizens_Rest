package resources.pojos.pets;

public class RacePets {
    private String type;
    private Integer totalPets;

    public RacePets() {
    }

    /**
     *
     * @param type pet race type
     * @param totalPets amount of type entered
     */
    public RacePets(String type, Integer totalPets) {
        this.type = type;
        this.totalPets = totalPets;
    }

    /**
     *
     * @return pet race type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type pet race type
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
