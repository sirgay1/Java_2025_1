package cycles;

public class InfiniteLoopsExample {
    public static void main(String[] args) {
        System.out.println("ПРИМЕРЫ БЕСКОНЕЧНЫХ ЦИКЛОВ\n");
        
        System.out.println("1. БЕСКОНЕЧНЫЙ ЦИКЛ WHILE:");
        
        // Пример 1.1: Самый простой бесконечный while
        System.out.println("   Пример 1.1: while(true)");
        int counter1 = 0;
        while (true) {
            counter1++;
            System.out.println("      Итерация: " + counter1);
            if (counter1 >= 3) {
                System.out.println("      Прерываем после 3 итераций");
                break; // Прерываем, чтобы программа не зависала
            }
        }
        
        // Пример 1.2: while с условием, которое всегда true
        System.out.println("\n   Пример 1.2: while(1 == 1)");
        int counter2 = 0;
        while (1 == 1) {
            counter2++;
            System.out.println("      Итерация: " + counter2);
            if (counter2 >= 3) {
                System.out.println("      Прерываем после 3 итераций");
                break;
            }
        }
        
        // Пример 1.3: while с переменной, которую никогда не меняем
        System.out.println("\n   Пример 1.3: while(flag) где flag всегда true");
        boolean flag = true;
        int counter3 = 0;
        while (flag) {
            counter3++;
            System.out.println("      Итерация: " + counter3);
            if (counter3 >= 3) {
                flag = false; // Меняем флаг, чтобы выйти
                System.out.println("      Меняем флаг на false");
            }
        }
        
        System.out.println("\n2. БЕСКОНЕЧНЫЙ ЦИКЛ DO-WHILE:");
        
        // Пример 2.1: Самый простой бесконечный do-while
        System.out.println("   Пример 2.1: do {...} while(true)");
        int counter4 = 0;
        do {
            counter4++;
            System.out.println("      Итерация: " + counter4);
            if (counter4 >= 3) {
                System.out.println("      Прерываем после 3 итераций");
                break;
            }
        } while (true);
        
        // Пример 2.2: do-while с условием 2 > 1
        System.out.println("\n   Пример 2.2: do {...} while(2 > 1)");
        int counter5 = 0;
        do {
            counter5++;
            System.out.println("      Итерация: " + counter5);
            if (counter5 >= 3) {
                System.out.println("      Прерываем после 3 итераций");
                break;
            }
        } while (2 > 1);
        
        // Пример 2.3: do-while с переменной, которая всегда true
        System.out.println("\n   Пример 2.3: do {...} while(alwaysTrue)");
        boolean alwaysTrue = true;
        int counter6 = 0;
        do {
            counter6++;
            System.out.println("      Итерация: " + counter6);
            if (counter6 >= 3) {
                alwaysTrue = false; // Меняем условие
                System.out.println("      Меняем alwaysTrue на false");
            }
        } while (alwaysTrue);
        
        System.out.println("\n3. РАЗНИЦА МЕЖДУ WHILE И DO-WHILE:");
        
        // Демонстрация разницы
        System.out.println("   while - проверка условия ДО выполнения:");
        int whileCounter = 0;
        while (whileCounter > 0) { // Условие false с самого начала
            System.out.println("      Это никогда не выполнится");
        }
        System.out.println("      Цикл while не выполнился ни разу");
        
        System.out.println("\n   do-while - проверка условия ПОСЛЕ выполнения:");
        int doWhileCounter = 0;
        do {
            System.out.println("      do-while выполнился 1 раз, даже если условие false");
            doWhileCounter++;
        } while (doWhileCounter > 1); // Условие false после первой итерации
        
        System.out.println("\n4. ПРАКТИЧЕСКИЕ ПРИМЕРЫ БЕСКОНЕЧНЫХ ЦИКЛОВ:");
        
        // Пример 4.1: Меню программы
        System.out.println("   Пример 4.1: Меню программы (упрощенный вариант)");
        int menuChoice = 0;
        while (true) {
            menuChoice++;
            System.out.println("      Показано меню (итерация " + menuChoice + ")");
            if (menuChoice >= 2) {
                System.out.println("      Пользователь выбрал 'Выход'");
                break;
            }
        }
        
        // Пример 4.2: Ожидание события
        System.out.println("\n   Пример 4.2: Ожидание события");
        boolean eventHappened = false;
        int waitCounter = 0;
        while (!eventHappened) {
            waitCounter++;
            System.out.println("      Ожидание... (" + waitCounter + ")");
            if (waitCounter >= 3) {
                eventHappened = true;
                System.out.println("      Событие произошло!");
            }
        }
        
        // Пример 4.3: Обработка в реальном времени (имитация)
        System.out.println("\n   Пример 4.3: Обработка в реальном времени");
        int sensorValue = 0;
        do {
            sensorValue++;
            System.out.println("      Получены данные с датчика: " + sensorValue);
            if (sensorValue >= 3) {
                System.out.println("      Система остановлена");
                break;
            }
        } while (true);
        

    }
}
