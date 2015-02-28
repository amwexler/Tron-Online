import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;
import java.util.ArrayList;


public class Line implements Serializable{

	final int DEFAULT_X=10, DEFAULT_Y=25;
	final Direction DEFAULT_DIRECTION = Direction.Right;
	Direction facing;
	int x,y;
	ArrayList<Spot> spots;
	boolean occupies[][];
	Color color;
	Direction lastDirection;
	
	public Line(){
		facing = DEFAULT_DIRECTION;
		lastDirection = facing;
		x = DEFAULT_X;
		y = DEFAULT_Y;
		color = Color.black;
		spots = new ArrayList<Spot>();
		spots.add(new Spot(x,y));
		
	}
	
	public Line(int inX, int inY, Direction d, Color c){
		facing = d;
		x = inX;
		y = inY;
		color = c;
		spots = new ArrayList<Spot>();
		
	}

	public enum Direction{
		Left, Right, Up, Down;
	}
	
	public boolean takeStep(){//true if step is successful, false otherwise
		//System.out.println(color.toString() + " is at " + x + ", " + y);
		
		spots.add(new Spot(x,y));
		synchronized(spots){
			lastDirection = facing;
			switch (facing){
				case Right:
					x++;
					return true;
				case Left:
					x--;
					return true;
				case Up:
					y--;
					return true;
				case Down:
					y++;
					return true;
			}
			return false;
		}
	}
	
	public void setFacing(Direction d){
		facing = d;
	}
	
	public Direction getFacing(){
		return facing;
	}
	
	public boolean occupies(int inX, int inY){
		synchronized(spots){
			Spot testSpot = new Spot(inX, inY);
			for(Spot s: spots){
				if(testSpot.equals(s)){return true;}
			}
			return false;
		}
	}
	
	public ArrayList<Spot> getSpots(){
		return spots;
	}
	
	public void draw(Graphics g){
		g.setColor(color);
		synchronized(spots){
			for(Spot s: spots){
				g.fillRect(s.getX()*Grid.BOX_WIDTH, s.getY()*Grid.BOX_WIDTH, Grid.BOX_WIDTH, Grid.BOX_WIDTH);
			}
			//g.fillRect(x*Grid.BOX_WIDTH, y*Grid.BOX_WIDTH, Grid.BOX_WIDTH, Grid.BOX_WIDTH);
			/*
			if(spots.size() > 0){
				Spot s = spots.get(spots.size()-1);
				g.fillRect(s.getX()*Grid.BOX_WIDTH, s.getY()*Grid.BOX_WIDTH, Grid.BOX_WIDTH, Grid.BOX_WIDTH);
			}*/
			
		}
		
	}
	
	public Spot getSpot(){
		return new Spot(x,y);
	}
	
	public Direction getLastDirection(){
		return lastDirection;
	}
	
	public Spot getHead(){
		return new Spot(x,y);		
	}

	public void add(Spot s) {
		synchronized(spots){
			spots.add(s);
		}
		
	}
	
}

