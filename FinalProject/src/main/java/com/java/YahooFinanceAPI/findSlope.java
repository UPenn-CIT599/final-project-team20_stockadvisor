package com.java.YahooFinanceAPI;

/**
 * This class will find the slope using forecasted prices for comparison
 * @author user
 *
 */
public class findSlope {
	private Point point;
	private double slope;
	
	public double getSlope() {
		return slope;
	}
	
	public void setSlope(double slope) {
		this.slope = slope;
	}
	
	/**
	 * Constructor of find slope, if we know the point and slope
	 * @param point
	 * @param slope
	 */
	public findSlope(Point point, double slope) {
		this.point = point;
		this.slope = slope;
	}
	
	/**
	 * Constructor of find slope, if we know the two points
	 * @param p1
	 * @param p2
	 */
	public findSlope(Point p1, Point p2) {
		this(p1,p2.getY()-p1.getY()/(p2.getX()-p1.getX()));
	}
	
	/**
	 * Constructor of find slope, if we know two integer value from x-axis and y-axis.
	 * @param a
	 * @param b
	 */
	public findSlope (int a,int b) {
        this(new Point(a,0),new Point(0,b));
	}


}
