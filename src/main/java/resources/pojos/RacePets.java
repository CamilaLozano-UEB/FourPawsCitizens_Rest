package resources.pojos;

public class RacePets {
    private String type;
    private Integer totalPets;

    public RacePets() {
    }

    public RacePets(String type, Integer totalPets) {
        this.type = type;
        this.totalPets = totalPets;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getTotalPets() {
        return totalPets;
    }

    public void setTotalPets(Integer totalPets) {
        this.totalPets = totalPets;
    }
}
