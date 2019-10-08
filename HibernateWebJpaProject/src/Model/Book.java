package Model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

// Generated 2019/9/20 �W�� 11:09:34 by Hibernate Tools 5.4.3.Final

@Entity
@Table(name="Book")
public class Book implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String bookname;
	private String author;
	private Integer price;
	private BookDetail bookDetail;

	public Book() { 
	}

	public Book(String bookname, String author, Integer price, BookDetail bookDetail) {
		this.bookname = bookname;
		this.author = author;
		this.price = price;
		this.bookDetail = bookDetail;
	}
	@Id @Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="BOOKNAME")
	public String getBookname() {
		return this.bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	
	@Column(name="AUTHOR")
	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Column(name="PRICE")
	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
	
	@OneToOne(fetch = FetchType.LAZY,mappedBy = "book",cascade = CascadeType.ALL)
	public BookDetail getBookDetail() {
		return this.bookDetail;
	}

	public void setBookDetail(BookDetail bookDetail) {
		this.bookDetail = bookDetail;
	}

}
