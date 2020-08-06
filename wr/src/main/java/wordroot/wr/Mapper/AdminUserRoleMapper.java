package wordroot.wr.Mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
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
    List<AdminUserRole> findAllUid();

    @Delete("delete from admin_user_role where uid = #{uid}")
    void deleteAllUid(int uid);
}
