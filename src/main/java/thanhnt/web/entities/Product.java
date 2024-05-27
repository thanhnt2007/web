package thanhnt.web.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
	@Id
	@Column(name = "productId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;
	@Column(name = "productName")
	private String productName;
	@Column(name = "price")
	private String price;
	@Column(name = "image")
	private String image;
	@Column(name = "color")
	private String color;
	@Column(name = "manufacture")
	private String manufacture;
	@Column(name = "description", length=40000)
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "categoryId",referencedColumnName = "id")
	private Category category;
	
	public Product() {
		super();
	}
	
	public Product(Integer productId, String productName, String price, String image, String color, String manufacture,
			String description, Category category) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.image = image;
		this.color = color;
		this.manufacture = manufacture;
		this.description = description;
		this.category = category;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getManufacture() {
		return manufacture;
	}

	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}
	
}
