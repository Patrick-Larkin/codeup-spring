//package com.patrick_larkin.blog.model;
//
//import javax.persistence.Column;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//
//public class Post {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private long id;
//
//	@Column(nullable = false, length = 255)
//	private String title;
//
//	@Column(nullable = false, length = 255)
//	private String summary;
//
//	@Column(nullable = false, length = 255)
//	private String content;
//
//
//	/*private Blob img;*/
//
//
//	public Post(String title, String summary, String content) {
//		this.title = title;
//		this.summary = summary;
//		this.content = content;
//		/*this.img = img;*/
//	}
//
//	public String getTitle() {
//		return title;
//	}
//
//	public String getSummary() {
//		return summary;
//	}
//
//	public String getContent() {
//		return content;
//	}
//
//	public void setTitle(String title) {
//		this.title = title;
//	}
//
//	public void setSummary(String summary) {
//		this.summary = summary;
//	}
//
//	public void setContent(String content) {
//		this.content = content;
//	}
//}
