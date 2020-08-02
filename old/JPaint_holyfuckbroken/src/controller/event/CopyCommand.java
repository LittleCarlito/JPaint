package controller.event;

import java.util.List;

import controller.Printer.ListOutput;
import controller.interfaces.IMouseEvent;
import model.ShapeHandler;
import model.interfaces.IShape;
import view.interfaces.PaintCanvasBase;

public class CopyCommand implements IMouseEvent {
	
	private PaintCanvasBase paintCanvas;
	
	public CopyCommand(PaintCanvasBase paintCanvas) {
		this.paintCanvas = paintCanvas;
	}

	@Override
	public void execute() {
		paintCanvas.clearClip();
		List<IShape> selectList = paintCanvas.getSelect();
		List<IShape> clipList = paintCanvas.getClip();
		IShape tempShape;
		System.out.println("Select list has these ID:");
		ListOutput.execute(selectList, (IShape shape) -> {System.out.println(shape.getID());});
		for(IShape shape : selectList) {
			tempShape = ShapeHandler.unwrap(shape);
			if (clipList.contains(tempShape)){
				System.out.println("It isn't supposed to be doing this!");
			}
			else {
				clipList.add(tempShape);
			}
		}
//		ListOutput.execute(selectList, (IShape shape) -> {clipList.add(ShapeHandler.unwrap(shape));});
//		System.out.println("\nClipboard has: ");
//		ListOutput.execute(clipList, (IShape shape) -> {System.out.println(shape.getID());});
	}

}
