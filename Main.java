// Класс, вложенный в интерфейс
interface Network {
    void connect();
    
    // Вложенный класс (неявно public static)
    class DefaultConnection {
        public static void testConnection() {
            System.out.println("Testing connection...");
        }
        
        public void showInfo() {
            System.out.println("Default connection info");
        }
    }
}

// Использование
public class Main {
    public static void main(String[] args) {
        // Вызов статического метода
        Network.DefaultConnection.testConnection();
        
        // Создание экземпляра
        Network.DefaultConnection conn = new Network.DefaultConnection();
        conn.showInfo();
        
        // Реализация интерфейса с использованием вложенного класса
        Network myNetwork = new Network() {
            @Override
            public void connect() {
                Network.DefaultConnection.testConnection();
                System.out.println("Connected!");
            }
        };
        myNetwork.connect();
    }
}
