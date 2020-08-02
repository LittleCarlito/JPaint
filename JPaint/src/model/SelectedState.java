package model;

import controller.interfaces.IPrinter;
import model.interfaces.IShape;
import model.interfaces.IShapeState;

public class SelectedState implements IShapeState {
	private IShape outline;
	private IShape shape;
	private IPrinter printer;
	
	public SelectedState(IShape outline, IShape shape, IPrinter printer) {
		this.outline = outline;
		this.shape = shape;
		this.printer = printer;
	}

	@Override
	public void print() {
		outline.print();
		printer.print(shape);
	}

}
