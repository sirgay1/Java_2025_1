package ternary;

public class IfToTernary {
    public static void main(String[] args) {
        int a = 2;
        int i2 = (a == 1) ? 1 : (a == 2) ? 2 : 3;
        System.out.println("Результат с ? : " + i2);
    }
}