package data_types_and_operators;

import java.util.*;

public class TypeInferenceExample {
    public static void main(String[] args) {
        // Без var - явное указание типа
        ArrayList<String> namesExplicit = new ArrayList<String>();
        namesExplicit.add("Анна");
        namesExplicit.add("Петр");
        namesExplicit.add("Мария");
        
        // С var - тип выводится автоматически из правой части выражения
        var namesInferred = new ArrayList<String>();
        namesInferred.add("Анна");
        namesInferred.add("Петр");
        namesInferred.add("Мария");
    }
}