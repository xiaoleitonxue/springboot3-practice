package com.itheima;

import com.example.EnableHeaderConfig;
import com.example.HeaderConfig;
import com.example.MyImportSelector;
import com.example.TokenParser;
import com.itheima.utils.AliyunOSSOperator;
import com.itheima.utils.AliyunOSSProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

//方法1：@ComponentScan + @Component
//@ComponentScan(basePackages = {"com.example", "com.itheima"})

//方法2：@Import
//@Import(TokenParser.class)

//@Import(HeaderConfig.class)

//@Import(MyImportSelector.class)

//方法3：@Enable...
//@EnableHeaderConfig

@Import(HeaderConfig.class)
@SpringBootApplication
public class SpringbootWebConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootWebConfigApplication.class, args);
    }

}
