// 1. Свой класс, реализующий AutoCloseable
class DatabaseConnection implements AutoCloseable {
    private String connectionId;
    private boolean isOpen;
    
    public DatabaseConnection(String id) {
        this.connectionId = id;
        this.isOpen = true;
        System.out.println("Открыто соединение: " + id);
    }
    
    public void query(String sql) {
        if (!isOpen) throw new IllegalStateException("Соединение закрыто!");
        System.out.println("Выполняем запрос: " + sql);
    }
    
    @Override
    public void close() {  // Вызывается автоматически
        if (isOpen) {
            isOpen = false;
            System.out.println("Закрыто соединение: " + connectionId);
        }
    }
}

// 2. Другой ресурс
class FileLogger implements AutoCloseable {
    private String filename;
    
    public FileLogger(String name) {
        this.filename = name;
        System.out.println("Открыт лог-файл: " + name);
    }
    
    public void log(String message) {
        System.out.println("LOG[" + filename + "]: " + message);
    }
    
    @Override
    public void close() {
        System.out.println("Файл " + filename + " сохранён и закрыт");
    }
}

// 3. Пример использования
public class AutoCloseableDemo {
    public static void main(String[] args) {
        
        // БЕЗ try-with-resources (старый способ)
        System.out.println("=== Старый способ ===");
        DatabaseConnection conn1 = null;
        try {
            conn1 = new DatabaseConnection("DB-1");
            conn1.query("SELECT * FROM users");
            // Может быть исключение...
            throw new RuntimeException("Ошибка в запросе!");
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            if (conn1 != null) {
                conn1.close();  // Закрываем вручную
            }
        }
        
        // С try-with-resources (Java 7+)
        System.out.println("\n=== try-with-resources ===");
        try (DatabaseConnection conn2 = new DatabaseConnection("DB-2")) {
            conn2.query("SELECT * FROM products");
            // Не нужно явно закрывать - close() вызовется автоматически
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }  // conn2.close() вызывается здесь автоматически!
        
        // Несколько ресурсов
        System.out.println("\n=== Несколько ресурсов ===");
        try (DatabaseConnection conn3 = new DatabaseConnection("DB-3");
             FileLogger logger = new FileLogger("app.log")) {
            
            conn3.query("BEGIN TRANSACTION");
            logger.log("Начало транзакции");
            
            // Ресурсы закрываются в обратном порядке создания
            // Сначала logger.close(), потом conn3.close()
            
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        
        // 4. Подавленные исключения
        System.out.println("\n=== Подавленные исключения ===");
        try (FailingResource res = new FailingResource()) {
            throw new RuntimeException("Исключение в try-блоке");
        } catch (Exception e) {
            System.out.println("Поймано: " + e.getMessage());
            
            // Получаем подавленные исключения (из close())
            Throwable[] suppressed = e.getSuppressed();
            for (Throwable t : suppressed) {
                System.out.println("Подавлено: " + t.getMessage());
            }
        }
    }
}

// Ресурс, который выбрасывает исключение в close()
class FailingResource implements AutoCloseable {
    public FailingResource() {
        System.out.println("Ресурс создан");
    }
    
    @Override
    public void close() throws Exception {
        System.out.println("Закрываем ресурс...");
        throw new IllegalStateException("Ошибка при закрытии!");
    }
}

// 5. Реальный пример с файлами
class RealWorldExample {
    public static void main(String[] args) {
        // Чтение файла с автоматическим закрытием
        try (java.io.BufferedReader reader = 
                new java.io.BufferedReader(
                    new java.io.FileReader("data.txt"))) {
            
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            
        } catch (java.io.IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }
        // reader.close() вызван автоматически, даже если было исключение
    }
}
