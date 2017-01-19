package data;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Publication implements Serializable, Comparable<Publication> {

	private static final long serialVersionUID = 7910452641164094454L;
	private LocalDate date;
	private String title;
	private String publisher;

	// Constructor
	protected Publication(String title, String publisher, int year) {
		setTitle(title);
		setPublisher(publisher);
		setDate(LocalDate.of(year, 1, 1));
	}

	// Setters and getters
	public String getTitle() {
		return title;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublisher() {
		return publisher;
	}

	public int getYear() {
		return date.getYear();
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((publisher == null) ? 0 : publisher.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Publication other = (Publication) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (publisher == null) {
			if (other.publisher != null)
				return false;
		} else if (!publisher.equals(other.publisher))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Publication [year=" + date.getYear() + ", title=" + title + ", publisher=" + publisher + "]";
	}

	@Override
	public int compareTo(Publication p) {
		return title.compareTo(p.getTitle());
	}

}
