package wordroot.wr.Mapper;

import org.apache.ibatis.annotations.Select;
import wordroot.wr.bean.AdminRole;


/**
 * @author wuliang
 * @date 2020/8/6
 */

public interface AdminRoleMapper {
    @Select("select * from user where id = #{id}")
    AdminRole findById(int id);
}
