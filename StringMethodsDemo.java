public class StringMethodsDemo {
    public static void main(String[] args) {
        String text = " Hello, World! ";
        String another = "HELLO, WORLD!";
        
        // 1. length() - возвращает длину строки
        System.out.println("Длина: " + text.length()); // 15
        
        // 2. trim() - удаляет пробелы в начале и конце
        System.out.println("trim: '" + text.trim() + "'");
        
        // 3. toUpperCase() / toLowerCase() - регистр
        System.out.println("toUpperCase: " + text.toUpperCase());
        System.out.println("toLowerCase: " + text.toLowerCase());
        
        // 4. substring() - часть строки
        System.out.println("substring(2,7): " + text.substring(2, 7));
        
        // 5. replace() - замена символов
        System.out.println("replace('l','L'): " + text.replace('l', 'L'));
        
        // 6. equals() / equalsIgnoreCase() - сравнение
        System.out.println("equals: " + text.equals(another));
        System.out.println("equalsIgnoreCase: " + text.equalsIgnoreCase(another));
        
        // 7. contains() - проверка наличия подстроки
        System.out.println("contains(\"World\"): " + text.contains("World"));
        
        // 8. split() - разделение на массив
        String[] parts = "a,b,c".split(",");
        System.out.println("split: " + java.util.Arrays.toString(parts));
        
        // 9. indexOf() - поиск индекса символа/строки
        System.out.println("indexOf('W'): " + text.indexOf('W'));
        
        // 10. startsWith() / endsWith() - проверка начала/конца
        System.out.println("startsWith(\" He\"): " + text.startsWith(" He"));
        System.out.println("endsWith(\"! \"): " + text.endsWith("! "));
    }
}
