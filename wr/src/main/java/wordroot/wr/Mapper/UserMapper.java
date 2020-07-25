package wordroot.wr.Mapper;

import org.apache.ibatis.annotations.*;
import wordroot.wr.bean.User;

import java.util.List;

/**
 * auctor:wuliang
 * date:2020/7/20
 */
public interface UserMapper {
    /**
     * 根据id查找用户
     */
    @Select("select * from user where id = #{id}")
    User getId(int id);

    /**
     * 根据用户名查找用户
     */

    @Select()

    /**
     * 查询所有用户
     */
    @Select("select * from user")
    @Results({
            @Result(property = "name", column = "name")
    })
    List<User> getUserAll();

    /**
     * 插入一个新用户
     */
    @Insert("insert into user(name,email,password,gmt_create,gmt_modified) values(#{name},#{email},#{password},#{gmt_create},#{gmt_modified})")
    void insert(User user);

    /**
     * 更新用户
     * @return
     */

    @Update("update user set name = #{name},email = #{email},password = #{password}, gmt_create = #{gmt_create}, gmt_modified = #{gmt_modified} where id = #{id}")
    User update(User user);

    /**
     * 删除用户
     */
    @Delete("delete from user where id = #{id}")
    void delete(int id);
}
