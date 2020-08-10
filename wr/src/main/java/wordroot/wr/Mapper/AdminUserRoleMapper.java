package wordroot.wr.Mapper;

import org.apache.ibatis.annotations.*;
import wordroot.wr.bean.AdminUserRole;

import java.util.List;

/**
 * @author wuliang
 * @date 2020/8/6
 */

public interface AdminUserRoleMapper {

    @Select("select * from admin_user_role")
    @Results({
            @Result(property = "uid",column = "uid")
    })
    List<AdminUserRole> findAllUid(int uid);

    @Delete("delete from admin_user_role where uid = #{uid}")
    void deleteAllUid(int uid);

    @Insert("insert into admin_user_role (id,uid,rid) values (#{id},#{uid},#{rid})")
    void insert(List list);
}
