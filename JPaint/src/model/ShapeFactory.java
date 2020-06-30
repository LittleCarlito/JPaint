package model;

import model.interfaces.IShape;

public class ShapeFactory{
	private Point origin;
	private ShapeColor color;
	private ShapeType type;
	private int width;
	private int height;

	public ShapeFactory (ShapeColor newColor, ShapeType newType, Point newOrigin, int newWidth, int newHeight) {
		color = newColor;
		type = newType;
		origin = newOrigin;
		width = newWidth;
		height = newHeight;
	}
	public IShape getShape() {
		if(!type.equals(null)) {
			return new Rectangle(color, origin, width, height);
		}
		return null;
	}

}
