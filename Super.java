class Animal {
    String name = "Животное";

    Animal(String name) {
        this.name = name;
    }

    void makeSound() {
        System.out.println("Животное издает звук");
    }
}

class Dog extends Animal {
    String name = "Собака";

    Dog() {
        super("Собака");  // 1. Вызов конструктора суперкласса
    }

    void makeSound() {
        System.out.println("Собака лает");
    }

    void show() {
        System.out.println(super.name);  // 3. Обращение к полю суперкласса
        super.makeSound();               // 2. Вызов метода суперкласса
    }
}

public class SuperExample {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.show();
    }
}
