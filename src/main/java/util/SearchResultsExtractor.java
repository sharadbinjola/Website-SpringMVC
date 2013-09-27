package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import model.Item;
import model.SearchResult;

/**
 * 
 * @author sharadb
 * 
 */
public class SearchResultsExtractor
{
	private static final int MAX_RESULTS = 3;

	public List<SearchResult> extract(Map<Item, String> rawResults) {
		List<SearchResult> searchResults = new ArrayList<SearchResult>();
		
		for (Map.Entry<Item, String> rawResult : rawResults.entrySet())
		{
			Item item = rawResult.getKey();
			String title = item.getColor() + " " + item.getType() + " for " + item.getAudience();
			
			String result = rawResult.getValue();
			result = getFilteredResultHtml(result, MAX_RESULTS);
			SearchResult searchResult = new SearchResult(title, result);

			searchResults.add(searchResult);
			
		}
		return searchResults;
	}

	private String getFilteredResultHtml(String rawResult, int maxCount) {
		Document doc = Jsoup.parse(rawResult);
		Elements sssElements = doc.getElementsByClass("sss");
		Elements storeElements = doc.getElementsByClass("store");
		Elements starsAndPrimeElements = doc.getElementsByClass("starsAndPrime");
		Elements usedNewPriceElements = doc.getElementsByClass("usedNewPrice");
		sssElements.remove();
		storeElements.remove();
		starsAndPrimeElements.remove();
		usedNewPriceElements.remove();
		
		String allResults = "";
		for(int i = 0; i < maxCount; i++) {
			Element result = doc.getElementById("result_" + i);
			allResults += result.toString();
		}
		return allResults;
	}
}
