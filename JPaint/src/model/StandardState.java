package model;

import controller.interfaces.IPrinter;
import model.interfaces.IShape;
import model.interfaces.IShapeState;

public class StandardState implements IShapeState {
	private IShape shape;
	private IPrinter printer;
	
	public StandardState(IPrinter printer, IShape shape) {
		this.printer = printer;
		this.shape = shape;
	}

	@Override
	public void print() {
		printer.print(shape);
	}

}
