package com.ruituo.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * description
 *
 * @author huijunjie
 * @date 2018-05-23 下午 5:48
 */
@Entity
public class User implements Serializable{
    private static final long serialVersionUID = 5053158293477191727L;

    @Id@GeneratedValue
    private Long id;

    private String name;

    private String pwd;

    public User() {
        super();
    }

    public User(String name, String pwd) {
        super();
        this.name = name;
        this.pwd = pwd;
    }

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

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
