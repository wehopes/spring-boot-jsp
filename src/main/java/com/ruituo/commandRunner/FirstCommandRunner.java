package com.ruituo.commandRunner;

import org.apache.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * description
 *
 * @author huijunjie
 * @date 2018-05-22 下午 3:41
 */
@Component
@Order(value = 1)
public class FirstCommandRunner implements CommandLineRunner{

   private Logger logger = Logger.getLogger(getClass());

    @Override
    public void run(String... strings) throws Exception {
        logger.info("执行启动任务......");
    }
}
