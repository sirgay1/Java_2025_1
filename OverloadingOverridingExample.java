package methods;
// Перегрузка методов (overloading)
class Calculator {
    // Перегруженные методы add
    int add(int a, int b) {
        return a + b;
    }
    
    double add(double a, double b) {
        return a + b;
    }
    
    int add(int a, int b, int c) {
        return a + b + c;
    }
}

// Переопределение методов (overriding)
class Animal {
    void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {
    @Override
    void makeSound() {
        System.out.println("Cat meows");
    }
}

public class OverloadingOverridingExample {
    public static void main(String[] args) {
        // Демонстрация перегрузки
        Calculator calc = new Calculator();
        System.out.println(calc.add(5, 10));
        System.out.println(calc.add(5.5, 2.3));
        System.out.println(calc.add(1, 2, 3));
        
        // Демонстрация переопределения
        Animal animal = new Animal();
        animal.makeSound();
        
        Animal dog = new Dog();
        dog.makeSound();
        
        Animal cat = new Cat();
        cat.makeSound();
    }
}