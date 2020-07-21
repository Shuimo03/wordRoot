package wordroot.wr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import wordroot.wr.Mapper.UserMapper;
import wordroot.wr.bean.User;

import java.util.Date;

/**
 * auctor:wuliang
 * date:2020/7/20
 */
@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserMapper userMapper;
    @RequestMapping("/")
    public ModelAndView index(){
        User user = new User();
        user.setName("test");
        user.setPassword("test");
        user.setEmail("test@qq.com");
        Date date = new java.sql.Date(new java.util.Date().getTime());
        user.setGmt_create(date);
        user.setGmt_modified(date);
        userMapper.insert(user);
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("count", userMapper.getUserAll().size());
        return modelAndView;
    }
}
