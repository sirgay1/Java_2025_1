package operators;

public class InstanceofExamples {
    public static void main(String[] args) {
        System.out.println("=== ПРИМЕРЫ ИСПОЛЬЗОВАНИЯ ОПЕРАТОРА instanceof ===\n");
        
        System.out.println("1. Базовые примеры с наследованием:");
        
        Object obj = new Object();
        String str = "Hello";
        Integer num = 52;
        Double dbl = 3.14;
        
        System.out.println("   obj instanceof Object: " + (obj instanceof Object));
        System.out.println("   str instanceof String: " + (str instanceof String));
        System.out.println("   str instanceof Object: " + (str instanceof Object));
        System.out.println("   num instanceof Integer: " + (num instanceof Integer));
        System.out.println("   num instanceof Number: " + (num instanceof Number));
        System.out.println("   dbl instanceof Double: " + (dbl instanceof Double));
        System.out.println("   dbl instanceof Number: " + (dbl instanceof Number));
    }
}