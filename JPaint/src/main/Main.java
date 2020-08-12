package main;

import controller.JPaintController;
import controller.MouseListener;
import controller.interfaces.IJPaintController;
import model.Point;
import model.ShapeColor;
import model.ShapeHandler;
import model.ShapeShadingType;
import model.ShapeType;
import model.persistence.ApplicationState;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.PaintCanvasBase;
import workSpace.IDrawable;
import view.interfaces.IUiModule;

public class Main {
    public static void main(String[] args){
        PaintCanvasBase paintCanvas = new PaintCanvas();
        IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);
        ApplicationState appState = new ApplicationState(uiModule);
        IJPaintController controller = new JPaintController(uiModule, appState, paintCanvas.getShapeManager());
        controller.setup();
        paintCanvas.addMouseListener(new MouseListener(paintCanvas, appState));
        
//        IDrawable test = ShapeHandler.getGroup(ShapeType.RECTANGLE, ShapeColor.GREEN, ShapeColor.MAGENTA, ShapeShadingType.OUTLINE_AND_FILLED_IN, new Point(60, 60), new int[] {60, 60}, paintCanvas);
//        IDrawable shapeTest = ShapeHandler.getShape(ShapeType.RECTANGLE, ShapeColor.BLACK, ShapeColor.MAGENTA, ShapeShadingType.OUTLINE, new Point(150, 60), new int[] {60, 60}, paintCanvas);
//        test.add(shapeTest);
//        test.print();
    }
}
