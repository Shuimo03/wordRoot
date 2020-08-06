package wordroot.wr.Mapper;

import org.apache.ibatis.annotations.*;
import wordroot.wr.bean.User;

import java.util.List;

/**
 * @auctor:wuliang
 * @date:2020/7/20
 * @updateDate 2020/8/6
 * 之前是作为一个测试mybatis有没有搭配好，所以在设计上出现了问题。
 * 用户功能：修改信息/收藏单词词根/删除单词词根
 */
public interface UserMapper {
    /*收藏单词*/
    @Insert("insert into user (word,cn_interpretation,en_interpretation) values(#{word},#{cn_interpretation},#{en_interpretation})")
    void insertWord(User user);
    /*更新单词*/
    @Update("update user set word = #{word},cn_interpretation = #{cn_interpretation},en_interpretation = {en_interpretation} where username = #{username}")
    User updateWord(User user);
    /*收藏词根*/
    @Insert("insert into user(root) values (#{root})")
    void insertRoot(User user);

    /*更新词根*/
    @Update("update user set root = #{root}")
    User update(User user);
    /*删除词根*/
    @Delete("delete from user where root = #{root}")
    void delete(String username);

    /*修改密码邮箱用户名*/
    @Update("update user set username = #{username},email = #{email},password = #{password}, gmt_create = #{gmt_create}, gmt_modified = #{gmt_modified} where id = #{id}")
    User updateUser(User user);
}
