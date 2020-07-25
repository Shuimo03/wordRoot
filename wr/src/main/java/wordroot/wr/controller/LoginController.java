package wordroot.wr.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;
import wordroot.wr.bean.User;
import wordroot.wr.result.Result;
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
    public Result login(@RequestBody User loginUser){
        String userName = loginUser.getName();
        userName = HtmlUtils.htmlEscape(userName);

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userName,loginUser.getPassword());
        usernamePasswordToken.setRememberMe(true);
        try {
            subject.login(usernamePasswordToken);
            User user = userService.findUserId(userName);
        }
    }
}
