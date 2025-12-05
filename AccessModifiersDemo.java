package access;

public class AccessModifiersDemo {
    
    // Поля с разными спецификаторами доступа
    public int publicField = 10;
    protected int protectedField = 20;
    int defaultField = 30;          // package-private (когда спецификатор отсутствует)
    private int privateField = 40;
    
    // Конструктор
    public AccessModifiersDemo() {
        System.out.println("Создан объект AccessModifiersDemo");
    }
    
    // ========== МЕТОДЫ С РАЗНЫМИ СПЕЦИФИКАТОРАМИ ==========
    
    // public метод - доступен отовсюду
    public void publicMethod() {
        System.out.println("publicMethod вызван");
        // Внутри класса доступны все поля
        System.out.println("Доступ ко всем полям изнутри класса:");
        System.out.println("  publicField: " + publicField);
        System.out.println("  protectedField: " + protectedField);
        System.out.println("  defaultField: " + defaultField);
        System.out.println("  privateField: " + privateField);
    }
    
    // protected метод - доступен в том же пакете и в подклассах
    protected void protectedMethod() {
        System.out.println("protectedMethod вызван");
    }
    
    // default метод (package-private) - доступен только в том же пакете
    void defaultMethod() {
        System.out.println("defaultMethod вызван");
    }
    
    // private метод - доступен только внутри этого класса
    private void privateMethod() {
        System.out.println("privateMethod вызван (только внутри класса)");
    }
    
    // Метод для демонстрации доступа к private методу изнутри класса
    public void accessPrivateMethod() {
        System.out.println("Доступ к private методу из public метода:");
        privateMethod();  // Можно вызвать изнутри класса
    }
    
    // Геттер для private поля (инкапсуляция)
    public int getPrivateField() {
        return privateField;
    }
    
    // Сеттер для private поля
    public void setPrivateField(int value) {
        if (value >= 0) {
            this.privateField = value;
        }
    }
    
    // Главный метод для демонстрации
    public static void main(String[] args) {
        System.out.println("=== ДЕМОНСТРАЦИЯ СПЕЦИФИКАТОРОВ ДОСТУПА ===\n");
        
        AccessModifiersDemo demo = new AccessModifiersDemo();
        
        // 1. Доступ к полям из того же класса
        System.out.println("1. Доступ из того же класса:");
        System.out.println("publicField: " + demo.publicField);
        System.out.println("protectedField: " + demo.protectedField);
        System.out.println("defaultField: " + demo.defaultField);
        System.out.println("privateField: " + demo.privateField);
        System.out.println();
        
        // 2. Вызов методов из того же класса
        System.out.println("2. Вызов методов из того же класса:");
        demo.publicMethod();
        demo.protectedMethod();
        demo.defaultMethod();
        demo.accessPrivateMethod();  // Косвенный доступ к private методу
        System.out.println();
        
        // 3. Демонстрация инкапсуляции через геттеры/сеттеры
        System.out.println("3. Инкапсуляция private поля:");
        System.out.println("Текущее значение privateField: " + demo.getPrivateField());
        demo.setPrivateField(50);
        System.out.println("Новое значение privateField: " + demo.getPrivateField());
        System.out.println();
        
        // 4. Тестирование с другим классом в том же пакете
        System.out.println("4. Тестирование с другим классом в том же пакете:");
        SamePackageTest.testAccess();
    }
}

// ========== КЛАСС В ТОМ ЖЕ ПАКЕТЕ ==========

class SamePackageTest {
    public static void testAccess() {
        System.out.println("\n--- Тестирование из того же пакета ---");
        AccessModifiersDemo demo = new AccessModifiersDemo();
        
        // Доступ из того же пакета
        System.out.println("publicField: " + demo.publicField);          // OK
        System.out.println("protectedField: " + demo.protectedField);    // OK
        System.out.println("defaultField: " + demo.defaultField);        // OK
        // System.out.println(demo.privateField);  // ОШИБКА: private поле не доступно
        
        demo.publicMethod();      // OK
        demo.protectedMethod();   // OK (тот же пакет)
        demo.defaultMethod();     // OK (тот же пакет)
        // demo.privateMethod();   // ОШИБКА: private метод не доступен
    }
}

//  ТЕСТОВЫЙ КЛАСС 

class TestClass {
    public static void main(String[] args) {
        System.out.println("=== ТЕСТИРОВАНИЕ СПЕЦИФИКАТОРОВ ДОСТУПА ===\n");
        
        AccessModifiersDemo demo = new AccessModifiersDemo();
        
        // Демонстрация доступа из другого класса в том же пакете
        System.out.println("Доступ из TestClass (тот же пакет):");
        System.out.println("publicField: " + demo.publicField);
        System.out.println("protectedField: " + demo.protectedField);
        System.out.println("defaultField: " + demo.defaultField);
        // System.out.println(demo.privateField); // ОШИБКА - компилятор не позволит
        
        System.out.println("\nВызов методов:");
        demo.publicMethod();
        demo.protectedMethod();
        demo.defaultMethod();
        // demo.privateMethod(); // ОШИБКА - компилятор не позволит
        
        System.out.println("\nИспользование геттера для private поля:");
        System.out.println("privateField через геттер: " + demo.getPrivateField());
    }
}
