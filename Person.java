class Person {
    private String name;
    private int age;

    @Override
    public boolean equals(Object obj) {
        // 1. Проверка на this
        if (this == obj) return true;
        
        // 2. Проверка на null
        if (obj == null) return false;
        
        // 3. Проверка класса
        if (getClass() != obj.getClass()) return false;
        
        // 4. Приведение типа
        Person other = (Person) obj;
        
        // 5. Сравнение значимых полей
        return age == other.age && 
               (name == null ? other.name == null : name.equals(other.name));
    }
}
