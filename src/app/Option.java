package app;

import java.util.NoSuchElementException;

public enum Option {
	EXIT(0, "Wyjscie z programu"), ADD_BOOK(1, "Dodanie ksiazki"), ADD_MAGAZINE(2, "Dodanie magazynu"), PRINT_BOOKS(3,
			"Wyswietlenie dostepnych ksiazek"), PRINT_MAGAZINES(4, "Wyswietlenie dostepnych magazynow"), ADD_USER(5, "Dodaj uzytkownika"), PRINT_USERS(6, "Wyswietl uzytkownikow");

	private int value;
	private String description;

	public int getValue() {
		return value;
	}

	public String getDescription() {
		return description;
	}

	Option(int value, String desc) {
		this.value = value;
		this.description = desc;
	}

	@Override
	public String toString() {
		return value + " - " + description;
	}

	public static Option createFromInt(int option) throws NoSuchElementException {
		Option result = null;
		try {
			result = Option.values()[option];
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new NoSuchElementException("Brak elementu o wskazanym ID");
		}
		return result;
	}
}
