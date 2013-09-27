package model;

/**
 * 
 * @author sharadb
 *
 */
public enum ItemType
{
	Jeans("Jeans"), Pants("Pants"), Shirt("Shirt"), TShirt("TShirt"), Shoes("Shoes");

	private String value;

	ItemType(String value)
	{
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}
}
