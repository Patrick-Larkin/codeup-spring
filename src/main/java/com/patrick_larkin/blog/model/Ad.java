package com.patrick_larkin.blog.model;

import javax.persistence.*;

@Entity
public class Ad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false, length = 100)
	private String title;

	@Column(nullable = false, columnDefinition = "TEXT")
	private String description;

	@Column(nullable = false)
	private double price;

	public Ad() {}

	//Create Ad
	public Ad(String title, String description, double price) {
		this.title = title;
		this.description = description;
	}

	//Update Ad
	public Ad(long id, String title, String description, double price) {
		this.id = id;
		this.title = title;
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}