package model;

import java.util.List;

/**
 * 
 * @author sharadb
 * 
 */
public class Look
{
	private List<Item> items;
	private String lookVisualUrl;

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public String getLookVisualUrl() {
		return lookVisualUrl;
	}

	public void setLookVisualUrl(String lookVisualUrl) {
		this.lookVisualUrl = lookVisualUrl;
	}
}
