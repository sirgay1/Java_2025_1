package data_types_and_operators;

public class NarrowingConversionExamples {
    public static void main(String[] args) {
        System.out.println("ВСЕ ПРИМЕРЫ СУЖАЮЩЕГО ПРЕОБРАЗОВАНИЯ ТИПОВ");
        System.out.println();
        
        System.out.println("1. БАЗОВЫЕ ПРИМЕРЫ СУЖАЮЩЕГО ПРЕОБРАЗОВАНИЯ");
        
        double d1 = 123.456;
        int i1 = (int)d1;
        System.out.println("double → int: (int)" + d1 + " = " + i1);
        
        float f1 = 127.9f;
        byte b1 = (byte)f1;
        System.out.println("float → byte: (byte)" + f1 + " = " + b1);
        
        long l1 = 2147483648L;
        int i2 = (int)l1;
        System.out.println("long → int: (int)" + l1 + " = " + i2);
        
        int i3 = 32768;
        short s1 = (short)i3;
        System.out.println("int → short: (short)" + i3 + " = " + s1);
        
        int i4 = 257;
        byte b2 = (byte)i4;
        System.out.println("int → byte: (byte)" + i4 + " = " + b2);
        
        char c1 = 'Я';
        byte b3 = (byte)c1;
        System.out.println("char → byte: (byte)'" + c1 + "' = " + b3);
        
        double d2 = 3.141592653589793;
        float f2 = (float)d2;
        System.out.println("double → float: (float)" + d2 + " = " + f2);
        
        int i5 = 65;
        char c2 = (char)i5;
        System.out.println("int → char: (char)" + i5 + " = '" + c2 + "'");
        
        System.out.println();
        System.out.println("2. СУЖАЮЩЕЕ ПРЕОБРАЗОВАНИЕ С АРИФМЕТИКОЙ");
        
        int a = 100;
        int b = 50;
        byte result1 = (byte)(a + b);
        System.out.println("(byte)(100 + 50) = " + result1);
        
        short x = 1000;
        short y = 100;
        short result2 = (short)(x * y);
        System.out.println("(short)(1000 * 100) = " + result2);
        
        double d3 = 10.0;
        double d4 = 3.0;
        int result3 = (int)(d3 / d4);
        System.out.println("(int)(10.0 / 3.0) = " + result3);
        
        int i6 = 200;
        int i7 = 100;
        double d5 = 50.5;
        byte result4 = (byte)(i6 - i7 + d5);
        System.out.println("(byte)(200 - 100 + 50.5) = " + result4);
        
        float negativeFloat = -123.456f;
        int negativeInt = (int)negativeFloat;
        System.out.println("(int)(-123.456f) = " + negativeInt);
        
        System.out.println();
        System.out.println("3. СУЖАЮЩЕЕ ПРЕОБРАЗОВАНИЕ В ПРИСВАИВАНИИ");
        
        int i8 = 100;
        byte b4 = (byte)i8;
        System.out.println("byte b4 = (byte)100 = " + b4);
        
        final int CONST_INT = 100;
        byte b5 = CONST_INT;
        System.out.println("byte b5 = 100 (константа) = " + b5);
        
        long l2 = 1234567890123L;
        int i9 = (int)l2;
        short s2 = (short)i9;
        byte b6 = (byte)s2;
        System.out.println("long → int → short → byte: " + l2 + " → " + i9 + " → " + s2 + " → " + b6);
        
        System.out.println();
        System.out.println("4. ПРОВЕРКА ДИАПАЗОНА ПЕРЕД ПРЕОБРАЗОВАНИЕМ");
        
        int unsafeValue = 1000;
        byte unsafeByte = (byte)unsafeValue;
        System.out.println("Небезопасное: (byte)1000 = " + unsafeByte);
        
        int valueToConvert = 500;
        if (valueToConvert >= Byte.MIN_VALUE && valueToConvert <= Byte.MAX_VALUE) {
            byte safeByte = (byte)valueToConvert;
            System.out.println("Безопасное: 500 → " + safeByte);
        } else {
            System.out.println("Значение " + valueToConvert + " вне диапазона byte");
        }
        
        int bigNumber = 0x12345678;
        short maskedShort = (short)bigNumber;
        byte maskedByte = (byte)bigNumber;
        System.out.println("Маскирование: int " + bigNumber + " → short " + maskedShort + " → byte " + maskedByte);
        
        System.out.println();
        System.out.println("5. СУЖАЮЩЕЕ ПРЕОБРАЗОВАНИЕ ИЗ РАЗНЫХ СИСТЕМ СЧИСЛЕНИЯ");
        
        int hexValue = 0xFF;
        byte hexToByte = (byte)hexValue;
        System.out.println("(byte)0xFF = " + hexToByte);
        
        int binaryValue = 0b11111111;
        byte binaryToByte = (byte)binaryValue;
        System.out.println("(byte)0b11111111 = " + binaryToByte);
        
        int octalValue = 0377;
        byte octalToByte = (byte)octalValue;
        System.out.println("(byte)0377 = " + octalToByte);
        
        int negativeHex = 0xFFFFFF80;
        byte negativeByte = (byte)negativeHex;
        System.out.println("(byte)0xFFFFFF80 = " + negativeByte);
        
        System.out.println();
        System.out.println("6. ОСОБЫЕ СЛУЧАИ СУЖАЮЩЕГО ПРЕОБРАЗОВАНИЯ");
        
        double nan = Double.NaN;
        double posInf = Double.POSITIVE_INFINITY;
        double negInf = Double.NEGATIVE_INFINITY;
        
        int intFromNaN = (int)nan;
        int intFromPosInf = (int)posInf;
        int intFromNegInf = (int)negInf;
        
        System.out.println("(int)NaN = " + intFromNaN);
        System.out.println("(int)+Infinity = " + intFromPosInf);
        System.out.println("(int)-Infinity = " + intFromNegInf);
        
        double huge = 1.7e308;
        int hugeToInt = (int)huge;
        System.out.println("(int)1.7e308 = " + hugeToInt);
        
        System.out.println();
        System.out.println("7. ОТБРАСЫВАНИЕ ДРОБНОЙ ЧАСТИ (НЕ ОКРУГЛЕНИЕ!)");
        
        double[] numbers = {2.9, 2.5, 2.1, -2.1, -2.5, -2.9};
        for (double num : numbers) {
            System.out.println("(int)" + num + " = " + (int)num);
        }
        
        System.out.println();
        double test = 2.9;
        System.out.println("Сравнение: (int)2.9 = " + (int)test);
        System.out.println("Сравнение: Math.round(2.9) = " + Math.round(test));
        
        System.out.println();
        System.out.println("8. ПОСТЕПЕННОЕ СУЖЕНИЕ");
        
        double start = 123456.789;
        float step1 = (float)start;
        long step2 = (long)step1;
        int step3 = (int)step2;
        short step4 = (short)step3;
        byte step5 = (byte)step4;
        
        System.out.println("double: " + start);
        System.out.println("→ float: " + step1);
        System.out.println("→ long: " + step2);
        System.out.println("→ int: " + step3);
        System.out.println("→ short: " + step4);
        System.out.println("→ byte: " + step5);
        
        System.out.println();
    }
}