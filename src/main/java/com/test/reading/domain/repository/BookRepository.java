package com.test.reading.domain.repository;

import com.test.reading.domain.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by ryan on 6/29/17.
 */
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByOrderByIdDesc();
    Book findByName(String name);
    Book findByTag(String tag);
    Book findByNameLike(String name);

}
