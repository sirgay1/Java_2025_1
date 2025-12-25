import java.io.*;

public class OutputStreamExample {
    public static void main(String[] args) {
        
        // 1. ByteArrayOutputStream - пишем в массив байтов в памяти
        System.out.println("=== ByteArrayOutputStream ===");
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            
            // write(int b) - пишет один байт (младшие 8 бит int)
            baos.write(72);    // 'H' - ASCII код
            baos.write(101);   // 'e'
            baos.write(108);   // 'l'
            baos.write(108);   // 'l'
            baos.write(111);   // 'o'
            baos.write(32);    // пробел
            baos.write(87);    // 'W'
            baos.write(111);   // 'o'
            baos.write(114);   // 'r'
            baos.write(108);   // 'l'
            baos.write(100);   // 'd'
            baos.write(33);    // '!'
            baos.write(10);    // '\n' - новая строка
            
            // Преобразуем записанные данные в строку
            String result = baos.toString();
            System.out.println("Записано: " + result);
            
            // Получаем массив байтов
            byte[] bytes = baos.toByteArray();
            System.out.print("Байты: ");
            for (byte b : bytes) {
                System.out.print(b + " ");
            }
            System.out.println();
            
            // 2. write(int) с русскими символами (кодировка важна!)
            System.out.println("\n=== С русскими символами ===");
            ByteArrayOutputStream baos2 = new ByteArrayOutputStream();
            String russian = "Привет";
            byte[] russianBytes = russian.getBytes("UTF-8");
            
            // Пишем каждый байт через write(int)
            for (int i = 0; i < russianBytes.length; i++) {
                // Байт преобразуется в int с сохранением значения
                baos2.write(russianBytes[i] & 0xFF); // Важно: & 0xFF для unsigned
            }
            System.out.println("Результат: " + baos2.toString("UTF-8"));
            baos2.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // 3. FileOutputStream - пишем в файл
        System.out.println("\n=== FileOutputStream ===");
        try (FileOutputStream fos = new FileOutputStream("output.txt")) {
            
            // Пишем ASCII-коды символов
            fos.write(84);  // 'T'
            fos.write(101); // 'e'
            fos.write(115); // 's'
            fos.write(116); // 't'
            fos.write(10);  // '\n'
            
            // Пишем числа как байты
            for (int i = 48; i <= 57; i++) { // ASCII '0'-'9'
                fos.write(i);
            }
            fos.write(10);
            
            // Пишем байты из массива
            byte[] data = {65, 66, 67, 68, 69}; // A, B, C, D, E
            for (byte b : data) {
                fos.write(b); // автоматическое преобразование byte → int
            }
            
            System.out.println("Данные записаны в output.txt");
            
            // Читаем и выводим содержимое файла
            System.out.println("Содержимое файла:");
            try (FileInputStream fis = new FileInputStream("output.txt")) {
                int byteValue;
                while ((byteValue = fis.read()) != -1) {
                    System.out.print((char) byteValue);
                }
            }
            
        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        
        // 4. BufferedOutputStream - с буферизацией
        System.out.println("\n=== BufferedOutputStream ===");
        try (BufferedOutputStream bos = new BufferedOutputStream(
                new FileOutputStream("buffered.txt"), 10)) { // буфер 10 байт
            
            // Пишем побайтно, но реальная запись в файл происходит при заполнении буфера
            for (int i = 65; i < 80; i++) { // A-O
                bos.write(i);
                System.out.println("Записан байт: " + i + " ('" + (char)i + "')");
            }
            
            // flush() принудительно записывает буфер
            bos.flush();
            System.out.println("Буфер сброшен");
            
            // Еще запись
            bos.write(90); // Z
            // При закрытии автоматически вызывается flush()
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // 5. System.out - тоже OutputStream
        System.out.println("\n=== System.out (PrintStream) ===");
        System.out.write(65);  // 'A'
        System.out.write(10);  // '\n'
        System.out.flush();    // Важно: буферизованный поток
        
        // 6. Демонстрация преобразования int в byte
        System.out.println("\n=== Преобразование int в byte ===");
        ByteArrayOutputStream demo = new ByteArrayOutputStream();
        
        // write(int b) берет только младшие 8 бит (0-255)
        demo.write(300);  // 300 в двоичном: 00000001 00101100
                          // берутся младшие 8 бит: 00101100 = 44 = ','
        demo.write(-1);   // -1 в двоичном: 11111111 11111111 11111111 11111111
                          // младшие 8 бит: 11111111 = 255 (но byte: -1)
        
        byte[] demoBytes = demo.toByteArray();
        System.out.println("300 → byte: " + demoBytes[0] + " (int: " + (demoBytes[0] & 0xFF) + ")");
        System.out.println("-1 → byte: " + demoBytes[1] + " (int: " + (demoBytes[1] & 0xFF) + ")");
        System.out.println("Как символы: '" + (char)(demoBytes[0] & 0xFF) + "' '" + (char)(demoBytes[1] & 0xFF) + "'");
        
        
    }
}
