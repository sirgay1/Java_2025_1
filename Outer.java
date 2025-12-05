class Outer {
    // Внутренний класс
    class InnerDefault {
        void show() { System.out.println("InnerDefault"); }
    }
    
    // Приватный внутренний класс
    private class InnerPrivate {
        void show() { System.out.println("InnerPrivate"); }
    }
    
    // Защищенный внутренний класс
    protected class InnerProtected {
        void show() { System.out.println("InnerProtected"); }
    }
    
    // Публичный внутренний класс
    public class InnerPublic {
        void show() { System.out.println("InnerPublic"); }
    }
    
    void test() {
        // Доступны все внутри Outer
        new InnerDefault().show();
        new InnerPrivate().show();
        new InnerProtected().show();
        new InnerPublic().show();
    }
}

class Other {
    void test() {
        Outer outer = new Outer();
        
        // Доступен только public
        Outer.InnerPublic pub = outer.new InnerPublic();
        pub.show();
        
        // Остальные недоступны
        // Outer.InnerDefault def = outer.new InnerDefault(); // Ошибка
        // Outer.InnerPrivate priv = outer.new InnerPrivate(); // Ошибка
        // Outer.InnerProtected prot = outer.new InnerProtected(); // Ошибка
    }
}
