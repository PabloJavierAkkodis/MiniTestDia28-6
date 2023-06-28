package minitest;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.json.JSONObject;

public class ApiConnection {
	
	/*{"activity":"Have a picnic with some friends",
	 * "type":"social",
	 * "participants":3,
	 * "price":0.1,
	 * "link":"",
	 * "key":"6813070",
	 * "accessibility":0.1}*/
	
	
	private static URL url;
	
	public static int connectApi() {
		int httpResponseCode = 0;
		
		try {
			url = new URL("https://www.boredapi.com/api/activity");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			httpResponseCode = conn.getResponseCode();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return httpResponseCode;
		
	}
	
	
	public static String callApi() {
		// TODO Auto-generated constructor stub
		String result = "";
		
		
		
		StringBuilder informacion = new StringBuilder();
		Scanner sc;
		try {
			
			if(url == null) {
				int reponseCode = connectApi();
				
				if (reponseCode != 200) {
					throw new RuntimeException("HTTPSResponseCode: "+ reponseCode);
				}
			}
			
			sc = new Scanner(url.openStream());
			while (sc.hasNext())
			{
				informacion.append(sc.nextLine());
			}
			
			JSONObject jsonObject = new JSONObject(informacion.toString());
			result = jsonObject.getString("activity");
			
			sc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		return result;
	}

}
