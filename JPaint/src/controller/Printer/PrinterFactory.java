package controller.Printer;

import controller.interfaces.IPrinter;
import view.interfaces.PaintCanvasBase;

public class PrinterFactory {
	
	private PrinterFactory() {
	}
	
	public static IPrinter getRectanglePrinter(PaintCanvasBase canvas) {
		return new RectanglePrinter(canvas);
	}
	
	public static IPrinter getEllipsePrinter(PaintCanvasBase canvas) {
		return new EllipsePrinter(canvas);
	}
	
	public static IPrinter getTrianglePrinter(PaintCanvasBase canvas) {
		return new TrianglePrinter(canvas);
	}
}
