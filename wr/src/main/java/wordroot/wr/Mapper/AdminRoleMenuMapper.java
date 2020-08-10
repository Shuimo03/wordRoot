package wordroot.wr.Mapper;

import org.apache.ibatis.annotations.*;
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
    AdminRoleMenu FindbyRid(int rid);

    /**
     * 通过rid删除
     */
    @Delete("delete from admin_role_menu where rid = #{rid}")
    void delete(int rid);


    @Select("select * from admin_role_menu")
    @Results({
            @Result(property = "rid", column = "rid")
    })
    List<AdminRoleMenu> geRidrAll(List<Integer> rids);

    @Insert("insert into admin_role_menu(id,rid,mid) values(#{id},#{rid},#{mid})")
    void insert(AdminRoleMenu adminRoleMenu);

    @Insert("insert into admin_role_menu(id,rid,mid) values(#{id},#{rid},#{mid})")
    void insertAll(List arrayList);
}
