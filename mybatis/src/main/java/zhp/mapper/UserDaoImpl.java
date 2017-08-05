package zhp.mapper;

import org.apache.ibatis.session.SqlSession;
import zhp.entity.User;

import java.util.List;

/**
 * Created by 张华平 on 2017/8/3.
 */
public class UserDaoImpl implements UserDao {
    private SqlSession sqlSession;

    public UserDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public User queryUserById(Long id) {
        return sqlSession.selectOne("UserMapper.queryUserById", id);
    }

    @Override
    public List<User> queryUserAll() {
        return sqlSession.selectList("UserMapper.queryUserAll");
    }

    @Override
    public void insertUser(User user) {
        sqlSession.insert("UserMapper.insertUser", user);
        sqlSession.commit();
    }

    @Override
    public void updateUser(User user) {
        sqlSession.update("UserMapper.updateUser", user);
        sqlSession.commit();
    }

    @Override
    public void deleteUserById(Long id) {
        sqlSession.update("UserMapper.deleteUserById", id);
        sqlSession.commit();
    }
}
