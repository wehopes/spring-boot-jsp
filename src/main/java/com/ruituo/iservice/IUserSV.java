package com.ruituo.iservice;

import com.ruituo.bean.User;

/**
 * description
 *
 * @author huijunjie
 * @date 2018-05-24 上午 9:28
 */
public interface IUserSV {

    public void save(User user);

    public User findById(Long id);

    public void deleteFromCache(Long id);

    public void myRedis();
}
