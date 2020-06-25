package com.yujia.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.io.Serializable;

/**
 * 建立实体类和数据表的映射关系以及属性和数据库列的对应关系
 * 1.实体类和数据表的映射关系
 *      @Entity
 *      @Table
 * 2.实体属性和数据库列的对应关系
 *
 */
@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    /**
     * 主键生成策略经常使用的两种：
     *      GenerationType.IDENTITY：主键自增 Mysql
     *      GenerationType.SEQUENCE：序列产生主键 Oracle
     *
     */
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "username")
    private String userName;
    @Column(name = "password")
    private String passWord;
    @Column(name = "birthday")
    private String birthday;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}
