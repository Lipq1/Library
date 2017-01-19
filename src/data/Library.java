package data;

import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Library implements Serializable {

	private static final long serialVersionUID = 2995794334600947814L;

	private Map<String, Publication> publications;
	private Map<String, LibraryUser> users;

	public int getPublicationsNumber() {
		return publications.size();
	}

	public Map<String, Publication> getPublications() {
		return publications;
	}

	public Map<String, LibraryUser> getUsers() {
		return users;
	}

	public Library() {
		publications = new HashMap<>();
		users = new HashMap<>();
	}

	public void addBook(Book book) {
		addPublication(book);
	}

	public void addMagazine(Magazine magazine) {
		addPublication(magazine);
	}

	public void addUser(LibraryUser user) {
		users.put(user.getPesel(), user);
	}

	public void removePublication(Publication pub) {
		if (publications.containsValue(pub)) {
			publications.remove(pub.getTitle());
		}
	}

	private void addPublication(Publication pub) {
		publications.put(pub.getTitle(), pub);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (Publication p : publications.values()) {
			builder.append(p);
			builder.append('\n');
		}
		return builder.toString();
	}

	public static class AlphabeticalComparator implements Comparator<Publication> {
		@Override
		public int compare(Publication p1, Publication p2) {
			if (p1 == null && p2 == null) {
				return 0;
			}
			if (p1 == null) {
				return 1;
			}
			if (p2 == null) {
				return -1;
			}
			return p1.getTitle().compareTo(p2.getTitle());
		}
	}

	public static class DateComparator implements Comparator<Publication> {
		@Override
		public int compare(Publication p1, Publication p2) {
			if (p1 == null && p2 == null) {
				return 0;
			}
			if (p1 == null) {
				return 1;
			}
			if (p2 == null) {
				return -1;
			}
			Integer i1 = p1.getYear();
			Integer i2 = p2.getYear();
			return -i1.compareTo(i2);
		}
	}
}