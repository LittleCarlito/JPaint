package model;

import model.interfaces.IShape;

public class Shape implements IShape{
	private ShapeType sType;
	private ShapeColor sColor;
	private ShapeColor sSecondColor;
	private ShapeShadingType sShade;
	private Point sOrigin;
	private int sWidth;
	private int sHeight;
	
	public Shape (ShapeType newType, ShapeColor newColor, ShapeColor newSecondColor, ShapeShadingType newShade, Point newOrigin, int newWidth, int newHeight) {
		sType = newType;
		sColor = newColor;
		sSecondColor = newSecondColor;
		sShade = newShade;
		sOrigin = newOrigin;
		sWidth = newWidth;
		sHeight = newHeight;
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
	public IShape getClone(Point newOrigin) {
		return new Shape(sType, sColor, sSecondColor, sShade, newOrigin, sWidth, sHeight);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sColor == null) ? 0 : sColor.hashCode());
		result = prime * result + sHeight;
		result = prime * result + ((sOrigin == null) ? 0 : sOrigin.hashCode());
		result = prime * result + ((sSecondColor == null) ? 0 : sSecondColor.hashCode());
		result = prime * result + ((sShade == null) ? 0 : sShade.hashCode());
		result = prime * result + ((sType == null) ? 0 : sType.hashCode());
		result = prime * result + sWidth;
		return result;
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
		if (sColor != other.sColor)
			return false;
		if (sHeight != other.sHeight)
			return false;
		if (sOrigin == null) {
			if (other.sOrigin != null)
				return false;
		} else if (!sOrigin.equals(other.sOrigin))
			return false;
		if (sSecondColor != other.sSecondColor)
			return false;
		if (sShade != other.sShade)
			return false;
		if (sType != other.sType)
			return false;
		if (sWidth != other.sWidth)
			return false;
		return true;
	}
	
	
}
