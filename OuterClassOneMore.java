class Outer {
    void accessInner() {
        Inner inner = new Inner();
        
        // Доступ к публичному методу внутреннего класса
        inner.publicMethod();
        
        // Доступ к protected методу
        inner.protectedMethod();
        
        // Доступ к default методу (в том же пакете)
        inner.defaultMethod();
        
        // Ошибка: приватный метод не доступен
        // inner.privateMethod();
        
        // Но можно получить доступ через публичный метод
        System.out.println(inner.publicField);
        // System.out.println(inner.privateField); // Ошибка
    }
    
    class Inner {
        private String privateField = "private";
        String defaultField = "default";
        protected String protectedField = "protected";
        public String publicField = "public";
        
        private void privateMethod() { System.out.println("Private"); }
        void defaultMethod() { System.out.println("Default"); }
        protected void protectedMethod() { System.out.println("Protected"); }
        public void publicMethod() { System.out.println("Public"); }
    }
}
