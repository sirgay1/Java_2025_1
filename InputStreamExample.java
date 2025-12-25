import java.io.*;

public class InputStreamExample {
    public static void main(String[] args) {
        // 1. Чтение из массива байтов (ByteArrayInputStream)
        byte[] data = "Hello, InputStream!".getBytes();
        
        try (ByteArrayInputStream bis = new ByteArrayInputStream(data)) {
            
            // Способ 1: read() - читает один байт (0-255) или -1 если конец
            System.out.println("=== read() по одному байту ===");
            int byteValue;
            while ((byteValue = bis.read()) != -1) {
                System.out.print((char) byteValue);  // Преобразуем в символ
            }
            System.out.println();
            
            // Создаем новый поток (старый уже прочитан)
            bis.reset();  // Возвращаемся в начало
            
            // Способ 2: read(byte[] buffer) - читает в массив, возвращает кол-во байт
            System.out.println("\n=== read(byte[]) ===");
            byte[] buffer = new byte[10];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                System.out.println("Прочитано " + bytesRead + " байт: " 
                                 + new String(buffer, 0, bytesRead));
            }
            
            // Еще раз сброс
            bis.reset();
            
            // Способ 3: read(byte[] buffer, int offset, int length)
            System.out.println("\n=== read(byte[], offset, length) ===");
            byte[] bigBuffer = new byte[20];
            int totalRead = 0;
            
            // Читаем частями по 5 байт
            while (true) {
                int count = bis.read(bigBuffer, totalRead, 5);
                if (count == -1) break;
                totalRead += count;
                System.out.println("Добавили " + count + " байт, всего: " + totalRead);
            }
            System.out.println("Итог: " + new String(bigBuffer, 0, totalRead));
            
            // 2. Работа с FileInputStream
            System.out.println("\n=== FileInputStream ===");
            try (FileInputStream fis = new FileInputStream("test.txt")) {
                // Проверяем доступное количество байт
                System.out.println("Доступно: " + fis.available() + " байт");
                
                // Пропускаем первые 5 байт
                fis.skip(5);
                
                // Читаем оставшееся
                byte[] fileBuffer = new byte[100];
                int fileBytes = fis.read(fileBuffer);
                if (fileBytes != -1) {
                    System.out.println("Из файла: " + new String(fileBuffer, 0, fileBytes));
                }
            } catch (FileNotFoundException e) {
                System.out.println("Файл не найден, создаем пример...");
                // Создаем тестовый файл для демонстрации
                try (FileOutputStream fos = new FileOutputStream("test.txt")) {
                    fos.write("Пример текста в файле".getBytes());
                }
            }
            
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e.getMessage());
        }
        
        // 3. Демонстрация маркировки и возврата
        System.out.println("\n=== mark() и reset() ===");
        ByteArrayInputStream bis2 = new ByteArrayInputStream("ABCDEFGHIJKLMNOP".getBytes());
        
        // Читаем 5 байт
        for (int i = 0; i < 5; i++) {
            System.out.print((char) bis2.read());
        }
        
        // Ставим метку (поддерживается ли?)
        if (bis2.markSupported()) {
            bis2.mark(10);  // 10 - максимальное количество байт, которые можно прочитать до reset
            
            // Читаем еще 5 байт
            System.out.print(" [");
            for (int i = 0; i < 5; i++) {
                System.out.print((char) bis2.read());
            }
            System.out.print("] ");
            
            // Возвращаемся к метке
            bis2.reset();
            
            // Читаем снова с метки
            for (int i = 0; i < 5; i++) {
                System.out.print((char) bis2.read());
            }
        }
        
        
    }
}
