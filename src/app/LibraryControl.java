package app;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

import utils.DataReader;
import utils.FileManager;
import utils.LibraryUtils;
import data.Book;
import data.Library;
import data.LibraryUser;
import data.Magazine;

public class LibraryControl {
	// zmienna do komunikacji z u�ytkownikiem
	private DataReader dataReader;
	private FileManager fileManager;

	// "biblioteka" przechowuj�ca dane
	private Library library;

	public LibraryControl() {
		dataReader = new DataReader();
		fileManager = new FileManager();
		try {
			library = fileManager.readLibraryFromFile();
			System.out.println("Wczytano dane biblioteki z pliku ");
		} catch (ClassNotFoundException | IOException e) {
			library = new Library();
			System.out.println("Utworzono now� baz� biblioteki.");
		}
	}

	/*
	 * G��wna p�tla programu, kt�ra pozwala na wyb�r opcji i interakcj�
	 */
	public void controlLoop() {
		Option option = null;
		while (option != Option.EXIT) {
			try {
				printOptions();
				option = Option.createFromInt(dataReader.getInt());
				switch (option) {
				case ADD_BOOK:
					addBook();
					break;
				case ADD_MAGAZINE:
					addMagazine();
					break;
				case PRINT_BOOKS:
					printBooks();
					break;
				case PRINT_MAGAZINES:
					printMagazines();
					break;
				case ADD_USER:
					addUser();
					break;
				case PRINT_USERS:
					printUsers();
					break;
				case EXIT:
					exit();
				}
			} catch (InputMismatchException e) {
				System.out.println("Wprowadzono niepoprawne dane, publikacji nie dodano");
			} catch (NumberFormatException | NoSuchElementException e) {
				System.out.println("Wybrana opcja nie istnieje, wybierz ponownie:");
			}
		}
		// zamykamy strumie� wej�cia
		dataReader.close();
	}

	private void printOptions() {
		System.out.println("Wybierz opcj�: ");
		for (Option o : Option.values()) {
			System.out.println(o);
		}
	}

	private void addBook() {
		Book book = dataReader.readAndCreateBook();
		library.addBook(book);
	}

	private void printBooks() {
		LibraryUtils.printBooks(library);
	}

	private void addMagazine() {
		Magazine magazine = dataReader.readAndCreateMagazine();
		library.addMagazine(magazine);
	}

	private void printMagazines() {
		LibraryUtils.printMagazines(library);
	}

	private void addUser() {
		LibraryUser user = dataReader.readAndCreateLibraryUser();
		library.addUser(user);
	}

	private void printUsers() {
		LibraryUtils.printUsers(library);
	}

	private void exit() {
        fileManager.writeLibraryToFile(library);
    }
}