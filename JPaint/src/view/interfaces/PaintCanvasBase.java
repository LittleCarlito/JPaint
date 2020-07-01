package view.interfaces;

import javax.swing.*;

import model.ShapeList;
import model.interfaces.IShape;

import java.awt.*;

public abstract class PaintCanvasBase extends JComponent {
	private static final long serialVersionUID = 7176229741060026776L;

	public abstract Graphics2D getGraphics2D();
	
	public abstract void add(IShape shape);
	
	public abstract ShapeList<IShape> getShapes();
}
