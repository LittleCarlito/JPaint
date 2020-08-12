package controller.singletons;

import java.util.List;

import controller.interfaces.IShapeCommand;
import workSpace.IDrawable;

public class ListOutput{
	
	public ListOutput() {
	}

	public static void execute(List<IDrawable> shapeList, IShapeCommand command) {
//		System.out.println("Output Factory\nSize of list: " + shapeList.size() + "\n");
		for (IDrawable shape : shapeList) {
			command.execute(shape);
		}
	}
}
