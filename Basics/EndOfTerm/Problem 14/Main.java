/*
Factory method: Định nghĩa một giao diện để tạo đối tượng, nhưng để các lớp
con quyết định đối tượng nào được khởi tạo. Factory method cho phép một
lớp trì hoãn việc khởi tạo cho các lớp con
*/

interface Animal {
    void speak();
}

class Dog implements Animal {
    @Override
    public void speak() {
        System.out.println("Dog: Woof");
    }

}

class Cat implements Animal {
    @Override
    public void speak() {
        System.out.println("Cat: Meow");
    }
}

abstract class AnimalCreator {
    public abstract Animal animalCreator();

    public void showAnimal() {
        Animal animal = animalCreator();
        animal.speak();
    }
}

class DogCreator extends AnimalCreator {

    public Animal animalCreator() {
        return new Dog();
    }
}

class CatCreator extends AnimalCreator {

    public Animal animalCreator() {
        return new Cat();
    }
}

public class Main {
    public static void main(String[] args) {
        AnimalCreator creator1 = new DogCreator();
        creator1.showAnimal();
        AnimalCreator creator2 = new CatCreator();
        creator2.showAnimal();
    }
}
