package com.test.reading.domain.repository;

import com.test.reading.domain.entity.user.UserInfo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * doc: https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-testing.html
 *
 * 因为classpath检测到h2的数据库，@DataJpaTest将默认采用嵌入的H2作为测试数据库。
 * 当想要测试真实数据库，则只要启用@AutoConfigureTestDatabase
 * @Transactional 将会对每次测试开启事物，默认单个测试用例结束后回滚，可以用@Commit或者@Rollback显示覆盖
 * Created by ryan on 6/29/17.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
//打开以下注解则启用真实数据库测试，否则启用h2
//@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Commit
    @Before
    public void setUp() throws Exception {
        UserInfo userInfo = new UserInfo("test", "123456", "test@qq.com", "Test", new Date());
        UserInfo userInfo2 = new UserInfo("test2", "123456", "test2@qq.com", "Test2", new Date());
        userRepository.save(Arrays.asList(userInfo, userInfo2));
    }

    @Commit
    @Test
    public void testSave(){
        UserInfo userInfo = new UserInfo("test1", "123456", "test1@qq.com", "Test1", new Date());

        UserInfo save = userRepository.save(userInfo);

        assertEquals(userInfo, save);
        assertNotNull(userInfo.getId());

    }

    @Test
    public void findByUserName() throws Exception {


        List<UserInfo> userInfoList = userRepository.findAll();
        assertEquals(2, userInfoList.size());

        UserInfo findUserInfo = userRepository.findByUsername("test");
        assertEquals("Test", findUserInfo.getNickname());

    }

    @Test
    public void findByUserNameOrEmail() throws Exception {
        UserInfo test = userRepository.findByUsernameOrEmail("test", null);

        assertEquals("test", test.getUsername());
        assertEquals("Test", test.getNickname());

        UserInfo test2 = userRepository.findByUsernameOrEmail("", "test2@qq.com");

        assertEquals("test2", test2.getUsername());
        assertEquals("Test2", test2.getNickname());


    }

}