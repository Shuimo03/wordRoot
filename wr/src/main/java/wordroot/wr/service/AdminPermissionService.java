package wordroot.wr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wordroot.wr.Mapper.AdminPermissionMapper;
import wordroot.wr.Mapper.AdminRolePermissionMapper;
import wordroot.wr.bean.AdminPermission;

import java.util.List;

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

    public List<AdminPermission> list(){return adminPermissionMapper.}
}
