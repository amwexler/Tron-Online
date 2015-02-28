import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class MenuGUI extends JFrame {

	public static final int DEFAULT_MENU_WIDTH = 700;
	public static final int DEFAULT_MENU_HEIGHT = 700;
	LocalGameManager lgm;
	int width, height;
	//JFrame frame;
	JPanel panel;
	String name;
	
	public MenuGUI(){
		this.setName("TRON");
		this.setTitle("TRON");
		init();
	}
	
	public MenuGUI(String str){
		this.setName(str);
		this.setTitle(str);
		init();
	}
	
	private void init(){
		width = DEFAULT_MENU_WIDTH;
		height = DEFAULT_MENU_HEIGHT;
		this.initialFrameSetup();
	}
	
	private void initialFrameSetup(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new Dimension(DEFAULT_MENU_WIDTH, DEFAULT_MENU_HEIGHT));
		this.setVisible(true);
		this.setAutoRequestFocus(true);
		panel = new JPanel();
		//panel.setSize(DEFAULT_MENU_WIDTH,DEFAULT_MENU_HEIGHT);
		panel.setVisible(true);
		
		panel.setLayout(new BoxLayout(panel,  BoxLayout.PAGE_AXIS));
		addButtons();
		panel.setFocusable(true);
		this.add(panel);
		this.setResizable(false);
		
		this.pack();
	}
	/*
	@Override
	public void paintComponents(Graphics g){
		super.paintComponents(g);
		//panel.paintComponents(g);
	}
	
	@Override
	public void paintAll(Graphics g){
		super.paintAll(g);
		//panel.paintComponents(g);
	}
	
	@Override
	public void paint(Graphics g){
		super.paint(g);
		//panel.paint(g);
	}*/
	
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
			switchToLocalGameMenu();/*
			LocalGameThread lgt = new LocalGameThread();
			new Thread(lgt).start();
			frame.dispose();*/
		}
	}
	
	private class OnlineGameListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			switchToOnlineGameMenu();
			//TODO: Add a call to open up the game browser window
			//System.exit(0);
		}
	}
	
	private class local2PlayerListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			LocalGameThread lgt = new LocalGameThread(2);
			new Thread(lgt).start();
			MenuGUI.this.dispose();
		}
	}
	
	private class local3PlayerListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			LocalGameThread lgt = new LocalGameThread(3);
			new Thread(lgt).start();
			MenuGUI.this.dispose();
		}
	}
	
	private class local4PlayerListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			LocalGameThread lgt = new LocalGameThread(4);
			new Thread(lgt).start();
			MenuGUI.this.dispose();
		}
	}
	
	private class online1PlayerListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			//TODO: hook up to lobby
			switchToLobby();
			//MenuGUI.this.dispose();
		}
	}
	
	private class online2PlayerListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			//TODO: hook up to lobby
			switchToLobby();
			//MenuGUI.this.dispose();
		}
	}
	
	private class RefreshListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			refreshGames();
		}
	}
	
	private class GameButtonListener implements ActionListener{
		GameInfo info;
		public GameButtonListener(GameInfo info){
			this.info=info;
		}
		public void actionPerformed(ActionEvent e) {
			System.out.println("Connecting to game " + info + " ...");
			//TODO: connect to game
		}
	}
	
	private void switchToLocalGameMenu(){
		System.out.println("Making Local Menu");
		JButton b2 = new JButton("2 Players"); b2.addActionListener(new local2PlayerListener());
		JButton b3 = new JButton("3 Players"); b3.addActionListener(new local3PlayerListener());
		JButton b4 = new JButton("4 Players"); b4.addActionListener(new local4PlayerListener());
		JTextArea text = new JTextArea("Controls:\nP1: Red - W, A, S, D\nP2: Blue - Up, Left, Down, Right\nP3: Green - Numpad 8, 4, 5, 6\nP4: Yellow - I, J, K, L");
		panel.removeAll();
		panel.add(b2);panel.add(b3);panel.add(b4);panel.add(text);
		//panel.add(new JButton("Hello World"));
		//panel.paintImmediately(0, 0, DEFAULT_MENU_WIDTH, DEFAULT_MENU_HEIGHT);
		panel.setBackground(Color.red);
		//this.add(panel);
		this.pack();
	}
	
	private void switchToOnlineGameMenu(){
		System.out.println("Making Online Menu");
		JButton b1 = new JButton("1 Local Player"); b1.addActionListener(new online1PlayerListener());
		JButton b2 = new JButton("2 Local Players"); b2.addActionListener(new online2PlayerListener());
		JTextArea text = new JTextArea("Controls:\nP1 - W, A, S, D\nP2 - Up, Left, Down, Right\n");
		JTextArea text2 = new JTextArea("The local players will be assigned a color once joining an online match");
		panel.removeAll();
		panel.add(text2);panel.add(b1);panel.add(b2);panel.add(text);
		//panel.add(new JButton("Hello World"));
		//panel.paintImmediately(0, 0, DEFAULT_MENU_WIDTH, DEFAULT_MENU_HEIGHT);
		panel.setBackground(Color.blue);
		//this.add(panel);
		this.pack();
	}
	
	private void switchToLobby(){
		refreshGames();	
	}
	
	private void refreshGames(){
		panel.removeAll();
		JButton refresh = new JButton("Refresh");
		refresh.addActionListener(new RefreshListener());
		panel.add(refresh);
		ArrayList<GameInfo> games = new ArrayList<GameInfo>();
		games.clear();
		//TODO: replace this with actual code that gets info from server
		games.add(new GameInfo("128.111.25.25", String.valueOf((int)(Math.random()*50000.0)), (int)(Math.random()*4.0), 4));
		games.add(new GameInfo("133.131.50.12", String.valueOf((int)(Math.random()*50000.0)), (int)(Math.random()*4.0), 2));
		games.add(new GameInfo("226.211.10.55", String.valueOf((int)(Math.random()*50000.0)), (int)(Math.random()*4.0), 4));
		games.add(new GameInfo("168.141.23.35", String.valueOf((int)(Math.random()*50000.0)), (int)(Math.random()*4.0), 3));
		for(GameInfo g: games){
			JButton temp = new JButton(g.toString());
			temp.addActionListener(new GameButtonListener(g));
			panel.add(temp);
		}
		panel.setBackground(Color.blue);
		this.pack();
	}
	
}
