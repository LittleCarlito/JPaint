package model.interfaces;

import model.Point;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;

public interface IShape extends IDrawable{
	public ShapeType getType();
	public ShapeColor getColor();
	public ShapeColor getSecondColor();
	public ShapeShadingType getShade();
	public Point getOrigin();
	public int getWidth();
	public int getHeight();
	public IPrinter getPrinter();
	public void setPrinter(IPrinter newPrinter);
	public void setOutline(IShape outline);
	public boolean equals(Object obj);
}
