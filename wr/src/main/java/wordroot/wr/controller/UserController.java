package wordroot.wr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import wordroot.wr.Mapper.UserMapper;
import wordroot.wr.bean.User;
import wordroot.wr.result.Result;
import wordroot.wr.result.ResultFactory;
import wordroot.wr.service.UserService;

import java.util.Date;

/**
 * @author wuliang
 * @date 2020/7/28
 */
@RestController
public  class UserController{

    @Autowired
    UserService userService;

    @GetMapping("/api/admin/user")
    public Result listUsers(){
        return ResultFactory.buildSuccessResult(userService)
    }

}
