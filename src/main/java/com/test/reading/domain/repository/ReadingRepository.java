package com.test.reading.domain.repository;

import com.test.reading.domain.entity.Book;
import com.test.reading.domain.entity.Reading;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by ryan on 6/30/17.
 */
public interface ReadingRepository extends JpaRepository<Reading, Long>{

    List<Reading> findAllByBook_NameLikeAndUserInfoIdOrderByTimeDesc(String name, Long userId);
}
