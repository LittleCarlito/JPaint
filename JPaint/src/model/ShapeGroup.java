package model;

import java.util.ArrayList;
import java.util.List;

import controller.singletons.ListOutput;
import model.handlers.GroupCreator;
import model.handlers.IShapeManager;
import model.interfaces.IDrawable;
import model.interfaces.IShape;

public class ShapeGroup implements IDrawable{
	
	private final int id;
	private final int baseShapeId;
	private List<IDrawable> groupList;
	
	public ShapeGroup(int groupId, IDrawable baseShape) {
		baseShapeId = baseShape.getID();
		id = groupId;
		groupList = new ArrayList<IDrawable>();
		groupList.add(baseShape);
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
		ListOutput.execute(groupList, (IDrawable drawObject) -> {drawObject.print();});
	}

	@Override
	public void setSelect() {
		ListOutput.execute(groupList, (IDrawable drawObject) -> {drawObject.setSelect();});
	}

	@Override
	public void setDeselect() {
		ListOutput.execute(groupList, (IDrawable drawObject) -> {drawObject.setDeselect();});
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
		if(result) {
			ListOutput.execute(groupList, (IDrawable drawObject) -> {drawObject.setSelect();});
		}
		return result;
	}

	@Override
	public void move(Point moveDimension) {
		ListOutput.execute(groupList, (IDrawable drawObject) -> {drawObject.move(moveDimension);});
	}

	@Override
	public IDrawable getClone() {
		int baseIndex = -1;
		IDrawable baseShape;
		List<IDrawable> listCopy = new ArrayList<IDrawable>();
		for (IDrawable drawObject : groupList) {
			if (drawObject.getID() == baseShapeId) {
				baseIndex = groupList.indexOf(drawObject);
			}
			else {
				listCopy.add(drawObject);
			}
		}
		baseShape = groupList.get(baseIndex).getClone();
		IDrawable groupCopy = GroupCreator.getClone(id, baseShape);
		ListOutput.execute(listCopy, (IDrawable drawObject) -> {groupCopy.add(drawObject.getClone());});
		return groupCopy;
	}

	@Override
	public Point pasteOrigin(Point pastePoint) {
		Point newOrigin = pastePoint;
		ListOutput.execute(groupList, (IDrawable drawObject) -> {drawObject.pasteOrigin(newOrigin);});
		return newOrigin;
	}

	@Override
	public boolean ungroup() {
		List<IDrawable> cleanList = new ArrayList<IDrawable>();
		for(IDrawable drawObject : groupList) {
			drawObject.setDeselect();
			if(drawObject.getID() != baseShapeId) {
				IShapeManager.addGroup(drawObject);
				cleanList.add(drawObject);
			}
		}
		ListOutput.execute(cleanList, (IDrawable drawObject) -> {groupList.remove(drawObject);});
		return (cleanList.size() > 0 ? true : false);
	}
	
	@Override
	public void soundOff() {
		System.out.println("Group ID and baseShape Id: " + id + " " + baseShapeId + "\nContaining Ids: ");
		ListOutput.execute(groupList, (IDrawable drawObject) -> {System.out.print(drawObject.getID() + "\n");});
	}

	@Override
	public void addId(List<Integer> idList) {
		for(IDrawable drawObject : groupList) {
			if(!idList.contains(id))
				idList.add(id);
			drawObject.addId(idList);
		}
	}
}
