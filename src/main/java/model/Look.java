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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		result = prime * result + ((visualUrl == null) ? 0 : visualUrl.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Look other = (Look) obj;
		if (items == null)
		{
			if (other.items != null)
				return false;
		}
		else if (!items.equals(other.items))
			return false;
		if (visualUrl == null)
		{
			if (other.visualUrl != null)
				return false;
		}
		else if (!visualUrl.equals(other.visualUrl))
			return false;
		return true;
	}
}
