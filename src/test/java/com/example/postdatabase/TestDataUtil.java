package com.example.postdatabase;

import com.example.postdatabase.domain.Author;
import com.example.postdatabase.domain.Book;

public final class TestDataUtil {

    private TestDataUtil() {
    }


    public static Author createTestAuthor() {
        return Author.builder()
                .id(1L)
                .name("Abigail")
                .age(80)
                .build();
    }

    public static Book createTestBook() {
        return Book.builder()
                .isbn("2345-42342-234234-0")
                .title("This is title")
                .authorId(1L)
                .build();
    }
}
