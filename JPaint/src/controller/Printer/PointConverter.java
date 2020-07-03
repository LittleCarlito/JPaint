package controller.Printer;

import model.Point;

public class PointConverter {
	private static final PointConverter INSTANCE = new PointConverter();
	
	private PointConverter() {}
	
	public static PointConverter getInstance() {
		return INSTANCE;
	}
	
	public static Point getOrigin(Point startPoint, Point endPoint) {
		int minX = Math.min(startPoint.getX(), endPoint.getX());
		int minY = Math.min(startPoint.getY(), endPoint.getY());
		return new Point(minX, minY);
	}
	
	public static int[] getDimension(Point startPoint, Point endPoint) {
		int minX = Math.min(startPoint.getX(), endPoint.getX());
		int maxX = Math.max(startPoint.getX(), endPoint.getX());
		int minY = Math.min(startPoint.getY(), endPoint.getY());
		int maxY = Math.max(startPoint.getY(), endPoint.getY());
		return new int[] {maxX - minX, maxY - minY};
	}
	
	public static int[][] getTriangle(Point origin, int width, int height){
		int[] xDimensions = new int[3];
		int[] yDimensions = new int[3];
		int x = origin.getX();
		int y = origin.getY();
		xDimensions[0] = x;
		xDimensions[1] = x + (width / 2);
		xDimensions[2] = x + width;
		yDimensions[0] = y + height;
		yDimensions[1] = y;
		yDimensions[2] = y + height;
		return new int[][]{xDimensions, yDimensions};
	}
}
