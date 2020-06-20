package com.OnlineStore.Entity;
// Generated 2020. 5. 25 ���� 6:24:37 by Hibernate Tools 5.2.3.Final

import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Review generated by hbm2java
 */
@Entity
@Table(name = "review", catalog = "onlinestoredb")
@NamedQueries({
	@NamedQuery(name="Review.listAll", query = "SELECT r FROM Review r ORDER BY r.reviwedTime DESC"),
	@NamedQuery(name="Review.countAll", query = "SELECT COUNT(r) FROM Review r")
})
public class Review implements java.io.Serializable {

	private Integer reviewId;
	private Customer customer;
	private Product product;
	private int rating;
	private String headline;
	private String comment;
	private Date reviwedTime;

	public Review() {
	}

	public Review(Customer customer, Product product, int rating, String headline, String comment, Date reviwedTime) {
		this.customer = customer;
		this.product = product;
		this.rating = rating;
		this.headline = headline;
		this.comment = comment;
		this.reviwedTime = reviwedTime;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "review_id", unique = true, nullable = false)
	public Integer getReviewId() {
		return this.reviewId;
	}

	public void setReviewId(Integer reviewId) {
		this.reviewId = reviewId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id", nullable = false)
	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id", nullable = false)
	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Column(name = "rating", nullable = false)
	public int getRating() {
		return this.rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Column(name = "headline", nullable = false, length = 128)
	public String getHeadline() {
		return this.headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	@Column(name = "comment", nullable = false, length = 500)
	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "reviwed_time", nullable = false, length = 19)
	public Date getReviwedTime() {
		return this.reviwedTime;
	}

	public void setReviwedTime(Date reviwedTime) {
		this.reviwedTime = reviwedTime;
	}

}
