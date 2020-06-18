package com.OnlineStore.Entity;
// Generated 2020. 5. 25 ���� 6:24:37 by Hibernate Tools 5.2.3.Final

import java.util.Base64;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

/**
 * Product generated by hbm2java
 */
@Entity
@Table(name = "product", catalog = "onlinestoredb", uniqueConstraints = @UniqueConstraint(columnNames = "product_name"))
@NamedQueries({ @NamedQuery(name = "Product.findAll", query = "SELECT b FROM Product b"),
		@NamedQuery(name = "Product.findByName", query = "SELECT b FROM Product b WHERE b.productName = :productName"),
		@NamedQuery(name = "Product.countAll", query = "SELECT COUNT(p) FROM Product p"),
		@NamedQuery(name = "Product.findByCategory", query = "SELECT p FROM Product p JOIN Category c on p.category.categoryId = c.categoryId AND c.categoryId =:catId"),
		@NamedQuery(name = "Product.ListNew", query = "SELECT p FROM Product p ORDER BY p.productName")
})
public class Product implements java.io.Serializable {

	private Integer productId;
	private Category category;
	private String productName;
	private String description;
	private byte[] image;
	private String base64Image;
	private float price;
	private String size;
	private Set<Review> reviews = new HashSet<Review>(0);
	private Set<OrderDetails> orderDetailses = new HashSet<OrderDetails>(0);

	public Product() {
	}

	public Product(Category category, String productName, String description, byte[] image, float price, String size) {
		this.category = category;
		this.productName = productName;
		this.description = description;
		this.image = image;
		this.price = price;
		this.size = size;
	}

	public Product(Category category, String productName, String description, byte[] image, float price, String size,
			Set<Review> reviews, Set<OrderDetails> orderDetailses) {
		this.category = category;
		this.productName = productName;
		this.description = description;
		this.image = image;
		this.price = price;
		this.size = size;
		this.reviews = reviews;
		this.orderDetailses = orderDetailses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "product_id", unique = true, nullable = false)
	public Integer getProductId() {
		return this.productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", nullable = false)
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Column(name = "product_name", unique = true, nullable = false, length = 128)
	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Column(name = "description", nullable = false, length = 16777215)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "image", nullable = false)
	public byte[] getImage() {
		return this.image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Column(name = "price", nullable = false, precision = 12, scale = 0)
	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Column(name = "size", nullable = false, length = 5)
	public String getSize() {
		return this.size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	public Set<Review> getReviews() {
		return this.reviews;
	}

	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	public Set<OrderDetails> getOrderDetailses() {
		return this.orderDetailses;
	}

	public void setOrderDetailses(Set<OrderDetails> orderDetailses) {
		this.orderDetailses = orderDetailses;
	}

	@Transient
	public String getBase64Image() {

		this.base64Image = Base64.getEncoder().encodeToString(this.image);
		return this.base64Image;
	}

	@Transient
	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
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
		Product other = (Product) obj;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		return true;
	}

}
