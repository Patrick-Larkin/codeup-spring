package com.patrick_larkin.blog.models;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

//@Entity
//@Table(name = "ads")
//public class Ad {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private long id;
//
//	@Column(nullable = false, length = 100)
//	private String title;
//
//	@Column(nullable = false, columnDefinition = "TEXT")
//	private String description;
//
//	@Column(precision=8, scale=2)
//  private float price;
//
//	@Temporal(TemporalType.TIMESTAMP)
//	@Column(name = "created_at", nullable = false, updatable = false)
//	@CreatedDate
//	private Date createdAt;
//
//	/*Todo: implement*/
////	@Temporal(TemporalType.TIMESTAMP)
////	@Column(name = "updated_at", nullable = false)
////	@LastModifiedDate
////	private Date updatedAt;
//
//	@OneToOne
//	private User user;
//
//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ad")
//	private String images;
//
//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(
//					name="ads_categories",
//					joinColumns={@JoinColumn(name="ad_id")},
//					inverseJoinColumns={@JoinColumn(name="category_id")}
//	)
//	private List<AdCategory> categories;
//
//	public Ad() {}
//
//	//Create Ad
//	public Ad(String title, String description, Float price, Date createdAt, User user, String images, List<AdCategory> categories) {
//		this.title = title;
//		this.description = description;
//		this.price = price;
//		this.createdAt = createdAt;
//		this.user = user;
//		this.images = images;
//		this.categories = categories;
//	}
//
//	//Update Ad
//	public Ad(Long id, String title, String description, Float price, Date createdAt, User user, String images, List<AdCategory> categories) {
//		this.id = id;
//		this.title = title;
//		this.description = description;
//		this.price = price;
//		this.createdAt = createdAt;
//		this.user = user;
//		this.images = images;
//		this.categories = categories;
//	}
//
//	public long getId() {
//		return id;
//	}
//
//	public String getTitle() {
//		return title;
//	}
//
//	public String getDescription() {
//		return description;
//	}
//
//	public float getPrice() {
//		return price;
//	}
//
//	public Date getDateCreated() {
//		return createdAt;
//	}
//
//	public User getUser() {
//		return user;
//	}
//
//	public String getImages() {
//		return images;
//	}
//
//	public List<AdCategory> getCategories() {
//		return categories;
//	}
//
//	public void setId(long id) {
//		this.id = id;
//	}
//
//	public void setTitle(String title) {
//		this.title = title;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}
//
//	public void setPrice(float price) {
//		this.price = price;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
//
//	public void setImages(String images) {
//		this.images = images;
//	}
//
//	public void setCategories(List<AdCategory> categories) {
//		this.categories = categories;
//	}
//}

	@Entity
	@Table(name = "ads")
	public class Ad {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;

		@Column(nullable = false, length = 100)
		private String title;

		@Column(nullable = false, columnDefinition = "TEXT")
		private String description;

		@OneToOne
		private User user;

		@OneToMany(cascade = CascadeType.ALL, mappedBy = "ad")
		private List<AdImage> images;

		@ManyToMany(cascade = CascadeType.ALL)
		@JoinTable(
						name = "ads_categories",
						joinColumns = {@JoinColumn(name = "ad_id")},
						inverseJoinColumns = {@JoinColumn(name = "category_id")}
		)
		private List<AdCategory> categories;

		public Ad() {
		}

		// CREATE
		public Ad(String title, String description, User user, List<AdImage> images) {
			this.title = title;
			this.description = description;
			this.user = user;
			this.images = images;
		}

		// READ
		public Ad(long id, String title, String description, User user, List<AdImage> images) {
			this.id = id;
			this.title = title;
			this.description = description;
			this.user = user;
			this.images = images;
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public List<AdImage> getImages() {
			return images;
		}

		public void setImages(List<AdImage> images) {
			this.images = images;
		}

		public List<AdCategory> getCategories() {
			return categories;
		}

		public void setCategories(List<AdCategory> categories) {
			this.categories = categories;
		}
	}