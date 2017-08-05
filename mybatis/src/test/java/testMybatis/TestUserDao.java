package testMybatis;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import zhp.entity.User;
import zhp.mapper.UserDao;
import zhp.mapper.UserDaoImpl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

/**
 * Created by 张华平 on 2017/8/3.
 */
public class TestUserDao {
    private UserDao userDao;

    @Before
    public void init() throws IOException {
        String  resource="mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        this.userDao=new UserDaoImpl(sqlSession);
    }
    @Test
    public void testQueryUserById(){
        System.out.println(userDao.queryUserById(1l));

    }
    @Test
    public void testQueryUserAll(){
        System.out.println(userDao.queryUserAll());
    }
    @Test
    public void testInsertUser(){
        User user=new User();
        user.setAge(22);
        user.setBirthday(new Date());
        user.setName("剑神");
        user.setUserName("西门吹雪");
        user.setPassword("123");
        user.setSex(1);
        userDao.insertUser(user);
    }
    @Test
    public void testUpdateUserl(){
       User user=userDao.queryUserById(2l);
        user.setPassword("654321");
        userDao.updateUser(user);
    }
    @Test
    public void testDeleteUserById(){
      userDao.deleteUserById(10l);
    }
}
