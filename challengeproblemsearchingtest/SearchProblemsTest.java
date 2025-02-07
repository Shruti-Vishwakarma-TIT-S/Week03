package challengeproblemsearchingtest;
import com.java.challengeproblemsearching.SearchProblems;
import org.junit.Assert;
import org.junit.Test;

public class SearchProblemsTest {

    @Test
    public void testFindFirstMissingPositive() {
        // Test case 1
        int[] nums = {3, 4, -1, 1};
        int expectedFirstMissingPositive = 2;
        int actualFirstMissingPositive = SearchProblems.findFirstMissingPositive(nums);
        Assert.assertEquals(expectedFirstMissingPositive, actualFirstMissingPositive);

        // Test case 2
        nums = new int[] {1, 2, 0};
        expectedFirstMissingPositive = 3;
        actualFirstMissingPositive = SearchProblems.findFirstMissingPositive(nums);
        Assert.assertEquals(expectedFirstMissingPositive, actualFirstMissingPositive);

    }

    @Test
    public void testBinarySearch() {
        // Test case 1
        int[] arr = {1, 2, 3, 4, 5};
        int target = 4;
        int expectedTargetIndex = 3;
        int actualTargetIndex = SearchProblems.binarySearch(arr, target);
        Assert.assertEquals(expectedTargetIndex, actualTargetIndex);

        // Test case 2
        target = 1;
        expectedTargetIndex = 0;
        actualTargetIndex = SearchProblems.binarySearch(arr, target);
        Assert.assertEquals(expectedTargetIndex, actualTargetIndex);

    }
}

