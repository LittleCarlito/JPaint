package model;

import java.util.ArrayList;
import java.util.List;

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
		for(IDrawable drawObject : groupList)
			drawObject.print();
	}

	@Override
	public void setSelect() {
		for(IDrawable drawObject : groupList)
			drawObject.setSelect();
	}

	@Override
	public void setDeselect() {
		for(IDrawable drawObject : groupList)
			drawObject.setDeselect();
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
			for(IDrawable drawObject : groupList) {
				drawObject.setSelect();
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

	@Override
	public IDrawable getClone() {
//		int baseIndex = -1;
//		IDrawable baseShape;
//		List<IDrawable> listCopy = new ArrayList<IDrawable>();
//		for (IDrawable drawObject : groupList) {
//			if (drawObject.getID() == baseShapeId) {
//				baseIndex = groupList.indexOf(drawObject);
//			}
//			else {
//				listCopy.add(drawObject);
//			}
//		}
//		baseShape = groupList.get(baseIndex).getClone();
//		IDrawable groupCopy = GroupCreator.getGroup(baseShape);
//		for (IDrawable drawObject : listCopy) {
//			groupCopy.add(drawObject.getClone());
//		}
//		return groupCopy;
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
		for (IDrawable drawObject : listCopy) {
			groupCopy.add(drawObject.getClone());
		}
		return groupCopy;
	}
	
//	@Override
//	public IDrawable getDeepCopy() {
//		int baseIndex = -1;
//		IDrawable baseShape;
//		List<IDrawable> listCopy = new ArrayList<IDrawable>();
//		for (IDrawable drawObject : groupList) {
//			if (drawObject.getID() == baseShapeId) {
//				baseIndex = groupList.indexOf(drawObject);
//			}
//			else {
//				listCopy.add(drawObject);
//			}
//		}
//		baseShape = groupList.get(baseIndex).getClone();
//		IDrawable groupCopy = GroupCreator.getClone(id, baseShape);
//		for (IDrawable drawObject : listCopy) {
//			groupCopy.add(drawObject.getClone());
//		}
//		return groupCopy;
//	}

	@Override
	public Point pasteOrigin(Point pastePoint) {
		Point newOrigin = pastePoint;
		for(IDrawable drawObject : groupList) {
			newOrigin = drawObject.pasteOrigin(newOrigin);
		}
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
		for(IDrawable drawObject : cleanList) {
			groupList.remove(drawObject);
		}
		return (cleanList.size() > 0 ? true : false);
	}
	
	@Override
	public void soundOff() {
		System.out.println("Group ID and baseShape Id: " + id + " " + baseShapeId + "\nContaining Ids: ");
		for(IDrawable drawObject : groupList) {
			System.out.print(drawObject.getID() + "\n");
		}
	}
}
