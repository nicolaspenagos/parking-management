package threads;

import userinterface.MainController;

public class TimeThread extends Thread{
	
	private MainController mc;
	private boolean running;
	
	public TimeThread(MainController mc) {
		this.mc = mc;
		running = true;
	}
	
	@Override
	public void run() {
		
		while(running) {
			
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			mc.updateTime();
			
			
		}
		
	}
	
	public void kill() {
		running = false;
	}

}
