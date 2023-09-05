package shopcart;

import java.util.Objects;

public class Product {
	private String name;
	private String pic;
	private Integer quantity;
	private Integer price;

	public Product(String name, String pic, Integer quantity, Integer price) {
		super();
		this.name = name;
		this.pic = pic;
		this.quantity = quantity;
		this.price = price;
	}

	public Product(String name, Integer quantity, Integer price) {
		super();
		this.name = name;
		this.pic = pic;
		this.quantity = quantity;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", pic=" + pic + ", quantity=" + quantity + ", price=" + price + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, price, quantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return this.getName() == other.getName();
	}

}
