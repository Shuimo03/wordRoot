package wordroot.wr.Mapper;

import org.apache.ibatis.annotations.*;
import wordroot.wr.bean.AdminRolePermission;

import java.util.List;

/**
 * @author wuliang
 * @date 2020/8/6
 */

public interface AdminRolePermissionMapper {

    @Select("select * from admin_role_permission where rid = #{rid}")
    AdminRolePermission findByid(int id);
    @Select("select * from admin_role_permission")
    @Results({
            @Result(property = "rid",column = "rid")
    })
    List<AdminRolePermission>findAllRid(int rid);

    @Delete("select * from where  admin_role_permission rid = #{rid}")
    void deleteByRid(int rid);

    @Insert("insert into admin_role_permission (id,rid,pid) values(#{id},{#rid},#{pid})")
    void insert(List list);
}
