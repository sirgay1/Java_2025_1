public class FormatSpecifiersDemo {
    public static void main(String[] args) {
        // 1. %b - логическое значение
        boolean flag = true;
        System.out.printf("%b%n", flag); // true
        
        // 2. %d - десятичное целое
        int number = 42;
        System.out.printf("Число: %d%n", number); // Число: 42
        
        // 3. %f - дробное число
        double pi = 3.14159;
        System.out.printf("Pi: %.2f%n", pi); // Pi: 3.14 (с округлением)
        
        // 4. %s - строка
        String name = "Иван";
        System.out.printf("Привет, %s!%n", name); // Привет, Иван!
        
        // 5. %% - знак процента
        double discount = 15.5;
        System.out.printf("Скидка: %.1f%%%n", discount); // Скидка: 15.5%
        
        // 6. %c - символ
        char letter = 'A';
        System.out.printf("Буква: %c%n", letter); // Буква: A
        
        // 7. %n - новая строка (кросс-платформенный \n)
        System.out.printf("Первая строка%nВторая строка%n");
        
        // 8. Комбинированный пример
        int apples = 5;
        double price = 2.5;
        System.out.printf("Яблок: %d, цена: %.2f руб., итого: %.2f руб.%n", 
                         apples, price, apples * price);
    }
}
