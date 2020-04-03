package Misc;


public class SecondCounter {
	
	public int frameCurrent = 0;
	
	public int seconds;

	public void updateCounter() {
		if(frameCurrent < 32) {
		frameCurrent++;
		
		}else {
			
			frameCurrent = 0;
			seconds++;
		}
		
		
	}
	
	public void resetCounter() {
		
		seconds = 0;
		frameCurrent = 0;
		
	}
	
	public void setTimeSinceGameHasStartedInSecs(int seconds) {
		
		this.seconds = seconds;
		
	}
	
	public int getTimeSinceGameHasStartedInSecs() {
		
		return seconds;
		
	}
	
}
