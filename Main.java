import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;


public class Main{
	
	public static void main(String[] args)  {
		//JFrame jf = new JFrame();
		//jf.setVisible(true);
		LocalGameManager lgm = new LocalGameManager();
		//MenuGUI m = new MenuGUI("TRON - MAIN MENU");
		
		/*
		Grid grid = new Grid("TRON - Host");
		LineManager lineManager = LineManager.getInstance();
		boolean loop = true;
		LineManager.TurnResult result;
		
		HostConnection hc = new HostConnection(lineManager);
		//System.out.println("test 1");
		new Thread(hc).start();
		
		boolean connected = false;
		//System.out.println("Waiting for client to connect...");
		while(!connected){
			connected = hc.connected();
			System.out.println("Waiting for client to connect...");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Client has connected!");
			
		while(true){
			
			while(loop){
				
				result = lineManager.moveLines();
				grid.drawLines();
				
				
				switch(result){
					case None:
						//System.out.println("No collisions");
						break;
					case Line1Win:
						System.out.println("Red wins!");
						loop=false;
						break;
					case Line2Win:
						System.out.println("Blue wins!");
						loop=false;
						break;
					case Draw:
						System.out.println("It's a Draw!");
						loop=false;
						break;			
				}
				hc.sendLocations();
				//System.out.println("Made send true");
				hc.sendResult(result);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
			lineManager.reset();
			grid.reset();
			grid.drawLines();
			hc.sendLocations();
			loop=true;
			System.out.println("Restarting in 1 second...");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}*/

	}

}
