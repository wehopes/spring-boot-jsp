package com.ruituo.controller;

import com.ruituo.bean.User;
import com.ruituo.iservice.IUserSV;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * description
 *
 * @author huijunjie
 * @date 2018-05-24 上午 10:19
 */
@Controller
@RequestMapping("user")
public class UserController {

    Logger logger = Logger.getLogger(getClass());

    @Autowired
    private IUserSV iUserSV;

    @ResponseBody
    @RequestMapping("doMyRedis")
    public String doMyRedis(){
        User userLoaded = iUserSV.findById(Long.parseLong("1"));
        logger.info("UserController.myRedis()=========userLoaded="+userLoaded.toString());
        User userCached = iUserSV.findById(Long.parseLong("1"));
        logger.info("UserController.myRedis()=========userCached="+userCached.toString());
        userLoaded = iUserSV.findById(Long.parseLong("2"));
        logger.info("UserController.myRedis()=========userLoaded="+userLoaded.toString());
        return "success";
    }

    @ResponseBody
    @RequestMapping("save")
    public String save(){
        iUserSV.save(new User("王二小","123456"));
        logger.info("UserController.save()");
        return "success";
    }

    @ResponseBody
    @RequestMapping("delete")
    public String deleteFromCache(Long id){
        iUserSV.deleteFromCache(id);
        logger.info("UserController.deleteFromCache()");
        return "success";
    }

    @ResponseBody
    @RequestMapping("myRedis")
    public String myRedis(){
        iUserSV.myRedis();
        logger.info("UserController.myRedis()");
        return "success";
    }

}
