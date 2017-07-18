package com.test.reading.domain.repository;

import com.test.reading.domain.entity.Book;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by ryan on 6/29/17.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;

    @Commit
    @Before
    public void setUp() throws Exception {

    }

    @Commit
    @Test
    public void findByName() throws Exception {
        long c = System.currentTimeMillis();
        Book book = new Book("深入理解Java虚拟机", "学习Java原理","Java", new Date(c),new Date(c+100));
        Book book2 = new Book("Head First设计模式", "Learning Design Pattern.","设计模式, Java", new Date(c+120), new Date(c+200));
        Book book3 = new Book("Effective Java", "提高Java技术水平。", "Java", new Date(c+130), new Date(c+230));

        bookRepository.save(Arrays.asList(book, book2, book3));
        List<Book> orderList = bookRepository.findAllByOrderByIdDesc();
        assertTrue(orderList.get(0).getId() > orderList.get(2).getId());

        List<Book> orders = bookRepository.findAll();
        assertFalse(orders.get(0).getId() > orders.get(2).getId());
    }

}