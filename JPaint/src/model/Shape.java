package model;

import java.util.ArrayList;
import java.util.List;

//comment to force commit

import controller.interfaces.IPrinter;
import controller.singletons.ListOutput;
import model.interfaces.IShape;

public class Shape implements IShape{
	private int sID;
	private IPrinter sPrinter;
	private IShape sOutline;
	private ShapeType sType;
	private ShapeColor sColor;
	private ShapeColor sSecondColor;
	private ShapeShadingType sShade;
	private Point sOrigin;
	private int sWidth;
	private int sHeight;
	private boolean selected;
	private List<IShape> groupList;
	
	public Shape (int newID, ShapeType newType, ShapeColor newColor, ShapeColor newSecondColor, ShapeShadingType newShade, Point newOrigin, int newWidth, int newHeight) {
		sID = newID;
		sType = newType;
		sColor = newColor;
		sSecondColor = newSecondColor;
		sShade = newShade;
		sOrigin = newOrigin;
		sWidth = newWidth;
		sHeight = newHeight;
		selected = false;
		groupList = new ArrayList<IShape>();
	}
	
	@Override
	public void group(IShape shape) {
		groupList.add(shape);
	}
	
	@Override
	public void degroup() {
		groupList.clear();
	}
	
	@Override
	public List<IShape> getGroup(){
		return groupList;
	}
	
	@Override
	public void setPrinter(IPrinter newPrinter) {
		sPrinter  = newPrinter;
	}
	
	@Override
	public void setOutline(IShape outline) {
		this.sOutline = outline;
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
	public IShape getCloneAt(Point newOrigin) {
		IShape newShape = new Shape(sID, sType, sColor, sSecondColor, sShade, newOrigin, sWidth, sHeight);
		return ShapeHandler.outlineShape(newShape, sPrinter);
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
	
	@Override
	public void setSelect() {
		select();
		ListOutput.execute(groupList, (IShape shape) -> {shape.select();});
	}
	
	@Override
	public void select() {
		selected = true;
	}
	
	@Override
	public void setNoSelect() {
		deSelect();
		ListOutput.execute(groupList, (IShape shape) -> {shape.setNoSelect();});
	}
	
	@Override
	public void deSelect() {
		selected = false;
	}
	
	@Override
	public void print() {
		if(selected) sOutline.print();
		sPrinter.print(this);
	}
	
	@Override
	public void groupPrint() {
		print();
		List<IShape> tempList;
		for(IShape shape : groupList) {
			tempList = shape.getGroup();
			if(tempList.size() == 0) {
				shape.print();
			}
			else {
				shape.groupPrint();
			}
		}
//		ListOutput.execute(groupList, (IShape shape) -> {shape.print();});
	}
	
}
