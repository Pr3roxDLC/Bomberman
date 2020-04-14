package render;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import java.awt.Color;

public class GUI extends JFrame implements Runnable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	TileRenderer tr = new TileRenderer();
	PlayerRenderer pr = new PlayerRenderer();
	game.PlayerMover pm = new game.PlayerMover();
	HudRenderer hr = new HudRenderer();
	Misc.SecondCounter counter = new Misc.SecondCounter();
	game.MapManager mm = new game.MapManager();
	
	int currentFrame = 0;
	private Image dbImage;
	private Graphics dbg;
	public String playerDirection = "W";
	
	//All Testing Objects, Variables, ... go here
	public String[] DevAnimationArray = {"FlameTile1.png", "FlameTile2.png", "FlameTile3.png", "FlameTile4.png", "FlameTile5.png", "FlameTile6.png", "FlameTile7.png", "FlameTile8.png"};
	public String[] PlayerFacingSouthTile = {"/anim/player/PlayerSpriteSouth1.png","/anim/player/PlayerSpriteSouth2.png","/anim/player/PlayerSpriteSouth3.png"};
	public String[] PlayerFacingNorthTile = {"/anim/player/PlayerSpriteNorth1.png","/anim/player/PlayerSpriteNorth2.png","/anim/player/PlayerSpriteNorth3.png"};
	public String[] PlayerFacingWestTile = {"/anim/player/PlayerSpriteWest1.png","/anim/player/PlayerSpriteWest2.png","/anim/player/PlayerSpriteWest3.png"};
	public String[] PlayerFacingEastTile = {"/anim/player/PlayerSpriteEast1.png","/anim/player/PlayerSpriteEast2.png","/anim/player/PlayerSpriteEast3.png"};
	AnimatedPlayerRenderer playerRenderer = new AnimatedPlayerRenderer(PlayerFacingSouthTile, PlayerFacingNorthTile, PlayerFacingEastTile, PlayerFacingWestTile, 4);
	AnimatedTile DevTile1 = new AnimatedTile(DevAnimationArray, 4);
	AnimatedTile DevTile2 = new AnimatedTile(DevAnimationArray, 4);

	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Thread f = new Thread(new GUI());
		
		f.start();
		
	}

	public void run() {
		
		tr.initTiles();
		pr.initPlayer();
		hr.initHud();
		
		
		
		mm.initWalls();
		tr.setTileIDArray(mm.getTileIDArray());
		pm.setTileIDArray(tr.getTileIDArray());
		mm.genCrates();
		while(true) {
			DevTile1.updateAnimation();
			DevTile2.updateAnimation();
			counter.updateCounter();
			
			
			pm.movePlayer();
			
			playerRenderer.updatePlayer();
			

			repaint();
			//System.out.println("[Frame]: "+ currentFrame++);
			try {
				Thread.sleep(31);
			}catch(InterruptedException e ) {
				e.printStackTrace();
			}

		}

	}

	public void paint(Graphics g) {
		
		if(!hr.getGamePaused()) {
		
		if(dbImage == null) {
			dbImage = createImage(this.getSize().width, this.getSize().height);
			dbg = dbImage.getGraphics();
		}
		//Draw Each Tile at location from the tileIDArray --- Layer 0
		for(int i = 0; i < 30; i++) {
			for(int j = 0;  j < 16; j++) {
				//System.out.println("J: " + j + " i: " + i);
				dbg.drawImage(tr.getTile(tr.tileIDArray[i][j]), (i*64), (j*64), null);
			}
		}

		//Draw Player --- Layer 1
		//dbg.drawImage(pr.getPlayerTile(), pm.getPlayerPosX(), pm.getPlayerPosY(), null);
		//System.out.println(pm.getplayerDirection());
		dbg.drawImage(playerRenderer.getPlayerTile(pm.getplayerDirection()), pm.getPlayerPosX(), pm.getPlayerPosY(), null);
		//Draw Enemies --- Layer 2

		//Draw Power-Ups --- Layer 3

		//Draw Effects --- Layer 4
		

		dbg.drawImage(DevTile2.getCurrentFrame(), 1664, 128, null);	
		dbg.drawImage(DevTile1.getCurrentFrame(), 1664, 192, null);

		
		//Draw HUD --- Layer 5
		for(int i = 27; i < 30; i++) {
			for(int j = 0; j < 16; j++) {
				dbg.drawImage(hr.getHudTile(), (i * 64), (j * 64), null);
			}
		}
		for (int i = 0; i<30; i++) {
			dbg.drawImage(hr.getHudTile(), (i * 64), (0 * 64), null);
		}
		
		
		
		
		dbg.setFont(new Font("Stencil", 1, 75));
		dbg.drawString("Score: " + Integer.toString(hr.getScore()), 64, 56);
		dbg.drawString("Time: " + Integer.toString( 500 - counter.getTimeSinceGameHasStartedInSecs()), 960, 56);

		//Draw Pre Buffered Image onto Screen, all layers combined
		g.drawImage(dbImage, 8, 32, null);
	
		}
		}


	/**
	 * Create the frame.
	 */
	public GUI() {
		setBackground(Color.GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 



		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		setVisible(true);
		addKeyListener(pm);
	}

}
