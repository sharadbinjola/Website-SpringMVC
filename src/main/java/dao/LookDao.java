package dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Audience;
import model.Item;
import model.ItemType;
import model.Look;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class LookDao
{
	private static final String LOOKS_JSON_PATH = "C:\\git\\Website-SpringMVC\\looks.json";

	private JSONParser parser = new JSONParser();

	public List<Look> getAllLooks() {
		JSONArray allLooksJson = getAllLooksAllJson();

		List<Look> allLooks = new ArrayList<Look>();
		for (int i = 0; i < allLooksJson.size(); i++)
		{
			JSONObject lookJson = (JSONObject) allLooksJson.get(i);

			List<Item> items = new ArrayList<Item>();
			JSONArray itemsJson = (JSONArray) lookJson.get("items");
			for (int j = 0; j < itemsJson.size(); j++)
			{
				JSONObject itemJson = (JSONObject) itemsJson.get(j);

				ItemType itemType = ItemType.valueOf((String) itemJson.get("type"));
				Audience audience = Audience.valueOf((String) itemJson.get("audience"));
				String color = (String) itemJson.get("color");

				Item item = new Item(itemType, audience, color);

				items.add(item);
			}

			Look look = new Look();
			look.setVisualUrl((String) lookJson.get("visualUrl"));
			look.setItems(items);

			allLooks.add(look);
		}
		return allLooks;
	}

	public JSONArray getAllLooksAllJson() {
		JSONArray allLooks = null;
		try
		{
			allLooks = (JSONArray) parser.parse(new FileReader(LOOKS_JSON_PATH));

		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		} catch (ParseException e)
		{
			e.printStackTrace();
		}
		return allLooks;
	}
}
