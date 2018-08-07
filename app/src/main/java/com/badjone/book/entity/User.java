package com.badjone.book.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @author BadJone
 * @data 2018/8/4.
 */
@Entity
public class User {
    @Id
    public long id;
    public String nickName;
    public String name;
    @NotNull
    public String mobile; //手机号码
    public String address;
    @Generated(hash = 1711714530)
    public User(long id, String nickName, String name, @NotNull String mobile,
            String address) {
        this.id = id;
        this.nickName = nickName;
        this.name = name;
        this.mobile = mobile;
        this.address = address;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNickName() {
        return this.nickName;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getMobile() {
        return this.mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
    }


}
