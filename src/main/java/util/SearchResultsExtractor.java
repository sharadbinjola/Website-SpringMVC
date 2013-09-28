package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import model.Item;
import model.ItemType;
import model.SearchResult;

/**
 * 
 * @author sharadb
 * 
 */
public class SearchResultsExtractor
{
	private static final String apparelSearchUrlPrefix = "http://www.amazon.com/s/ref=nb_sb_noss_1?url=search-alias%3Dapparel&field-keywords=";
	private static final String shoesSearchUrlPrefix = "http://www.amazon.com/s/ref=nb_sb_noss_1?url=search-alias%3Dshoes&field-keywords=";
	private static final int MAX_RESULTS = 3;

	public List<SearchResult> extract(Map<Item, String> rawResults) {
		List<SearchResult> searchResults = new ArrayList<SearchResult>();
		
		for (Map.Entry<Item, String> rawResult : rawResults.entrySet())
		{
			Item item = rawResult.getKey();
			String title = item.getColor() + " " + item.getType() + " for " + item.getAudience();
			
			String result = rawResult.getValue();
			result = getFilteredResultHtml(result, MAX_RESULTS);
			SearchResult searchResult = new SearchResult(title, result, getSearchUrl(item));

			searchResults.add(searchResult);
			
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
