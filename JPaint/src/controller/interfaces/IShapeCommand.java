package controller.interfaces;

import model.interfaces.IDrawable;

public interface IShapeCommand {
	public void execute(IDrawable o);
}
