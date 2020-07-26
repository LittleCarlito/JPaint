package controller.event;

import controller.interfaces.IMouseEvent;
import model.Point;
import model.StartAndEndPointMode;
import model.persistence.ApplicationState;
import view.interfaces.PaintCanvasBase;

public class EventHandler {

	private EventHandler() {
	}

	public static IMouseEvent getEvent(Point startPoint, Point endPoint, PaintCanvasBase baseCanvas, ApplicationState baseState) {
		StartAndEndPointMode eventMode = baseState.getActiveStartAndEndPointMode();
		if (eventMode.equals(StartAndEndPointMode.DRAW)) {
			return EventFactory.getDraw(startPoint, endPoint, baseCanvas, baseState);
		} else if (eventMode.equals(StartAndEndPointMode.SELECT)) {
			return EventFactory.getSelect(startPoint, endPoint, baseCanvas, baseState);
		} else if (eventMode.equals(StartAndEndPointMode.MOVE)) {
			return EventFactory.getMove(startPoint, endPoint, baseCanvas, baseState);
		} else {
			// Add more cases here as they are required
			return null;
		}
	}
}
