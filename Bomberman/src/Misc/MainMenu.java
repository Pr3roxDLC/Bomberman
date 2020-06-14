package Misc;

import java.awt.MouseInfo;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import org.junit.experimental.theories.Theories;





public class MainMenu extends MouseAdapter {
	
	public static int mousePosX = 0;
	public static int mousePosY = 0;
	public static boolean levelPaused = true;
	public static Button[] buttons = new Button[4];
	
	
	
	public static boolean getLevelPaused() {
		
		return levelPaused;
	}
	
	public static void setLevelPaused(boolean boolLevelPaused) {
	
		levelPaused = boolLevelPaused;
	
	}
	
	
	
	
	
	
	
	public void mouseClicked(MouseEvent e) {
		System.out.println("Event Fired");
		
		System.out.println(getButtonMouseIsClickingOn(e).getText());
		
		if(getButtonMouseIsClickingOn(e) == buttons[0]) {
			
			levelPaused = false;
			
		}
	
		
		
	}
	
	public static Button getButtonFromArray(int index) {
		
			return buttons[index];
			
	}
	
	public static void initMainMenu() {
		
		buttons[0] = new Button("Start", 752 , 200, 400, 100, false);
		
	}
	
	public static Button getButtonMouseIsClickingOn(MouseEvent e) {
		
		for(int i = 0; i < 4; i++) {
			if(e.getLocationOnScreen().x > buttons[i].getPosX() && e.getLocationOnScreen().x < buttons[i].getPosX() + buttons[i].getWidth()) {
				if(e.getLocationOnScreen().y > buttons[i].getPosY() && e.getLocationOnScreen().y < buttons[i].getPosY() + buttons[i].getHeight())
				
				return buttons[i];
				System.out.println("Button Hit");
				
			}
			
		
			
		}
		
		return null;
		
	}
	
	
	
	
	
	
	public static void updateMainMenu() {
		
		mousePosX = MouseInfo.getPointerInfo().getLocation().x;
		mousePosY = MouseInfo.getPointerInfo().getLocation().y;
		//System.out.println(mousePosX + " " + mousePosY);
		
	}
	

}
