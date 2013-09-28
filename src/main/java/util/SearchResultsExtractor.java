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
		Elements newPrice = doc.getElementsByClass("newPrice");
		Elements usedPrice = doc.getElementsByClass("usedPrice");
		Elements sssUnrated = doc.getElementsByClass("sssUnrated");
		Elements number = doc.getElementsByClass("number");
		Elements sss = doc.getElementsByClass("sss");
		Elements sssFree = doc.getElementsByClass("sssFree");
		Elements sssLastLine = doc.getElementsByClass("sssLastLine");
		Elements starsAndPrime = doc.getElementsByClass("starsAndPrime");
		
		sss.remove();
		number.remove();
		newPrice.remove();
		usedPrice.remove();
		sssUnrated.remove();
		sssFree.remove();
		sssLastLine.remove();
		starsAndPrime.remove();
		
		String allResults = "";
		for(int i = 0; i < maxCount; i++) {
			Element result = doc.getElementById("result_" + i);
			allResults += result.toString();
		}
		return allResults;
	}
}
