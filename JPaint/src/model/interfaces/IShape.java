package model.interfaces;

import java.util.List;

import controller.interfaces.IPrinter;
import model.Point;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;

public interface IShape{
	public int getID();
	public ShapeType getType();
	public ShapeColor getColor();
	public ShapeColor getSecondColor();
	public ShapeShadingType getShade();
	public Point getOrigin();
	public int getWidth();
	public int getHeight();
	public IShape getCloneAt(Point newOrigin);
	public boolean equals(Object obj);
	public void print();
	public void setPrinter(IPrinter newPrinter);
	public void setOutline(IShape outline);
	public void setSelect();
	public void setNoSelect();
	public void group(IShape shape);
	public void degroup();
	public List<IShape> getGroup();
	public void groupPrint();
	public void select();
	public void deSelect();
}
