public class OuterClass {
    private String privateField = "private";
    String defaultField = "default";
    protected String protectedField = "protected";
    public String publicField = "public";
    
    private void privateMethod() { System.out.println("Private method"); }
    
    class Inner {
        void accessAll() {
            // Доступ ко всем полям, независимо от спецификатора
            System.out.println(privateField);
            System.out.println(defaultField);
            System.out.println(protectedField);
            System.out.println(publicField);
            
            privateMethod(); // И к методам тоже
        }
    }
    
    void test() {
        Inner inner = new Inner();
        inner.accessAll();
    }


    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.test();
    }
}
