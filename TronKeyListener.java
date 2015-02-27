import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class TronKeyListener implements KeyListener {
	
	InputManager im;
	
	public TronKeyListener(boolean local){
		super();
		if(local){ im = new LocalInputManager();}
		else{ im = new OnlineInputManager();}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int button = e.getKeyCode();
		im.giveInput(e);/*
		switch (button){
			case KeyEvent.VK_W:
				im.giveCommand()
				break;
			case KeyEvent.VK_A:
				if(line1.getLastDirection()!=Line.Direction.Right)
				line1.setFacing(Line.Direction.Left);
				dir = 'a';
				break;
			case KeyEvent.VK_S:
				if(line1.getLastDirection()!=Line.Direction.Up)
				line1.setFacing(Line.Direction.Down);
				dir = 's';
				break;
			case KeyEvent.VK_D:
				if(line1.getLastDirection()!=Line.Direction.Left)
				line1.setFacing(Line.Direction.Right);
				dir = 'd';
				break;
			case KeyEvent.VK_UP:
				if(line2.getLastDirection()!=Line.Direction.Down)
				line2.setFacing(Line.Direction.Up);
				break;
			case KeyEvent.VK_LEFT:
				if(line2.getLastDirection()!=Line.Direction.Right)
				line2.setFacing(Line.Direction.Left);
				break;
			case KeyEvent.VK_DOWN:
				if(line2.getLastDirection()!=Line.Direction.Up)
				line2.setFacing(Line.Direction.Down);
				break;
			case KeyEvent.VK_RIGHT:
				if(line2.getLastDirection()!=Line.Direction.Left)
				line2.setFacing(Line.Direction.Right);
				break;	
		}*/
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

}
