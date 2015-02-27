
public class LocalGameThread implements Runnable{

	@Override
	public void run() {
		new LocalGameManager();
	}	
}
