package com.java.YahooFinanceAPI;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class SlopeAndPointTest {

	@Test
	void SlopeAndPointtestPositive() {
		
		Point p1 = new Point(1,1);
		Point p2 = new Point(5,4);
		
		findSlope testSlope1 = new findSlope(p1, p2);
		double testSlope1Result = testSlope1.getSlope();
		
		assertEquals(3.75, testSlope1Result);
		
	}
	
	@Test
	void SlopeAndPointtestNegative() {
			
			Point p1 = new Point(-3,-2);
			Point p2 = new Point(-4,-3);
			
			findSlope testSlope2 = new findSlope(p1, p2);
			double testSlope1Result = testSlope2.getSlope();
			
			assertEquals(-5.0, testSlope1Result);
	}
}
