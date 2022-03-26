package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import controller.event.EventHandler;
import controller.interfaces.IMouseEvent;
import model.Point;
import model.persistence.ApplicationState;
import view.interfaces.PaintCanvasBase;

public class MouseListener extends MouseAdapter{
	
	// Wow i changed something
	private Point startPoint;
	private Point endPoint;
	private PaintCanvasBase paintCanvas;
	private ApplicationState appState;
	
	public MouseListener(PaintCanvasBase baseCanvas, ApplicationState baseState) {
		paintCanvas = baseCanvas;
		appState = baseState;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		startPoint = new Point(e.getX(), e.getY());
		IMouseEvent newEvent = EventHandler.getEvent(startPoint, startPoint, paintCanvas, appState);
		newEvent.execute();
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		startPoint = new Point(e.getX(), e.getY());
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		endPoint = new Point(e.getX(), e.getY());
		IMouseEvent newEvent = EventHandler.getEvent(startPoint, endPoint, paintCanvas, appState);
		newEvent.execute();
	}
}
