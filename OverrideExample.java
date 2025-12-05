class Animal {
    // Метод в суперклассе
    public Animal getAnimal() {
        return new Animal();
    }
    
    public void makeSound() {
        System.out.println("Животное издает звук");
    }
}

class Dog extends Animal {
    // Переопределение метода с ковариантным возвращаемым типом
    @Override
    public Dog getAnimal() {
        return new Dog();
    }
    
    // Переопределение метода
    @Override
    public void makeSound() {
        System.out.println("Собака лает");
    }
}

public class OverrideExample {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.makeSound();
        
        Animal animal = dog.getAnimal();
        System.out.println(animal.getClass());
    }
}
