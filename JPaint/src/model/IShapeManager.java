package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import controller.singletons.ListOutput;
import model.interfaces.IShape;

public class IShapeManager {
	private List<IShape> shapeList;
	private List<IShape> selectList;
	private List<IShape> clipList;
	private Stack<IShape> deleteList;
	
	public IShapeManager() {
		shapeList = new ArrayList<IShape>();
		selectList = new ArrayList<IShape>();
		clipList = new ArrayList<IShape>();
		deleteList = new Stack<IShape>();
	}
	
	public void add(IShape newShape) {
		shapeList.add(newShape);
	}
	
	public void select(IShape newShape) {
		selectList.add(newShape);
	}
	
	public List<IShape> getShapes() {
		return shapeList;
	}
	
	public List<IShape> getSelect() {
		return selectList;
	}
	
	public List<IShape> getClip(){
		return clipList;
	}
	
	public void cleanShapeList(List<IShape> removeList) {
		ListOutput.execute(removeList, (IShape shape) -> {if(shapeList.contains(shape)) {shapeList.remove(shape);}});
	}

	public void deSelect() {
		ListOutput.execute(selectList, (IShape shape) -> {shapeList.add(shape);});
		selectList.clear();
	}
	
	public void clearClip() {
		clipList.clear();
	}
	
	public void deleteCommand() {
		ListOutput.execute(selectList, (IShape shape) -> {deleteList.push(shape);});
		selectList.clear();
	}
}
