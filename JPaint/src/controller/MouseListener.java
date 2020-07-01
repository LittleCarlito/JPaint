package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import event.EventFactory;
import event.IMouseEvent;
import model.Point;
import model.persistence.ApplicationState;
import view.interfaces.PaintCanvasBase;

public class MouseListener extends MouseAdapter{
	
	private Point startPoint;
	private Point endPoint;
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
		endPoint = new Point(e.getX(), e.getY());
		// Create Mouse Click Event
		IMouseEvent newEvent = new EventFactory(startPoint, endPoint, paintCanvas, appState).getEvent();
		newEvent.Execute();
	}
}
