package com.itheima;

import com.itheima.utils.AliyunOSSOperator;
import com.itheima.utils.AliyunOSSProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class SpringbootWebTests {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private AliyunOSSOperator aliyunOSSOperator;

    @Test
    void testScope(){
        for (int i = 0; i < 100; i++) {
            System.out.println(applicationContext.getBean("deptController"));
        }
    }

    @Test
    void testUpload() throws Exception {

    }

}
