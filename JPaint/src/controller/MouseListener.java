package controller;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.Point;
import model.persistence.ApplicationState;
import view.gui.PaintCanvas;
import view.interfaces.PaintCanvasBase;

public class MouseListener extends MouseAdapter{
	
	private Point startPoint;
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
		int width = e.getX() - startPoint.getX();
		int height = e.getY() - startPoint.getY();
		
		
		// Hard set for rectangle only; should make this based off of "shape" class instead
		// Can't draw rectangles clicking and dragging mouse to left or up
		// think about passing Graphics2D into this listener to abstract away from this creation
		// Should be making everything new in one area of code, not throughout
		Graphics2D graphics2d = paintCanvas.getGraphics2D();
        graphics2d.setColor(Color.GREEN);
        graphics2d.fillRect(startPoint.getX(), startPoint.getY(), width, height);
	}
}
