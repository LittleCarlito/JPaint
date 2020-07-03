package controller.Printer;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

import model.ShapeShadingType;
import model.interfaces.IShape;

public class RectanglePrinter extends ShapePrinter{
	
	public RectanglePrinter(IShape newShape, Graphics2D baseGraphics) {
		super(newShape, baseGraphics);
	}

	@Override
	public void print() {
		setPrimaryColor();
		ShapeShadingType shadeType = getShade();
		if(shadeType.equals(ShapeShadingType.FILLED_IN)) {
			graphics2d.fillRect(getOrigin().getX(), getOrigin().getY(), getWidth(), getHeight());
		}
		else if(shadeType.equals(ShapeShadingType.OUTLINE)) {
	        graphics2d.setStroke(new BasicStroke(5));
	        graphics2d.drawRect(getOrigin().getX(), getOrigin().getY(), getWidth(), getHeight());
		}
		else if(shadeType.equals(ShapeShadingType.OUTLINE_AND_FILLED_IN)) {
			graphics2d.fillRect(getOrigin().getX() - 1, getOrigin().getY() - 1, getWidth() - 2, getHeight() - 2);
			setSecondaryColor();
			graphics2d.setStroke(new BasicStroke(5));
	        graphics2d.drawRect(getOrigin().getX(), getOrigin().getY(), getWidth(), getHeight());
		}
	}

}
