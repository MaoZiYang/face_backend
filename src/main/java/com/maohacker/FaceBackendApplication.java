package com.maohacker;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
//@MapperScan("com.maohacker.dao")//扫描dao层接口
public class FaceBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(FaceBackendApplication.class, args);
    }

    /**
     * 修改启动类，继承 SpringBootServletInitializer 并重写 configure 方法
     */
/*    public class SpringBootStartApplication extends SpringBootServletInitializer {

        @Override
        protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
            // 注意这里要指向原先用main方法执行的Application启动类
            return builder.sources(FaceBackendApplication.class);
        }
    }*/


}
