import java.util.Date;
import java.util.Calendar;

public class DateFormatDemo {
    public static void main(String[] args) {
        Date now = new Date();
        Calendar cal = Calendar.getInstance();
        
        // 1. %tH - час (00-23)
        System.out.printf("Текущий час (24-часовой): %tH%n", now);
        
        // 2. %tM - минуты (00-59)
        System.out.printf("Минуты: %tM%n", now);
        
        // 3. %tS - секунды (00-59)
        System.out.printf("Секунды: %tS%n", now);
        
        // 4. %tY - год (4 цифры)
        System.out.printf("Год: %tY%n", now);
        
        // 5. %tB - полное название месяца
        System.out.printf("Месяц: %tB%n", now);
        
        // 6. Комбинированный пример
        System.out.printf("%nПолное время: %tH:%tM:%tS%n", now, now, now);
        System.out.printf("Дата: %tA, %td %tB %tY года%n", 
                         now, now, now, now);
        
        // 7. С Calendar
        System.out.printf("%nС Calendar:%n");
        System.out.printf("Время: %tH:%tM:%tS.%tL%n", 
                         cal, cal, cal, cal);
        System.out.printf("Дата: %td.%tm.%tY%n", 
                         cal, cal, cal);
        
        // 8. С аргументами в виде массива
        Object[] timeArgs = {now, now, now, now};
        System.out.printf("%nФормат: %tH:%tM:%tS %td.%tm.%tY%n", 
                         timeArgs[0], timeArgs[1], timeArgs[2],
                         timeArgs[3], timeArgs[3], timeArgs[3]);
    }
}
