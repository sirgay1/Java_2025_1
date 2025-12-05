import java.util.*;

/**
 * Демонстрация основных аннотаций Java
 */
public class AnnotationDemo {
    
    static class Animal {
        void makeSound() {
            System.out.println("Animal sound");
        }
    }
    
    static class Cat extends Animal {
        @Override
        void makeSound() {  // Корректное переопределение
            System.out.println("Meow");
        }
        
        // @Override
        // void makeSound(String volume) {  // Ошибка: метод не существует в родителе
        //     System.out.println("Meow " + volume);
        // }
    }
    
    
    static class Calculator {
        /**
         * @deprecated Используйте {@link #newAdd(int, int)} вместо этого.
         * Старый метод не поддерживает переполнение.
         */
        @Deprecated(since = "2.0", forRemoval = false)
        int add(int a, int b) {
            return a + b;
        }
        
        int newAdd(int a, int b) {
            return Math.addExact(a, b);  // Проверка переполнения
        }
        
        @Deprecated
        void oldMethod() {
            System.out.println("This is old");
        }
    }
    
    @SuppressWarnings("unchecked")  // Подавляет предупреждения для всего класса
    static class DataProcessor {
        
        // Без @SuppressWarnings было бы "unchecked" warning
        List processRawData() {
            List rawList = new ArrayList();  // raw type
            rawList.add("data");
            return rawList;
        }
        
        @SuppressWarnings({"deprecation", "unused"})
        void process() {
            Calculator calc = new Calculator();
            calc.oldMethod();  // Предупреждение о deprecated подавлено
            
            int unusedVar = 42;  // Предупреждение о неиспользуемой переменной подавлено
        }
        
        void normalMethod() {
            @SuppressWarnings("rawtypes")
            List list = new ArrayList();  // Предупреждение только для этой строки
            
            // Список common warning types:
            // "unchecked" - для generic-операций без type checking
            // "rawtypes" - использование raw типов вместо generics
            // "deprecation" - использование deprecated методов
            // "unused" - неиспользуемые переменные/методы
            // "all" - все предупреждения
        }
    }
    
    // ================= Практический пример =================
    public static void main(String[] args) {
        System.out.println("=== @Override Demo ===");
        Animal cat = new Cat();
        cat.makeSound();  // Meow
        
        System.out.println("\n=== @Deprecated Demo ===");
        Calculator calc = new Calculator();
        
        // При компиляции: warning: [deprecation] add(int,int) in Calculator is deprecated
        int result = calc.add(5, 3);  // Использование deprecated метода
        System.out.println("Deprecated method result: " + result);
        
        // IDE обычно зачеркивает deprecated методы
        calc.oldMethod();
        
        // Правильный способ - использовать новый метод
        try {
            calc.newAdd(5, 3);
        } catch (ArithmeticException e) {
            System.out.println("Overflow detected by new method");
        }
        
        System.out.println("\n=== @SuppressWarnings Demo ===");
        DataProcessor processor = new DataProcessor();
        List data = processor.processRawData();  // Без unchecked warning
        System.out.println("Processed data: " + data);
        
        // Проверка предупреждений при компиляции:
        // javac -Xlint:all AnnotationDemo.java
    }
}
