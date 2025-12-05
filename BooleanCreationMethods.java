package wrapper_classes;

public class BooleanCreationMethods {
    public static void main(String[] args) {
        System.out.println("ВСЕ СПОСОБЫ СОЗДАНИЯ ЭКЗЕМПЛЯРОВ BOOLEAN\n");
        
        System.out.println("1. Через конструктор (устаревший способ):");
        Boolean bool1 = new Boolean(true);
        Boolean bool2 = new Boolean(false);
        Boolean bool3 = new Boolean("true");
        Boolean bool4 = new Boolean("false");
        Boolean bool5 = new Boolean("TRUE");
        Boolean bool6 = new Boolean("FALSE");
        Boolean bool7 = new Boolean("True");
        Boolean bool8 = new Boolean("False");
        
        System.out.println("   new Boolean(true) -> " + bool1);
        System.out.println("   new Boolean(false) -> " + bool2);
        System.out.println("   new Boolean(\"true\") -> " + bool3);
        System.out.println("   new Boolean(\"false\") -> " + bool4);
        System.out.println("   new Boolean(\"TRUE\") -> " + bool5);
        System.out.println("   new Boolean(\"FALSE\") -> " + bool6);
        System.out.println("   new Boolean(\"True\") -> " + bool7);
        System.out.println("   new Boolean(\"False\") -> " + bool8);
        
        System.out.println("\n2. Через статический метод valueOf():");
        Boolean bool9 = Boolean.valueOf(true);
        Boolean bool10 = Boolean.valueOf(false);
        Boolean bool11 = Boolean.valueOf("true");
        Boolean bool12 = Boolean.valueOf("false");
        Boolean bool13 = Boolean.valueOf("TRUE");
        Boolean bool14 = Boolean.valueOf("FALSE");
        Boolean bool15 = Boolean.valueOf("True");
        Boolean bool16 = Boolean.valueOf("False");
        Boolean bool17 = Boolean.valueOf("yes"); // любые другие строки дают false
        Boolean bool18 = Boolean.valueOf("no");
        Boolean bool19 = Boolean.valueOf("1");
        Boolean bool20 = Boolean.valueOf("0");
        
        System.out.println("   Boolean.valueOf(true) -> " + bool9);
        System.out.println("   Boolean.valueOf(false) -> " + bool10);
        System.out.println("   Boolean.valueOf(\"true\") -> " + bool11);
        System.out.println("   Boolean.valueOf(\"false\") -> " + bool12);
        System.out.println("   Boolean.valueOf(\"yes\") -> " + bool17 + " (любые строки кроме 'true' дают false)");
        System.out.println("   Boolean.valueOf(null) -> " + Boolean.valueOf(null));
        
        System.out.println("\n3. Через статические константы:");
        Boolean bool21 = Boolean.TRUE;
        Boolean bool22 = Boolean.FALSE;
        
        System.out.println("   Boolean.TRUE -> " + bool21);
        System.out.println("   Boolean.FALSE -> " + bool22);
        
        System.out.println("\n4. Автоупаковка (autoboxing):");
        Boolean bool23 = true; // автоупаковка примитива в объект
        Boolean bool24 = false;
        
        System.out.println("   Boolean bool23 = true -> " + bool23);
        System.out.println("   Boolean bool24 = false -> " + bool24);
        
        System.out.println("\n5. Через логические выражения:");
        Boolean bool25 = 10 > 5;
        Boolean bool26 = "text".length() == 4;
        Boolean bool27 = (10 % 2 == 0);
        Boolean bool28 = !bool27;
        
        System.out.println("   10 > 5 -> " + bool25);
        System.out.println("   \"text\".length() == 4 -> " + bool26);
        System.out.println("   (10 % 2 == 0) -> " + bool27);
        System.out.println("   !(10 % 2 == 0) -> " + bool28);
        
        System.out.println("\n6. Через метод parseBoolean():");
        Boolean bool29 = Boolean.parseBoolean("true") ? Boolean.TRUE : Boolean.FALSE;
        Boolean bool30 = Boolean.parseBoolean("false") ? Boolean.TRUE : Boolean.FALSE;
        Boolean bool31 = Boolean.parseBoolean("TRUE") ? Boolean.TRUE : Boolean.FALSE;
        Boolean bool32 = Boolean.parseBoolean("any other string") ? Boolean.TRUE : Boolean.FALSE;
        
        System.out.println("   Boolean.parseBoolean(\"true\") -> " + bool29);
        System.out.println("   Boolean.parseBoolean(\"false\") -> " + bool30);
        System.out.println("   Boolean.parseBoolean(\"TRUE\") -> " + bool31);
        System.out.println("   Boolean.parseBoolean(\"other\") -> " + bool32 + " (любые другие строки дают false)");
        
        System.out.println("\n7. Через метод getBoolean() (системные свойства):");
        // Устанавливаем системное свойство для демонстрации
        System.setProperty("my.boolean.property", "true");
        Boolean bool33 = Boolean.getBoolean("my.boolean.property");
        Boolean bool34 = Boolean.getBoolean("non.existent.property");
        
        System.out.println("   System.setProperty(\"my.boolean.property\", \"true\")");
        System.out.println("   Boolean.getBoolean(\"my.boolean.property\") -> " + bool33);
        System.out.println("   Boolean.getBoolean(\"non.existent.property\") -> " + bool34);
        
        System.out.println("\n8. Через тернарный оператор:");
        String input = "true";
        Boolean bool35 = "true".equalsIgnoreCase(input) ? Boolean.TRUE : Boolean.FALSE;
        int number = 7;
        Boolean bool36 = number % 2 == 0 ? Boolean.TRUE : Boolean.FALSE;
        
        System.out.println("   \"true\".equalsIgnoreCase(\"true\") ? Boolean.TRUE : Boolean.FALSE -> " + bool35);
        System.out.println("   7 % 2 == 0 ? Boolean.TRUE : Boolean.FALSE -> " + bool36);
        
        System.out.println("\n9. Через сравнение объектов:");
        Boolean bool37 = Boolean.valueOf(10 == 10); // true
        Boolean bool38 = Boolean.valueOf("A".equals("B")); // false
        
        System.out.println("   Boolean.valueOf(10 == 10) -> " + bool37);
        System.out.println("   Boolean.valueOf(\"A\".equals(\"B\")) -> " + bool38);
        
        System.out.println("\n10. Использование BooleanCache:");
        System.out.println("   Boolean использует внутренний кэш:");
        System.out.println("   Boolean.valueOf(true) == Boolean.TRUE -> " + (Boolean.valueOf(true) == Boolean.TRUE));
        System.out.println("   Boolean.valueOf(false) == Boolean.FALSE -> " + (Boolean.valueOf(false) == Boolean.FALSE));
        System.out.println("   new Boolean(true) == Boolean.TRUE -> " + (new Boolean(true) == Boolean.TRUE));
        
        System.out.println("\nВАЖНЫЕ ЗАМЕЧАНИЯ:");
        System.out.println("1. Конструктор Boolean() deprecated с Java 9");
        System.out.println("2. Всегда используйте Boolean.valueOf() вместо new Boolean()");
        System.out.println("3. Boolean.parseBoolean() возвращает примитив boolean");
        System.out.println("4. Boolean.TRUE и Boolean.FALSE - единственные экземпляры");
        System.out.println("5. Boolean.getBoolean() читает системные свойства");
        
        System.out.println("\nСРАВНЕНИЕ РАЗНЫХ СПОСОБОВ:");
        Boolean b1 = new Boolean(true);
        Boolean b2 = Boolean.valueOf(true);
        Boolean b3 = Boolean.TRUE;
        Boolean b4 = true;
        
        System.out.println("   new Boolean(true).equals(Boolean.TRUE) -> " + b1.equals(Boolean.TRUE));
        System.out.println("   Boolean.valueOf(true) == Boolean.TRUE -> " + (b2 == Boolean.TRUE));
        System.out.println("   Boolean.TRUE == Boolean.TRUE -> " + (b3 == Boolean.TRUE));
        System.out.println("   true == Boolean.TRUE -> " + (b4 == Boolean.TRUE));
    }
}