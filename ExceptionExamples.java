public class ExceptionExamples {
    public static void main(String[] args) {
        System.out.println("=== 1. ArithmeticException ===");
        try {
            int a = 10;
            int b = 0;
            int result = a / b;  // Деление на ноль
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println("\n=== 2. ArrayIndexOutOfBoundsException ===");
        try {
            int[] arr = {1, 2, 3};
            System.out.println(arr[5]);  // Индекс за пределами массива
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Неверный индекс: " + e.getMessage());
        }

        System.out.println("\n=== 3. IllegalArgumentException ===");
        try {
            setAge(-5);  // Передаем некорректный аргумент
        } catch (IllegalArgumentException e) {
            System.out.println("Некорректный аргумент: " + e.getMessage());
        }

        System.out.println("\n=== 4. ClassCastException ===");
        try {
            Object obj = "String";
            Integer num = (Integer) obj;  // Неверное приведение типа
        } catch (ClassCastException e) {
            System.out.println("Ошибка приведения типа: " + e.getMessage());
        }

        System.out.println("\n=== 5. NullPointerException ===");
        try {
            String text = null;
            System.out.println(text.length());  // Вызов метода у null
        } catch (NullPointerException e) {
            System.out.println("Работа с null ссылкой: " + e.getMessage());
        }

        System.out.println("\n=== Комбинированный пример ===");
        try {
            processData(null, 0);
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println("Обнаружена ошибка: " + e.getClass().getSimpleName());
        }
    }

    // Метод, генерирующий IllegalArgumentException
    static void setAge(int age) {
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException("Возраст должен быть от 0 до 150");
        }
        System.out.println("Возраст установлен: " + age);
    }

    // Метод с несколькими возможными исключениями
    static void processData(String data, int divisor) {
        if (data == null) {
            throw new NullPointerException("Данные не могут быть null");
        }
        if (divisor == 0) {
            throw new IllegalArgumentException("Делитель не может быть 0");
        }
        System.out.println("Результат: " + data.length() / divisor);
    }
}
