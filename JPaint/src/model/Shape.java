package model;

import model.interfaces.IShape;

public class Shape implements IShape{
	private static int sID;
	private ShapeType sType;
	private ShapeColor sColor;
	private ShapeColor sSecondColor;
	private ShapeShadingType sShade;
	private Point sOrigin;
	private int sWidth;
	private int sHeight;
	
	public Shape (int newID, ShapeType newType, ShapeColor newColor, ShapeColor newSecondColor, ShapeShadingType newShade, Point newOrigin, int newWidth, int newHeight) {
		sID = newID;
		sType = newType;
		sColor = newColor;
		sSecondColor = newSecondColor;
		sShade = newShade;
		sOrigin = newOrigin;
		sWidth = newWidth;
		sHeight = newHeight;
	}
	
	@Override
	public int getID() {
		return sID;
	}
	
	@Override
	public ShapeType getType() {
		return sType;
	}
	@Override
	public ShapeColor getColor() {
		return sColor;
	}
	@Override
	public ShapeShadingType getShade() {
		return sShade;
	}
	@Override
	public Point getOrigin() {
		return sOrigin;
	}
	@Override
	public int getWidth() {
		return sWidth;
	}
	@Override
	public int getHeight() {
		return sHeight;
	}

	@Override
	public ShapeColor getSecondColor() {
		return sSecondColor;
	}

	@Override
	public IShape getClone(Point newOrigin) {
		return new Shape(sID, sType, sColor, sSecondColor, sShade, newOrigin, sWidth, sHeight);
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
		if (sID == other.getID()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
}
