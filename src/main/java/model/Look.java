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
	private String visualUrl;

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public String getVisualUrl() {
		return visualUrl;
	}

	public void setVisualUrl(String visualUrl) {
		this.visualUrl = visualUrl;
	}

	@Override
	public String toString() {
		return "Look [items=" + items + ", visualUrl=" + visualUrl + "]";
	}
}
