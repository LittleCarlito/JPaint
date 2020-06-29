package model;

import model.interfaces.IFactory;
import model.interfaces.IShape;
import model.persistence.ApplicationState;

public class ShapeFactory implements IFactory {
	private ApplicationState appState;
	private ShapeColor color;
	private Point origin;
	private int width;
	private int height;

	public ShapeFactory (ApplicationState newAppState, ShapeColor newColor, Point newOrigin, int newWidth, int newHeight) {
		appState = newAppState; 
		color = newColor;
		origin = newOrigin;
		width = newWidth;
		height = newHeight;
	}
	@Override
	public IShape getShape() {
		ShapeType currType = appState.getActiveShapeType();
		if(!currType.equals(null)) {
			return new Rectangle(color, origin, width, height);
		}
		return null;
	}

}
