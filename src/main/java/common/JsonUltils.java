package common;

import java.io.File;
import java.nio.file.Files;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUltils {
		public String readJsonFile(String filePath) {
			File file = new File(filePath);
			String jsonBody="";
			try {
				FileReader reader = new FileReader(file);
				JSONParser parser = new JSONParser();
				JSONObject responseBodyJsonObj;
				
				responseBodyJsonObj = (JSONObject) parser.parse(reader);
				jsonBody= responseBodyJsonObj.toJSONString();
			} catch ( IOException | ParseException e) {
				System.out.println("file not found");
				e.printStackTrace();
			}
			return jsonBody;		
		}
		public void copyFile(File srcFile, File destFile) throws IOException{
			Files.copy(srcFile.toPath(), destFile.toPath());
			
		}
		public ArrayList<String> getArrayValueByKey(String responseBody, String key) {
			ArrayList<String> valueArrayList= null;
			Object obj = JSONValue.parse(responseBody);
			JSONObject jsonObject = (JSONObject) obj;
			Object value = jsonObject.get(key);
			String valueStr = value.toString();
			valueArrayList = new ArrayList<>(Arrays.asList(valueStr));
			return valueArrayList;
		}
}
