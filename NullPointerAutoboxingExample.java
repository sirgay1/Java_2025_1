package wrapper_classes;

public class NullPointerAutoboxingExample {
    public static void main(String[] args) {
        System.out.println("ПРИМЕРЫ NullPointerException ПРИ АВТОУПАКОВКЕ/АВТОРАСПАКОВКЕ\n");
        
        // Пример 1: Прямая автораспаковка null
        System.out.println("1. Прямая автораспаковка null:");
        Integer nullInteger = null;
        
        try {
            int primitiveInt = nullInteger; // NullPointerException!
            System.out.println("   Успешно: " + primitiveInt);
        } catch (NullPointerException e) {
            System.out.println("   NullPointerException: нельзя распаковать null Integer в int");
        }
        
        // Пример 2: Автораспаковка в арифметической операции
        System.out.println("\n2. Автораспаковка в арифметической операции:");
        Integer anotherNull = null;
        
        try {
            int result = anotherNull + 10; // NullPointerException!
            System.out.println("   Успешно: " + result);
        } catch (NullPointerException e) {
            System.out.println("   NullPointerException: null + 10 вызывает автораспаковку null");
        }
        
        // Пример 3: Автораспаковка в сравнении
        System.out.println("\n3. Автораспаковка при сравнении:");
        Integer x = null;
        
        try {
            if (x > 5) { // NullPointerException!
                System.out.println("   x больше 5");
            }
        } catch (NullPointerException e) {
            System.out.println("   NullPointerException: сравнение null > 5 требует распаковки");
        }
        
        // Пример 4: Автораспаковка в условном операторе
        System.out.println("\n4. Автораспаковка в условном операторе:");
        Boolean nullBoolean = null;
        
        try {
            if (nullBoolean) { // NullPointerException!
                System.out.println("   true");
            }
        } catch (NullPointerException e) {
            System.out.println("   NullPointerException: if(nullBoolean) требует распаковки");
        }
        
        // Пример 5: Автораспаковка в switch (Java 7+)
        System.out.println("\n5. Автораспаковка в switch:");
        Integer switchValue = null;
        
        try {
            switch (switchValue) { // NullPointerException!
                case 1: System.out.println("   1"); break;
                default: System.out.println("   другое");
            }
        } catch (NullPointerException e) {
            System.out.println("   NullPointerException: switch(null) требует распаковки");
        }
        
        // Пример 6: Автораспаковка в массиве
        System.out.println("\n6. Автораспаковка в массиве:");
        Integer[] numbers = {1, null, 3};
        
        try {
            int sum = numbers[0] + numbers[1] + numbers[2]; // NullPointerException!
            System.out.println("   Сумма: " + sum);
        } catch (NullPointerException e) {
            System.out.println("   NullPointerException: numbers[1] = null, нельзя сложить с int");
        }
        
        // Пример 7: Автораспаковка в цикле
        System.out.println("\n7. Автораспаковка в цикле:");
        Integer[] values = {10, null, 30};
        
        try {
            for (Integer val : values) {
                int processed = val * 2; // NullPointerException при val = null!
                System.out.println("   " + val + " * 2 = " + processed);
            }
        } catch (NullPointerException e) {
            System.out.println("   NullPointerException: val * 2 требует распаковки null");
        }
        
        // Пример 8: Автораспаковка в return
        System.out.println("\n8. Автораспаковка в return:");
        Integer returnValue = null;
        
        try {
            int result = getPrimitiveValue(returnValue);
            System.out.println("   Результат: " + result);
        } catch (NullPointerException e) {
            System.out.println("   NullPointerException: return требует распаковки null");
        }
        
        // Пример 9: Безопасные способы (без исключения)
        System.out.println("\n9. БЕЗОПАСНЫЕ СПОСОБЫ (без NullPointerException):");
        
        // Способ 1: Явная проверка на null
        Integer safeInteger = null;
        if (safeInteger != null) {
            int safe = safeInteger; // Безопасно
            System.out.println("   С проверкой: " + safe);
        } else {
            System.out.println("   Значение null, проверка сработала");
        }
        
        // Способ 2: Тернарный оператор
        Integer nullable = null;
        int result = (nullable != null) ? nullable : -1;
        System.out.println("   С тернарным оператором: " + result);
        
        // Пример 10: Автоупаковка null безопасна
        System.out.println("\n10. АВТОУПАКОВКА null безопасна:");
        // int primitiveNull = null; // Ошибка компиляции!
        // Integer boxed = null; // Успешно - это просто присваивание null
        Integer boxedNull = getNull();
        System.out.println("   Integer boxedNull = getNull() -> " + boxedNull + " (без исключения)");
        
    }
    
    private static int getPrimitiveValue(Integer value) {
        return value; // Автораспаковка при return
    }
    
    private static Integer getNull() {
        return null;
    }
}