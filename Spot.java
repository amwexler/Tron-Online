import java.io.Serializable;


public class Spot implements Serializable{
	private int x, y;
	
	public Spot(int inX, int inY){
		x=inX;
		y=inY;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public boolean equals(Object o){
		Spot s;
		if(o instanceof Spot){
			s=(Spot)o;
		}
		else{return false;}
		//System.out.println("Testing at spot " + s.getX() + ", " + s.getY() + " with " + x + " " + y);
		if(s.getX()==x && s.getY()==y){
			//System.out.println("Equal!");
			return true;
		}
		//System.out.println("not equal");
		return false;
	}
	
	public String toString(){
		return x + ", " + y;
	}
}
