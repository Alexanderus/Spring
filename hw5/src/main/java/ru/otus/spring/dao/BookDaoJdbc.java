package ru.otus.spring.dao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.otus.spring.domain.Book;
import ru.otus.spring.mappers.BookMapper;

import java.util.*;

@Repository
public class BookDaoJdbc implements BookDao {
    private final NamedParameterJdbcOperations namedParameterJdbcOperations;

    public BookDaoJdbc(NamedParameterJdbcOperations namedParameterJdbcOperations) {
        this.namedParameterJdbcOperations = namedParameterJdbcOperations;
    }

    @Override
    public long insert(Book book) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        KeyHolder keyHolder = new GeneratedKeyHolder();
        params.addValue("author", book.getAuthor());
        params.addValue("title", book.getTitle());
        params.addValue("genre", book.getGenre());
        namedParameterJdbcOperations.update("INSERT INTO BOOKS(AUTHOR, TITLE, GENRE) VALUES(:author, :title, :genre)", params, keyHolder);
        return Objects.requireNonNull(keyHolder.getKey()).intValue();
    }

    @Override
    public void update(Book book) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", book.getId());
        params.put("author", book.getAuthor());
        params.put("title", book.getTitle());
        params.put("genre", book.getGenre());
        int status = namedParameterJdbcOperations.update(
                "UPDATE books SET author= :author, title= :title, genre= :genre WHERE id=:id", params
        );
        if (status != 0) {
            System.out.println("Book data updated to " + book.toString());
        } else {
            System.out.println("Cant find book with id = " + book.getId());
        }
    }

    @Override
    public void delete(long id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        namedParameterJdbcOperations.update(
                "DELETE FROM books WHERE id = :id", params
        );
    }

    @Override
    public Book getById(long id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        return namedParameterJdbcOperations.queryForObject(
                "SELECT * FROM books WHERE id = :id", params, new BookMapper()
        );
    }

    @Override
    public List<Book> getAll() {
        return namedParameterJdbcOperations.query("SELECT * FROM books", new BookMapper());
    }
}
