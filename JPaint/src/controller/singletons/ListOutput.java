package controller.singletons;

import java.util.List;

import controller.interfaces.IShapeCommand;
import model.interfaces.IShape;

public class ListOutput{
	
	public ListOutput() {
	}

	public static void execute(List<IShape> shapeList, IShapeCommand command) {
//		System.out.println("Output Factory\nSize of list: " + shapeList.size() + "\n");
		for (IShape shape : shapeList) {
			command.execute(shape);
		}
	}
}
