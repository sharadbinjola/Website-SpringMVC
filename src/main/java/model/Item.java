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

	@Override
	public String toString() {
		return "Item [type=" + type + ", audience=" + audience + ", color=" + color + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((audience == null) ? 0 : audience.hashCode());
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Item other = (Item) obj;
		if (audience != other.audience)
			return false;
		if (color == null)
		{
			if (other.color != null)
				return false;
		}
		else if (!color.equals(other.color))
			return false;
		if (type != other.type)
			return false;
		return true;
	}
}
