import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Grid {
	
	public static final int DEFAULT_GRID_WIDTH = 70;
	public static final int DEFAULT_GRID_HEIGHT = 70;
	private static final int X_GAP=30, Y_GAP=50;
	public static final int BOX_WIDTH = 10;
	int width, height;
	boolean local;
	JFrame frame;
	LineManager lineManager;
	JPanel panel;
	String name;
	
	public Grid(){
		local = true;
		name = "TRON";
		init();
	}
	
	public Grid(String str){
		local = true;
		name = str;
		init();
	}
	
	public Grid(String str, boolean local){
		this.local = local;
		name = str;
		init();
	}
	
	private void init(){
		width = DEFAULT_GRID_WIDTH;
		height = DEFAULT_GRID_HEIGHT;
		lineManager = LineManager.getInstance();
		frame = new JFrame(name);
		this.initialFrameSetup();
	}
	
	private void initialFrameSetup(){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(DEFAULT_GRID_WIDTH*BOX_WIDTH + X_GAP, DEFAULT_GRID_HEIGHT*BOX_WIDTH + Y_GAP));
		frame.setVisible(true);
		frame.setResizable(false);
		panel = new JPanel();
		panel.setSize(DEFAULT_GRID_WIDTH,DEFAULT_GRID_HEIGHT);
		panel.setVisible(true);
		frame.add(panel);
		//panel.setBounds(0, 160, DEFAULT_GRID_WIDTH, DEFAULT_GRID_HEIGHT);
		panel.setFocusable(true);
		panel.addKeyListener(new TronKeyListener(true));
	}
	
	public void drawLines(){
		Graphics g = panel.getGraphics();
		lineManager.drawLines(g);
		g.setColor(Color.black);
		g.drawRect(X_GAP/4, Y_GAP/4, DEFAULT_GRID_WIDTH*BOX_WIDTH, DEFAULT_GRID_HEIGHT*BOX_WIDTH);
		
	}
	
	public void reset(){
		Graphics g = panel.getGraphics();
		g.clearRect(0, 0, frame.getWidth(), frame.getHeight());
	}
	
	
	
	
	
}
