package model;

import controller.interfaces.IPrinter;
import model.interfaces.IShape;

public class NullShape implements IShape {

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ShapeType getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShapeColor getColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShapeColor getSecondColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShapeShadingType getShade() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Point getOrigin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public IShape getCloneAt(Point newOrigin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPrinter(IPrinter newPrinter) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setOutline(IShape outline) {
		// TODO Auto-generated method stub

	}

}
