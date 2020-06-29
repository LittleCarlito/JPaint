package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.Point;
import model.ShapeFactory;
import model.interfaces.IShape;
import model.persistence.ApplicationState;
import view.interfaces.PaintCanvasBase;

public class MouseListener extends MouseAdapter{
	
	private Point startPoint;
	private Point endPoint;
	private PaintCanvasBase paintCanvas;
	private ApplicationState appState;
	
	public MouseListener(PaintCanvasBase baseCanvas, ApplicationState baseState) {
		this.paintCanvas = baseCanvas;
		this.appState = baseState;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		startPoint = new Point(e.getX(), e.getY());
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		endPoint = new Point(e.getX(), e.getY());

		//NEW CODE
		Point drawStart = getOrigin();
		int[] dimArray = getDimension();
		int width = dimArray[0];
		int height = dimArray[1];
		ShapePrinter testPrint = new ShapePrinter(paintCanvas);
		IShape testShape = new ShapeFactory(appState, appState.getActivePrimaryColor(), drawStart, width, height).getShape();
		testPrint.draw(testShape);
		
		//DEBUG
		System.out.println("<DEBUG> X:" + drawStart.getX() + " Y:" + drawStart.getY());
		System.out.println("<DEBUG> New shape is a " + testShape.getType().toString() + " and is the color " + testShape.getColor().toString());
	}
	
	private Point getOrigin() {
		int minX = Math.min(startPoint.getX(), endPoint.getX());
		int minY = Math.min(startPoint.getY(), endPoint.getY());
		return new Point(minX, minY);
	}
	
	private int[] getDimension() {
		int minX = Math.min(startPoint.getX(), endPoint.getX());
		int maxX = Math.max(startPoint.getX(), endPoint.getX());
		int minY = Math.min(startPoint.getY(), endPoint.getY());
		int maxY = Math.max(startPoint.getY(), endPoint.getY());
		int width = maxX - minX;
		int height = maxY - minY;
		return new int[]{width, height};
	}
}
