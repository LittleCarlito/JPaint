package model;

import model.interfaces.IShape;
import model.interfaces.IShapeFactory;

public class ShapeFactory implements IShapeFactory{
	private Point origin;
	private ShapeType shapeType;
	private ShapeColor shapeColor;
	private int width;
	private int height;

	public ShapeFactory (ShapeType newType, ShapeColor newColor, Point newOrigin, int newWidth, int newHeight) {
		shapeType = newType;
		shapeColor = newColor;
		origin = newOrigin;
		width = newWidth;
		height = newHeight;
	}
	
	@Override
	public IShape getShape() {
		if(!shapeType.equals(null)) {
			return new Shape(shapeType, shapeColor, origin, width, height);
		}
		return null;
	}

}
