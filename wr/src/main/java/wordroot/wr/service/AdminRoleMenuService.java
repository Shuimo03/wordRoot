package wordroot.wr.service;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import wordroot.wr.Mapper.AdminMenuMapper;
import wordroot.wr.Mapper.AdminRoleMenuMapper;
import wordroot.wr.bean.AdminMenu;
import wordroot.wr.bean.AdminRoleMenu;
import wordroot.wr.bean.AdminUserRole;
import wordroot.wr.bean.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author wuliang
 * @date 2020/8/10
 */
public class AdminRoleMenuService {
    @Autowired
    AdminRoleMenuMapper adminRoleMenuMapper;

    public List<AdminRoleMenu> findAllByRid(int rid){
        return (List<AdminRoleMenu>) adminRoleMenuMapper.FindbyRid(rid);
    }

    public List<AdminRoleMenu> findAllByRid(List<Integer> rids){
        return adminRoleMenuMapper.geRidrAll(rids);
    }

    public void save(AdminRoleMenu adminRoleMenu){
        adminRoleMenuMapper.insert(adminRoleMenu);
    }

    @Transactional
    public void updateRoleMenu(int  rid, Map<String,List<Integer>> menusIds){
        adminRoleMenuMapper.delete(rid);
        List<AdminRoleMenu> roleMenus = new ArrayList<>();
        for(Integer mid : menusIds.get("menusIds")){
            AdminRoleMenu adminRoleMenu = new AdminRoleMenu();
            adminRoleMenu.setMid(mid);
            adminRoleMenu.setRid(rid);
            roleMenus.add(adminRoleMenu);
        }

        adminRoleMenuMapper.insertAll(roleMenus);
    }
}
