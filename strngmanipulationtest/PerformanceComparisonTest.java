package strngmanipulationtest;

import com.java.stringmanipulation.PerformanceComparison;
import org.junit.Assert;
import org.junit.Test;

public class PerformanceComparisonTest {
    @Test
    public void testPerformance(){
        String[] args = {};
        PerformanceComparison pc = new PerformanceComparison();
        PerformanceComparison.main(args);
    }
}

