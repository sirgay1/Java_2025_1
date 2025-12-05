package cycles;

public class BreakContinueExample {
    public static void main(String[] args) {
        System.out.println("Поиск первого чётного числа, кратного 5, от 1 до 20, но пропускаем числа кратные 3:");
        
        for (int i = 1; i <= 20; i++) {
            
            // continue - пропускаем числа, кратные 3
            if (i % 3 == 0) {
                System.out.println("Пропускаем число " + i + " (кратно 3)");
                continue;
            }
            
            System.out.println("Проверяем число: " + i);
            
            // break - находим первое чётное число, кратное 5
            if (i % 2 == 0 && i % 5 == 0) {
                System.out.println("Найдено первое подходящее число: " + i);
                System.out.println("Прерываем цикл.");
                break;
            }
        }
        
        System.out.println("Цикл завершён.");
    }
}