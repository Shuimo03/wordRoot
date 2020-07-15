package worldroot.wr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import worldroot.wr.mapper.UserMapper;
import worldroot.wr.pojo.User;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
    public List<User> insertAllUser(){
        return userMapper.insertAllUser();
    }
}
