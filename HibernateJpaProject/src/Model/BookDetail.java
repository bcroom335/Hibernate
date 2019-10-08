package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

// Generated 2019/9/20 �W�� 11:09:34 by Hibernate Tools 5.4.3.Final

@Entity
@Table(name="BookDetail")
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
	
	@Id @Column(name = "ID")
	@GenericGenerator(name = "generator",strategy = "foreign",
	parameters = @Parameter(name="property",value = "book"))
	@GeneratedValue(generator = "generator")
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	@Column(name = "PUBLISHER")
	public String getPublisher() {
		return this.publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	@Column(name = "PUBLISHERADDRESS")
	public String getPublisheraddress() {
		return this.publisheraddress;
	}

	public void setPublisheraddress(String publisheraddress) {
		this.publisheraddress = publisheraddress;
	}

}