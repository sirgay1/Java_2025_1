package param_classes;

import java.util.*;

public class WildcardsExample {
    public static void main(String[] args) {
        // ========== <? extends T> - PRODUCER (Читаем) ==========
        List<Integer> ints = Arrays.asList(1, 2, 3);
        List<Double> doubles = Arrays.asList(1.1, 2.2, 3.3);
        
        // Можем читать любые Number из списков
        System.out.println("Сумма ints: " + sumOfList(ints));
        System.out.println("Сумма doubles: " + sumOfList(doubles));
        
        // ========== <? super T> - CONSUMER (Записываем) ==========
        List<Number> numbers = new ArrayList<>();
        List<Object> objects = new ArrayList<>();
        
        // Можем добавлять Integer в любые списки, которые принимают супертипы Integer
        addIntegers(numbers); // Number super Integer
        addIntegers(objects); // Object super Integer
        
        System.out.println("Numbers: " + numbers);
        System.out.println("Objects: " + objects);
        
        // ========== PECS (Producer Extends, Consumer Super) ==========
        List<Animal> animals = new ArrayList<>();
        List<Cat> cats = new ArrayList<>();
        List<Dog> dogs = new ArrayList<>();
        
        cats.add(new Cat("Мурка"));
        dogs.add(new Dog("Барсик"));
        
        // Producer: читаем котов как животных
        printAnimals(cats);
        printAnimals(dogs);
        
        // Consumer: добавляем котов в список животных
        addCatToAnimals(animals, new Cat("Васька"));
        System.out.println("Животные: " + animals);
    }
    
    // <? extends Number> - МОЖЕМ ЧИТАТЬ Number
    public static double sumOfList(List<? extends Number> list) {
        double sum = 0;
        for (Number n : list) {  // Чтение - OK
            sum += n.doubleValue();
        }
        // list.add(10); // ОШИБКА: нельзя добавлять - неизвестен точный тип
        return sum;
    }
    
    // <? super Integer> - МОЖЕМ ЗАПИСЫВАТЬ Integer
    public static void addIntegers(List<? super Integer> list) {
        list.add(100);      // Запись Integer - OK
        list.add(200);
        // Integer i = list.get(0); // ОШИБКА: можем читать только как Object
        Object obj = list.get(0); // Чтение как Object - OK
    }
    
    // ========== Демонстрация с иерархией классов ==========
    static class Animal {
        String name;
        Animal(String name) { this.name = name; }
        public String toString() { return name; }
    }
    
    static class Cat extends Animal {
        Cat(String name) { super(name); }
    }
    
    static class Dog extends Animal {
        Dog(String name) { super(name); }
    }
    
    // Producer Extends: читаем животных
    public static void printAnimals(List<? extends Animal> animals) {
        for (Animal a : animals) {  // Читаем как Animal
            System.out.println("Животное: " + a.name);
        }
    }
    
    // Consumer Super: добавляем котов
    public static void addCatToAnimals(List<? super Cat> animals, Cat cat) {
        animals.add(cat);  // Добавляем Cat
        // animals.add(new Animal("Другое")); // ОШИБКА: неизвестно, что это супертип Cat
    }
}