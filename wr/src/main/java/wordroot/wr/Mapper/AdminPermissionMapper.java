package wordroot.wr.Mapper;

import org.apache.ibatis.annotations.Select;
import wordroot.wr.bean.User;

/**
 * @author wuliang
 * @date 2020/8/6
 */

public interface AdminPermissionMapper {

    @Select("select * from user where id = #{id}")
    User findById(int id);

}
