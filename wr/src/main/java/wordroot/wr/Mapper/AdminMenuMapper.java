package wordroot.wr.Mapper;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import wordroot.wr.bean.User;

import java.util.List;

/**
 * @author wuliang
 * @date 2020/8/6
 */

public interface AdminMenuMapper {
    /**
     * 查询所有用户
     */
    @Select("select * from user")
    @Results({
            @Result(property = "username", column = "username")
    })
    List<User> getUserAll();

    @Select("select * from user where id = #{id}")
    User findById(int id);
}
