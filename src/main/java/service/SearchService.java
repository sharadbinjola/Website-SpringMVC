package service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import util.PageDownloader;

import model.Item;
import model.ItemType;
import model.Look;

/**
 * 
 * @author sharadb
 * 
 */
public class SearchService
{
	private static final String apparelSearchUrlPrefix = "http://www.amazon.com/s/ref=nb_sb_noss_1?url=search-alias%3Dapparel&field-keywords=";
	private static final String shoesSearchUrlPrefix = "http://www.amazon.com/s/ref=nb_sb_noss_1?url=search-alias%3Dshoes&field-keywords=";

	public Map<Item, String> getSearchResults(Look look) {
		List<Item> items = look.getItems();

		ExecutorService executor = Executors.newCachedThreadPool();

		List<Future<String>> futureResults = new ArrayList<Future<String>>();
		for (Item item : items)
		{
			String searchUrl = getSearchUrl(item);

			Future<String> futureResult = executor.submit(new PageDownloader(searchUrl));
			futureResults.add(futureResult);

		}

		Map<Item, String> searchResults = new LinkedHashMap<Item, String>();
		for (int i = 0; i < items.size(); i++)
		{
			Item item = items.get(i);

			Future<String> futureResult = futureResults.get(i);
			String searchResult = null;
			try
			{
				searchResult = futureResult.get();
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			} catch (ExecutionException e)
			{
				e.printStackTrace();
			}
			
			searchResults.put(item, searchResult);
		}

		return searchResults;
	}
	
	private String getSearchUrl(Item item) {
		String searchUrl = apparelSearchUrlPrefix;
		if(item.getType().equals(ItemType.Shoes)) {
			searchUrl = shoesSearchUrlPrefix;
		}
		searchUrl += item.getColor().replaceAll(" ", "%20") + "%20" + item.getType() + "%20" + item.getAudience();
		
		return searchUrl;
	}
}
