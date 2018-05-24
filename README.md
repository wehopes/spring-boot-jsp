加模板引擎，springboot默认读取src/resources/templates下的html文件
springboot同时支持freemarker和thymeleaf模板引擎
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
不加模板，可设置web目录，读取webapp下的jsp文件