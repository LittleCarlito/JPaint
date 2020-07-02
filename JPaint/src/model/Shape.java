package model;

import model.interfaces.IShape;

public class Shape implements IShape{
	private ShapeType sType;
	private ShapeColor sColor;
	private ShapeShadingType sShade;
	private Point sOrigin;
	private int sWidth;
	private int sHeight;
	
	public Shape (ShapeType newType, ShapeColor newColor, ShapeShadingType newShade, Point newOrigin, int newWidth, int newHeight) {
		sType = newType;
		sColor = newColor;
		sShade = newShade;
		sOrigin = newOrigin;
		sWidth = newWidth;
		sHeight = newHeight;
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
}
