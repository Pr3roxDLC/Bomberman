package Misc;


//Tim

public class Utils {

	
	public static int RoundToClosestMultipleOf(int number, int multiple) {
		
		float numberfloat = (float) number;
		
		return Math.round((numberfloat / multiple))*multiple;
		
		
	}
	
	
	
	
	public static int RoundNumberToMultipleOf64(int i) {
		
	float number = (float) i;
		
		return Math.round((number/64))*64;
		 
	}
	
	
	  
      
	
	}