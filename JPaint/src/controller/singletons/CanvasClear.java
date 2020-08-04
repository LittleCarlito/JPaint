package controller.singletons;

import java.awt.Color;
import java.awt.Graphics2D;

import view.interfaces.PaintCanvasBase;

public class CanvasClear {
	private static PaintCanvasBase canvas;
	
	public CanvasClear(PaintCanvasBase canvas) {
		CanvasClear.canvas = canvas;
	}
	
	public static void clear() {
		Graphics2D graphics2d = canvas.getGraphics2D();      
		graphics2d.setColor(Color.WHITE);
		graphics2d.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
	}

}
