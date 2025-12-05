package docs;

/**
 * Класс для вычисления факториала чисел.
 * <p>
 * Этот класс предоставляет метод для вычисления факториала
 * неотрицательных целых чисел.
 * </p>
 * 
 * @author Программист
 * @version 1.0
 * @since 2025
 * @see <a href="https://ru.wikipedia.org/wiki/Факториал">Факториал в Википедии</a>
 */
public class FactorialDocs {
    
    /**
     * Вычисляет факториал заданного целого неотрицательного числа.
     * <p>
     * Факториал неотрицательного целого числа n, обозначаемый n!,
     * является произведением всех положительных целых чисел,
     * меньших или равных n. По определению, 0! = 1.
     * </p>
     *
     * @param n число, факториал которого требуется вычислить.
     *          Должно быть неотрицательным.
     * @return факториал числа {@code n}.
     * @throws IllegalArgumentException если {@code n} является отрицательным числом.
     * @see <a href="https://en.wikipedia.org/wiki/Factorial">Factorial on Wikipedia</a>
     */
    public long calculateFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Число не должно быть отрицательным: " + n);
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    
    /**
     * Основной метод для демонстрации работы класса.
     * 
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        FactorialDocs factorial = new FactorialDocs();
        
        try {
            System.out.println("Демонстрация вычисления факториала:");
            System.out.println("Факториал 0 = " + factorial.calculateFactorial(0));
            System.out.println("Факториал 1 = " + factorial.calculateFactorial(1));
            System.out.println("Факториал 5 = " + factorial.calculateFactorial(5));
            System.out.println("Факториал 10 = " + factorial.calculateFactorial(10));
            
            // Вызов с отрицательным числом вызовет исключение
            System.out.println("Факториал -5 = " + factorial.calculateFactorial(-5));
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}