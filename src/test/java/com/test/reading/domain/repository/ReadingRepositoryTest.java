package com.test.reading.domain.repository;

import com.test.reading.domain.entity.Reading;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by ryan on 7/1/17.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class ReadingRepositoryTest {

    @Autowired
    private ReadingRepository repository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private UserRepository userRepository;

    @Commit
    @Before
    public void setUp() throws Exception {

        repository.save(new Reading(bookRepository.findOne(1L), userRepository.getOne(1L), 11, "读书第一天", 11, new Date()));
        repository.save(new Reading(bookRepository.findOne(1L), userRepository.getOne(1L), 22, "读书第2天", 11, new Date()));
        repository.save(new Reading(bookRepository.findOne(3L), userRepository.getOne(1L), 25, "读书第3天", 3, new Date()));


    }

    @Commit
    @Test
    public void findAllByBook_NameLikeOrderByTime() throws Exception {

        List<Reading> all = repository.findAll();
        System.out.println(all);

        List<Reading> java = repository.findAllByBook_NameLikeAndUserInfoIdOrderByTimeDesc("%Java%", 2L);
        System.out.println(java);
    }

}