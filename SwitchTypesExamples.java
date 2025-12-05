package selection_operator;

public class SwitchTypesExamples {
    public static void main(String[] args) {
        System.out.println("ТИПЫ ПЕРЕМЕННЫХ, КОТОРЫЕ МОГУТ ИСПОЛЬЗОВАТЬСЯ В SWITCH\n");
        
        // 1. Целочисленные примитивные типы
        System.out.println("1. ЦЕЛОЧИСЛЕННЫЕ ПРИМИТИВНЫЕ ТИПЫ:");
        
        // byte
        byte byteValue = 2;
        System.out.print("   byte: ");
        switch(byteValue) {
            case 1: System.out.println("один"); break;
            case 2: System.out.println("два"); break;
            case 3: System.out.println("три"); break;
            default: System.out.println("другое");
        }
        
        // short
        short shortValue = 100;
        System.out.print("   short: ");
        switch(shortValue) {
            case 100: System.out.println("сто"); break;
            case 200: System.out.println("двести"); break;
            default: System.out.println("другое");
        }
        
        // int (самый распространенный)
        int intValue = 3;
        System.out.print("   int: ");
        switch(intValue) {
            case 1: System.out.println("январь"); break;
            case 2: System.out.println("февраль"); break;
            case 3: System.out.println("март"); break;
            default: System.out.println("другой месяц");
        }
        
        // char (обрабатывается как целое число)
        char charValue = 'B';
        System.out.print("   char: ");
        switch(charValue) {
            case 'A': System.out.println("отлично"); break;
            case 'B': System.out.println("хорошо"); break;
            case 'C': System.out.println("удовлетворительно"); break;
            default: System.out.println("не оценено");
        }
        
        // 2. String (с Java 7)
        System.out.println("\n2. STRING (с Java 7):");
        String stringValue = "blue";
        System.out.print("   String: ");
        switch(stringValue) {
            case "red": System.out.println("красный"); break;
            case "green": System.out.println("зеленый"); break;
            case "blue": System.out.println("синий"); break;
            default: System.out.println("другой цвет");
        }
        
        // 3. Enum (перечисления)
        System.out.println("\n3. ENUM (ПЕРЕЧИСЛЕНИЯ):");
        Day day = Day.WEDNESDAY;
        System.out.print("   Enum: ");
        switch(day) {
            case MONDAY: System.out.println("понедельник"); break;
            case TUESDAY: System.out.println("вторник"); break;
            case WEDNESDAY: System.out.println("среда"); break;
            case THURSDAY: System.out.println("четверг"); break;
            case FRIDAY: System.out.println("пятница"); break;
            default: System.out.println("выходной");
        }
        
        // 4. Обертки примитивных типов (autoboxing)
        System.out.println("\n4. ОБЕРТКИ ПРИМИТИВНЫХ ТИПОВ (autoboxing):");
        
        // Integer
        Integer integerValue = 10;
        System.out.print("   Integer: ");
        switch(integerValue) {
            case 5: System.out.println("мало"); break;
            case 10: System.out.println("нормально"); break;
            case 15: System.out.println("много"); break;
            default: System.out.println("неизвестно");
        }
        
        // Character
        Character characterValue = 'X';
        System.out.print("   Character: ");
        switch(characterValue) {
            case 'X': System.out.println("икс"); break;
            case 'Y': System.out.println("игрек"); break;
            case 'Z': System.out.println("зет"); break;
            default: System.out.println("другая буква");
        }
        
        // Byte
        Byte byteObj = 1;
        System.out.print("   Byte: ");
        switch(byteObj) {
            case 1: System.out.println("первый"); break;
            case 2: System.out.println("второй"); break;
            default: System.out.println("другой");
        }
        
        // 5. Выражения, которые можно привести к допустимым типам
        System.out.println("\n5. ВЫРАЖЕНИЯ, ПРИВОДИМЫЕ К ДОПУСТИМЫМ ТИПАМ:");
        
        // long → int (с приведением)
        long longValue = 5L;
        System.out.print("   long (с приведением): ");
        switch((int)longValue) {
            case 5: System.out.println("пять"); break;
            default: System.out.println("не пять");
        }
        
        // float → int (с приведением)
        float floatValue = 2.0f;
        System.out.print("   float (с приведением): ");
        switch((int)floatValue) {
            case 1: System.out.println("единица"); break;
            case 2: System.out.println("двойка"); break;
            default: System.out.println("другое");
        }
        
        // 6. Switch expression (Java 14+)
        System.out.println("\n6. SWITCH EXPRESSION (Java 14+):");
        int number = 2;
        String result = switch(number) {
            case 1 -> "один";
            case 2 -> "два";
            case 3 -> "три";
            default -> "много";
        };
        System.out.println("   Switch expression: " + result);
        
        // 7. Yield в switch expression (Java 13+)
        System.out.println("\n7. YIELD В SWITCH EXPRESSION:");
        int code = 404;
        String message = switch(code) {
            case 200:
                yield "OK";
            case 404:
                yield "Not Found";
            case 500:
                yield "Internal Server Error";
            default:
                yield "Unknown";
        };
        System.out.println("   С yield: Код " + code + " - " + message);
        
        // 8. Примеры с нескольчениями в case (Java 14+)
        System.out.println("\n8. НЕСКОЛЬЧЕНИЯ В CASE (Java 14+):");
        int month = 2;
        String season = switch(month) {
            case 12, 1, 2 -> "зима";
            case 3, 4, 5 -> "весна";
            case 6, 7, 8 -> "лето";
            case 9, 10, 11 -> "осень";
            default -> "неверный месяц";
        };
        System.out.println("   Месяц " + month + " - это " + season);
        
        // 9. НЕДОПУСТИМЫЕ ТИПЫ (вызовут ошибку компиляции)
        System.out.println("\n9. НЕДОПУСТИМЫЕ ТИПЫ ДЛЯ SWITCH:");
        System.out.println("   Следующие типы НЕЛЬЗЯ использовать в switch:");
        System.out.println("   - boolean (можно заменить if-else)");
        System.out.println("   - long (слишком большой диапазон)");
        System.out.println("   - float/double (из-за неточности сравнения)");
        System.out.println("   - любые объекты, кроме String и Enum");
        
        // Демонстрация why некоторых типов не допускаются
        System.out.println("\n10. ПОЧЕМУ НЕКОТОРЫЕ ТИПЫ НЕ ДОПУСКАЮТСЯ:");
        System.out.println("   boolean: всего 2 значения, проще использовать if-else");
        System.out.println("   long: слишком большой диапазон (2^64 значений)");
        System.out.println("   float/double: проблемы с точностью сравнения");
        
        System.out.println("\nИТОГОВЫЙ СПИСОК ДОПУСТИМЫХ ТИПОВ:");
        System.out.println("1. byte, short, int, char");
        System.out.println("2. String (с Java 7)");
        System.out.println("3. Enum");
        System.out.println("4. Byte, Short, Integer, Character (autoboxing)");
        System.out.println("5. Любые выражения, приводимые к вышеуказанным типам");
    }
    
    // Enum для примеров
    enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }
}