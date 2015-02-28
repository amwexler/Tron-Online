
public class LocalGameThread implements Runnable{

	int players;
	
	public LocalGameThread(int players){
		super();
		this.players = players;
	}
	
	@Override
	public void run() {
		new LocalGameManager(players);
	}	
}
