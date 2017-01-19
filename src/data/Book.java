package data;

public class Book extends Publication {
	private static final long serialVersionUID = -7907331751072277846L;
	private String author;
	private int pages;
	private String isbn;

	// Constructor
	public Book(String title, String author, int year, int pages, String publisher, String isbn) {
		super(title, publisher, year);
		this.setPages(pages);
		this.setAuthor(author);
		this.setIsbn(isbn);
	}

	public Book(Book book) {
		this(book.getTitle(), book.getAuthor(), book.getYear(), book.getPages(), book.getPublisher(), book.getIsbn());
	}

	// Setters and getters
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + pages;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (pages != other.pages)
			return false;
		return true;
	}

	@Override
    public String toString() {
        StringBuilder print = new StringBuilder(32);
        print.append(getTitle());
        print.append("; ");
        print.append(getAuthor());
        print.append("; ");
        print.append(getYear());
        print.append("; ");
        print.append(getPages());
        print.append("; ");
        print.append(getPublisher());
        print.append("; ");
        print.append(getIsbn());
        return print.toString();
    }
}