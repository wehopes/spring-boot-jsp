package com.ruituo.controller;

import com.ruituo.bean.MyConfig;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description
 *
 * @author huijunjie
 * @date 2018-05-22 上午 11:36
 */
@Controller
public class IndexController {

    @RequestMapping("index")
    public String index(ModelMap map){
        map.put("message","this data is from index controller");
        return "index";
    }

}
