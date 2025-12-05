/**
 * Демонстрация 10 методов StringBuffer и StringBuilder
 * StringBuilder - быстрее, не потокобезопасен (используется по умолчанию)
 * StringBuffer - потокобезопасен, медленнее из-за синхронизации
 */
public class BufferBuilderDemo {
    public static void main(String[] args) {
        // 1. append() - добавляет строку в конец
        StringBuilder sb1 = new StringBuilder("Hello");
        sb1.append(" World");
        System.out.println("1. append(): " + sb1); // Hello World
        
        // 2. insert() - вставляет строку в указанную позицию
        StringBuilder sb2 = new StringBuilder("Java Programming");
        sb2.insert(5, "is ");
        System.out.println("2. insert(): " + sb2); // Java is Programming
        
        // 3. delete() - удаляет символы с start до end-1
        StringBuffer sb3 = new StringBuffer("abcdefghijk");
        sb3.delete(2, 5); // Удаляет символы с индексом 2,3,4
        System.out.println("3. delete(): " + sb3); // abfghijk
        
        // 4. reverse() - переворачивает строку
        StringBuilder sb4 = new StringBuilder("ABCDEF");
        sb4.reverse();
        System.out.println("4. reverse(): " + sb4); // FEDCBA
        
        // 5. replace() - заменяет часть строки
        StringBuffer sb5 = new StringBuffer("I like apples");
        sb5.replace(7, 13, "oranges");
        System.out.println("5. replace(): " + sb5); // I like oranges
        
        // 6. capacity() - возвращает текущую вместимость буфера
        StringBuilder sb6 = new StringBuilder();
        System.out.println("6. capacity(): " + sb6.capacity()); // 16 (по умолчанию)
        sb6.append("This is a very long string that exceeds default capacity");
        System.out.println("   capacity after append: " + sb6.capacity()); // 70
        
        // 7. ensureCapacity() - гарантирует минимальную вместимость
        StringBuffer sb7 = new StringBuffer();
        sb7.ensureCapacity(100);
        System.out.println("7. ensureCapacity(100): " + sb7.capacity()); // 100
        
        // 8. setLength() - устанавливает длину строки
        StringBuilder sb8 = new StringBuilder("Hello World");
        sb8.setLength(5);
        System.out.println("8. setLength(5): " + sb8); // Hello
        sb8.setLength(10);
        System.out.println("   after setLength(10): '" + sb8 + "'"); // Hello     (с пробелами)
        
        // 9. charAt() и setCharAt() - получить/установить символ по индексу
        StringBuilder sb9 = new StringBuilder("JAVA");
        System.out.println("9. charAt(2): " + sb9.charAt(2)); // V
        sb9.setCharAt(2, 'v');
        System.out.println("   after setCharAt(2, 'v'): " + sb9); // JAvA
        
        // 10. substring() - получить подстроку
        StringBuffer sb10 = new StringBuffer("Hello Java Developers");
        String sub1 = sb10.substring(6); // с 6 индекса до конца
        String sub2 = sb10.substring(6, 10); // с 6 до 10-1
        System.out.println("10. substring(6): " + sub1); // Java Developers
        System.out.println("    substring(6, 10): " + sub2); // Java
        
        // Дополнительно: сравнение StringBuilder vs StringBuffer
        System.out.println("\n--- Сравнение производительности ---");
        long startTime, endTime;
        
        // StringBuilder (не потокобезопасен, быстрее)
        startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            sb.append(i);
        }
        endTime = System.nanoTime();
        System.out.println("StringBuilder time: " + (endTime - startTime) + " ns");
        
        // StringBuffer (потокобезопасен, медленнее)
        startTime = System.nanoTime();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < 100000; i++) {
            buffer.append(i);
        }
        endTime = System.nanoTime();
        System.out.println("StringBuffer time: " + (endTime - startTime) + " ns");
        
        // Когда использовать что:
        // - StringBuilder: однопоточные приложения, где важна скорость
        // - StringBuffer: многопоточные приложения, где нужна синхронизация
    }
}
