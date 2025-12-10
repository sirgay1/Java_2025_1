public class ExceptionExample {
    public static void main(String[] args) {
        try {
            // Это исключение будет перехвачено
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Перехвачено ArithmeticException: " + e.getMessage());
        }
        
        // Это исключение не будет перехвачено и приведет к аварийной остановке
        String str = null;
        str.length();
    }
}
