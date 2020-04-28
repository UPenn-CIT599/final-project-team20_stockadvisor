package com.java.YahooFinanceAPI;

public class findSlope {
	private Point point;
	private double slope;
	
	public double getSlope() {
		return slope;
	}
	
	public void setSlope(double slope) {
		this.slope = slope;
	}
	
	public findSlope(Point point, double slope) {
		this.point = point;
		this.slope = slope;
	}
	
	public findSlope(Point p1, Point p2) {
		this(p1,p2.getY()-p1.getY()/(p2.getX()-p1.getX()));
	}
	
	public findSlope (int a,int b) {
        this(new Point(a,0),new Point(0,b));
	}


}
