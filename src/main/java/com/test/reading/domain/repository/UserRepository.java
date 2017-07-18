package com.test.reading.domain.repository;

import com.test.reading.domain.entity.user.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ryan on 6/29/17.
 */
public interface UserRepository extends JpaRepository<UserInfo, Long> {
    UserInfo findByUsername(String username);
    UserInfo findByUsernameOrEmail(String username, String email);
}
