package model.interfaces;

import model.Point;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;

public interface IShape {
	public int getID();
	public ShapeType getType();
	public ShapeColor getColor();
	public ShapeColor getSecondColor();
	public ShapeShadingType getShade();
	public Point getOrigin();
	public int getWidth();
	public int getHeight();
	public IShape getClone(Point newOrigin);
	public boolean equals(Object obj);
}
