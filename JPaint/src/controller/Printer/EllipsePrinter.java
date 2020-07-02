package controller.Printer;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

import model.ShapeShadingType;
import model.interfaces.IShape;

public class EllipsePrinter extends ShapePrinter{
	
	public EllipsePrinter(IShape newShape, Graphics2D baseGraphics) {
		super(newShape, baseGraphics);
	}

	@Override
	public void print() {
		setColor();
		ShapeShadingType shadeType = getShade();
		if(shadeType.equals(ShapeShadingType.FILLED_IN)) {
			graphics2d.fillOval(getOrigin().getX(), getOrigin().getY(), getWidth(), getHeight());
		}
		else if(shadeType.equals(ShapeShadingType.OUTLINE)) {
	        graphics2d.setStroke(new BasicStroke(5));
	        graphics2d.drawOval(getOrigin().getX(), getOrigin().getY(), getWidth(), getHeight());
		}
	}

}