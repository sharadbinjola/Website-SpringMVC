package model;

/**
 * 
 * @author sharadb
 * 
 */
public class SearchResult
{
	private String title;
	private String result;
	private String url;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public SearchResult(String title, String result, String url)
	{
		super();
		this.title = title;
		this.result = result;
		this.url = url;
	}

	@Override
	public String toString() {
		return "SearchResult [title=" + title + ", result=" + result + ", url=" + url + "]";
	}
}
