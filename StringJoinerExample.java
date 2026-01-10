import java.util.StringJoiner;

public class StringJoinerExample {
    public static void main(String[] args) {
        // 1. Простое объединение с разделителем
        StringJoiner sj1 = new StringJoiner(", ");
        sj1.add("Apple").add("Banana").add("Orange");
        System.out.println(sj1); // Apple, Banana, Orange
        
        // 2. С префиксом и суффиксом
        StringJoiner sj2 = new StringJoiner(", ", "[", "]");
        sj2.add("Java").add("Python").add("C++");
        System.out.println(sj2); // [Java, Python, C++]
        
        // 3. Пустой StringJoiner с дефолтным значением
        StringJoiner sj3 = new StringJoiner("|");
        sj3.setEmptyValue("Нет данных");
        System.out.println(sj3); // Нет данных
        sj3.add("Один");
        System.out.println(sj3); // Один
        
        // 4. Объединение двух StringJoiner
        StringJoiner sj4 = new StringJoiner(", ", "Ученики: ", ".");
        sj4.add("Анна").add("Петр");
        
        StringJoiner sj5 = new StringJoiner(" и ", "Преподаватели: ", ".");
        sj5.add("Иван Иванович");
        
        sj4.merge(sj5);
        System.out.println(sj4); // Ученики: Анна, Петр, Преподаватели: Иван Иванович.
        
        // 5. Использование в Stream API
        StringJoiner sj6 = new StringJoiner("; ");
        for (String s : new String[]{"1", "2", "3"}) {
            sj6.add(s);
        }
        System.out.println("CSV: " + sj6); // CSV: 1; 2; 3
    }
}
