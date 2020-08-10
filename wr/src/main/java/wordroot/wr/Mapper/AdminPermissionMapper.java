package wordroot.wr.Mapper;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import wordroot.wr.bean.AdminPermission;
import wordroot.wr.bean.AdminRoleMenu;

import java.util.List;

/**
 * @author wuliang
 * @date 2020/8/6
 */

public interface AdminPermissionMapper {

    @Select("select * from user where id = #{id}")
    AdminPermission findById(List<Integer> id);

    @Select("select * from admin_permission")
    @Results({
            @Result(property = "",column = "")
    })
    List<AdminPermission> findAll();
}
