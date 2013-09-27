package model;

/**
 * 
 * @author sharadb
 *
 */
public class Item
{
	private ItemType type;
	private Audience audience;
	private String color;

	public Item(ItemType type, Audience audience, String color)
	{
		super();
		this.type = type;
		this.audience = audience;
		this.color = color;
	}

	public Item(ItemType type, String color)
	{
		this(type, null, color);
	}

	public ItemType getType() {
		return type;
	}

	public void setType(ItemType type) {
		this.type = type;
	}

	public Audience getAudience() {
		return audience;
	}

	public void setAudience(Audience audience) {
		this.audience = audience;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
