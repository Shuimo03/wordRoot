package wordroot.wr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wordroot.wr.Mapper.AdminPermissionMapper;
import wordroot.wr.Mapper.AdminRolePermissionMapper;
import wordroot.wr.bean.AdminPermission;
import wordroot.wr.bean.AdminRole;
import wordroot.wr.bean.AdminRolePermission;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author wuliang
 * @date 2020/8/10
 */

@Service
public class AdminPermissionService {

    @Autowired
    AdminPermissionMapper adminPermissionMapper;
    @Autowired
    AdminUserRoleService adminUserRoleService;
    @Autowired
    AdminRoleService adminRoleService;
    @Autowired
    AdminRolePermissionService adminRolePermissionService;
    @Autowired
    AdminRolePermissionMapper adminRolePermissionMapper;
    @Autowired
    UserService userService;

    public List<AdminPermission> list(){return adminPermissionMapper.findAll();}

    public boolean needFilter(String requestAPI){
        List<AdminPermission> adminPermissions = adminPermissionMapper.findAll();
        for(AdminPermission adminPermission : adminPermissions){
            if(requestAPI.startsWith(adminPermission.getUrl()))
            {
                return true;
            }
        }

        return false;
    }

    public List<AdminPermission> listPermsByRoleId(int rid){
        List<Integer> pids = adminRolePermissionService.findAllRid(rid)
                .stream().map(AdminRolePermission::getPid).collect(Collectors.toList());
        return (List<AdminPermission>) adminPermissionMapper.findById(pids);
    }

    public Set<String> listPermissionURLsByUser(String username){
        List<Integer> rids = adminRoleService.listRolesByUser(username)
                .stream().map(AdminRole::getId).collect(Collectors.toList());

        List<Integer> pids = adminRolePermissionMapper.findAllRid(rids)
                .stream().map(AdminRolePermission::getPid).collect(Collectors.toList());

        List<AdminPermission> permissions = (List<AdminPermission>) adminPermissionMapper.findById(pids);
        Set<String> URLS = permissions.stream().map(AdminPermission::getUrl).collect(Collectors.toSet());

        return URLS;
    }
}
