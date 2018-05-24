package com.ruituo.controller;

import com.ruituo.bean.MyConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description
 *
 * @author huijunjie
 * @date 2018-05-22 下午 5:10
 */
@RestController
public class PersonController {

    @Value("${person.name}")
    private String personNane;

    @Value("${person.gender}")
    private String personGender;


    @RequestMapping("person")
    public MyConfig person(){
        return new MyConfig(personNane,personGender);
    }
}
