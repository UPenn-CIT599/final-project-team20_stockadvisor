<<<<<<< HEAD
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.Test;

import com.java.YahooFinanceAPI.DataProcessor;

class DataProcessorTest {

    @Test
    void testCalculateAverageZero() {
        DataProcessor processor = new DataProcessor();
        ArrayList<Double> tests = new ArrayList<Double>();
        // -9999 means invalid result, it caused by setting the denominator as 0
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
=======
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.Test;

import com.java.YahooFinanceAPI.DataProcessor;

class DataProcessorTest {

    @Test
    void testCalculateAverageZero() {
        DataProcessor processor = new DataProcessor();
        ArrayList<Double> tests = new ArrayList<Double>();
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
>>>>>>> 3b92b9b319b29a742e3c9b76b2b9a48c906cb442
