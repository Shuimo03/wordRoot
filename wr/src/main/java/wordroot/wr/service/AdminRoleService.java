package wordroot.wr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import wordroot.wr.Mapper.AdminRoleMapper;
import wordroot.wr.bean.AdminMenu;
import wordroot.wr.bean.AdminPermission;
import wordroot.wr.bean.AdminRole;
import wordroot.wr.bean.AdminUserRole;

import java.util.List;
import java.util.stream.Collectors;

public class AdminRoleService {

    @Autowired
    AdminRoleMapper adminRoleMapper;
    @Autowired
    UserService userService;
    @Autowired
    AdminUserRoleService adminUserRoleService;
    @Autowired
    AdminRolePermissionService adminRolePermissionService;
    @Autowired
    AdminMenuService adminMenuService;
    @Autowired
    AdminPermissionService adminPermissionService;

    public List<AdminRole> listWithPermsAndMenus(){
        List<AdminRole> roles = adminRoleMapper.findAll();
        List<AdminPermission> permissions;
        List<AdminMenu> menus;

        for(AdminRole role : roles){

            permissions = adminPermissionService.listPermsByRoleId(role.getId());
            menus = adminMenuService.getMenusByRoleId(role.getId());
            role.setPerms(permissions);
            role.setMenus(menus);
        }
        return roles;
    }

    public List<AdminRole> findAll(){
        return adminRoleMapper.findAll();
    }

    public void addOrUpdate(AdminRole adminRole){
        adminRoleMapper.insert(adminRole);
    }

    public List<AdminRole> listRolesByUser(String username){
        int uid = userService.findUserName(username).getId();
        List<Integer> rids = adminUserRoleService.listAllByUid(uid)
                .stream().map(AdminUserRole::getId).collect(Collectors.toList());
        return adminRoleMapper.findAllById(rids);
    }

    public void editRole(@RequestBody AdminRole role){
        adminRoleMapper.insert(role);
        adminRolePermissionService.savePermChanges(role.getId(),role.getPerms());
    }
}
