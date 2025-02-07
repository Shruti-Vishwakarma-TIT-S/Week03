package linearsearchtest;
import com.java.linearsearch.FirstNegativeNumber;
import org.junit.Test;
import org.junit.Assert;
public class FirstNegativeNumberTest {
    @Test
    public void firstNegative(){
        int[] arr = {12, 3, -10, 8, -1};
        int negative = FirstNegativeNumber.findFirstNegative(arr);
        Assert.assertEquals(2, negative);
    }
}
