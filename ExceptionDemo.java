// 1. Иерархия исключений
class Ex1 extends Exception {
    public Ex1(String message) { super(message); }
}

class Ex2 extends Ex1 {
    public Ex2(String message) { super(message); }
}

class Ex3 extends Ex2 {
    public Ex3(String message) { super(message); }
}

public class ExceptionDemo {
    public static void main(String[] args) {
        System.out.println("=== 1. Одинаковая обработка разных исключений ===");
        
        // Ситуация 1: Одинаковая обработка ArithmeticException и ArrayIndexOutOfBoundsException
        try {
            int[] arr = {1, 2, 3};
            int a = 10 / 0;  // ArithmeticException
            int b = arr[5];  // ArrayIndexOutOfBoundsException (не выполнится)
        } 
        catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            // Одинаковая обработка двух разных исключений
            System.out.println("Ошибка вычисления или массива: " + e.getClass().getSimpleName());
        }
        
        // Ситуация 2: Одинаковая обработка IllegalArgumentException и NullPointerException
        try {
            String text = null;
            validateInput(text);  // Может выбросить оба исключения
        }
        catch (IllegalArgumentException | NullPointerException e) {
            System.out.println("Некорректные данные: " + e.getMessage());
        }
        
        System.out.println("\n=== 2. Обработка иерархии исключений ===");
        
        // Порядок catch БЛОКОВ ВАЖЕН: от специфичных к общим
        try {
            throwRandomException();
        } 
        catch (Ex3 e) {  // Самый специфичный (подкласс)
            System.out.println("Поймали Ex3: " + e.getMessage());
        }
        catch (Ex2 e) {  // Средний уровень
            System.out.println("Поймали Ex2: " + e.getMessage());
        }
        catch (Ex1 e) {  // Самый общий (суперкласс)
            System.out.println("Поймали Ex1: " + e.getMessage());
        }
        finally {
            System.out.println("Finally выполняется всегда");
        }
        
        System.out.println("\n=== 3. Демонстрация полиморфизма ===");
        
        // Ex3 может быть обработан как Ex1 (полиморфизм)
        try {
            throw new Ex3("Это Ex3");
        }
        catch (Ex1 e) {  // Ловит Ex1 и всех его потомков
            System.out.println("Поймали через Ex1: " + e.getClass().getSimpleName());
        }
        
        // ОШИБОЧНЫЙ порядок (не скомпилируется)
        /*
        try {
            throw new Ex3("Ошибка");
        }
        catch (Ex1 e) {  // Слишком общий блок ПЕРВЫМ
            System.out.println("Ex1");
        }
        catch (Ex3 e) {  // Этот блок никогда не выполнится - ошибка компиляции
            System.out.println("Ex3");
        }
        */
    }
    
    // Метод, выбрасывающий случайное исключение из иерархии
    static void throwRandomException() throws Ex1 {
        int random = (int) (Math.random() * 3);
        switch (random) {
            case 0: throw new Ex1("Исключение уровня 1");
            case 1: throw new Ex2("Исключение уровня 2");
            case 2: throw new Ex3("Исключение уровня 3");
            default: throw new Ex1("По умолчанию");
        }
    }
    
    // Метод, который может выбросить разные исключения
    static void validateInput(String input) {
        if (input == null) {
            throw new NullPointerException("Строка не может быть null");
        }
        if (input.length() < 3) {
            throw new IllegalArgumentException("Строка слишком короткая");
        }
    }
}
