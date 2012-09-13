package me.batizhao;

import me.batizhao.dao.UserDao;
import me.batizhao.model.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class UserDaoTest extends BaseDaoTestCase {

    @Autowired
    private UserDao userDao;

    @Test
    public void testSaveUser() throws Exception {

        User user = new User();
        user.setId(1002L);
        user.setName("Jacky");

        userDao.saveUser(user);

        user = userDao.getUser(1002L);

        assertNotNull(user);
        assertTrue(user.getName().equals("Jacky"));

        log.info("User: " + user);

    }

    @Test
    public void testUpdateUser() throws Exception {
        User user = new User();
        user.setId(1000L);
        user.setName("Obmar");

        userDao.updateUser(user);

        user = userDao.getUser(1000L);

        assertNotNull(user);
        assertEquals("Obmar", user.getName());

        log.info("User: " + user);
    }

    @Test
    public void testGetUser() throws Exception {

        User user = userDao.getUser(1000L);

        assertNotNull(user);
        assertTrue(user.getName().equals("Tom"));

        log.info("User: " + user);

    }

    @Test
    public void testGetUsers() throws Exception {
        List list = userDao.getUsers();

        assertNotNull(list);
        assertEquals(2, list.size());
    }
}