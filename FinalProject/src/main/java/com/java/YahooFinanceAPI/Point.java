package com.java.YahooFinanceAPI;

/**
 * This class creates points for helping with slope calculation
 */
public class Point {
	private double x;
	private double y;
	
	/**
	 * Constructor of point
	 * @param x
	 * @param y
	 */
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return x;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public double getY() {
		return y;
	}
	
	public void setY(double y) {
		this.y = y;
	}
}
