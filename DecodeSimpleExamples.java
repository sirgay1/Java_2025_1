package wrapper_classes;

public class DecodeSimpleExamples {
    public static void main(String[] args) {
        System.out.println("ПРОСТЫЕ ПРИМЕРЫ decode()\n");

        System.out.println("1. Integer.decode():");
        System.out.println("   \"42\" -> " + Integer.decode("42"));
        System.out.println("   \"077\" -> " + Integer.decode("077") + " (восьмеричное)");
        System.out.println("   \"0x2B\" -> " + Integer.decode("0x2B") + " (шестнадцатеричное)");
        System.out.println("   \"-75\" -> " + Integer.decode("-75"));
        System.out.println("   \"#00FF00\" -> " + Integer.decode("#00FF00"));
        
        System.out.println("\n2. Long.decode():");
        System.out.println("   \"500000\" -> " + Long.decode("500000"));
        System.out.println("   \"0xABCD\" -> " + Long.decode("0xABCD"));
        
        System.out.println("\n3. Short и Byte:");
        System.out.println("   Short.decode(\"300\") -> " + Short.decode("300"));
        System.out.println("   Byte.decode(\"65\") -> " + Byte.decode("65"));
    }
}