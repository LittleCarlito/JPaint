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
		setColor();
		ShapeShadingType shadeType = getShade();
		if(shadeType.equals(ShapeShadingType.FILLED_IN)) {
			graphics2d.fillRect(getOrigin().getX(), getOrigin().getY(), getWidth(), getHeight());
		}
		else if(shadeType.equals(ShapeShadingType.OUTLINE)) {
	        graphics2d.setStroke(new BasicStroke(5));
	        graphics2d.drawRect(getOrigin().getX(), getOrigin().getY(), getWidth(), getHeight());
		}
	}

}
