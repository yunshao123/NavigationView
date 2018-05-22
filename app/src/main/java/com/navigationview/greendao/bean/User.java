package com.navigationview.greendao.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @Auth Mr.lc(兰超)
 * @Date 2018/5/17
 * @Time 12:59
 * 数据库类
 */
@Entity
public class User {
    @Id(autoincrement = true)
    private Long id;
    private String username;
    @Transient
    private int temp;
    public String getUsername() {
        return this.username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Generated(hash = 79420138)
    public User(Long id, String username) {
        this.id = id;
        this.username = username;
    }
    @Generated(hash = 586692638)
    public User() {
    }
}
