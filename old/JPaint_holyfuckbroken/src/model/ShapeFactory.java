package model;

import model.interfaces.IShape;

public class ShapeFactory {
	private static int sid = 0;

	private ShapeFactory() {		
	}
	
	public static IShape getRectangle(ShapeType newType, ShapeColor newColor, ShapeColor newSecondColor, ShapeShadingType newShade, Point origin, int[] dimensions) {
		return getShape(newType, newColor, newSecondColor, newShade, origin, dimensions);
	}
	
	public static IShape getEllipse(ShapeType newType, ShapeColor newColor, ShapeColor newSecondColor, ShapeShadingType newShade, Point origin, int[] dimensions) {
		return getShape(newType, newColor, newSecondColor, newShade, origin, dimensions);
	}
	
	public static IShape getTriangle(ShapeType newType, ShapeColor newColor, ShapeColor newSecondColor, ShapeShadingType newShade, Point origin, int[] dimensions) {
		return getShape(newType, newColor, newSecondColor, newShade, origin, dimensions);
	}
	
	private static IShape getShape(ShapeType newType, ShapeColor newColor, ShapeColor newSecondColor, ShapeShadingType newShade, Point origin, int[] dimensions) {
		IShape newShape = new Shape(sid, newType, newColor, newSecondColor, newShade, origin, dimensions[0], dimensions[1]);
		sid++;
		return newShape;
	}
}
