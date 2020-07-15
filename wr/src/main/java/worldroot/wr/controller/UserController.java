package worldroot.wr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;
import worldroot.wr.pojo.User;
import worldroot.wr.result.Result;
import worldroot.wr.service.UserService;

import java.util.Objects;

@Controller
public class UserController {


    @Autowired
    UserService userService;

    @CrossOrigin
    @PostMapping(value = "api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser) {
        //对html标签进行转义,防止xss攻击
        String useremail = requestUser.getEmail();
        useremail = HtmlUtils.htmlEscape(useremail);
        User user = (User) userService.insertAllUser();
        if(null == user){
            return new Result(400);
        }
        else{
            return new Result(200);
        }
    }
}
