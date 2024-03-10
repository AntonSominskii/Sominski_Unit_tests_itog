package org.example;

import java.util.List;

public class ListComparator {

    public static double calculateAverage(List<Integer> list) {
        if (list == null) {
            throw new NullPointerException("Список не может быть null");
        }
        if (list.isEmpty()) {
            return 0;
        }
        return list.stream().mapToInt(Integer::intValue).average().getAsDouble();
    }

    public static String compareLists(List<Integer> list1, List<Integer> list2) {
        if (list1 == null || list2 == null) {
            throw new NullPointerException("Список не может быть null");
        }

        double average1 = calculateAverage(list1);
        double average2 = calculateAverage(list2);

        if (average1 > average2) {
            return "Первый список имеет большее среднее значение";
        } else if (average1 < average2) {
            return "Второй список имеет большее среднее значение";
        } else {
            return "Средние значения равны";
        }
    }
}