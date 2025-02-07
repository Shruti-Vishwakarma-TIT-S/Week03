package binarysearchtest;
import com.java.binarysearch.FindPeakElement;
import org.junit.Assert;
import org.junit.Test;

public class FindPeakElementTest {

    @Test
    public void testFindPeakElement() {
        // Test case 1
        int[] array = {1, 3, 20, 4, 1, 0};
        int expectedPeakIndex = 2;
        int actualPeakIndex = FindPeakElement.findPeakElement(array);
        Assert.assertEquals(expectedPeakIndex, actualPeakIndex);

        // Test case 2
        array = new int[] {1, 2, 3, 1};
        expectedPeakIndex = 2;
        actualPeakIndex = FindPeakElement.findPeakElement(array);
        Assert.assertEquals(expectedPeakIndex, actualPeakIndex);

    }
}
