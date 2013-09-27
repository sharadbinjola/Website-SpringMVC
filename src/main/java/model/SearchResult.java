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

	public SearchResult(String title, String result)
	{
		super();
		this.title = title;
		this.result = result;
	}

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
}
