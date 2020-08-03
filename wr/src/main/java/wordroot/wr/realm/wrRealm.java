package wordroot.wr.realm;

import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import wordroot.wr.service.UserService;

import java.util.Set;

/**
 * @author wuliang
 * @date 2020/8/1
 */

public class wrRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    //重写获取授权的信息方法
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection){

        //获取当前用户的所有权限
        String username = principalCollection.getPrimaryPrincipal().toString();
        Set<String> permissions =
    }
}
