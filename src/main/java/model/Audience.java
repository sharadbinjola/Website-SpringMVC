package model;

/**
 * 
 * @author sharadb
 *
 */
public enum Audience
{
	Men("Men"), Women("Women"), Kids("Kids");

	private String value;

	Audience(String value)
	{
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}
}
