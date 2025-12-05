interface A {
    default void print() { System.out.println("A"); }
}

interface B {
    default void print() { System.out.println("B"); }
}

class C implements A, B {
    @Override
    public void print() {
        // Выбираем реализацию A
        A.super.print(); // или B.super.print()
        
        // Или пишем свою:
        // System.out.println("C");
    }
}
