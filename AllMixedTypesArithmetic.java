package data_types_and_operators;

public class AllMixedTypesArithmetic {
    public static void main(String[] args) {
        System.out.println("Арифметические операции с разными типами");
        System.out.println();
        
        byte b = 100;
        short s = 200;
        int i = 300;
        long l = 400L;
        float f = 500.5f;
        double d = 600.6;
        char c = 'A';
        boolean bool = true;
        
        System.out.println("Исходные значения:");
        System.out.println("byte b = " + b);
        System.out.println("short s = " + s);
        System.out.println("int i = " + i);
        System.out.println("long l = " + l);
        System.out.println("float f = " + f);
        System.out.println("double d = " + d);
        System.out.println("char c = '" + c + "' (Unicode " + (int)c + ")");
        System.out.println("boolean bool = " + bool);
        
        System.out.println();
        System.out.println("Целочисленные типы между собой");
        
        int result1 = b + s;
        System.out.println("byte + short = int: " + b + " + " + s + " = " + result1);
        
        int result2 = b + i;
        System.out.println("byte + int = int: " + b + " + " + i + " = " + result2);
        
        int result3 = s + i;
        System.out.println("short + int = int: " + s + " + " + i + " = " + result3);
        
        long result4 = i + l;
        System.out.println("int + long = long: " + i + " + " + l + " = " + result4);
        
        int result5 = b * 2;
        System.out.println("byte * int = int: " + b + " * 2 = " + result5);
        
        System.out.println();
        System.out.println("С плавающей точкой");
        
        float result6 = i + f;
        System.out.println("int + float = float: " + i + " + " + f + " = " + result6);
        
        float result7 = l + f;
        System.out.println("long + float = float: " + l + " + " + f + " = " + result7);
        
        double result8 = i + d;
        System.out.println("int + double = double: " + i + " + " + d + " = " + result8);
        
        double result9 = f + d;
        System.out.println("float + double = double: " + f + " + " + d + " = " + result9);
        
        System.out.println();
        System.out.println("С участием char");
        
        int result10 = c + i;
        System.out.println("char + int = int: '" + c + "' + " + i + " = " + result10);
        
        int result11 = c + 'B';
        System.out.println("char + char = int: 'A' + 'B' = " + result11);
        
        int result12 = c * 2;
        System.out.println("char * int = int: 'A' * 2 = " + result12);
        
        System.out.println();
        System.out.println("Деление с разными типами");
        
        int div1 = i / 4;
        System.out.println("Целочисленное деление: " + i + " / 4 = " + div1);
        
        double div2 = i / 4;
        System.out.println("int / int в double: " + i + " / 4 = " + div2);
        
        double div3 = i / 4.0;
        System.out.println("int / double: " + i + " / 4.0 = " + div3);
        
        float div4 = f / i;
        System.out.println("float / int = float: " + f + " / " + i + " = " + div4);
        
        System.out.println();
        System.out.println("Смешанные выражения");
        
        double expr1 = b + s * i / c;
        System.out.println("b + s * i / c = " + expr1);
        
        double expr2 = (f + i) * (d - l);
        System.out.println("(f + i) * (d - l) = " + expr2);
        
        System.out.println();
    }
}