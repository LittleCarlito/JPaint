package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import controller.singletons.CanvasClear;
import controller.singletons.ListOutput;
import model.interfaces.IShape;
import workSpace.IDrawable;

public class IShapeManager {
	private static List<IDrawable> shapeList;
	private static List<IDrawable> selectList;
	private static List<IDrawable> clipList;
	private static Stack<IDrawable> deleteList;

	
	public IShapeManager() {
		shapeList = new ArrayList<IDrawable>();
		selectList = new ArrayList<IDrawable>();
		clipList = new ArrayList<IDrawable>();
		deleteList = new Stack<IDrawable>();
	}
	
	public static void selectWithin(IShape selectShape) {
		for(IDrawable drawObject : shapeList) {
			if(drawObject.collides(selectShape))
				selectList.add(drawObject);
		}
	}
	
	public static void unGroup(List<IDrawable> groupList) {
		
	}
	
	public static void addSelect(IDrawable newSelect) {
		selectList.add(newSelect);
	}
	
	public static void addGroup(IDrawable drawObject) {
		shapeList.add(drawObject);
	}
	
	public static void removeGroup(IDrawable drawObject) {
		boolean shapeListCheck = shapeList.contains(drawObject);
		boolean selectListCheck = selectList.contains(drawObject);
		if(shapeListCheck) {
			shapeList.remove(shapeList.indexOf(drawObject));
		}
		else if(selectListCheck) {
			selectList.remove(selectList.indexOf(drawObject));
		}
	}
	
	public static void select(IDrawable newShape) {
		newShape.setSelect();
		selectList.add(newShape);
	}
	
	public static List<IDrawable> getShapes() {
		return shapeList;
	}
	
	public static List<IDrawable> getSelect() {
		return selectList;
	}
	
	public static List<IDrawable> getClip(){
		return clipList;
	}
	
	public static void cleanShapeList(List<IDrawable> removeList) {
		for(IDrawable drawObject : removeList) {
			if(shapeList.contains(drawObject)) {
				shapeList.remove(drawObject);
			}
			else if(selectList.contains(drawObject)) {
				selectList.remove(drawObject);
			}
		}
	}

	public static void deSelect() {
		ListOutput.execute(selectList, (IDrawable shape) -> {shape.setDeselect();});
		ListOutput.execute(selectList, (IDrawable shape) -> {shapeList.add(shape);});
		selectList.clear();
	}
	
	public static void clearSelect() {
		selectList.clear();
	}
	
	public static void clearClip() {
		clipList.clear();
	}
	
	public static void deleteCommand() {
		ListOutput.execute(selectList, (IDrawable shape) -> {deleteList.push(shape);});
		selectList.clear();
	}
	
	public static void print() {
		CanvasClear.clear();
		ListOutput.execute(shapeList, ((IDrawable shape) -> {shape.print();}));
		ListOutput.execute(selectList, ((IDrawable shape) -> {shape.print();}));
	}
	
	public static void soundOff() {
		System.out.println("\n----------------------------------------------------------------------------------------");
		System.out.println("Shape list: ");
		ListOutput.execute(shapeList, ((IDrawable shape) -> {shape.soundOff();}));
		System.out.println("\nSelect list ids: ");
		ListOutput.execute(selectList, ((IDrawable shape) -> {shape.soundOff();}));
		System.out.println("\nClip board ids: ");
		ListOutput.execute(clipList, ((IDrawable shape) -> {shape.soundOff();}));
		System.out.println("\nDelete list ids: ");
		ListOutput.execute(deleteList, ((IDrawable shape) -> {shape.soundOff();}));
		System.out.println("----------------------------------------------------------------------------------------\n");
//		System.out.println("\n----------------------------------------------------------------------------------------");
//		System.out.println("Shape list ids: ");
//		ListOutput.execute(shapeList, ((IDrawable shape) -> {System.out.println("ShapeList ID: " + shape.getID());}));
//		System.out.println("\nSelect list ids: ");
//		ListOutput.execute(selectList, ((IDrawable shape) -> {System.out.println("SelectList ID: " + shape.getID());}));
//		System.out.println("\nClip board ids: ");
//		ListOutput.execute(clipList, ((IDrawable shape) -> {System.out.println("SelectList ID: " + shape.getID());}));
//		System.out.println("\nDelete list ids: ");
//		ListOutput.execute(deleteList, ((IDrawable shape) -> {System.out.println("SelectList ID: " + shape.getID());}));
//		System.out.println("----------------------------------------------------------------------------------------\n");
	}
}
