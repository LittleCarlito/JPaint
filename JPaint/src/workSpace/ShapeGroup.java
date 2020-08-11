package workSpace;

import java.util.ArrayList;
import java.util.List;

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
}
