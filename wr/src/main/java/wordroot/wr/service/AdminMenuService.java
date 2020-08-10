package wordroot.wr.service;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wordroot.wr.Mapper.AdminMenuMapper;
import wordroot.wr.bean.AdminMenu;
import wordroot.wr.bean.AdminRoleMenu;
import wordroot.wr.bean.AdminUserRole;
import wordroot.wr.bean.User;

import javax.jnlp.ClipboardService;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wuliang
 * @date 2020/8/6
 */

@Service
public class AdminMenuService {

    @Autowired
    AdminMenuMapper adminMenuMapper;
    @Autowired
    UserService userService;
    @Autowired
    AdminUserRoleService adminUserRoleService;
    @Autowired
    AdminRoleMenuService adminRoleMenuService;

    public List<AdminMenu> getAllById(int id){
        return adminMenuMapper.getUserAll(id);
    }

    public List<AdminMenu> getMenusByCurrentUser(){

        //在数据库获得用户信息
        String username = SecurityUtils.getSubject().getPrincipal().toString();
        User user = userService.findUserName(username);

        List<Integer> rids = adminUserRoleService.listAllByUid(user.getId())
                .stream().map(AdminUserRole::getRid).collect(Collectors.toList());

        List<Integer> menuIds = adminRoleMenuService.findAllByRid(rids)
                .stream().map(AdminRoleMenu::getMid).collect(Collectors.toList());

       List<AdminMenu> menus = adminMenuMapper.findAllByRid(menuIds).stream().distinct().collect(Collectors.toList());
       hadnleMenus(menus);
       return menus;
    }

    public List<AdminMenu> getMenusByRoleId(int rid){
        List<Integer> menuIds = adminRoleMenuService.findAllByRid(rid)
                .stream().map(AdminRoleMenu::getMid).collect(Collectors.toList());
        List<AdminMenu> menus = adminMenuMapper.findAllByRid(menuIds);
        hadnleMenus(menus);
        return menus;
    }

    public void hadnleMenus(List<AdminMenu> menus){
        menus.forEach(m->{
            List<AdminMenu> children = getAllById(m.getId());
            m.setChildren(children);
        });

        menus.removeIf(m-> m.getParentId() != 0);
    }
}
