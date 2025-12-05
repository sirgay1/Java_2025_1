package operators;

public class OperatorsExamples {
    public static void main(String[] args) {
        System.out.println("ДЕМОНСТРАЦИЯ ОПЕРАТОРОВ JAVA\n");
        
        // Арифметические операторы
        System.out.println("АРИФМЕТИЧЕСКИЕ ОПЕРАТОРЫ");
        int numA = 15, numB = 4;
        System.out.println("numA = " + numA + ", numB = " + numB);
        System.out.println("Сложение: numA + numB = " + (numA + numB));
        System.out.println("Вычитание: numA - numB = " + (numA - numB));
        System.out.println("Умножение: numA * numB = " + (numA * numB));
        System.out.println("Деление: numA / numB = " + (numA / numB));
        System.out.println("Остаток: numA % numB = " + (numA % numB));
        
        // Операторы сравнения
        System.out.println("\nОПЕРАТОРЫ СРАВНЕНИЯ");
        System.out.println("Равно: numA == numB = " + (numA == numB));
        System.out.println("Не равно: numA != numB = " + (numA != numB));
        System.out.println("Больше: numA > numB = " + (numA > numB));
        System.out.println("Меньше: numA < numB = " + (numA < numB));
        System.out.println("Больше или равно: numA >= numB = " + (numA >= numB));
        System.out.println("Меньше или равно: numA <= numB = " + (numA <= numB));
        
        // Логические операторы
        System.out.println("\nЛОГИЧЕСКИЕ ОПЕРАТОРЫ");
        boolean condition1 = true, condition2 = false;
        System.out.println("И: condition1 && condition2 = " + (condition1 && condition2));
        System.out.println("ИЛИ: condition1 || condition2 = " + (condition1 || condition2));
        System.out.println("НЕ: !condition1 = " + (!condition1));
        
        // Побитовые операторы
        System.out.println("\nПОБИТОВЫЕ ОПЕРАТОРЫ");
        int bitNum1 = 9, bitNum2 = 5; // 1001 и 0101
        System.out.println("Побитовое И: " + bitNum1 + " & " + bitNum2 + " = " + (bitNum1 & bitNum2));
        System.out.println("Побитовое ИЛИ: " + bitNum1 + " | " + bitNum2 + " = " + (bitNum1 | bitNum2));
        System.out.println("Побитовое XOR: " + bitNum1 + " ^ " + bitNum2 + " = " + (bitNum1 ^ bitNum2));
        System.out.println("Побитовое НЕ: ~" + bitNum1 + " = " + (~bitNum1));
        
        // Операторы сдвига
        System.out.println("\nОПЕРАТОРЫ СДВИГА");
        int shiftNum = 8; // 1000 в двоичной
        System.out.println("Сдвиг влево: " + shiftNum + " << 1 = " + (shiftNum << 1));
        System.out.println("Сдвиг вправо: " + shiftNum + " >> 1 = " + (shiftNum >> 1));
        System.out.println("Беззнаковый сдвиг вправо: " + shiftNum + " >>> 1 = " + (shiftNum >>> 1));
        
        // Операторы присваивания
        System.out.println("\nОПЕРАТОРЫ ПРИСВАИВАНИЯ");
        int assignVar = 10;
        System.out.println("Начальное значение: " + assignVar);
        assignVar += 5;
        System.out.println("После += 5: " + assignVar);
        assignVar -= 3;
        System.out.println("После -= 3: " + assignVar);
        assignVar *= 2;
        System.out.println("После *= 2: " + assignVar);
        assignVar /= 4;
        System.out.println("После /= 4: " + assignVar);
        
        // Унарные операторы
        System.out.println("\nУНАРНЫЕ ОПЕРАТОРЫ");
        int unaryVar = 7;
        System.out.println("Префиксный инкремент: ++unaryVar = " + (++unaryVar));
        System.out.println("Постфиксный декремент: unaryVar-- = " + (unaryVar--));
        System.out.println("После операций: unaryVar = " + unaryVar);
        
        // Тернарный оператор
        System.out.println("\nТЕРНАРНЫЙ ОПЕРАТОР");
        int age = 18;
        String status = (age >= 18) ? "совершеннолетний" : "несовершеннолетний";
        System.out.println("Возраст " + age + ": " + status);
        
        // Конкатенация строк
        System.out.println("\nКОНКАТЕНАЦИЯ СТРОК");
        String firstName = "Иван";
        String lastName = "Иванов";
        String fullName = firstName + " " + lastName;
        System.out.println("Имя и фамилия: " + fullName);
        
        // Приоритет операторов
        System.out.println("\nПРИОРИТЕТ ОПЕРАТОРОВ");
        int calc1 = 3 + 4 * 5;
        int calc2 = (3 + 4) * 5;
        System.out.println("Без скобок: 3 + 4 * 5 = " + calc1);
        System.out.println("Со скобками: (3 + 4) * 5 = " + calc2);
        
        // Практический пример
        System.out.println("\nПРАКТИЧЕСКИЙ ПРИМЕР");
        int number = 13;
        boolean isEven = (number % 2 == 0);
        boolean isPositive = (number > 0);
        boolean isValid = isPositive && !isEven;
        
        System.out.println("Число: " + number);
        System.out.println("Четное: " + isEven);
        System.out.println("Положительное: " + isPositive);
        System.out.println("Положительное и нечетное: " + isValid);
        
        if (isValid) {
            System.out.println("Число " + number + " подходит по условиям");
        }
    }
}