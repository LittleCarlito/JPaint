package workSpace;

import model.Point;
import model.interfaces.IShape;

public interface IDrawable {
	
	public int getID();
	public boolean add(IDrawable o);
	public boolean remove(IDrawable o);
	public boolean collides(IShape o);
	public void move(Point moveDimension);
	public void setSelect();
	public void setDeselect();
	public void print();
}
