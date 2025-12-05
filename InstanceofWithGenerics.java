
import java.util.*;

public class InstanceofWithGenerics {
    public static void main(String[] args) {
        // 1. Проверка параметризованных коллекций
        List<String> stringList = new ArrayList<>();
        List<Integer> integerList = new LinkedList<>();
        Set<Double> doubleSet = new HashSet<>();
        
        System.out.println("1. Проверка параметризованных коллекций:");
        System.out.println("stringList instanceof List: " + (stringList instanceof List));
        System.out.println("stringList instanceof ArrayList: " + (stringList instanceof ArrayList));
        // НЕЛЬЗЯ: System.out.println(stringList instanceof List<String>); // Ошибка компиляции
        
        // 2. Проверка с generic-классами
        Box<String> stringBox = new Box<>("Hello");
        Box<Integer> intBox = new Box<>(42);
        
        System.out.println("\n2. Проверка generic-классов:");
        System.out.println("stringBox instanceof Box: " + (stringBox instanceof Box));
        System.out.println("intBox instanceof Box: " + (intBox instanceof Box));
        
        // 3. Проверка с кастингом
        Object obj1 = new ArrayList<String>();
        Object obj2 = "Not a list";
        
        System.out.println("\n3. Проверка с безопасным кастингом:");
        if (obj1 instanceof List) {
            List<?> list = (List<?>) obj1;
            System.out.println("obj1 - это List, размер: " + list.size());
        }
        
        // 4. Pattern matching (Java 16+)
        System.out.println("\n4. Pattern matching (Java 16+):");
        Object[] objects = { "Text", 123, new ArrayList<String>(), 45.6 };
        
        for (Object obj : objects) {
            if (obj instanceof List) {
                System.out.println("Найден List: " + obj.getClass().getSimpleName());
            } else if (obj instanceof String) {
                System.out.println("Найден String: " + obj);
            } else if (obj instanceof Integer) {
                System.out.println("Найден Integer: " + obj);
            }
        }
        
        // 5. Проверка с wildcard-типами
        List<?> wildcardList = Arrays.asList(1, 2, 3);
        System.out.println("\n5. Проверка с wildcard:");
        System.out.println("wildcardList instanceof List: " + (wildcardList instanceof List));
        
        // 6. Сравнение типов через getClass()
        System.out.println("\n6. Сравнение через getClass():");
        System.out.println("stringList.getClass() == integerList.getClass(): " + 
                          (stringList.getClass() == integerList.getClass())); // true
        System.out.println("stringList.getClass() == doubleSet.getClass(): " + 
                          (stringList.getClass() == doubleSet.getClass())); // false
    }
    
    // Generic класс для примера
    static class Box<T> {
        private T value;
        
        public Box(T value) {
            this.value = value;
        }
        
        public T getValue() {
            return value;
        }
    }
}