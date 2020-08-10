package wordroot.wr.Mapper;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import wordroot.wr.bean.AdminMenu;

import java.util.List;

/**
 * @author wuliang
 * @date 2020/8/6
 */

public interface AdminMenuMapper {

    List<AdminMenu> getUserAll(int id);

    @Select("select * from user where id = #{id}")
    AdminMenu findById(int id);


    /**
     * 查询所有用户
     * @param parentId
     */
    @Select("select * from admin_menu")
    @Results({
            @Result(property = "parent_id",column = "parent_id")
    })
    List<AdminMenu> findAllByRid(List<Integer> parentId);

}
