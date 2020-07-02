package model.interfaces;

import model.Point;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;

public interface IShape {
	public ShapeType getType();
	public ShapeColor getColor();
	public ShapeShadingType getShade();
	public Point getOrigin();
	public int getWidth();
	public int getHeight();
}
