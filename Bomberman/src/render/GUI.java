package render;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.DefaultDesktopManager;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Misc.MainMenu;
import game.ExplosionHandler;
import game.PlayerDeathTiles;

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

	public String[] levelNames = {"level1","level2","level3", "level4"};
	int levelID = 0;

	AnimatedPlayerRenderer playerRenderer = new AnimatedPlayerRenderer(PlayerFacingSouthTile, PlayerFacingNorthTile, PlayerFacingEastTile, PlayerFacingWestTile, 4);




	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Thread f = new Thread(new GUI());

		f.start();

	}

	public void loadNextLevel() {

		pm.setBlockPlayerInputs(false);

		game.MapManager.initWalls();
		game.MapManager.remCrates();
		game.MapManager.genCrates(				Misc.LevelLoader.getLevelData(levelID)[0] );
		bomb.setRadius(							Misc.LevelLoader.getLevelData(levelID)[2] );
		bomb.setMaxBombs(						Misc.LevelLoader.getLevelData(levelID)[3] );
		eMover.setAmmount(						Misc.LevelLoader.getLevelData(levelID)[1] );
		eMover.spawnEnemies();
		eMover.setTileIDArray(tr.getTileIDArray());
		eMover.setEnemyTileIDArrayForEachEnemy(tr.getTileIDArray());
		game.LevelEnd.resetLevelEnd();



		pm.setPlayerPos(64, 128);

		game.LevelEnd.textSize = 75;

		levelID++;
	}


	public void loadGame() throws IOException {


		tr.initTiles();
		pr.initPlayer();
		hr.initHud();

		//LevelLoader.writeLevelJSONs();


		game.MapManager.initWalls();
		//Lower Number = Higher Chance of Crates Spawning
		game.MapManager.genCrates(3);

		tr.setTileIDArray(game.MapManager.getTileIDArray());
		pm.setTileIDArray(tr.getTileIDArray());

		//Set Radius Of the BombExplosions
		bomb.setRadius(1);
		bomb.setMaxBombs(1);
		eMover.setTileIDArray(tr.getTileIDArray());

		//Set The Amount of Enemies to Spawn in
		eMover.setAmmount(8);
		eMover.spawnEnemies();
		eMover.setEnemyTileIDArrayForEachEnemy(tr.getTileIDArray());
		ExplosionHandler.setTileIDArray(game.MapManager.getTileIDArray());
		MainMenu.initMainMenu();




	}

	public void updateGame() {

		if(MainMenu.getLevelPaused() == false) {

			counter.updateCounter();
			bomb.setPlayerPos(pm.getPlayerPosX(), pm.getPlayerPosY());
			bomb.incBombTimer();
			pm.movePlayer();
			tr.setTileIDArray(game.MapManager.getTileIDArray());



			playerRenderer.updatePlayer();
			eMover.moveEnemies();
			eMover.setEnemyTileIDArrayForEachEnemy(tr.getTileIDArray());
			ExplosionFX.updateFX();
			PlayerDeathTiles.addEnemiesToDeathArray(eMover.getEnemyArray());
			PlayerDeathTiles.addExplosionsToDeathArray(ExplosionFX.getFXTileArray());
			PlayerDeathTiles.playerIsOnDeathTile(pm.getPlayerPosX(), pm.getPlayerPosY());
			eMover.checkColWithExplosion(ExplosionFX.getFXTileArray());
			game.LevelEnd.setTileIDArrayForLevelEnd(tr.getTileIDArray());
			game.LevelEnd.livingEnemies = eMover.getNumberOfLivingEnemies();
			game.LevelEnd.checkForLevelEnd();
			game.LevelEnd.setPlayerPosForLevelEnd(pm.getPlayerPosX(), pm.getPlayerPosY());
			game.LevelEnd.checkForPlayerColWithEndTile();
			tr.setTileIDArray(game.LevelEnd.getTileIdArray());

			if(game.LevelEnd.opacity == 1F) {

				loadNextLevel();
				game.LevelEnd.opacity = 0F;

			}
		}

		MainMenu.updateMainMenu();


	}


	public void run() {

		try {
			loadGame();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		while(true) {

			updateGame();

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


			if(MainMenu.getLevelPaused() == true) {
				int i = 0;
				
				if(MainMenu.getButtonFromArray(i) != null) {
					
					dbg.fill3DRect(		MainMenu.getButtonFromArray(i).getPosX(),
										MainMenu.getButtonFromArray(i).getPosY(),
										MainMenu.getButtonFromArray(i).getWidth(),
										MainMenu.getButtonFromArray(i).getHeight(),
										false);
					dbg.setColor(new Color(255, 255,255));
					dbg.drawString(MainMenu.getButtonFromArray(i).getText(), MainMenu.getButtonFromArray(i).getPosX() - (MainMenu.getButtonFromArray(i).getWidth()/2) + dbg.getFontMetrics().stringWidth(MainMenu.getButtonFromArray(i).getText())  , MainMenu.getButtonFromArray(i).getPosY() + dbg.getFont().getSize());
					dbg.setColor(new Color(0, 0, 0));
				}
				
			}




			dbg.setFont(new Font("Stencil", 1, 75));
			dbg.drawString("Score: " + Integer.toString(hr.getScore()), 64, 56);
			dbg.drawString("Time: " + Integer.toString( 500 - counter.getTimeSinceGameHasStartedInSecs()), 960, 56);

			if(game.LevelEnd.getPlayerIsTouchingEndTile() == true) {
				dbg.setFont(new Font("Stencil", 1, game.LevelEnd.getTextSize()));
				pm.setBlockPlayerInputs(true);
				game.LevelEnd.updateTextSize();

				int width = dbg.getFontMetrics().stringWidth("Level Complete!");


				dbg.drawString("Level Complete!", this.getWidth()/2 - width/2, this.getHeight()/2);

				dbg.setColor(new Color(0, 0, 0, game.LevelEnd.getUpdatedOpacity()));

				dbg.fillRect(0, 0, this.getWidth(), this.getHeight());

			}
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
		addMouseListener(new MainMenu());
	}

}
