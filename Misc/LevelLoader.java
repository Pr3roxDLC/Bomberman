package Misc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class LevelLoader {
	
  
	
	public static void writeLevelJSONs()  throws IOException{
		List<String> level =  new ArrayList<String>(); 
		
		
		
		JSONObject LevelJsonObj = new JSONObject();
		
		JSONObject Level1 = new JSONObject();
		JSONObject Level2 = new JSONObject();
		JSONObject Level3 = new JSONObject();
		JSONObject Level4 = new JSONObject();
		
		Level1.put("boxSpawnrate", 3);
		Level1.put("enemies", "5");
		
		Level2.put("boxSpawnrate", 3);
		Level2.put("enemies", "5");
		
		Level3.put("boxSpawnrate", 3);
		Level3.put("enemies", "5");
		
		Level4.put("boxSpawnrate", 3);
		Level4.put("enemies", "5");
		
		LevelJsonObj.put("level1", Level1);
				
	    Files.write(Paths.get("Level.json"), LevelJsonObj.toString().getBytes());

		
	}
	
	
	
	public LevelLoader() {
		// TODO Auto-generated constructor stub
	}

}
