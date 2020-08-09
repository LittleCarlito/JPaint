package model;

import controller.interfaces.IPrinter;
import model.interfaces.IShape;
import model.interfaces.IShapeState;

public class ShapeState implements IShapeState {
	private IShape outline;
	private IShape shape;
	private IPrinter printer;
	
	public ShapeState(IShape shape, IShape outline, IPrinter printer) {
		this.outline = outline;
		this.shape = shape;
		this.printer = printer;
	}

	@Override
	public void print() {
		printer.print(shape);
		outline.print();
	}
}
