package model.handlers;

import model.Point;
import model.Shape;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.interfaces.IShape;

public class ShapeFactory {
	private static int sid = 0;

	private ShapeFactory() {		
	}
	
	public static IShape getShapeWithId(ShapeType newType, ShapeColor newColor, ShapeColor newSecondColor, ShapeShadingType newShade, Point origin, int[] dimensions) {
		IShape newShape = getShape(newType, newColor, newSecondColor, newShade, origin, dimensions);
		sid++;
		return newShape;
	}
	
	public static IShape getShape(ShapeType newType, ShapeColor newColor, ShapeColor newSecondColor, ShapeShadingType newShade, Point origin, int[] dimensions) {
		return new Shape(sid, newType, newColor, newSecondColor, newShade, origin, dimensions[0], dimensions[1]);
	}
}
