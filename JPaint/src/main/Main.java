package main;

import java.util.ArrayList;

import controller.JPaintController;
import controller.MouseListener;
import controller.interfaces.IJPaintController;
import model.interfaces.IShape;
import model.persistence.ApplicationState;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.PaintCanvasBase;
import view.interfaces.IUiModule;

public class Main {
    public static void main(String[] args){
        PaintCanvasBase paintCanvas = new PaintCanvas(new ArrayList<IShape>(), new ArrayList<IShape>());
        IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);
        ApplicationState appState = new ApplicationState(uiModule);
        IJPaintController controller = new JPaintController(uiModule, appState, paintCanvas);
        controller.setup();
        paintCanvas.addMouseListener(new MouseListener(paintCanvas, appState));
    }
}
