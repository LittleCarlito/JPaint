package model.interfaces;

import controller.interfaces.IPrinter;
import model.Point;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import workSpace.IDrawable;

public interface IShape extends IDrawable{
	public ShapeType getType();
	public ShapeColor getColor();
	public ShapeColor getSecondColor();
	public ShapeShadingType getShade();
	public Point getOrigin();
	public int getWidth();
	public int getHeight();
	public boolean equals(Object obj);
	public void setPrinter(IPrinter newPrinter);
	public void setOutline(IShape outline);
	public void select();
	public void deSelect();
}
