package wordroot.wr.service;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import wordroot.wr.Mapper.UserMapper;
import wordroot.wr.bean.User;

import java.util.Date;
import java.util.List;

/**
 * @auctor wuliang
 * @date 2020/7/21
 */

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public List<>

    public boolean isExist(int id){
        User user = userMapper.getId(id);
        return  null != user;
    }

    public User findUserId(int id){
        return userMapper.getId(id);
    }

    public User findUserName(String name){
        return  userMapper.getUserName(name);
    }


    public int register(User user){
        String userName = user.getName();
        String userEmail = user.getEmail();
        String userPassword = user.getPassword();
        Date date = new java.sql.Date(new java.util.Date().getTime());

        user.setGmt_create(date);
        user.setGmt_modified(date);
        /**
         * 这里做处理，防止XSS攻击
         */

        userName = HtmlUtils.htmlEscape(userName);
        user.setName(userName);

        userEmail = HtmlUtils.htmlEscape(userEmail);
        user.setName(userEmail);

        if(userName.equals("") || userPassword.equals("")){
            return 0;
        }

        /**
         * 这里简单做下处理，默认生成16位盐
         */
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        int times = 2;
        String encodeedPasssword = new SimpleHash("md5",userPassword,salt,times).toString();
        user.setSalt(salt);
        user.setSalt(encodeedPasssword);


        userMapper.insert(user);

        return 1;
    }

    /**
     *  更新用户状态
     *
     */

    public void updateUserStatus(User user){
        User userID = userMapper.update(user);
        userID.setEnabled(userID.isEnabled());
        userMapper.insert(userID);
    }

    /**
     * 编辑用户信息
     */
    public void editUser(User user){
        User userID = userMapper.getId(user.getId());
        userID.setName(user.getName());
        userID.setPassword(user.getPassword());
        userID.setEmail(user.getEmail());
        userID.setGmt_modified(user.getGmt_modified());
        userMapper.insert(user);
    }

    /**
     * 根据ID删除用户
     */

    public void deteleById(int id){
        userMapper.delete(id);
    }
}
