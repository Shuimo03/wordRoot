package worldroot.wr.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import worldroot.wr.pojo.User;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select id as id,name as name,email,password as password, gmt_create as gmt_create, gmt_modified as gmt_modified from user")
    List<User> insertAllUser();
}
