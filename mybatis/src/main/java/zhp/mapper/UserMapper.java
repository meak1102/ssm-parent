package zhp.mapper;

import org.apache.ibatis.annotations.Param;
import zhp.entity.User;

import java.util.List;

/**
 * Created by 张华平 on 2017/8/3.
 */
public interface UserMapper {
    /**
     * 按照多个id查询用户信息
     * @param ids
     * @return
     */
    public List<User> queryByids(@Param("ids") List<Long> ids);

    /**
     * 查询所有用户，如果输入了用户名按照用户名进行模糊查询，如果输入年龄，按照年龄进行查询，如果两者都输入，两个条件都要成立。
     * @param userName
     * @param age
     * @return
     */
    public List<User> queryAllUserlikeUserNameOrAge(@Param("userName") String userName, @Param("age") Integer age);
    /**
     * 查询男性用户，如果输入了用户名则按照用户名模糊查找，否则如果输入了年龄则按照年龄查找，否则查找用户名为“zhangsan”的用户。
     * @param userName
     * @param age
     * @return
     */
    public List<User> queryUserByuserNameOrAge(@Param("userName") String userName, @Param("age") Integer age);

    /**
     * 查询男性用户，如果输入了用户名，按用户名模糊查询
     * @param userName
     * @return
     */
    public List<User> queryUserBySexLikeUserName(@Param("userName") String userName);
    /**
     * 登录
     * @param userName
     * @param password
     * @return
     */
    public User login(@Param("userName") String userName, @Param("password") String password);
    /**
     * 根据用户名模糊查询
     * @param userName
     * @return
     */
    public  List<User>  queryUserLikeUserName(@Param("userName") String userName);
    /**
     * 根据表名以及用户id查询用户信息
     * @param tableName
     */
    public User queryUserByTableName(@Param("tableName") String tableName, @Param("id") long id);
    /**
     * 根据id获取用户信息
     * @param id
     * @return
     */
    public User queryUserById(Long id);

    /**
     * 查询所有用户
     * @return
     */
    public List<User> queryUserAll();

    /**
     * 新增用户
     * @param user
     */
    public void insertUser(User user);

    /**
     * 更新用户信息
     * @param user
     */
    public void updateUser(User user);

    /**
     * 使用set标签进行修改：修改用户信息，如果参数user中的某个属性为null，则不修改。
     * @param user
     */
    public void updateUserBysetTag(User user);

    /**
     * 根据id删除用户信息
     * @param id
     */
    public void deleteUserById(Long id);
}
