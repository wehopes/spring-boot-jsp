package com.ruituo.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * description 定义读取自定义配置类
 *
 * @author huijunjie
 * @date 2018-05-22 下午 4:53
 */
@ConfigurationProperties(prefix = "person")//读取系统配置文件以person开头的所有配置，并自动封装到实体类中
public class MyConfig {

    private String name;
    private String gender;

    public MyConfig() {
    }

    public MyConfig(String name, String gender) {
        super();
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
