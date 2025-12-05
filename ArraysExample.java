package arrays;

import java.util.Arrays;

public class ArraysExample {
    public static void main(String[] args) {
        
        // 1. Создание и инициализация массивов
        int[] arr1 = {5, 3, 8, 1, 9, 2};
        int[] arr2 = {5, 3, 8, 1, 9, 2};
        int[] arr3 = {1, 2, 3, 5, 8, 9};
        int[] arr4 = {10, 20, 30, 40, 50};
        
        System.out.println("=== Метод Arrays.toString() ===");
        // Преобразует массив в читаемую строку
        System.out.println("arr1: " + Arrays.toString(arr1));
        System.out.println("arr2: " + Arrays.toString(arr2));
        System.out.println("arr3: " + Arrays.toString(arr3));
        System.out.println("arr4: " + Arrays.toString(arr4));
        System.out.println();
        
        System.out.println("=== Метод Arrays.sort() ===");
        // Сортирует массив (изменяет исходный)
        Arrays.sort(arr1);
        System.out.println("После сортировки arr1: " + Arrays.toString(arr1));
        System.out.println();
        
        System.out.println("=== Метод Arrays.binarySearch() ===");
        // Бинарный поиск (массив должен быть отсортирован!)
        int searchKey = 8;
        int index = Arrays.binarySearch(arr1, searchKey);
        System.out.println("Поиск числа " + searchKey + " в arr1: индекс = " + index);
        
        int searchKey2 = 7;
        int index2 = Arrays.binarySearch(arr1, searchKey2);
        System.out.println("Поиск числа " + searchKey2 + " в arr1: индекс = " + index2 + " (отрицательный - не найден)");
        System.out.println();
        
        System.out.println("=== Метод Arrays.equals() ===");
        // Сравнивает два массива на равенство
        System.out.println("arr1.equals(arr2) через Objects.equals: " + arr1.equals(arr2));
        System.out.println("Arrays.equals(arr1, arr2): " + Arrays.equals(arr1, arr2));
        System.out.println("Arrays.equals(arr1, arr3): " + Arrays.equals(arr1, arr3));
        System.out.println();
        
        System.out.println("=== Метод Arrays.compare() (Java 9+) ===");
        // Сравнивает два массива лексикографически
        // Возвращает:
        // 0 - если массивы равны
        // <0 - если первый массив меньше второго
        // >0 - если первый массив больше второго
        
        int[] arrA = {1, 2, 3};
        int[] arrB = {1, 2, 3};
        int[] arrC = {1, 2, 4};
        int[] arrD = {1, 2};
        
        System.out.println("Arrays.compare(arrA, arrB): " + Arrays.compare(arrA, arrB));
        System.out.println("Arrays.compare(arrA, arrC): " + Arrays.compare(arrA, arrC));
        System.out.println("Arrays.compare(arrC, arrA): " + Arrays.compare(arrC, arrA));
        System.out.println("Arrays.compare(arrA, arrD): " + Arrays.compare(arrA, arrD));
        System.out.println("Arrays.compare(arrD, arrA): " + Arrays.compare(arrD, arrA));
        System.out.println();
        
        // Дополнительный пример с массивами разной длины
        System.out.println("=== Сравнение массивов разной длины ===");
        int[] shortArr = {1, 2};
        int[] longArr = {1, 2, 0};
        System.out.println("shortArr: " + Arrays.toString(shortArr));
        System.out.println("longArr: " + Arrays.toString(longArr));
        System.out.println("Arrays.compare(shortArr, longArr): " + Arrays.compare(shortArr, longArr));
    }
}