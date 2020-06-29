package controller;

import model.Point;
import model.ShapeFactory;
import model.interfaces.IShape;
import model.persistence.ApplicationState;
import view.interfaces.PaintCanvasBase;

public class MouseHandler {
	private ApplicationState appState;
	private PaintCanvasBase paintCanvas;
	
	public MouseHandler(PaintCanvasBase baseCanvas, ApplicationState baseState) {
		paintCanvas = baseCanvas;
		appState = baseState;
	}
	
	public void handle(Point startPoint, Point endPoint) {
		Point origin = getOrigin(startPoint, endPoint);
		int[] dimen = getDimension(startPoint, endPoint);
		int width = dimen[0];
		int height = dimen[1];
		ShapePrinter testPrint = new ShapePrinter(paintCanvas);
		IShape testShape = new ShapeFactory(appState, appState.getActivePrimaryColor(), origin, width, height).getShape();
		testPrint.draw(testShape);
		
		//DEBUG
		System.out.println("<DEBUG> X:" + origin.getX() + " Y:" + origin.getY());
		System.out.println("<DEBUG> New shape is a " + testShape.getType().toString() + " and is the color " + testShape.getColor().toString());
	}
	
	private Point getOrigin(Point startPoint, Point endPoint) {
		int minX = Math.min(startPoint.getX(), endPoint.getX());
		int minY = Math.min(startPoint.getY(), endPoint.getY());
		return new Point(minX, minY);
	}
	
	private int[] getDimension(Point startPoint, Point endPoint) {
		int minX = Math.min(startPoint.getX(), endPoint.getX());
		int maxX = Math.max(startPoint.getX(), endPoint.getX());
		int minY = Math.min(startPoint.getY(), endPoint.getY());
		int maxY = Math.max(startPoint.getY(), endPoint.getY());
		int width = maxX - minX;
		int height = maxY - minY;
		return new int[]{width, height};
	}
}
