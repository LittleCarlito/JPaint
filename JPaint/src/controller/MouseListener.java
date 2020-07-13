package controller;

import java.awt.Color;
import java.awt.Graphics2D;
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
		new EventFactory();
		paintCanvas = baseCanvas;
		appState = baseState;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		startPoint = new Point(e.getX(), e.getY());
		//Put stuff to clear out select list at the start of every mouse click
			//Should remove them from select list and put them back in the shape list
			//Could make a seed for Shape object to get global draw order and sort array lists by that, decides who gets printed first
		//Change the mouse events to have a super class that does draw for execute
			//Have the draw just call super for execute
			//the other two do their thing then do super at the end of their executes
				//this will make sure that when we do selects the repaint() above won't delete everything off the screen and leave a blank screen after it executes
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		Point endPoint = new Point(e.getX(), e.getY());
		
		// Create Mouse Click Event
		IMouseEvent newEvent = EventFactory.getEvent(startPoint, endPoint, paintCanvas, appState);
		
		Graphics2D graphics2d = paintCanvas.getGraphics2D();      
		graphics2d.setColor(Color.WHITE);
		graphics2d.fillRect(0, 0, 2000, 1000);
		newEvent.Execute();
	}
}
