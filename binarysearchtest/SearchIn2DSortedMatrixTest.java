package binarysearchtest;

import com.java.binarysearch.SearchIn2DSortedMatrix;
import org.junit.Assert;
import org.junit.Test;

public class SearchIn2DSortedMatrixTest {

    @Test
    public void testSearchMatrix() {
        // Test case 1
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target = 3;
        boolean expectedResult = true;
        boolean actualResult = SearchIn2DSortedMatrix.searchMatrix(matrix, target);
        Assert.assertEquals(expectedResult, actualResult);

        // Test case 2
        target = 13;
        expectedResult = false;
        actualResult = SearchIn2DSortedMatrix.searchMatrix(matrix, target);
        Assert.assertEquals(expectedResult, actualResult);

    }
}
