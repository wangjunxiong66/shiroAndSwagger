package com.shiroandswagger.service.serviceImpl;

import com.shiroandswagger.dao.RoleDao;
import com.shiroandswagger.dao.UserDao;
import com.shiroandswagger.entity.Permission;
import com.shiroandswagger.entity.Role;
import com.shiroandswagger.entity.User;
import com.shiroandswagger.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wjx
 * @version 1.0
 * @date 2020/8/11 上午10:27
 */
@Service
@Transactional
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;

    //添加用户
    @Override
    public User addUser(User user) {
        userDao.save(user);   // save方法是org.springframework.data.repository.CrudRepository中的方法
        return user;
    }

    //添加角色
    @Override
    public Role addRole(Role role) {
        User user = userDao.findByName(role.getUser().getName());
        role.setUser(user);
        Permission permission1 = new Permission();
        permission1.setPermission("create");
        permission1.setRole(role);
        Permission permission2 = new Permission();
        permission2.setPermission("update");
        permission2.setRole(role);
        List<Permission> permissions = new ArrayList<Permission>();
        permissions.add(permission1);
        permissions.add(permission2);
        role.setPermissions(permissions);
        roleDao.save(role);
        return role;
    }

    //查询用户通过用户名
    @Override
    public User findByName(String name) {
        return userDao.findByName(name);
    }
}
