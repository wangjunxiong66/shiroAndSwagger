package com.shiroandswagger.service;

import com.shiroandswagger.entity.Role;
import com.shiroandswagger.entity.User;

/**
 * @author wjx
 * @version 1.0
 * @date 2020/8/11 上午10:26
 */
public interface LoginService {

    User addUser(User user);

    Role addRole(Role role);

    User findByName(String name);

}