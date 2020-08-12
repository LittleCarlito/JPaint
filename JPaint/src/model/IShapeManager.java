package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import controller.singletons.CanvasClear;
import controller.singletons.ListOutput;
import model.interfaces.IShape;
import view.interfaces.PaintCanvasBase;
import workSpace.IDrawable;

public class IShapeManager {
	private List<IDrawable> shapeList;
	private List<IDrawable> selectList;
	private List<IDrawable> clipList;
	private Stack<IDrawable> deleteList;
	private PaintCanvasBase canvas;
	
	public IShapeManager(PaintCanvasBase canvas) {
		this.canvas = canvas;
		shapeList = new ArrayList<IDrawable>();
		selectList = new ArrayList<IDrawable>();
		clipList = new ArrayList<IDrawable>();
		deleteList = new Stack<IDrawable>();
	}
	
	public void selectWithin(IShape selectShape) {
		for(IDrawable drawObject : shapeList) {
			if(drawObject.collides(selectShape))
				selectList.add(drawObject);
		}
	}
	
	public void addSelect(IDrawable newSelect) {
		selectList.add(newSelect);
	}
	
	public void addGroup(IDrawable drawObject) {
		shapeList.add(drawObject);
	}
	
	public void removeGroup(IDrawable drawObject) {
		boolean shapeListCheck = shapeList.contains(drawObject);
		boolean selectListCheck = selectList.contains(drawObject);
//		int shapeIndex = shapeList.indexOf(shape);
//		int selectIndex = selectList.indexOf(shape);
//		System.out.println("\nShape to undo was in shapeList: " + shapeListCheck + "\nIts index is: " + shapeIndex);
//		System.out.println("Shape to undo was in shapeList: " + selectListCheck + "\nIts index is: " + selectIndex);
		if(shapeListCheck) {
			shapeList.remove(shapeList.indexOf(drawObject));
		}
		else if(selectListCheck) {
			selectList.remove(selectList.indexOf(drawObject));
		}
	}
	
	public void remove(IShape shape) {
		boolean shapeListCheck = shapeList.contains(shape);
		boolean selectListCheck = selectList.contains(shape);
//		int shapeIndex = shapeList.indexOf(shape);
//		int selectIndex = selectList.indexOf(shape);
//		System.out.println("\nShape to undo was in shapeList: " + shapeListCheck + "\nIts index is: " + shapeIndex);
//		System.out.println("Shape to undo was in shapeList: " + selectListCheck + "\nIts index is: " + selectIndex);
		if(shapeListCheck) {
			shapeList.remove(shapeList.indexOf(shape));
		}
		else if(selectListCheck) {
			selectList.remove(selectList.indexOf(shape));
		}
	}
	
	public PaintCanvasBase getCanvas() {
		return canvas;
	}
	
	public void add(IShape newShape) {
		shapeList.add(newShape);
	}
	
	public void select(IShape newShape) {
		newShape.setSelect();
		selectList.add(newShape);
	}
	
	public List<IDrawable> getShapes() {
		return shapeList;
	}
	
	public List<IDrawable> getSelect() {
		return selectList;
	}
	
	public List<IDrawable> getClip(){
		return clipList;
	}
	
	public void cleanShapeList(List<IDrawable> removeList) {
		for(IDrawable drawObject : removeList) {
			if(shapeList.contains(drawObject)) {
				shapeList.remove(drawObject);
			}
			else if(selectList.contains(drawObject)) {
				selectList.remove(drawObject);
			}
		}
//		ListOutput.execute(removeList, (IDrawable shape) -> {if(shapeList.contains(shape)) {shapeList.remove(shape);}});
	}

	public void deSelect() {
		ListOutput.execute(selectList, (IDrawable shape) -> {shape.setDeselect();});
		ListOutput.execute(selectList, (IDrawable shape) -> {shapeList.add(shape);});
		selectList.clear();
	}
	
	public void clearClip() {
		clipList.clear();
	}
	
	public void deleteCommand() {
		ListOutput.execute(selectList, (IDrawable shape) -> {deleteList.push(shape);});
		selectList.clear();
	}
	
	public void print() {
		CanvasClear.clear();
		ListOutput.execute(shapeList, ((IDrawable shape) -> {shape.print();}));
		ListOutput.execute(selectList, ((IDrawable shape) -> {shape.print();}));
//		ListOutput.execute(shapeList, ((IShape shape) -> {System.out.println("ShapeList ID: " + shape.getID());}));
//		ListOutput.execute(selectList, ((IShape shape) -> {System.out.println("SelectList ID: " + shape.getID());}));

	}
	
	public void soundOff() {
		System.out.println("\n----------------------------------------------------------------------------------------");
		System.out.println("Shape list ids: ");
		ListOutput.execute(shapeList, ((IDrawable shape) -> {System.out.println("ShapeList ID: " + shape.getID());}));
		System.out.println("\nSelect list ids: ");
		ListOutput.execute(selectList, ((IDrawable shape) -> {System.out.println("SelectList ID: " + shape.getID());}));
		System.out.println("\nClip board ids: ");
		ListOutput.execute(clipList, ((IDrawable shape) -> {System.out.println("SelectList ID: " + shape.getID());}));
		System.out.println("\nDelete list ids: ");
		ListOutput.execute(deleteList, ((IDrawable shape) -> {System.out.println("SelectList ID: " + shape.getID());}));
		System.out.println("----------------------------------------------------------------------------------------\n");
	}
}
