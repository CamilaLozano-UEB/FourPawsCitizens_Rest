package resources.pojos.pets;

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

    /**
     *
     * @param totalPets total pets
     * @param petswithMicrochip total pets with microchip
     * @param petswithSterilization total pets with sterilization
     * @param sexPets Pet sex list
     * @param sizePets List of pet sizes
     * @param racePets List of pet races
     * @param speciesPets List of pet species
     */
    public Pets(Integer totalPets, Integer petswithMicrochip, Integer petswithSterilization, List<SexPets> sexPets, List<SizePets> sizePets, List<RacePets> racePets, List<SpeciesPets> speciesPets) {
        this.totalPets = totalPets;
        this.petswithMicrochip = petswithMicrochip;
        this.petswithSterilization = petswithSterilization;
        this.sexPets = sexPets;
        this.sizePets = sizePets;
        this.racePets = racePets;
        this.speciesPets = speciesPets;
    }

    /**
     *
     * @return total pets
     */
    public Integer getTotalPets() {
        return totalPets;
    }

    /**
     *
     * @param totalPets total pets
     */
    public void setTotalPets(Integer totalPets) {
        this.totalPets = totalPets;
    }

    /**
     *
     * @return total pets with microchip
     */
    public Integer getPetswithMicrochip() {
        return petswithMicrochip;
    }

    /**
     *
     * @param petswithMicrochip total pets with microchip
     */
    public void setPetswithMicrochip(Integer petswithMicrochip) {
        this.petswithMicrochip = petswithMicrochip;
    }

    /**
     *
     * @return total pets with sterilization
     */
    public Integer getPetswithSterilization() {
        return petswithSterilization;
    }

    /**
     *
     * @param petswithSterilization total pets with sterilization
     */
    public void setPetswithSterilization(Integer petswithSterilization) {
        this.petswithSterilization = petswithSterilization;
    }

    /**
     *
     * @return  Pet sex list
     */
    public List<SexPets> getSexPets() {
        return sexPets;
    }

    /**
     *
     * @param sexPets  Pet sex list
     */
    public void setSexPets(List<SexPets> sexPets) {
        this.sexPets = sexPets;
    }

    /**
     *
     * @return List of pet sizes
     */
    public List<SizePets> getSizePets() {
        return sizePets;
    }

    /**
     *
     * @param sizePets List of pet sizes
     */
    public void setSizePets(List<SizePets> sizePets) {
        this.sizePets = sizePets;
    }

    /**
     *
     * @return List of pet races
     */
    public List<RacePets> getRacePets() {
        return racePets;
    }

    /**
     *
     * @param racePets List of pet races
     */
    public void setRacePets(List<RacePets> racePets) {
        this.racePets = racePets;
    }

    /**
     *
     * @return List of pet species
     */
    public List<SpeciesPets> getSpeciesPets() {
        return speciesPets;
    }

    /**
     *
     * @param speciesPets List of pet species
     */
    public void setSpeciesPets(List<SpeciesPets> speciesPets) {
        this.speciesPets = speciesPets;
    }
}
