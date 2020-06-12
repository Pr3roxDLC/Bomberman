package Misc;


//Tim


//Class Created to hold Utility Methods that get used alot
public class Utils {

	
	public static int RoundToClosestMultipleOf(int number, int multiple) {
		
		float numberfloat = (float) number;
		
		return Math.round((numberfloat / multiple))*multiple;
		
		
	}
	
	public static int random(int upper, int lower) {
		
		
		return (int) (Math.random() * (upper - lower)) + lower;

	}
	
	
	
	
	public static int RoundNumberToMultipleOf64(int i) {
		
	float number = (float) i;
		
		return Math.round((number/64))*64;
		 
	}
	
	
	  
      
	
	}