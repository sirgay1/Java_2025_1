public class StringConversionDemo {
    public static void main(String[] args) {
        // 1. String → StringBuilder
        String str1 = "Hello";
        StringBuilder sbFromStr1 = new StringBuilder(str1); // Конструктор
        System.out.println("String → StringBuilder: " + sbFromStr1);
        
        // 2. String → StringBuffer  
        String str2 = "World";
        StringBuffer bufFromStr2 = new StringBuffer(str2); // Конструктор
        System.out.println("String → StringBuffer: " + bufFromStr2);
        
        // 3. StringBuilder → String
        StringBuilder sb = new StringBuilder("Java");
        String strFromSb1 = sb.toString(); // метод toString()
        String strFromSb2 = new String(sb); // Конструктор String
        String strFromSb3 = sb.substring(0); // substring()
        System.out.println("StringBuilder → String (toString): " + strFromSb1);
        System.out.println("StringBuilder → String (constructor): " + strFromSb2);
        System.out.println("StringBuilder → String (substring): " + strFromSb3);
        
        // 4. StringBuffer → String
        StringBuffer buffer = new StringBuffer("Programming");
        String strFromBuf1 = buffer.toString(); // метод toString()
        String strFromBuf2 = new String(buffer); // Конструктор String
        String strFromBuf3 = buffer.substring(0); // substring()
        System.out.println("StringBuffer → String (toString): " + strFromBuf1);
        System.out.println("StringBuffer → String (constructor): " + strFromBuf2);
        System.out.println("StringBuffer → String (substring): " + strFromBuf3);
        
        // 5. StringBuilder ↔ StringBuffer (через String)
        StringBuilder sb3 = new StringBuilder("Builder");
        StringBuffer buf3 = new StringBuffer("Buffer");
        
        // StringBuilder → StringBuffer
        String temp1 = sb3.toString();
        StringBuffer bufFromSb = new StringBuffer(temp1);
        
        // StringBuffer → StringBuilder
        String temp2 = buf3.toString();
        StringBuilder sbFromBuf = new StringBuilder(temp2);
        
        System.out.println("StringBuilder → StringBuffer: " + bufFromSb);
        System.out.println("StringBuffer → StringBuilder: " + sbFromBuf);
        
        // 6. StringBuffer → StringBuilder и наоборот (без String)
        // НЕТ прямого преобразования! Только через String
        
        // 7. Примеры с изменением содержимого
        System.out.println("\n--- Практические примеры ---");
        
        // Изменяем String через StringBuilder
        String immutable = "Text";
        StringBuilder mutable = new StringBuilder(immutable);
        mutable.append(" modified");
        String result = mutable.toString();
        System.out.println("Original String: " + immutable);
        System.out.println("Modified result: " + result);
        
        // Работа с StringBuffer в многопоточном контексте
        StringBuffer threadSafeBuffer = new StringBuffer("Start");
        threadSafeBuffer.append(" end");
        String finalString = threadSafeBuffer.toString();
        System.out.println("Thread-safe result: " + finalString);
    }
}
