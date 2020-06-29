package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.Point;
import model.persistence.ApplicationState;
import view.interfaces.PaintCanvasBase;

public class MouseListener extends MouseAdapter{
	
	private Point startPoint;
	private Point endPoint;
	private PaintCanvasBase paintCanvas;
	private ApplicationState appState;
	private MouseHandler mHandler;
	
	public MouseListener(PaintCanvasBase baseCanvas, ApplicationState baseState) {
		paintCanvas = baseCanvas;
		appState = baseState;
		mHandler = new MouseHandler(paintCanvas, appState);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		startPoint = new Point(e.getX(), e.getY());
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		endPoint = new Point(e.getX(), e.getY());

		mHandler.handle(startPoint, endPoint);
	}
}
