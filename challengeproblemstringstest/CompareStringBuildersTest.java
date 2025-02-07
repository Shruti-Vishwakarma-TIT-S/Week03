package challengeproblemstringstest;
import com.java.challengeproblemstrings.CompareStringBuilders;
import org.junit.Test;
import org.junit.Assert;
import java.io.*;
public class CompareStringBuildersTest {
    @Test
    public void testCompareStringBuilders() {
        // Call the compareStringBuilders method to ensure it runs without errors
        CompareStringBuilders.compareStringBuilders();
    }

    @Test
    public void testCompareFileReaders() throws IOException {
        // Provide the path to the large file
        String largeFilePath = "C:\\Users\\HP\\OneDrive\\Attachments\\Hii\\src\\main\\java\\com\\java\\challengeproblemstrings\\Story The Magical Paintbrush.txt";

        // Call the compareFileReaders method to ensure it runs without errors
        CompareStringBuilders.compareFileReaders(largeFilePath);
    }

}
