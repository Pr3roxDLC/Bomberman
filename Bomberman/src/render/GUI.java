package render;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import game.BombHandler;
import game.ExplosionHandler;

import java.awt.Color;

//Tim & Leo

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
	game.BombHandler bomb = new game.BombHandler();
	game.EnemyMover eMover = new game.EnemyMover();
	public ExplosionFX explosionFX = new ExplosionFX();
	
	int currentFrame = 0;
	private Image dbImage;
	private Graphics dbg;
	public String playerDirection = "W";

	//All Testing Objects, Variables, ... go here
	//All the Paths to the Tiles used by the AnimatedPlayerRenderer
	public String[] PlayerFacingSouthTile = {"/anim/player/PlayerSpriteSouth1.png","/anim/player/PlayerSpriteSouth2.png","/anim/player/PlayerSpriteSouth3.png"};
	public String[] PlayerFacingNorthTile = {"/anim/player/PlayerSpriteNorth1.png","/anim/player/PlayerSpriteNorth2.png","/anim/player/PlayerSpriteNorth3.png"};
	public String[] PlayerFacingWestTile = {"/anim/player/PlayerSpriteWest1.png","/anim/player/PlayerSpriteWest2.png","/anim/player/PlayerSpriteWest3.png"};
	public String[] PlayerFacingEastTile = {"/anim/player/PlayerSpriteEast1.png","/anim/player/PlayerSpriteEast2.png","/anim/player/PlayerSpriteEast3.png"};
	
	AnimatedPlayerRenderer playerRenderer = new AnimatedPlayerRenderer(PlayerFacingSouthTile, PlayerFacingNorthTile, PlayerFacingEastTile, PlayerFacingWestTile, 4);
	



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
		//Lower Number = Higher Chance of Crates Spawning
		mm.genCrates(10);
		tr.setTileIDArray(mm.getTileIDArray());
		pm.setTileIDArray(tr.getTileIDArray());
		bomb.setRadius(3);
		eMover.setTileIDArray(tr.getTileIDArray());
		eMover.setAmmount(10);
		eMover.spawnEnemies();
		eMover.setEnemyTileIDArrayForEachEnemy(tr.getTileIDArray());
		ExplosionHandler.setTileIDArray(mm.getTileIDArray());


		while(true) {
			
			counter.updateCounter();
			bomb.setPlayerPos(pm.getPlayerPosX(), pm.getPlayerPosY());
			bomb.incBombTimer();
			pm.movePlayer();
			tr.setTileIDArray(mm.getTileIDArray());
			
			
			playerRenderer.updatePlayer();
			eMover.moveEnemies();
			eMover.setEnemyTileIDArrayForEachEnemy(tr.getTileIDArray());

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
			//Draw Power-Ups --- Layer 2



			//Draw Enemies --- Layer 3 [Also Contains the Bomb]
			for(int i = 0; i < 16; i++) {
				if(bomb.getBombArray()[i] != null) {
					if(bomb.getBombArray()[i].getUsed() == true) {
						dbg.drawImage(bomb.getBombTile(), bomb.getBombArray()[i].getBombPosX(), bomb.getBombArray()[i].getBombPosY(), null);
					}
				}


			}

			for(int i = 0; i < eMover.getAmmount(); i++) {

				if(eMover.getEnemyFromArray(i) != null) {

					dbg.drawImage(
							eMover.getEnemyFromArray(i).getEnemyTile(), 
							eMover.getEnemyFromArray(i).getX(), 
							eMover.getEnemyFromArray(i).getY(),
							null);
				}
			}




			//Draw Effects --- Layer 4

			for(int i = 0; i < 30; i++) {
				for(int j = 0; j < 16; j++) {
					
					dbg.drawImage(ExplosionFX.getFXTile(ExplosionFX.getFXTileArray()[i][j]), i * 64, j * 64, null);
					
				}
				
			}



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
		addKeyListener(bomb);
	}

}
