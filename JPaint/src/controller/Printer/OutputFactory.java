package controller.Printer;

import java.util.List;

import controller.interfaces.IShapeCommand;
import model.interfaces.IShape;

public class OutputFactory{
	
	public OutputFactory() {
	}

	public static void execute(List<IShape> shapeList, IShapeCommand command) {
		System.out.println("Output Factory\nSize of list: " + shapeList.size() + "\n");
		for (IShape shape : shapeList) {
			command.execute(shape);
		}
	}
}
