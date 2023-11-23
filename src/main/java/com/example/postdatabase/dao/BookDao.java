package com.example.postdatabase.dao;

import com.example.postdatabase.domain.Book;

import java.util.Optional;

public interface BookDao {
    void create(Book book);

    Optional<Book> find(String isbn);
}
