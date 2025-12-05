package cls_met_final;

// Final-класс - нельзя от него наследоваться
final class FinalClass {
    void showMessage() {
        System.out.println("Я final-класс!");
    }
}

// Попытка наследования вызывает ошибку компиляции
// class SubClass extends FinalClass { // ОШИБКА: нельзя наследовать final-класс
//     void additionalMethod() {
//         System.out.println("Дополнительный метод");
//     }
// }

// Демонстрация с разными final-элементами
class ParentClass {
    // final-метод - можно перегрузить, но нельзя переопределить в подклассах
    final void finalMethod() {
        System.out.println("Этот метод нельзя переопределить");
    }
    
    // Обычный метод - можно переопределить
    void normalMethod() {
        System.out.println("Обычный метод родителя");
    }
}

class ChildClass extends ParentClass {
    //  НЕЛЬЗЯ - ошибка компиляции:
    // @Override
    // void finalMethod() {
    //     System.out.println("Попытка переопределить final-метод");
    // }
    
    //  МОЖНО - переопределяем обычный метод
    @Override
    void normalMethod() {
        System.out.println("Переопределенный метод в подклассе");
    }
}

public class FinalInheritanceDemo {
    public static void main(String[] args) {
        System.out.println("Демонстрация ограничений final в наследовании\n");
        
        System.out.println("1. Final-класс:");
        FinalClass obj = new FinalClass();
        obj.showMessage();
        System.out.println("   FinalClass нельзя унаследовать - ошибка компиляции\n");
        
        System.out.println("2. Final-метод:");
        ChildClass child = new ChildClass();
        child.finalMethod();      // Вызывает метод родителя
        child.normalMethod();     // Вызывает переопределенный метод
        
        System.out.println("\n3. Final-переменная:");
        final int MAX_VALUE = 100;
        // MAX_VALUE = 200; // ОШИБКА: нельзя изменить final-переменную
        
        System.out.println("   MAX_VALUE = " + MAX_VALUE);
        
        System.out.println("\nЧто можно и нельзя с final:");
        System.out.println(" Final-класс: создать экземпляр, но нельзя наследовать");
        System.out.println(" Final-метод: вызвать, но нельзя переопределить");
        System.out.println(" Final-переменная: использовать, но нельзя изменить");
    }
}