package com.shiroandswagger.dao;

import com.shiroandswagger.entity.User;

/**
 * @author wjx
 * @version 1.0
 * @date 2020/8/11 上午10:25
 */
public interface UserDao extends BaseDao<User, Long> {

    User findByName(String name);

}
