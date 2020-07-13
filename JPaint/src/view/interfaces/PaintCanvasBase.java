package view.interfaces;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;

import model.interfaces.IShape;

public abstract class PaintCanvasBase extends JComponent {
	private static final long serialVersionUID = 7176229741060026776L;

	public abstract Graphics2D getGraphics2D();
	
	public abstract void add(IShape shape);
	
	public abstract void select(IShape shape);
	
	public abstract List<IShape> getShapes();
	
	public abstract List<IShape> getSelect();
	
	public abstract void cleanShapeList(List<IShape> shape);
	
	public abstract void deSelect();
}
