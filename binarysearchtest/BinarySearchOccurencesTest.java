package binarysearchtest;

import com.java.binarysearch.BinarySearchOcurrences;
import org.junit.Assert;
import org.junit.Test;

public class BinarySearchOccurencesTest {

    @Test
    public void testFindFirstOccurrence() {
        // Test case 1
        int[] arr = {1, 2, 2, 2, 3, 4, 5};
        int target = 2;
        int expectedFirstOccurrence = 1;
        int actualFirstOccurrence = BinarySearchOcurrences.findFirstOccurrence(arr, target);
        Assert.assertEquals(expectedFirstOccurrence, actualFirstOccurrence);

        // Test case 2
        arr = new int[] {1, 2, 2, 2, 3, 4, 5};
        target = 3;
        expectedFirstOccurrence = 4;
        actualFirstOccurrence = BinarySearchOcurrences.findFirstOccurrence(arr, target);
        Assert.assertEquals(expectedFirstOccurrence, actualFirstOccurrence);


    }

    @Test
    public void testFindLastOccurrence() {
        // Test case 1
        int[] arr = {1, 2, 2, 2, 3, 4, 5};
        int target = 2;
        int expectedLastOccurrence = 3;
        int actualLastOccurrence = BinarySearchOcurrences.findLastOccurrence(arr, target);
        Assert.assertEquals(expectedLastOccurrence, actualLastOccurrence);

        // Test case 2
        arr = new int[] {1, 2, 2, 2, 3, 4, 5};
        target = 3;
        expectedLastOccurrence = 4;
        actualLastOccurrence = BinarySearchOcurrences.findLastOccurrence(arr, target);
        Assert.assertEquals(expectedLastOccurrence, actualLastOccurrence);


    }
}
