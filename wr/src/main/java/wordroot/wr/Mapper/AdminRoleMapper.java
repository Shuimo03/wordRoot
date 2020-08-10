package wordroot.wr.Mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import wordroot.wr.bean.AdminRole;

import java.util.List;


/**
 * @author wuliang
 * @date 2020/8/6
 */

public interface AdminRoleMapper {
    @Select("select * from admin_role where id = #{id}")
    AdminRole findById(int id);

    @Select("select * from admin_role")
    @Results({
            @Result(property = "",column = "")
    })
    List<AdminRole> findAll();

    @Select("select * from admin_role")
    @Results({
            @Result(property = "",column = "")
    })
    List<AdminRole> findAllById(List<Integer> rids);

    @Insert("insert into admin_role(id,name,name_zh,enabled) values(#{id},#{name},#{name_zh},#{enabled})")
    void insert(AdminRole adminRole);
}
