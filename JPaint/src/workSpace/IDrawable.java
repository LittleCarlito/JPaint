package workSpace;

import model.Point;
import model.interfaces.IShape;

public interface IDrawable {
	
	public int getID();
	public IDrawable getClone();
	public boolean add(IDrawable o);
	public boolean remove(IDrawable o);
	public boolean collides(IShape o);
	public void move(Point moveDimension);
	public Point pasteOrigin(Point pastePoint);
	public void setSelect();
	public void setDeselect();
	public boolean ungroup();
	public void print();
	public void soundOff();
}
