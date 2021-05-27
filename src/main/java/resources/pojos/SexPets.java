package resources.pojos;

public class SexPets {
    private String type;
    private Integer totalPets;

    /**
     *
     * @param type pet's sex type
     * @param totalPets amount of type entered
     */
    public SexPets(String type, Integer totalPets) {
        this.type = type;
        this.totalPets = totalPets;
    }

    public SexPets() {
    }

    /**
     *
     * @return pet's sex type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type pet's sex type
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
