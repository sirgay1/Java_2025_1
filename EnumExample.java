public class EnumExample {
    
    // Перечисление дней недели с дополнительным функционалом
    enum DayOfWeek {
        MONDAY("Понедельник", false, 1),
        TUESDAY("Вторник", false, 2),
        WEDNESDAY("Среда", false, 3),
        THURSDAY("Четверг", false, 4),
        FRIDAY("Пятница", false, 5),
        SATURDAY("Суббота", true, 6),
        SUNDAY("Воскресенье", true, 7);
        
        private final String russianName;
        private final boolean isWeekend;
        private final int order;
        
        DayOfWeek(String russianName, boolean isWeekend, int order) {
            this.russianName = russianName;
            this.isWeekend = isWeekend;
            this.order = order;
        }
        
        // Дополнительный метод: проверка на выходной
        public boolean isWeekend() {
            return isWeekend;
        }
        
        // Дополнительный метод: получение русского названия
        public String getRussianName() {
            return russianName;
        }
        
        // Дополнительный метод: получение следующего дня
        public DayOfWeek nextDay() {
            int nextIndex = (this.ordinal() + 1) % values().length;
            return values()[nextIndex];
        }
        
        // Дополнительный метод: получение по русскому названию
        public static DayOfWeek fromRussianName(String name) {
            for (DayOfWeek day : values()) {
                if (day.russianName.equalsIgnoreCase(name)) {
                    return day;
                }
            }
            throw new IllegalArgumentException("Неизвестный день: " + name);
        }
    }
    
    // Второй пример: перечисление валют
    enum Currency {
        USD("Доллар США", 1.0, "$"),
        EUR("Евро", 0.85, "€"),
        RUB("Российский рубль", 73.5, "₽"),
        JPY("Японская иена", 110.0, "¥");
        
        private final String description;
        private final double rateToUSD;
        private final String symbol;
        
        Currency(String description, double rateToUSD, String symbol) {
            this.description = description;
            this.rateToUSD = rateToUSD;
            this.symbol = symbol;
        }
        
        // Метод конвертации валюты
        public double convertTo(Currency target, double amount) {
            return amount * (this.rateToUSD / target.rateToUSD);
        }
        
        // Метод форматирования суммы
        public String format(double amount) {
            return String.format("%s %.2f", symbol, amount);
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Пример 1: Дни недели");
        DayOfWeek today = DayOfWeek.MONDAY;
        System.out.println("Сегодня: " + today.getRussianName());
        System.out.println("Выходной? " + today.isWeekend());
        System.out.println("Завтра: " + today.nextDay().getRussianName());
        System.out.println("Из русского названия: " + DayOfWeek.fromRussianName("Среда"));
        
        System.out.println("\nПример 2: Валюты");
        Currency usd = Currency.USD;
        Currency eur = Currency.EUR;
        double amount = 100.0;
        System.out.println(usd.format(amount) + " = " + 
                          eur.format(usd.convertTo(eur, amount)));
    }
}
