package resources.pojos;

import java.util.List;

public class Pets {
    private Integer totalPets;
    private Integer petswithMicrochip;
    private Integer petswithSterilization;
    private List<SexPets> sexPets;
    private List<SizePets> sizePets;
    private List<RacePets> racePets;
    private List<SpeciesPets> speciesPets;

    public Pets() {
    }

    public Pets(Integer totalPets, Integer petswithMicrochip, Integer petswithSterilization, List<SexPets> sexPets, List<SizePets> sizePets, List<RacePets> racePets, List<SpeciesPets> speciesPets) {
        this.totalPets = totalPets;
        this.petswithMicrochip = petswithMicrochip;
        this.petswithSterilization = petswithSterilization;
        this.sexPets = sexPets;
        this.sizePets = sizePets;
        this.racePets = racePets;
        this.speciesPets = speciesPets;
    }

    public Integer getTotalPets() {
        return totalPets;
    }

    public void setTotalPets(Integer totalPets) {
        this.totalPets = totalPets;
    }

    public Integer getPetswithMicrochip() {
        return petswithMicrochip;
    }

    public void setPetswithMicrochip(Integer petswithMicrochip) {
        this.petswithMicrochip = petswithMicrochip;
    }

    public Integer getPetswithSterilization() {
        return petswithSterilization;
    }

    public void setPetswithSterilization(Integer petswithSterilization) {
        this.petswithSterilization = petswithSterilization;
    }

    public List<SexPets> getSexPets() {
        return sexPets;
    }

    public void setSexPets(List<SexPets> sexPets) {
        this.sexPets = sexPets;
    }

    public List<SizePets> getSizePets() {
        return sizePets;
    }

    public void setSizePets(List<SizePets> sizePets) {
        this.sizePets = sizePets;
    }

    public List<RacePets> getRacePets() {
        return racePets;
    }

    public void setRacePets(List<RacePets> racePets) {
        this.racePets = racePets;
    }

    public List<SpeciesPets> getSpeciesPets() {
        return speciesPets;
    }

    public void setSpeciesPets(List<SpeciesPets> speciesPets) {
        this.speciesPets = speciesPets;
    }
}
