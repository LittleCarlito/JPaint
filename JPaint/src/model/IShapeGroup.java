package model;

import java.util.ArrayList;
import java.util.List;

import controller.singletons.ListOutput;
import model.interfaces.IShape;
import model.interfaces.IShapeObject;

public class IShapeGroup implements IShapeObject {
	private ArrayList<IShape> shapeList;

	public IShapeGroup() {
		shapeList = new ArrayList<IShape>();
	}
	
	@Override
	public List<IShape> getShape() {
		return shapeList;
	}

	@Override
	public void print() {
		ListOutput.execute(shapeList, (IShape shape) -> {shape.print();});
	}

}
