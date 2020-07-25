package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import controller.event.EventFactory;
import controller.interfaces.IMouseEvent;
import model.Point;
import model.persistence.ApplicationState;
import view.interfaces.PaintCanvasBase;

public class MouseListener extends MouseAdapter{
	
	private Point startPoint;
	private PaintCanvasBase paintCanvas;
	private ApplicationState appState;
	
	public MouseListener(PaintCanvasBase baseCanvas, ApplicationState baseState) {
		paintCanvas = baseCanvas;
		appState = baseState;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		startPoint = new Point(e.getX(), e.getY());
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		Point endPoint = new Point(e.getX(), e.getY());
		IMouseEvent newEvent = EventFactory.getEvent(startPoint, endPoint, paintCanvas, appState);
		newEvent.Execute();
	}
}
