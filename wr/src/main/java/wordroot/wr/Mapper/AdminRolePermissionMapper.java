package wordroot.wr.Mapper;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
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
    List<AdminRolePermission>geRidrAll();
}
