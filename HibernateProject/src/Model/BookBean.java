package Model;

public class BookBean {
	private BookDetailBean bookdetail;
	private int id, price;
	private String bookname, author;

	public BookDetailBean getBookdetail() {
		return bookdetail;
	}

	public void setBookdetail(BookDetailBean bookdetail) {
		this.bookdetail = bookdetail;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
