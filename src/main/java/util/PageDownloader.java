package util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;

public class PageDownloader implements Callable<String>
{
	private String urlToRead;
	
	public PageDownloader(String urlToRead)
	{
		super();
		this.urlToRead = urlToRead;
	}

	// http://www.amazon.com/s/ref=nb_sb_noss_1?url=search-alias%3Daps&field-keywords=Black%20pants%20men
	@Override
	public String call() {
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
