package binarysearchtest;
import com.java.binarysearch.RotationPoint;
import org.junit.Assert;
import org.junit.Test;

public class RotationPointTest {

    @Test
    public void testFindRotationPoint() {
        // Test case 1
        int[] array = {15, 18, 43, 92, 3, 6, 12};
        int expectedRotationPointIndex = 4;
        int actualRotationPointIndex = RotationPoint.findRotationPoint(array);
        Assert.assertEquals(expectedRotationPointIndex, actualRotationPointIndex);

        // Test case 2
        array = new int[] {4, 5, 6, 7, 0, 1, 2};
        expectedRotationPointIndex = 4;
        actualRotationPointIndex = RotationPoint.findRotationPoint(array);
        Assert.assertEquals(expectedRotationPointIndex, actualRotationPointIndex);

        // Test case 4
        array = new int[] {5, 6, 1, 2, 3, 4};
        expectedRotationPointIndex = 2;
        actualRotationPointIndex = RotationPoint.findRotationPoint(array);
        Assert.assertEquals(expectedRotationPointIndex, actualRotationPointIndex);
    }
}
