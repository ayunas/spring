package com.attacomsian.entities;

import javax.persistence.*;

@Entity //JPA
@Table(name = "page")
public class Page {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pageId;

	private int number;
	private String content;
	private String chapter;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "book_id", nullable = false)
	private Book book;

	public Page() {
	}

	public Page(int number, String content, String chapter, Book book) {
		this.number = number;
		this.content = content;
		this.chapter = chapter;
		this.book = book;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getChapter() {
		return chapter;
	}

	public void setChapter(String chapter) {
		this.chapter = chapter;
	}

	public int getPageId() {
		return pageId;
	}

	public Book getBook() {
		return book;
	}
}
