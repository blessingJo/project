package com.opule.entity;

import java.util.Base64;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.swing.event.TreeSelectionEvent;


@Entity
@Table(name = "product", catalog = "opuledb", uniqueConstraints = @UniqueConstraint(columnNames = "title"))
@NamedQueries({
	@NamedQuery(name = "Product.findAll", query = "SELECT b FROM Product b"),
	@NamedQuery(name = "Product.findByTitle", query = "SELECT b FROM Product b WHERE b.title = :title"),
	@NamedQuery(name = "Product.countAll", query = "SELECT COUNT(*) FROM Product b"),
	@NamedQuery(name = "Product.countByCategory", query = "SELECT COUNT(b) FROM Product b "
			+ "WHERE b.category.categoryId = :catId"),
	@NamedQuery(name = "Product.findByCategory", query = "SELECT b FROM Product b JOIN "
			+ "Category c ON b.category.categoryId = c.categoryId AND c.categoryId = :catId"),
	@NamedQuery(name = "Product.search", query = "SELECT b FROM Product b WHERE b.title LIKE '%' || :keyword || '%'"
			+ " OR b.description LIKE '%' || :keyword || '%'")
})
public class Product implements java.io.Serializable {

	private Integer productId;
	private Category category;
	private String title;
	private String description;
	private byte[] image;
	private String base64Image;
	private float price;
	private Set<Review> reviews = new HashSet<Review>(0);
	private Set<OrderDetail> orderDetails = new HashSet<OrderDetail>(0);

	public Product() {
	}
	
	public Product(Integer productId) {
		super();
		this.productId = productId;
	}



	public Product(Category category, String title, String description, byte[] image,
			float price) {
		
		this.category = category;
		this.title = title;
		this.description = description;
		this.image = image;
		this.price = price;

	}

	public Product(Category category, String title, String description, byte[] image,
			float price, Set<Review> reviews, Set<OrderDetail> orderDetails) {
		this.category = category;
		this.title = title;
		this.description = description;
		this.image = image;
		this.price = price;
		this.reviews = reviews;
		this.orderDetails = orderDetails;
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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id", nullable = false)
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Column(name = "title", unique = true, nullable = false, length = 128)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
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


	@OneToMany(fetch = FetchType.EAGER, mappedBy = "product")
	public Set<Review> getReviews() {
		TreeSet<Review> sortedReviews = new TreeSet<>(new Comparator<Review>() {

			@Override
			public int compare(Review review1, Review review2) {
				return review2.getReviewTime().compareTo(review1.getReviewTime());
			}
			
		});
		
		sortedReviews.addAll(reviews);
		return sortedReviews;
	}

	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	public Set<OrderDetail> getOrderDetails() {
		return this.orderDetails;
	}

	public void setOrderDetails(Set<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
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

	@Transient
	public float getAverageRating() {
		float averageRating = 0.0f;
		float sum = 0.0f;
		
		if (reviews.isEmpty()) {
			return 0.0f;
		}
		
		for (Review review : reviews) {
			sum += review.getRating();
		}
		
		averageRating = sum / reviews.size();
		
		return averageRating;
	}
	
	@Transient
	public String getRatingStars() {
		float averageRating = getAverageRating();
		
		return getRatingString(averageRating);
	}
	
	@Transient
	public String getRatingString(float averageRating) {
		String result = "";
		
		int numberOfStarsOn = (int) averageRating;
		
		for (int i = 1; i <= numberOfStarsOn; i++) {
			result += "on,";
		}
		
		int next = numberOfStarsOn + 1;
		
		if (averageRating > numberOfStarsOn) {
			result += "half,";
			next++;
		}
		
		for (int j = next; j <= 5; j++) {
			result += "off,";
		}
		
		return result.substring(0, result.length() - 1);
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
