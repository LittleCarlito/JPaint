package controller.event;

import java.util.Stack;

import controller.interfaces.IMouseEvent;

public class CommandHistory {
	private static final Stack<IMouseEvent> undoStack = new Stack<IMouseEvent>();
	private static final Stack<IMouseEvent> redoStack = new Stack<IMouseEvent>();

	public static void add(IMouseEvent cmd) {
		undoStack.push(cmd);
		redoStack.clear();
//		System.out.println("Command was added");
	}
	
	public static boolean undo() {
		boolean result = !undoStack.empty();
		System.out.println("Undo was successfully clicked\nUndo stack is not empty: " + result);
		if (result) {
			IMouseEvent c = undoStack.pop();
			redoStack.push(c);
			c.undo();
		}
		return result;
	}

	public static boolean redo() {
		boolean result = !redoStack.empty();
		if (result) {
			IMouseEvent c = redoStack.pop();
			undoStack.push(c);
			c.redo();
		}
		return result;
	}
}
