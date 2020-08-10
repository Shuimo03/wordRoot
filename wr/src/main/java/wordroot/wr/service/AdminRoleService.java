package wordroot.wr.service;

import org.springframework.beans.factory.annotation.Autowired;
import wordroot.wr.Mapper.AdminRoleMapper;

public class AdminRoleService {

    @Autowired
    AdminRoleMapper adminRoleMapper;
    @Autowired
    UserService userService;
    @Autowired
    AdminUserRoleService adminUserRoleService;
    @Autowired
    AdminRolePermissionService adminRolePermissionService;

}
