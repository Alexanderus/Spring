package ru.otus.spring.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.otus.spring.domain.Book;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@JdbcTest
@Import(BookDaoJdbc.class)
class BookDaoJdbcTest {
    private static final int STARTING_BOOK_COUNT = 10;
    private static final Book FIRST_BOOK_IN_DB = new Book(1, "Joshua Bloch", "Effective Java", "programming");

    @Autowired
    private BookDao bookDao;

    @Test
    void insert() {
        Book bookFromDb = bookDao.getById(FIRST_BOOK_IN_DB.getId());
        assertThat(bookFromDb.getId()).isEqualTo(FIRST_BOOK_IN_DB.getId());
        assertThat(bookFromDb.getAuthor()).isEqualTo(FIRST_BOOK_IN_DB.getAuthor());
        assertThat(bookFromDb.getTitle()).isEqualTo(FIRST_BOOK_IN_DB.getTitle());
        assertThat(bookFromDb.getGenre()).isEqualTo(FIRST_BOOK_IN_DB.getGenre());
    }

    @Test
    void update() {
        Book book = new Book(1, "test author", "test title", "test genre");
        String testTitle = "another title";
        book.setTitle(testTitle);
        bookDao.update(book);
        Book changedBook = bookDao.getById(1);
        assertThat(changedBook.getTitle()).isEqualTo(testTitle);
    }

    @Test
    void delete() {
        bookDao.delete(1);
        List<Book> books = bookDao.getAll();
        assertThat(books.size()).isEqualTo(STARTING_BOOK_COUNT - 1);
    }

    @Test
    void getById() {
        Book book = new Book(0, "TestAuthor", "TestTitle", "TestGenre");
        long id = bookDao.insert(book);
        Book bookFromDb = bookDao.getById(id);
        assertThat(bookFromDb.getTitle()).isEqualTo(book.getTitle());
        assertThat(bookFromDb.getAuthor()).isEqualTo(book.getAuthor());
        assertThat(bookFromDb.getGenre()).isEqualTo(book.getGenre());
    }

    @Test
    void getAll() {
        List<Book> books = bookDao.getAll();
        assertThat(books.size()).isEqualTo(STARTING_BOOK_COUNT);
    }
}