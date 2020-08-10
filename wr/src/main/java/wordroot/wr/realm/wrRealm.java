package wordroot.wr.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import wordroot.wr.bean.AdminRole;
import wordroot.wr.bean.User;
import wordroot.wr.service.AdminPermissionService;
import wordroot.wr.service.AdminRoleService;
import wordroot.wr.service.UserService;

import java.util.Set;

/**
 * @author wuliang
 * @date 2020/8/1
 */

public class wrRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;
    @Autowired
    private AdminPermissionService adminPermissionService;
    @Autowired
    private AdminRoleService adminRoleService;

    //重写获取授权的信息方法
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection){

        //获取当前用户的所有权限
        String username = principalCollection.getPrimaryPrincipal().toString();
        Set<String> permissions = adminPermissionService.listPermissionURLsByUser(username);

        //将权限放入授权信息中
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setStringPermissions(permissions);
        return  authorizationInfo;
    }

    //获取认真信息，根据token中的用户名从数据库中获取密码，盐等返回
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException{
        String username = token.getPrincipal().toString();
        User user = userService.findUserName(username);
        if(ObjectUtils.isEmpty(user)){
            throw  new UnknownAccountException();
        }
        String passwordInDB = user.getPassword();
        String salt = user.getSalt();
        SimpleAuthenticationInfo authorizationInfo = new SimpleAuthenticationInfo(username,passwordInDB,ByteSource.Util.bytes(salt),getName());
        return  authorizationInfo;
    }
}
