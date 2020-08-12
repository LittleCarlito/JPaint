package workSpace;

public class GroupCreator {
	private static int sid = 100;

	
	public static IDrawable getGroup(IDrawable baseShape) {
		ShapeGroup sGroup = new ShapeGroup(sid, baseShape);
		sid++;
		return sGroup;
	}
}
