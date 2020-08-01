package wordroot.wr.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

@Api(tags = "用户登录注册")

@RestController
@CrossOrigin//解决跨域
public class LoginController {

    @Autowired
    UserService userService;

    /**
     * 登录功能
     */
    @ApiOperation("用户登录")
    @PostMapping(value = "/api/login")
    public Result login(@RequestBody User loginUser) {
        String userEmail = loginUser.getEmail();
        userEmail = HtmlUtils.htmlEscape(userEmail);

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userEmail, loginUser.getPassword());
        usernamePasswordToken.setRememberMe(true);
        try {
            subject.login(usernamePasswordToken);
            User user = userService.findUserName(userEmail);
            if (!user.isEnabled()) {
                return ResultFactory.buildFailResult("账号被禁用");
            }
            return ResultFactory.buildFailResult(userEmail);
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
    @ApiOperation(value = "用户注册")
    @PostMapping(value = "/api/signup")

    public Result signup(@RequestBody User user){
        int status = userService.signup(user);

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
    @ApiOperation("登出")
    @GetMapping(value = "/api/logout")
    public Result logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return ResultFactory.buildSuccessResult("成功登出");
    }
    @ApiOperation("身份认证")
    @GetMapping("/api/authentication")
    public String authentication(){
        return "身份认证成功";
    }
}
