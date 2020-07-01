package model;

import java.util.ArrayList;
import java.util.List;

import model.interfaces.IShape;

public class ShapeList<T> extends ArrayList<T>{
	private static final long serialVersionUID = 9043923558702240666L;
	List<IShape> shapeList;
	
	public ShapeList() {
		shapeList = new ArrayList<IShape>();
	}
}
