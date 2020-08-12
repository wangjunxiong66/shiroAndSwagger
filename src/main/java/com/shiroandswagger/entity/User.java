package com.shiroandswagger.entity;

import javax.persistence.*;
import java.util.List;

/**
 * @author wjx
 * @version 1.0
 * @date 2020/8/11 上午10:08
 */
@Entity
public class User {

    @Id   // 主键声明
    @GeneratedValue(strategy = GenerationType.AUTO)  // 主键生成策略，由JPA自动生成
    private Long id;
    @Column(unique = true)     // unique 属性表示该字段是否为唯一标识
    private String name;
    private String password;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")  // 关联实体的类型，级联类型为所有，关联实体的属性为“user”
    private List<Role> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
