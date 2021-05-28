package resources.pojos.pets;

public class SpeciesPets {
    private String type;
    private Integer totalPets;

    public SpeciesPets() {
    }

    /**
     *
     * @param type type of pet species
     * @param totalPets amount of type entered
     */
    public SpeciesPets(String type, Integer totalPets) {
        this.type = type;
        this.totalPets = totalPets;
    }

    /**
     *
     * @return type of pet species
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type type of pet species
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
