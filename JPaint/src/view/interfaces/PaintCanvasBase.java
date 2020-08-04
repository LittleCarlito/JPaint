package view.interfaces;

import java.awt.Graphics2D;

import javax.swing.JComponent;

import model.IShapeManager;

public abstract class PaintCanvasBase extends JComponent {
	private static final long serialVersionUID = 7176229741060026776L;

	public abstract IShapeManager getShapeManager();
	
	public abstract Graphics2D getGraphics2D();
}
