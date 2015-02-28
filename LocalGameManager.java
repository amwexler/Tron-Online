
public class LocalGameManager {

	public LocalGameManager(int players){
		
		Grid grid = new Grid("TRON - Local Game");
		LineManager lineManager = LineManager.getInstance();
		boolean loop = true;
		boolean[] lost;
		//int players = 4;
		lineManager.setNumPlayers(players);
		lineManager.reset(players);
		
		while(true){
			while(loop){
				lost = lineManager.moveLines();
				System.out.println("drawing..." + lost[0] + ", " + lost[1] + ", " +  lost[2] + ", " +  lost[3] );
				grid.drawLines();
				int playersAlive=0;
				for(int i = 0; i < players; i++){
					if(!lost[i]){
						System.out.println("Incrementing alive");
						playersAlive++;
					}
				}
				if(playersAlive == 0){//draw
					System.out.println("It's a Draw!");
					loop=false;
					break;
				}
				if(playersAlive == 1){//one left, figure out the winner
					if(!lost[0]){
						System.out.println("Red wins!");
						loop=false;
						break;	
					}
					else if(!lost[1]){
						System.out.println("Blue wins!");
						loop=false;
						break;							
					}
					else if(!lost[2]){
						System.out.println("Green wins!");
						loop=false;
						break;	
					}
					else if(!lost[3]){
						System.out.println("Yellow wins!");
						loop=false;
						break;	
					}
				}
				/*
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
				}*/
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
			lineManager.reset(players);
			grid.reset();
			lineManager.moveLines();
			System.out.println("drawing");
			grid.drawLines();
			loop=true;
			System.out.println("Restarting in 1 second...");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
}
