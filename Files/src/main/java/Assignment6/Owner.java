package Assignment6;

public class Owner {
    private String name;
    private String address;

    public int getPetsAdopted() {
        return petsAdopted;
    }

    private int petsAdopted;
    public Owner(String name, String address) {
        this.name = name;
        this.address = address;
        petsAdopted = 0;
    }
    void adoptPet(Pet pet){
        petsAdopted++;
        System.out.println("You have adopted "+pet.getName()+"!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
