package workSpace;

public interface IDrawable {
	
	public int getID();
	public boolean add(IDrawable o);
	public boolean remove(IDrawable o);
	public void setSelect();
	public void setDeselect();
	public void print();
}
