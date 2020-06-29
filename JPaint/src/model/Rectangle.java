package model;

import model.interfaces.IShape;

public class Rectangle implements IShape{
	private ShapeType sType = ShapeType.RECTANGLE;
	private ShapeColor sColor;
	private Point sOrigin;
	private int sWidth;
	private int sHeight;
	
	public Rectangle (ShapeColor newColor, Point newOrigin, int newWidth, int newHeight) {
		sColor = newColor;
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
