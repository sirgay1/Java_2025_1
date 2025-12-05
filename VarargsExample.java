package var_args;

public class VarargsExample {
    
    // 1. Базовый пример с varargs
    public static int sum(int... numbers) {
        int total = 0;
        for (int num : numbers) {
            total += num;
        }
        return total;
    }
    
    // 2. Перегрузка varargs метода
    public static String concatenate(String... strings) {
        StringBuilder sb = new StringBuilder();
        for (String str : strings) {
            sb.append(str);
        }
        return sb.toString();
    }
    
    // Перегрузка с разным количеством обычных параметров
    public static String concatenate(String delimiter, String... strings) {
        if (strings.length == 0) return "";
        
        StringBuilder sb = new StringBuilder(strings[0]);
        for (int i = 1; i < strings.length; i++) {
            sb.append(delimiter).append(strings[i]);
        }
        return sb.toString();
    }
    
    // 3. Перегрузка с разными типами varargs
    public static void printAll(String... strings) {
        System.out.print("Strings: ");
        for (String s : strings) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
    
    public static void printAll(int... numbers) {
        System.out.print("Integers: ");
        for (int n : numbers) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
    
    // 4. Комбинация обычных параметров и varargs
    public static void printInfo(String prefix, Object... items) {
        System.out.print(prefix + ": ");
        for (Object item : items) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
    
    // 5. Конфликт перегрузки - что будет вызвано?
    public static void test(int a, int b) {
        System.out.println("Два int: " + a + ", " + b);
    }
    
    public static void test(int... numbers) {
        System.out.print("Varargs int: ");
        for (int n : numbers) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
    
    // 6. Varargs с generic типами
    @SafeVarargs
    public static <T> void printArray(T... array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
    
    // 7. Метод без параметров vs varargs с 0 параметров
    public static void empty() {
        System.out.println("Метод без параметров");
    }
    
    public static void empty(String... strings) {
        System.out.println("Varargs метод с " + strings.length + " строками");
    }
    
    // ========== Main метод ==========
    public static void main(String[] args) {
        // 1. Базовый varargs
        System.out.println("Сумма: " + sum(1, 2, 3));
        System.out.println("Сумма: " + sum(10, 20, 30, 40, 50));
        System.out.println("Сумма: " + sum()); // 0 параметров
        
        // 2. Перегрузка varargs
        System.out.println("\nКонкатенация: " + concatenate("A", "B", "C"));
        System.out.println("Конкатенация с разделителем: " + 
                          concatenate(", ", "Java", "Python", "C++"));
        
        // 3. Разные типы varargs
        printAll("Hello", "World");
        printAll(1, 2, 3, 4, 5);
        
        // 4. Комбинация параметров
        printInfo("Числа", 1, 2.5, 3.7f);
        printInfo("Смешанные", "Text", 42, true);
        
        // 5. Конфликт перегрузки
        test(1, 2);       // Вызовет test(int, int) - более специфичный
        test(1, 2, 3);    // Вызовет test(int...)
        test(new int[]{1, 2}); // Вызовет test(int...)
        
        // 6. Generic varargs
        printArray("A", "B", "C");
        printArray(1, 2, 3);
        
        // 7. Метод без параметров vs varargs
        empty();           // Вызовет empty() - более специфичный
        empty(new String[0]); // Вызовет empty(String...)
        
        // 8. Передача массива как varargs
        int[] arr = {10, 20, 30};
        // sum(arr); // ОШИБКА! Массив не развернется автоматически
        System.out.println("Сумма массива: " + sum(arr[0], arr[1], arr[2]));
        
        String[] strArr = {"X", "Y", "Z"};
        printAll(strArr); // Массив String[] передается как varargs
    }
}