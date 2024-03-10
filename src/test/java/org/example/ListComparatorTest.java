package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ListComparatorTest {

    private ListComparator listComparator;

    @BeforeEach
    public void setUp() {
        listComparator = new ListComparator();
    }

    @Test
    public void testAverageCalculationWithNonEmptyList() {
        assertEquals(3.0, listComparator.calculateAverage(Arrays.asList(1, 2, 3, 4, 5)));
        assertEquals(5.0, listComparator.calculateAverage(Arrays.asList(4, 5, 6)));
    }

    @Test
    public void testAverageCalculationWithEmptyList() {
        assertEquals(0, listComparator.calculateAverage(Collections.emptyList()));
    }

    @Test
    public void testAverageCalculationWithNull() {
        assertThrows(NullPointerException.class, () -> ListComparator.calculateAverage(null));
    }

    @Test
    public void testCompareListsWithDifferentAverages() {
        assertEquals("Первый список имеет большее среднее значение", listComparator.compareLists(Arrays.asList(10, 20, 30), Arrays.asList(2, 4, 6)));
        assertEquals("Второй список имеет большее среднее значение", listComparator.compareLists(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6)));
    }

    @Test
    public void testCompareListsWithEqualAverages() {
        assertEquals("Средние значения равны", listComparator.compareLists(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3)));
    }

    @Test
    public void testCompareListsWithEmptyAndNonNullLists() {
        assertEquals("Второй список имеет большее среднее значение", listComparator.compareLists(Collections.emptyList(), Arrays.asList(1, 2, 3)));
        assertEquals("Первый список имеет большее среднее значение", listComparator.compareLists(Arrays.asList(1, 2, 3), Collections.emptyList()));
    }

    @Test
    public void testCompareListsWithBothEmpty() {
        assertEquals("Средние значения равны", listComparator.compareLists(Collections.emptyList(), Collections.emptyList()));
    }

    @Test
    public void testCompareListsWithNulls() {
        assertThrows(NullPointerException.class, () -> ListComparator.compareLists(null, Arrays.asList(1, 2, 3)));
        assertThrows(NullPointerException.class, () -> ListComparator.compareLists(Arrays.asList(1, 2, 3), null));
        assertThrows(NullPointerException.class, () -> ListComparator.compareLists(null, null));
    }
}