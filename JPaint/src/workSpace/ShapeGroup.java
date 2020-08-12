package workSpace;

import java.util.ArrayList;
import java.util.List;

import model.Point;
import model.Shape;
import model.interfaces.IShape;

public class ShapeGroup implements IDrawable{
	
	private final int id;
	private List<IDrawable> groupList;
	
	public ShapeGroup(int id) {
		this.id = id;
		groupList = new ArrayList<IDrawable>();
	}
	
	@Override
	public int getID() {
		return id;
	}
	@Override
	public boolean add(IDrawable o) {
		groupList.add(o);
		return true;
	}

	@Override
	public boolean remove(IDrawable o) {
		if(groupList.contains(o)) {
			groupList.remove(o);
			return true;
		}
		return false;
	}

	@Override
	public void print() {
		for(IDrawable i : groupList)
			i.print();
	}

	@Override
	public void setSelect() {
		for(IDrawable i : groupList)
			i.setSelect();
	}

	@Override
	public void setDeselect() {
		for(IDrawable i : groupList)
			i.setDeselect();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShapeGroup other = (ShapeGroup) obj;
		if (id == other.getID()) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean collides(IShape o) {
		boolean result = false;
		for(IDrawable drawObject : groupList) {
			if(drawObject.collides(o)) {
				result = true;
			}
		}
		return result;
	}

	@Override
	public void move(Point moveDimension) {
		for (IDrawable drawObject : groupList) {
			drawObject.move(moveDimension);
		}
	}
}
