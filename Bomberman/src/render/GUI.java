package render;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class GUI extends JFrame implements Runnable {

	private JPanel contentPane;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	TileRenderer tr = new TileRenderer();
	PlayerRenderer pr = new PlayerRenderer();
	int currentFrame = 0;
	private Image dbImage;
	private Graphics dbg;




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
		while(true) {


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
		dbg.drawImage(pr.getPlayerTile(), pr.getPlayerPosX(), pr.getPlayerPosY(), null);

		//Draw Enemies --- Layer 2

		//Draw Power-Ups --- Layer 3

		//Draw Effects --- Layer 4

		//Draw HUD --- Layer 5

		//Draw Pre Buffered Image onto Screen, all layers combined
		g.drawImage(dbImage, 8, 32, null);
	}


	/**
	 * Create the frame.
	 */
	public GUI() {
		setBackground(Color.GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 

		//Uncommentate before Final Build --- decorated for easier working.
		//setUndecorated(true);


		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		setVisible(true);
	}

}
