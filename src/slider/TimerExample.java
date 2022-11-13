package slider;

import java.util.Timer;
import java.util.TimerTask;

public class TimerExample {
	
	static int counter = 0;
	
	public static void main(String[] args) {
		
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				System.out.println("Hello From Timer");
				counter++;
				if(counter==5) {
					timer.cancel();
				}
				
			}
		};
		
		timer.schedule(task, 0 ,2000);
	}

}
