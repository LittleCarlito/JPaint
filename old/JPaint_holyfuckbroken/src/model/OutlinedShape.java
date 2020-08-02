package model;

import controller.interfaces.IPrinter;
import model.interfaces.IShape;

public class OutlinedShape implements IShape {
	private IShape shape;
	private IPrinter printer;
	
	public OutlinedShape(IShape shape) {
		this.shape = shape;
		printer = shape.getPrinter();
	}

	@Override
	public int getID() {
		return shape.getID();
	}

	@Override
	public ShapeType getType() {
		return shape.getType();
	}

	@Override
	public ShapeColor getColor() {
		return shape.getColor();
	}

	@Override
	public ShapeColor getSecondColor() {
		return shape.getSecondColor();
	}

	@Override
	public ShapeShadingType getShade() {
		return shape.getShade();
	}

	@Override
	public Point getOrigin() {
		return shape.getOrigin();
	}

	@Override
	public int getWidth() {
		return shape.getWidth();
	}

	@Override
	public int getHeight() {
		return shape.getHeight();
	}

	@Override
	public IShape getClone(ShapeColor newColor, ShapeShadingType newShade, Point newOrigin, int cWidth, int cHeight) {
		return shape.getClone(newColor, newShade, newOrigin, cWidth, cHeight);

	}

	@Override
	public void print() {
		Point outlineOrigin = new Point(getOrigin().getX() - 5, getOrigin().getY() - 5);
		int outlineWidth = getWidth() + 10;
		int outlineHeight = getHeight() + 10;
		IShape outline = shape.getClone(ShapeColor.BLACK, ShapeShadingType.SELECTED, outlineOrigin, outlineWidth, outlineHeight);
//		IShape outline = ShapeHandler.getShape(getType(), ShapeColor.BLACK, ShapeColor.WHITE, ShapeShadingType.SELECTED,outlineOrigin, new int[] { outlineWidth, outlineHeight });
		printer.print(outline);
		shape.print();
	}

	@Override
	public void setPrinter(IPrinter newPrinter) {
		printer = newPrinter;
		shape.setPrinter(printer);
	}

	@Override
	public IPrinter getPrinter() {
		return printer;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shape other = (Shape) obj;
		if (shape.getID() == other.getID()) {
			return true;
		}
		else {
			return false;
		}
	}

}
