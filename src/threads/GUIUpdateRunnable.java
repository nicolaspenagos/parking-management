package threads;

import userinterface.MainController;

public class GUIUpdateRunnable implements Runnable{
private MainController gui;
	
	public GUIUpdateRunnable(MainController gui) {
		this.gui = gui;
	}
	@Override
	public void run() {
		gui.update();
		
	}
}
