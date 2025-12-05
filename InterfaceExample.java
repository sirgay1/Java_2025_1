// Интерфейс с default (неабстрактным) методом и статическим методом
interface MyInterface {
    // default метод (неабстрактный)
    default void defaultMethod() {
        System.out.println("Default method in interface");
    }
    
    // статический метод
    static void staticMethod() {
        System.out.println("Static method in interface");
    }
}

// Класс, реализующий интерфейс
class MyClass implements MyInterface {
    // Можно переопределить default метод, но не обязательно
    @Override
    public void defaultMethod() {
        System.out.println("Overridden default method in class");
    }
}

public class InterfaceExample {
    public static void main(String[] args) {
        // Создаем объект класса
        MyClass obj = new MyClass();
        
        // Вызов default метода через объект класса
        obj.defaultMethod();
        
        // Вызов статического метода через имя интерфейса
        MyInterface.staticMethod();
        
        // Создаем объект через тип интерфейса
        MyInterface interfaceObj = new MyClass();
        interfaceObj.defaultMethod();
        
        // Если бы был еще один класс, не переопределяющий default метод:
        class AnotherClass implements MyInterface {}
        MyInterface anotherObj = new AnotherClass();
        anotherObj.defaultMethod(); // Вызовет default метод из интерфейса
    }
}
