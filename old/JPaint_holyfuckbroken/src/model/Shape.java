package model;

import controller.interfaces.IPrinter;
import model.interfaces.IShape;

public class Shape implements IShape{
	private int sID;
	private IPrinter sPrinter;
	private ShapeType sType;
	private ShapeColor sColor;
	private ShapeColor sSecondColor;
	private ShapeShadingType sShade;
	private Point sOrigin;
	private int sWidth;
	private int sHeight;
	
	public Shape (int newID, ShapeType newType, ShapeColor newColor, ShapeColor newSecondColor, ShapeShadingType newShade, Point newOrigin, int newWidth, int newHeight) {
		sID = newID;
		sType = newType;
		sColor = newColor;
		sSecondColor = newSecondColor;
		sShade = newShade;
		sOrigin = newOrigin;
		sWidth = newWidth;
		sHeight = newHeight;
	}

	@Override
	public void setPrinter(IPrinter newPrinter) {
		sPrinter  = newPrinter;
	}
	
	@Override
	public IPrinter getPrinter() {
		return sPrinter;
	}
	
	@Override
	public int getID() {
		return sID;
	}
	
	@Override
	public ShapeType getType() {
		return sType;
	}
	@Override
	public ShapeColor getColor() {
		return sColor;
	}
	@Override
	public ShapeShadingType getShade() {
		return sShade;
	}
	@Override
	public Point getOrigin() {
		return sOrigin;
	}
	@Override
	public int getWidth() {
		return sWidth;
	}
	@Override
	public int getHeight() {
		return sHeight;
	}

	@Override
	public ShapeColor getSecondColor() {
		return sSecondColor;
	}

	@Override
	public IShape getClone(ShapeColor newColor, ShapeShadingType newShade, Point newOrigin, int cWidth, int cHeight) {
		IShape newShape = new Shape(sID, sType, newColor, sSecondColor, newShade, newOrigin, cWidth, cHeight);
		newShape.setPrinter(sPrinter);
		return newShape;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shape other = (Shape) obj;
		if (sID == other.getID()) {
			return true;
		}
		else {
			return false;
		}
	}
	
//	@Override
//	public void outline() {
//		Point outlineOrigin = new Point(sOrigin.getX() - 5, sOrigin.getY() - 5);
//		int outlineWidth = sWidth + 10;
//		int outlineHeight = sHeight + 10;
//		IShape outline = ShapeHandler.getShape(sType, ShapeColor.BLACK, ShapeColor.WHITE, ShapeShadingType.SELECTED, outlineOrigin, new int[] {outlineWidth, outlineHeight});
//		sPrinter.print(outline);
//	}
	
	@Override
	public void print() {
		sPrinter.print(this);
	}	
}
