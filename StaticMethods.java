package static_methods;

// Файл A.java
public class A {
    public static int a = 1;
    public static int b;

    public static void printVars() {
        System.out.println(a);
        System.out.println(b);
    }
    
    // Пример вызова без квалификатора из того же класса
    public static void callFromSameClass() {
        printVars(); // внутри класса A - можно без квалификатора
    }
}

// Файл StaticMethods.java
public class StaticMethods {
    public static void main(String[] args) {
        // 1. Через имя класса
        A.printVars();
        
        // 2. Через объект класса
        A obj = new A();
        obj.printVars();
        
        // 3. Из того же класса A (но не из StaticMethods!)
        // printVars(); // ОШИБКА! Это другой класс
        
        // Правильный вызов из другого класса
        A.callFromSameClass();
    }
}