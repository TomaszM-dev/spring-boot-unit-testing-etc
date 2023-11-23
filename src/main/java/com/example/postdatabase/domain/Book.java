package com.example.postdatabase.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {

    private String isbn;
    private String title;
    private Long authorId;


}
