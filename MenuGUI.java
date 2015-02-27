import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class MenuGUI {

	public static final int DEFAULT_MENU_WIDTH = 700;
	public static final int DEFAULT_MENU_HEIGHT = 700;
	LocalGameManager lgm;
	int width, height;
	JFrame frame;
	JPanel panel;
	String name;
	
	public MenuGUI(){
		name = "TRON";
		init();
	}
	
	public MenuGUI(String str){
		name = str;
		init();
	}
	
	private void init(){
		width = DEFAULT_MENU_WIDTH;
		height = DEFAULT_MENU_HEIGHT;
		frame = new JFrame(name);
		this.initialFrameSetup();
	}
	
	private void initialFrameSetup(){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(DEFAULT_MENU_WIDTH, DEFAULT_MENU_HEIGHT));
		frame.setVisible(true);
		frame.setResizable(false);
		panel = new JPanel();
		panel.setSize(DEFAULT_MENU_WIDTH,DEFAULT_MENU_HEIGHT);
		panel.setVisible(true);
		//panel.setLayout(new BorderLayout());
		addButtons();
		frame.add(panel);
		panel.setFocusable(true);
	}
	
	private void addButtons(){
		JButton ogb = new JButton("Online Game");
		ogb.addActionListener(new OnlineGameListener());
		panel.add(ogb);
		JButton lgb = new JButton("Local Game");
		lgb.addActionListener(new LocalGameListener());
		panel.add(lgb);
		JButton eb = new JButton("Exit");
		eb.addActionListener(new ExitListener());
		panel.add(eb);
		
	}
	
	private class ExitListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
	
	private class LocalGameListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			LocalGameThread lgt = new LocalGameThread();
			new Thread(lgt).start();
			frame.dispose();
		}
	}
	
	private class OnlineGameListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.out.println("Coming out soon");
			//TODO: Add a call to open up the game browser window
			System.exit(0);
		}
	}
	
}
