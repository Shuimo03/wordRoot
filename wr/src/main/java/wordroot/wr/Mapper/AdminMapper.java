package wordroot.wr.Mapper;

import org.apache.ibatis.annotations.*;
import wordroot.wr.bean.User;

import java.util.List;

public interface AdminMapper {

    /**
     * 根据id查找用户
     */
    @Select("select * from user where id = #{id}")
    User getId(int id);

    /**
     * 根据用户名查找用户
     */

    @Select("select * from user where username = #{username}")
    User getUserName(String user);

    /**
     * 查询所有用户
     */
    @Select("select * from user")
    @Results({
            @Result(property = "username", column = "username")
    })
    List<User> getUserAll();

    /**
     * 插入一个新用户
     */
    @Insert("insert into user(username,email,password,gmt_create,gmt_modified,salt) values(#{username},#{email},#{password},#{gmt_create},#{gmt_modified}, #{salt})")
    void insert(User user);

    /**
     * 更新用户
     * @return
     */

    @Update("update user set username = #{username},email = #{email},password = #{password}, gmt_create = #{gmt_create}, gmt_modified = #{gmt_modified} where id = #{id}")
    User update(User user);

    /**
     * 删除用户
     */
    @Delete("delete from user where id = #{id}")
    void delete(int id);
}
