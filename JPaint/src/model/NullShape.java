package model;

import controller.interfaces.IPrinter;
import model.interfaces.IDrawable;
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

	@Override
	public void setSelect() {
		// TODO Auto-generated method stub
	}

	@Override
	public void setDeselect() {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean add(IDrawable o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(IDrawable o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean collides(IShape o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void move(Point moveDimension) {
		// TODO Auto-generated method stub
	}

	@Override
	public IDrawable getClone() {
		return new NullShape();
	}

	@Override
	public Point pasteOrigin(Point pastePoint) {
		// TODO Auto-generated method stub
		return pastePoint;
	}

	@Override
	public boolean ungroup() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void soundOff() {
		// TODO Auto-generated method stub
	}

	@Override
	public IPrinter getPrinter() {
		// TODO Auto-generated method stub
		return null;
	}

}
