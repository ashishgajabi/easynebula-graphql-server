package au.com.easynebula.easynebulagraphqlserver.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import static javax.persistence.GenerationType.AUTO;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy= AUTO)
	private Long id;

	private String title;

	private String isbn;

	private int pageCount;

	@ManyToOne
	@JoinColumn(name = "author_id",
			nullable = false, updatable = false)
	private Author author;

	public Book() {
	}

	public Book(final String title,
	            final String isbn,
	            final int pageCount,
	            final Author author) {
		this.title = title;
		this.isbn = isbn;
		this.pageCount = pageCount;
		this.author = author;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book{" +
				"id=" + id +
				", title='" + title + '\'' +
				", isbn='" + isbn + '\'' +
				", pageCount=" + pageCount +
				", author=" + author +
				'}';
	}
}
