import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;



public class LineManager{

	final Line.Direction DEFAULT_DIRECTION_RED = Line.Direction.Down;
	final Line.Direction DEFAULT_DIRECTION_BLUE = Line.Direction.Up;
	final Line.Direction DEFAULT_DIRECTION_GREEN = Line.Direction.Right;
	final Line.Direction DEFAULT_DIRECTION_YELLOW = Line.Direction.Left;
	
	final int DEFAULT_X_RED = (int)(Grid.DEFAULT_GRID_WIDTH * .1);
	final int DEFAULT_Y_RED = (int)(Grid.DEFAULT_GRID_HEIGHT * .1);
	final int DEFAULT_X_BLUE = (int)(Grid.DEFAULT_GRID_WIDTH * .9);
	final int DEFAULT_Y_BLUE = (int)(Grid.DEFAULT_GRID_HEIGHT * .9);
	final int DEFAULT_X_GREEN = (int)(Grid.DEFAULT_GRID_WIDTH * .1);
	final int DEFAULT_Y_GREEN = (int)(Grid.DEFAULT_GRID_HEIGHT * .9);
	final int DEFAULT_X_YELLOW = (int)(Grid.DEFAULT_GRID_WIDTH * .9);
	final int DEFAULT_Y_YELLOW = (int)(Grid.DEFAULT_GRID_HEIGHT * .1);
	
	int numLines;
	ArrayList<Line> lines;
	boolean[] lose = {false,false,false,false};
	boolean[] localPlayers = {true,true,false,false};
 	//Line line1, line2;

	private static LineManager instance = null;
	
	protected LineManager(){
		lines = new ArrayList<Line>();
		lines.add(new Line(DEFAULT_X_RED, DEFAULT_Y_RED, DEFAULT_DIRECTION_RED,Color.RED));
		lines.add(new Line(DEFAULT_X_BLUE, DEFAULT_Y_BLUE, DEFAULT_DIRECTION_BLUE,Color.BLUE));
		/*
		line1 = new Line(10,Grid.DEFAULT_GRID_HEIGHT/2, Line.Direction.Right, Color.red);
		line2 = new Line(Grid.DEFAULT_GRID_WIDTH-10, Grid.DEFAULT_GRID_HEIGHT/2 , Line.Direction.Left, Color.blue);
		*/
	}
	
	protected LineManager(int numLines){
		this.numLines = numLines;
		lines.add(new Line(DEFAULT_X_RED, DEFAULT_Y_RED, DEFAULT_DIRECTION_RED,Color.RED));
		lines.add(new Line(DEFAULT_X_BLUE, DEFAULT_Y_BLUE, DEFAULT_DIRECTION_BLUE,Color.BLUE));
		if(numLines > 2){
			lines.add(new Line(DEFAULT_X_GREEN, DEFAULT_Y_GREEN, DEFAULT_DIRECTION_GREEN,Color.GREEN));
		}
		if(numLines > 3){
			lines.add(new Line(DEFAULT_X_YELLOW, DEFAULT_Y_YELLOW, DEFAULT_DIRECTION_YELLOW,Color.YELLOW));
		}
	}
	
	public boolean[] moveLines(){//0 means game goes on, 1 means player 1 wins, 2 means player 2 wins, 3 means draw;
		
		for(int i = 0; i < numLines; i++){//all lines move 1
			if(!lose[i]){
				lines.get(i).takeStep();
			}
		}
		for(int i = 0; i < lines.size(); i++){//check for collisions
			System.out.println("Size: " + lines.size()); 
			Spot head = lines.get(i).getHead();
			if(head.getX() > Grid.DEFAULT_GRID_WIDTH || head.getX() < 0 || head.getY() > Grid.DEFAULT_GRID_WIDTH || head.getY() < 0){
				lose[i] = true;
				continue;
			}
			
			for(int j = 0; j < lines.size(); j++){
				
				for(Spot s: lines.get(j).getSpots()){
					if(head.equals(s)){
						System.out.println("Collision at " + head.getX() + ", " + head.getY() + " and " + s.getX() + ", " + s.getY());
						lose[i] = true;
					}
				}
				if(head.equals(lines.get(j).getHead()) && i!=j){
					System.out.println("Heads are equal");
					lose[i] = true; lose [j] = true;
				}
			}
		}
		return lose;
	}
	
