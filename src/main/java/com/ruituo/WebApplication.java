package com.ruituo;

import com.ruituo.bean.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.MultipartConfigFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.MultipartConfigElement;

/**
 * description
 *
 * @author huijunjie
 * @date 2018-05-22 上午 11:14
 */
@RestController
@SpringBootApplication
@ServletComponentScan
@EnableConfigurationProperties(MyConfig.class)
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class,args);
    }

    /**
     *TODO 配置文件上传
     *
     */
    @Bean
    public MultipartConfigElement multipartConfigFactory(){
        MultipartConfigFactory configFactory = new MultipartConfigFactory();
        configFactory.setMaxFileSize("128MB");//kb MB 设置单个上传文件大小
        configFactory.setMaxRequestSize("1024MB");//设置单次上传文件个数
        configFactory.setLocation("/");//设置文件上传路径
        return configFactory.createMultipartConfig();
    }
}
