import java.awt.event.KeyEvent;


public class LocalInputManager extends InputManager {
	
	LineManager lm;
	
	public LocalInputManager(){
		super();
		lm = LineManager.getInstance();
	}

	public void giveInput(KeyEvent e){
		int button = e.getKeyCode();
		System.out.println(button);
		switch (button){
			case KeyEvent.VK_W:
				//check valid
				//if valid, send to LocalLines
				if(lm.getLocalLine(1).getFacing() != Line.Direction.Down)
				lm.changeLocalDirection(1, Line.Direction.Up);
				break;
			case KeyEvent.VK_A:
				if(lm.getLocalLine(1).getFacing() != Line.Direction.Right)
				lm.changeLocalDirection(1, Line.Direction.Left);
				//if(line1.getLastDirection()!=Line.Direction.Right)
				//line1.setFacing(Line.Direction.Left);
				//dir = 'a';
				break;
			case KeyEvent.VK_S:
				if(lm.getLocalLine(1).getFacing() != Line.Direction.Up)
				lm.changeLocalDirection(1, Line.Direction.Down);
				/*if(line1.getLastDirection()!=Line.Direction.Up)
				line1.setFacing(Line.Direction.Down);
				dir = 's';*/
				break;
			case KeyEvent.VK_D:
				if(lm.getLocalLine(1).getFacing() != Line.Direction.Left)
				lm.changeLocalDirection(1, Line.Direction.Right);
				/*if(line1.getLastDirection()!=Line.Direction.Left)
				line1.setFacing(Line.Direction.Right);
				dir = 'd';*/
				break;
			case KeyEvent.VK_UP:
				if(lm.getLocalLine(2).getFacing() != Line.Direction.Down)
				lm.changeLocalDirection(2, Line.Direction.Up);
				/*if(line2.getLastDirection()!=Line.Direction.Down)
				line2.setFacing(Line.Direction.Up);*/
				break;
			case KeyEvent.VK_LEFT:
				if(lm.getLocalLine(2).getFacing() != Line.Direction.Right)
				lm.changeLocalDirection(2, Line.Direction.Left);
				/*if(line2.getLastDirection()!=Line.Direction.Right)
				line2.setFacing(Line.Direction.Left);*/
				break;
			case KeyEvent.VK_DOWN:
				if(lm.getLocalLine(2).getFacing() != Line.Direction.Up)
				lm.changeLocalDirection(2, Line.Direction.Down);
				/*if(line2.getLastDirection()!=Line.Direction.Up)
				line2.setFacing(Line.Direction.Down);*/
				break;
			case KeyEvent.VK_RIGHT:
				if(lm.getLocalLine(2).getFacing() != Line.Direction.Left)
				lm.changeLocalDirection(2, Line.Direction.Right);
				/*if(line2.getLastDirection()!=Line.Direction.Left)
				line2.setFacing(Line.Direction.Right);*/
				break;
			case KeyEvent.VK_NUMPAD8:
				if(lm.getLocalLine(3).getFacing() != Line.Direction.Down)
				lm.changeLocalDirection(3, Line.Direction.Up);
				/*if(line2.getLastDirection()!=Line.Direction.Down)
				line2.setFacing(Line.Direction.Up);*/
				break;
			case KeyEvent.VK_NUMPAD4:
				if(lm.getLocalLine(3).getFacing() != Line.Direction.Right)
				lm.changeLocalDirection(3, Line.Direction.Left);
				/*if(line2.getLastDirection()!=Line.Direction.Right)
				line2.setFacing(Line.Direction.Left);*/
				break;
			case KeyEvent.VK_NUMPAD5:
				if(lm.getLocalLine(3).getFacing() != Line.Direction.Up)
				lm.changeLocalDirection(3, Line.Direction.Down);
				/*if(line2.getLastDirection()!=Line.Direction.Up)
				line2.setFacing(Line.Direction.Down);*/
				break;
			case KeyEvent.VK_NUMPAD6:
				if(lm.getLocalLine(3).getFacing() != Line.Direction.Left)
				lm.changeLocalDirection(3, Line.Direction.Right);
				/*if(line2.getLastDirection()!=Line.Direction.Left)
				line2.setFacing(Line.Direction.Right);*/
				break;
		}
	}
	
}
