package enums;

public class EnumInitializationExample {
    
    // Перечисление с инициализацией
    enum Planet {
        // Элементы с конструктором
        MERCURY(3.303e23, 2.4397e6),
        VENUS(4.869e24, 6.0518e6),
        EARTH(5.976e24, 6.3781e6),
        MARS(6.421e23, 3.3972e6),
        JUPITER(1.9e27, 7.1492e7),
        SATURN(5.688e26, 6.0268e7),
        URANUS(8.686e25, 2.5559e7),
        NEPTUNE(1.024e26, 2.4746e7);
        
        // Поля перечисления
        private final double mass;   // в килограммах
        private final double radius; // в метрах
        private final double surfaceGravity; // вычисляемое поле
        
        // Константа
        private static final double G = 6.67300E-11;
        
        // Конструктор перечисления (приватный по умолчанию)
        Planet(double mass, double radius) {
            this.mass = mass;
            this.radius = radius;
            this.surfaceGravity = G * mass / (radius * radius);
        }
        
        // Методы доступа
        public double getMass() { return mass; }
        public double getRadius() { return radius; }
        public double getSurfaceGravity() { return surfaceGravity; }
        
        // Метод для вычисления веса на планете
        public double surfaceWeight(double otherMass) {
            return otherMass * surfaceGravity;
        }
    }
    
    // Перечисление с разными типами инициализации
    enum HttpStatus {
        // Элементы с кодом и сообщением
        OK(200, "OK"),
        CREATED(201, "Created"),
        BAD_REQUEST(400, "Bad Request"),
        UNAUTHORIZED(401, "Unauthorized"),
        NOT_FOUND(404, "Not Found"),
        INTERNAL_SERVER_ERROR(500, "Internal Server Error");
        
        private final int code;
        private final String message;
        
        HttpStatus(int code, String message) {
            this.code = code;
            this.message = message;
        }
        
        public int getCode() { return code; }
        public String getMessage() { return message; }
        
        // Метод для поиска по коду
        public static HttpStatus findByCode(int code) {
            for (HttpStatus status : values()) {
                if (status.code == code) {
                    return status;
                }
            }
            return null;
        }
    }
    
    // Перечисление с абстрактным методом
    enum Operation {
        PLUS("+") {
            public double apply(double x, double y) { return x + y; }
        },
        MINUS("-") {
            public double apply(double x, double y) { return x - y; }
        },
        TIMES("*") {
            public double apply(double x, double y) { return x * y; }
        },
        DIVIDE("/") {
            public double apply(double x, double y) { return x / y; }
        };
        
        private final String symbol;
        
        Operation(String symbol) {
            this.symbol = symbol;
        }
        
        // Абстрактный метод
        public abstract double apply(double x, double y);
        
        @Override
        public String toString() {
            return symbol;
        }
    }
    
    // Перечисление с ленивой инициализацией
    enum Database {
        MYSQL("jdbc:mysql://localhost:3306/test"),
        POSTGRESQL("jdbc:postgresql://localhost:5432/test"),
        ORACLE("jdbc:oracle:thin:@localhost:1521:xe");
        
        private final String url;
        private String connection; // Лениво инициализируемое поле
        
        Database(String url) {
            this.url = url;
        }
        
        public String getUrl() {
            return url;
        }
        
        public String getConnection() {
            if (connection == null) {
                // Ленивая инициализация
                connection = "Connected to " + name() + " at " + url;
                System.out.println("Инициализировано соединение для " + name());
            }
            return connection;
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Инициализация перечисления Planet ===");
        double earthWeight = 70; // кг
        double mass = earthWeight / Planet.EARTH.getSurfaceGravity();
        
        for (Planet p : Planet.values()) {
            System.out.printf("Вес на %s: %.2f кг%n", 
                p.name(), p.surfaceWeight(mass));
        }
        
        System.out.println("\n=== Инициализация перечисления HttpStatus ===");
        System.out.println("Статус 404: " + HttpStatus.NOT_FOUND.getMessage());
        System.out.println("Поиск по коду 200: " + HttpStatus.findByCode(200));
        
        System.out.println("\n=== Перечисление с абстрактным методом ===");
        double x = 10, y = 5;
        for (Operation op : Operation.values()) {
            System.out.printf("%.1f %s %.1f = %.1f%n", 
                x, op, y, op.apply(x, y));
        }
        
        System.out.println("\n=== Ленивая инициализация Database ===");
        System.out.println(Database.MYSQL.getConnection());
        System.out.println(Database.MYSQL.getConnection()); // Второй раз - из кэша
        
        System.out.println("\n=== Дополнительные возможности ===");
        // ordinal() и name()
        System.out.println("Порядковый номер EARTH: " + Planet.EARTH.ordinal());
        System.out.println("Имя константы: " + Planet.EARTH.name());
        
        // valueOf()
        Planet p = Planet.valueOf("MARS");
        System.out.println("Найденная планета: " + p);
    }
}