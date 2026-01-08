package Assignment6;

public class Dog extends Pet implements PetBehaviour {
    public Dog(String name, int age, String breed) {
        super(name, age, breed);
    }

    @Override
    void makeSound() {
        System.out.println("Woof!");
    }

    @Override
    public void feed() {
        System.out.println("Feeding the dog");
    }

    @Override
    public void play() {
        System.out.println("Playing with the dog");
    }
    public String toString(){
        return "\nName: "+super.getName()+"\nAge: "+super.getAge()+"\nBreed: "+super.getBreed();
    }
}
