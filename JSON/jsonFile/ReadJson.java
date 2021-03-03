package jsonFile;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileReader;

public class ReadJson {
	public static void main(String[] args) {
		try {
			@SuppressWarnings("deprecation")
			JsonParser parser=new JsonParser();
			JsonObject object=(JsonObject) parser.parse(new FileReader("test.json"));
			System.out.println("cat="+object.get("cat").getAsString());
			System.out.println("pop="+object.get("pop").getAsBoolean());
			JsonArray array=object.get("languages").getAsJsonArray();
			for(int i=0;i<array.size();i++){
				System.out.println("-- -- -- -- -- -- --");
				JsonObject subObject=array.get(i).getAsJsonObject();
				System.out.println("id="+subObject.get("id").getAsInt());
				System.out.println("ide="+subObject.get("ide").getAsString());
				System.out.println("name="+subObject.get("name").getAsString());
				
			}
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
	}
}