	public enum TurnResult{
		None, Line1Win, Line2Win, Draw;
	}

	public static LineManager getInstance() {
		if(instance == null){
			instance = new LineManager();
		}
		return instance;
	}
	
	public void drawLines(Graphics g){
		for(Line l: lines){
			l.draw(g);
		}
	}
/*
	@Override
	public void keyPressed(KeyEvent e) {
		//char button = e.getKeyChar();
		//System.out.println(e.toString());
		int button = e.getKeyCode();
		switch (button){
			case KeyEvent.VK_W:
				if(line1.getLastDirection()!=Line.Direction.Down)
				line1.setFacing(Line.Direction.Up);
				dir = 'w';
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
				
		}
		
	}*/
	
	public void setNumPlayers(int numPlayers){
		numLines=numPlayers;
	}
	
	public void reset(int numPlayers){
		for(int i = 0; i < numPlayers; i++){
			lose[i] = false;
		}
		lines.clear();
		numLines = numPlayers;
		lines.add(new Line(DEFAULT_X_RED, DEFAULT_Y_RED, DEFAULT_DIRECTION_RED,Color.RED));
		lines.add(new Line(DEFAULT_X_BLUE, DEFAULT_Y_BLUE, DEFAULT_DIRECTION_BLUE,Color.BLUE));
		if(numLines > 2){
			lines.add(new Line(DEFAULT_X_GREEN, DEFAULT_Y_GREEN, DEFAULT_DIRECTION_GREEN,Color.GREEN));
		}
		if(numLines > 3){
			lines.add(new Line(DEFAULT_X_YELLOW, DEFAULT_Y_YELLOW, DEFAULT_DIRECTION_YELLOW,Color.YELLOW));
		}
	}
/*
	public void receiveMessage(char str) {
		//System.out.println("LINE MANAGER HAS " + str);
		switch(str){
			case 'w':
				if(line2.getLastDirection()!=Line.Direction.Down)
				line2.setFacing(Line.Direction.Up);
				break;
			case 'a':
				if(line2.getLastDirection()!=Line.Direction.Right)
				line2.setFacing(Line.Direction.Left);
				break;
			case 's':
				if(line2.getLastDirection()!=Line.Direction.Up)
				line2.setFacing(Line.Direction.Down);
				break;
			case 'd':
				if(line2.getLastDirection()!=Line.Direction.Left)
				line2.setFacing(Line.Direction.Right);
				break;
		}
		
	}*/
	
	/*public void addHeads(Spot s1, Spot s2){
		line1.add(s1);
		line2.add(s2);
	}*/
	
	/**
	 * Changed the direction of a local player.  This should only come from local input
	 * 
	 * @param localPlayerNum Number of local player is being changed. This is the i'th player in the list of local players starting from 1 
	 * @param dir The new direction
	 */
	public void changeLocalDirection(int localPlayerNum, Line.Direction dir){
		int found = 0;
		int i = 0;
		while(i < numLines){
			if(localPlayers[i]){//if this player number is local
				found++;
			}
			if(found == localPlayerNum){
				break;
			}
			i++;
		}
		if(found == localPlayerNum){
			lines.get(i).setFacing(dir);
		}
	}
	
	public void changeOnlineDirection(int onlinePlayerNum, Line.Direction dir){
		lines.get(onlinePlayerNum).setFacing(dir);		
	}
	
	public Line getLocalLine(int localPlayerNum){
		int found = 0;
		int i = 0;
		while(i < numLines){
			if(localPlayers[i]){//if this player number is local
				found++;
			}
			if(found == localPlayerNum){
				break;
			}
			i++;
		}
		if(found == localPlayerNum){
			return lines.get(i);
		}
		return null;
	}
	
	
}
