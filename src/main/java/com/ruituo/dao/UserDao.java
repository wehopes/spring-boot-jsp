package com.ruituo.dao;

import com.ruituo.bean.User;
import org.springframework.data.repository.CrudRepository;

/**
 * description
 *
 * @author huijunjie
 * @date 2018-05-24 上午 9:22
 */
public interface UserDao extends CrudRepository<User,Long>{
}
