class Animal {
    public void makeSound() {
        System.out.println("Животное издает звук");
    }
}

class Dog extends Animal {
    // Предположим, мы хотим переопределить метод makeSound, но допустили опечатку в названии метода
    // Без аннотации @Override код скомпилируется, но переопределения не произойдет
    // С аннотацией @Override компилятор сообщит об ошибке
    
    // Неправильно: опечатка в имени метода (makeSoud вместо makeSound)
    // @Override  // Если раскомментировать, будет ошибка компиляции
    public void makeSoud() {
        System.out.println("Собака лает");
    }
}

public class OverrideAnnotationExample {
    public static void main(String[] args) {
        Animal myDog = new Dog();
        myDog.makeSound(); // Выведет "Животное издает звук", а не "Собака лает"
        
        // Правильный код с аннотацией @Override:
        // class Dog extends Animal {
        //     @Override
        //     public void makeSound() {
        //         System.out.println("Собака лает");
        //     }
        // }
        // Тогда myDog.makeSound() выведет "Собака лает"
    }
}
