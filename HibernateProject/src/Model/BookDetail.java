package Model;
// Generated 2019/9/20 �W�� 11:09:34 by Hibernate Tools 5.4.3.Final

/**
 * BookDetail generated by hbm2java
 */
public class BookDetail implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private Book book;
	private String publisher;
	private String publisheraddress;

	public BookDetail() {
	}

	public BookDetail(Book book) {
		this.book = book;
	}

	public BookDetail(Book book, String publisher, String publisheraddress) {
		this.book = book;
		this.publisher = publisher;
		this.publisheraddress = publisheraddress;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public String getPublisher() {
		return this.publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPublisheraddress() {
		return this.publisheraddress;
	}

	public void setPublisheraddress(String publisheraddress) {
		this.publisheraddress = publisheraddress;
	}

}
