package com.example.postdatabase.dao.impl;

import com.example.postdatabase.TestDataUtil;
import com.example.postdatabase.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class BookDaoImplTest {
    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private BookDaoImpl underTest;

    @Test
    public void testBook() {
        Book book = TestDataUtil.createTestBook();


        underTest.create(book);

        verify(jdbcTemplate).update(
                eq("INSERT INTO books (isbn,title,author_id) VALUES (?,?,?)"),
                eq("2345-42342-234234-0"),
                eq("This is title"),
                eq(1L)
         );
    }

    @Test
    public void testThatFindOneBookGeneratesCorrectSql() {
        underTest.find("2345-42342-234234-0");
        verify(jdbcTemplate).query(
                eq("SELECT isbn, title, " +
                        "author_id from books WHERE isbn = ? LIMIT 1"),
                ArgumentMatchers.<BookDaoImpl.BookRowMapper>any(),
                eq("2345-42342-234234-0")
        );
    }

}
