package wordroot.wr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wordroot.wr.Mapper.AdminUserRoleMapper;
import wordroot.wr.bean.AdminRole;
import wordroot.wr.bean.AdminUserRole;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuliang
 * @date 2020/8/6
 */

@Service
public class AdminUserRoleService {

    @Autowired
    AdminUserRoleMapper adminUserRoleMapper;

    public List<AdminUserRole> listAllByUid(int uid){
        return adminUserRoleMapper.findAllUid(uid);
    }

    @Transactional
    public void saveRoleChanges(int uid, List<AdminRole> roles){
        adminUserRoleMapper.deleteAllUid(uid);
        List<AdminUserRole> userRoles = new ArrayList<>();
        roles.forEach(r->{
            AdminUserRole role = new AdminUserRole();
            role.setId(uid);
            role.setRid(r.getId());
            userRoles.add(role);
        });
        adminUserRoleMapper.insert(userRoles);
    }
}
