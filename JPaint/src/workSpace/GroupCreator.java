package workSpace;

public class GroupCreator {
	private static int sid = 0;

	
	public static IDrawable getGroup() {
		ShapeGroup sGroup = new ShapeGroup(sid);
		sid++;
		return sGroup;
	}
}
