package render;


import java.awt.image.BufferedImage;

//Tim

public class TileRenderer {

 //Array to store the ID of each Tile in
 public BufferedImage[] tileSet = new BufferedImage[64];
 //Array that gets pushed to the GUI containing information about what TileID needs to be drawn at what position.
 public int[][] tileIDArray = new int[30][16];


 public static void main() {}

 public void setTileIDArray(int[][] tileIDArray) {
  this.tileIDArray = tileIDArray;
 }


 public void setTileID(int xPos, int yPos, int ID) {
  tileIDArray[xPos][yPos] = ID;
 }

 public int[][] getTileIDArray() {
  return tileIDArray;
 }




 public void initTiles() {
  System.out.println("[Tile Renderer]: Started Init Sequence");


  // Load devTile1 into Memory
  BufferedImage devTile1 = null;
  devTile1 = ResourceLoader.ladeBild("/Floor.png");
  tileSet[0] = devTile1;
  System.out.println("[Tile Remderer]: Loaded DevTile1");

  //Load Wall into memory
  BufferedImage devWallTile = null;
  devWallTile = ResourceLoader.ladeBild("/Wall.png");
  tileSet[2] = devWallTile;

  BufferedImage crate = null;
  crate = ResourceLoader.ladeBild("/Crate.png");
  tileSet[3] = crate;

  //Load devTile2 into Memory


  BufferedImage devTile2 = null;
  devTile2 = ResourceLoader.ladeBild("/Dev2.png");
  System.out.println("[Tile Remderer]: Loaded DevTile2");
  tileSet[1] = devTile2;

  //Fill the tileIDArray with devTile1
  for (int i = 0; i < tileIDArray.length; i++) {
   for (int j = 0; j < tileIDArray[i].length; j++) {

    tileIDArray[i][j] = 0;


   }


  }


  System.out.println("[Tile Renderer]: Completed Init Sequence");

 }
 //Returns the Tile assigned to the given TileID
 public BufferedImage getTile(int i) {

  return tileSet[i];
 }

 //Assign a position a new TileID
 public void addTile(int tileID, int y, int x) {

  tileIDArray[y][x] = tileID;


 }








}