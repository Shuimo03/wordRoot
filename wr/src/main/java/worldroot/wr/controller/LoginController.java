package worldroot.wr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;
import worldroot.wr.pojo.User;
import worldroot.wr.result.Result;

import java.util.Objects;

@Controller
public class LoginController {


    @CrossOrigin
    @PostMapping(value = "api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser) {
        //对html标签进行转义,防止xss攻击
        String useremail = requestUser.getEmail();
        useremail = HtmlUtils.htmlEscape(useremail);

        if(!Objects.equals("test@qq.com",useremail) || ! Objects.equals("test",requestUser.getPassword())){
            String messages = "账号密码错误";
            System.out.println("test");
            return  new Result(400);
        }
        else{
            return  new Result(200);
        }
    }
}
