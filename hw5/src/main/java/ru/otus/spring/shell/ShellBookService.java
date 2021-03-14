package ru.otus.spring.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.spring.dao.BookDaoJdbc;
import ru.otus.spring.domain.Book;

@ShellComponent
public class ShellBookService {
    private final BookDaoJdbc bookDaoJdbc;

    public ShellBookService(BookDaoJdbc bookDaoJdbc) {
        this.bookDaoJdbc = bookDaoJdbc;
    }

    @ShellMethod(key = "insert", value = "Please, to insert new book enter 'author title genre'.")
    public void insert(String author, String title, String genre) {
        bookDaoJdbc.insert(new Book(0, author, title, genre));
    }

    @ShellMethod(key = "update", value = "To update book data, please enter id author title genre")
    public void update(long id, String author, String title, String genre) {
        bookDaoJdbc.update(new Book(id, author, title, genre));
    }

    @ShellMethod(key = "findById", value = "Find book in database by id.")
    public void findById(long id) {
        System.out.println(bookDaoJdbc.getById(id));
    }

    @ShellMethod(key = "deleteBook", value = "Please, enter id to delete books from database.")
    public void deleteBook(long id) {
        bookDaoJdbc.delete(id);
    }

    @ShellMethod(key = "showBooks", value = "Print all books in database.")
    public void showBooks() {
        bookDaoJdbc.getAll().forEach(System.out::println);
    }
}
