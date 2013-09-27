package service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Item;
import model.Look;

/**
 * 
 * @author sharadb
 * 
 */
public class SearchService
{
	private static final String searchUrlPrefix = "http://www.amazon.com/s/ref=nb_sb_noss_1?url=search-alias%3Daps&field-keywords=";

	public Map<Item, String> getSearchResults(Look look) {
		List<Item> items = look.getItems();

		Map<Item, String> searchResults = new HashMap<Item, String>();
		for (Item item : items)
		{
			String searchUrl = searchUrlPrefix;
			searchUrl += item.getColor() + "%20" + item.getType() + "%20" + item.getAudience();
			String searchResult = getHTML(searchUrl);
			searchResults.put(item, searchResult);
		}

		return searchResults;
	}

	// http://www.amazon.com/s/ref=nb_sb_noss_1?url=search-alias%3Daps&field-keywords=Black%20pants%20men
	private String getHTML(String urlToRead) {
		URL url;
		HttpURLConnection conn;
		BufferedReader rd;
		String line;
		String result = "";
		try
		{
			url = new URL(urlToRead);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			while ((line = rd.readLine()) != null)
			{
				result += line;
			}
			rd.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
}
