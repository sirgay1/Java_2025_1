// Суперкласс с final методами
class Vehicle {
    private String brand;
    
    public Vehicle(String brand) {
        this.brand = brand;
    }
    
    // 1. Final метод - нельзя переопределить
    public final void startEngine() {
        System.out.println(brand + " двигатель запущен (final метод)");
    }
    
    // 2. Не-final метод - можно переопределить
    public void stopEngine() {
        System.out.println(brand + " двигатель остановлен");
    }
    
    // 3. Final private метод - и так не наследуется
    private final void secretMethod() {
        System.out.println("Секретный метод Vehicle");
    }
    
    // 4. Final статический метод - нельзя переопределить
    public static final void staticMethod() {
        System.out.println("Статический final метод Vehicle");
    }
}

// Подкласс
class Car extends Vehicle {
    public Car(String brand) {
        super(brand);
    }
    
    //  Можно переопределить не-final метод
    @Override
    public void stopEngine() {
        System.out.println("Автомобиль остановлен с помощью ABS");
    }
    
    //  НЕЛЬЗЯ переопределить final метод - ошибка компиляции
    /*
    @Override
    public final void startEngine() {  // ОШИБКА: startEngine() in Car cannot override startEngine() in Vehicle
        System.out.println("Переопределенный запуск двигателя");
    }
    */
    
    //  Можно создать метод с таким же именем, но это НЕ переопределение
    // Это просто другой метод (если бы не было аннотации @Override)
    public void startEngine(String keyType) {
        System.out.println("Запуск с ключом типа: " + keyType);
    }
    
    //  НЕЛЬЗЯ переопределить final статический метод
    /*
    public static void staticMethod() {  // ОШИБКА
        System.out.println("Переопределенный статический метод");
    }
    */
}

// Еще один пример с абстрактным классом
abstract class Animal {
    // Final метод в абстрактном классе
    public final void breathe() {
        System.out.println("Все животные дышат одинаково (final метод)");
    }
    
    // Абстрактный метод - должен быть переопределен
    public abstract void makeSound();
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Гав-гав!");
    }
    
    //  НЕЛЬЗЯ переопределить final метод breathe()
    /*
    @Override
    public void breathe() {  // ОШИБКА
        System.out.println("Собака дышит по-своему");
    }
    */
}

// Главный класс
public class FinalMethodExample {
    public static void main(String[] args) {
        System.out.println("=== Пример 1: Vehicle и Car ===");
        Car car = new Car("Toyota");
        car.startEngine();  // Вызов final метода из Vehicle
        car.stopEngine();   // Вызов переопределенного метода
        car.startEngine("keyless"); // Вызов перегруженного метода
        
        System.out.println("\n=== Пример 2: Animal и Dog ===");
        Dog dog = new Dog();
        dog.breathe();     // Вызов final метода
        dog.makeSound();   // Вызов переопределенного абстрактного метода
        
        System.out.println("\n=== Демонстрация ошибок компиляции ===");
        System.out.println("Следующий код вызовет ошибки компиляции:");
        System.out.println("1. Попытка переопределить final метод startEngine()");
        System.out.println("2. Попытка переопределить final static метод staticMethod()");
        System.out.println("3. Попытка переопределить final метод breathe() в классе Dog");
    }
}
