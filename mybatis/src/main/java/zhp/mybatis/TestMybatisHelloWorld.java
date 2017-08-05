package zhp.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import zhp.entity.User;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by 张华平 on 2017/8/3.
 */
public class TestMybatisHelloWorld {
    public static void main(String[] args) throws IOException {
        //加载全局配置文件
        String resource="mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //获取sqlsessionFactory工厂
        SqlSessionFactory sqlSessionFactory= new  SqlSessionFactoryBuilder().build(inputStream);
        //打开sqlSession会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 执行查询操作，获取结果集。参数：1-命名空间（namespace）+“.”+statementId,2-sql的占位符参数
        User user = sqlSession.selectOne("UserMapper.queryUserById", 1l);
        System.out.println(user);
        sqlSession.close();
    }
}
