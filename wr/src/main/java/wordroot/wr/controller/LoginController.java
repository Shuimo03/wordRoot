package wordroot.wr.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;
import wordroot.wr.bean.User;
import wordroot.wr.result.Result;
import wordroot.wr.result.ResultFactory;
import wordroot.wr.service.UserService;

/**
 * @author wuliang
 * @date 2020/7/21
 * 登录注册两个功能写在一块了
 */

@RestController
public class LoginController {

    @Autowired
    UserService userService;

    /**
     * 登录功能
     */
    @PostMapping("/api/login")
    public Result login(@RequestBody User loginUser) {
        String userName = loginUser.getName();
        userName = HtmlUtils.htmlEscape(userName);

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userName, loginUser.getPassword());
        usernamePasswordToken.setRememberMe(true);
        try {
            subject.login(usernamePasswordToken);
            User user = userService.findUserName(userName);
            if (!user.isEnabled()) {
                return ResultFactory.buildFailResult("账号被禁用");
            }
            return ResultFactory.buildFailResult(userName);
        }
        catch (IncorrectCredentialsException e){
            return ResultFactory.buildFailResult("密码错误");
        }
        catch (UnknownAccountException e){
            return ResultFactory.buildFailResult("账号不存在");
        }
    }

    /**
     * 注册
     */

    @GetMapping("/api/signup")
    public Result signup(@RequestBody User user){
        int status = userService.register(user);

        switch (status){
            case 0:
                return ResultFactory.buildFailResult("用户名和密码不能为空!");
            case 1:
                return ResultFactory.buildFailResult("注册成功!");
            case 2:
                return ResultFactory.buildFailResult("用户已存在");
        }
        return ResultFactory.buildFailResult("未知错误");
    }

    /**
     * 登出
     */

    @GetMapping("/api/logout")
    public Result logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return ResultFactory.buildSuccessResult("成功登出");
    }

    @GetMapping("")
}
