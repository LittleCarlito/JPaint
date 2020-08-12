package view.gui;

import java.awt.Graphics2D;

import view.interfaces.PaintCanvasBase;
import controller.singletons.CanvasClear;

public class PaintCanvas extends PaintCanvasBase {
	private static final long serialVersionUID = 1509453058678547085L;
	
	public PaintCanvas() {
		new CanvasClear(this);
	}
	
    public Graphics2D getGraphics2D() {
        return (Graphics2D)getGraphics();
    }
}
