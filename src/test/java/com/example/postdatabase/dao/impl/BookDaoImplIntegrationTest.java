package com.example.postdatabase.dao.impl;

import com.example.postdatabase.TestDataUtil;
import com.example.postdatabase.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.Optional;


@SpringBootTest
@ExtendWith(SpringExtension.class)
public class BookDaoImplIntegrationTest {


    private BookDaoImpl underTest;

    @Autowired
    public BookDaoImplIntegrationTest(BookDaoImpl underTest) {
        this.underTest = underTest;
    }

    @Test
    public void TestThatBookCanBeCreatedAndRecalled(){
        Book book = TestDataUtil.createTestBook();
        underTest.create(book);


        Optional<Book> result = underTest.find(book.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(book);






    }


}
