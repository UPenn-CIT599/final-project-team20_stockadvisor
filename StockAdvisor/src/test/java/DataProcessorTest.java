
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.Test;

import com.java.YahooFinanceAPI.DataProcessor;

class DataProcessorTest {

    @Test
    void testCalculateAverageZero() {
        DataProcessor processor = new DataProcessor();
        ArrayList<Double> tests = new ArrayList<Double>();
        // -9999 means invalid result, it is caused by setting the denominator as 0
        assertEquals(processor.calculateAverage(tests), -9999);
    }

    @Test
    void testCalculateAverage() {
        DataProcessor processor = new DataProcessor();
        ArrayList<Double> tests = new ArrayList<Double>();
        tests.add(1.0);
        tests.add(2.0);
        tests.add(3.0);
        assertEquals(processor.calculateAverage(tests), 2.0);
    }

}
