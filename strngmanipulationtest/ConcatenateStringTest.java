package strngmanipulationtest;

import com.java.stringmanipulation.ConcatenateString;
import org.junit.Assert;
import org.junit.Test;

public class ConcatenateStringTest {

    @Test
    public void testConcatenateString() {
        String[] strArray = {"Hello", "Mam", "Nice", "To", "Meet", "You"};
        StringBuffer sb = new StringBuffer();

        String result = ConcatenateString.concatenateString(strArray, sb);
        Assert.assertEquals("HelloMamNiceToMeetYou", result);
    }

    @Test
    public void testPrintArray() {
        String[] strArray = {"Hello", "Mam", "Nice", "To", "Meet", "You"};

        // Capture the print output (if needed)
        // For demonstration, we won't capture the output here
        ConcatenateString.printArray(strArray);
    }
}
