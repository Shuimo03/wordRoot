package wordroot.wr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wordroot.wr.Mapper.AdminRolePermissionMapper;
import wordroot.wr.bean.AdminPermission;
import wordroot.wr.bean.AdminRolePermission;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuliang
 * @date 2020/8/6
 */
@Service
public class AdminRolePermissionService {
    @Autowired
    AdminRolePermissionMapper adminRolePermissionMapper;

    List<AdminRolePermission> findAllRid(int rid){
        return adminRolePermissionMapper.findAllRid(rid);
    }

    @Transactional
    public void savePermChanges(int rid, List<AdminPermission> permissions){
        adminRolePermissionMapper.deleteByRid(rid);
        List<AdminRolePermission> adminRolePermissionList = new ArrayList<>();
        permissions.forEach(p->{
            AdminRolePermission adminRolePermission = new AdminRolePermission();
            adminRolePermission.setRid(rid);
            adminRolePermission.setPid(p.getId());
            adminRolePermissionList.add(adminRolePermission);
        });
        adminRolePermissionMapper.insert(adminRolePermissionList);
    }
}
