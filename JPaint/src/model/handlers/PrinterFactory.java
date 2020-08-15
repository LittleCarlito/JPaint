package model.handlers;

import model.interfaces.IPrinter;
import model.printer.EllipseOutlinePrinter;
import model.printer.EllipsePrinter;
import model.printer.RectangleOutlinePrinter;
import model.printer.RectanglePrinter;
import model.printer.TriangleOutlinePrinter;
import model.printer.TrianglePrinter;
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
	
	public static IPrinter getRectangleOutlinePrinter(PaintCanvasBase canvas) {
		return new RectangleOutlinePrinter(canvas);
	}
	
	public static IPrinter getEllipseOutlinePrinter(PaintCanvasBase canvas) {
		return new EllipseOutlinePrinter(canvas);
	}
	
	public static IPrinter getTriangleOutlinePrinter(PaintCanvasBase canvas) {
		return new TriangleOutlinePrinter(canvas);
	}
}
