package wordroot.wr.Mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import wordroot.wr.bean.AdminRoleMenu;

import java.util.List;

/**
 * @author wuliang
 * @date 2020/8/6
 */

public interface AdminRoleMenuMapper {
    /**
     * 通过rid查找
     */
    @Select("select * from admin_role_menu where rid = #{rid}")
    AdminRoleMenu rid(int rid);

    /**
     * 通过rid删除
     */
    @Delete("delete from admin_role_menu where rid = #{rid}")
    void delete(int rid);


    @Select("select * from admin_role_menu")
    @Results({
            @Result(property = "rid", column = "rid")
    })
    List<AdminRoleMenu> geRidrAll();
}
