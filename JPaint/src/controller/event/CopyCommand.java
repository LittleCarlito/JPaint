package controller.event;

import java.util.List;

import controller.Printer.ListOutput;
import controller.interfaces.IMouseEvent;
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
		ListOutput.execute(selectList, (IShape shape) -> {clipList.add(shape);});
		
		System.out.println("\nClipboard has: ");
		ListOutput.execute(clipList, (IShape shape) -> {System.out.println(shape.toString());});
	}

}
