package testMybatis;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import zhp.entity.Order;
import zhp.mapper.OrderMapper;

import java.io.InputStream;

/**
 * Created by 张华平 on 2017/8/4.
 */
public class OrderMapperTest {
    private OrderMapper orderMapper;
    @Before
    public void setUp() throws Exception {
        String  resource="mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        orderMapper=sqlSession.getMapper(OrderMapper.class);
    }

    @Test
    public void queryOrderandUserByOrderNumber() throws Exception {
        System.out.println(orderMapper);
        Order order = orderMapper.queryOrderandUserByOrderNumber("20140921001");
        System.out.println(order);
    }
    @Test
    public void queryOrderAndUserAndOrderByOrderNumber() throws Exception {
        Order order = orderMapper.queryOrderAndUserAndOrderByOrderNumber("20140921001");
        System.out.println(order);
    }
    @Test
    public void queryOrderAndUserAndOrderdetailAndItem() throws Exception {
        Order order = orderMapper.queryOrderAndUserAndOrderdetailAndItem("20140921001");
        System.out.println(order);
    }
}