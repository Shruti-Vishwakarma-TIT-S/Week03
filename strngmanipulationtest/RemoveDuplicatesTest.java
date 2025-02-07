package strngmanipulationtest;

import com.java.stringmanipulation.RemoveDuplicates;
import org.junit.Assert;
import org.junit.Test;
public class RemoveDuplicatesTest {
    @Test
    public void removeDuplicates(){
        //Test Case 1
        String original = "Hello Everyone Good Morning";
        String expected = "Helo EvrynGdMig";
        String str = RemoveDuplicates.removeDuplicate(original);
        Assert.assertEquals(expected, str );

        //Test case2
        original = "abbssb";
        expected = "abs";
        str = RemoveDuplicates.removeDuplicate(original);
        Assert.assertEquals(expected, str );

    }
}
