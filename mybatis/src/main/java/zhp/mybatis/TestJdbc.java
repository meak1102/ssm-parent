package zhp.mybatis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by 张华平 on 2017/8/3.
 */
public class TestJdbc {
    public static void main(String[] args) throws Exception {
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql:///mybatis";
            String userName="root";
            String password="mysql";
        Connection connection = DriverManager.getConnection(url, userName, password);
        PreparedStatement preparedStatement = connection.prepareStatement("select * from tb_user where id =?");
        preparedStatement.setLong(1,1l);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            System.out.println(resultSet.getString("name"));
            System.out.println(resultSet.getString("password"));
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();



    }
}
