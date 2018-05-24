package com.ruituo.serviceImpl;

import com.ruituo.bean.User;
import com.ruituo.dao.UserDao;
import com.ruituo.iservice.IUserSV;
import org.apache.log4j.Logger;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * description
 *
 * @author huijunjie
 * @date 2018-05-24 上午 9:34
 */
@Service
public class UserSVImpl implements IUserSV{

    Logger logger = Logger.getLogger(getClass());

    @Resource
    private UserDao userDao;

    @Resource
    private RedisTemplate<String,String> redisTemplate;


    @Override
    public void myRedis() {
        ValueOperations<String,String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set("mykeys","random="+Math.random());
        logger.info("UserSVImpl.myRedis()=========mykeys="+valueOperations.get("mykeys"));
    }


    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Cacheable(value = "userInfo")//这里没有指定key 默认参数是key，返回值是value
    @Override
    public User findById(Long id) {
        logger.info("UserSVImpl.findById()=========从数据库中获取到的...Id="+id);
        return userDao.findOne(id);
    }

    @CacheEvict(value = "userInfo")
    @Override
    public void deleteFromCache(Long id) {
        logger.info("UserSVImpl.deleteFromCache()=========删除缓存中的...Id="+id);
    }

}
