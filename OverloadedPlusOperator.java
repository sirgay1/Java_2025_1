package data_types_and_operators;

public class OverloadedPlusOperator {
    public static void main(String[] args) {
        String firstName = "Сергей";
        int age = 20;
        double height = 1.75;
        boolean isStudent = true;
        char grade = 'A';
        
        String info = "Имя: " + firstName + 
                     ", Возраст: " + age + 
                     ", Рост: " + height + 
                     ", Студент: " + isStudent + 
                     ", Оценка: " + grade;
        System.out.println("Строка + примитивы: " + info);
        
        Day today = Day.MONDAY;
        System.out.println("Сегодня: " + today);
    }
    enum Day{
        MONDAY, TUESDAY
    }
}