package Assignment6;

public class PetAdoptionSystem {
    public static void main(String[] args) {
        Dog dog=new Dog("Dogesh",6,"deshi");
        Cat cat=new Cat("Caterpillar",9,"Orange");
        Owner owner=new Owner("John wick","Area51, NY");
        owner.adoptPet(dog);
        dog.makeSound();
        dog.feed();
        dog.play();
        owner.adoptPet(cat);
        cat.makeSound();
        cat.feed();
        cat.play();
        System.out.println("--------------------------------------\nOwner name: "+owner.getName()+"\nNumber of pets adopted: "+owner.getPetsAdopted()+dog.toString()+cat.toString());
    }
}
