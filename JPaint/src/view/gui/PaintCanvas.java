package view.gui;

import java.awt.Graphics2D;

import view.interfaces.PaintCanvasBase;
import controller.singletons.CanvasClear;
import model.IShapeManager;

public class PaintCanvas extends PaintCanvasBase {
	private static final long serialVersionUID = 1509453058678547085L;
	private IShapeManager shapeManager;
	
	public PaintCanvas(IShapeManager shapeManager) {
		this.shapeManager = shapeManager;
		new CanvasClear(this);
	}
	
	public IShapeManager getShapeManager() {
		return shapeManager;
	}
	
    public Graphics2D getGraphics2D() {
        return (Graphics2D)getGraphics();
    }
}
